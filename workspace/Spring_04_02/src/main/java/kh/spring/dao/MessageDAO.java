package kh.spring.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import kh.spring.dto.MessageDTO;

//<property name="defaultAutoCommit" value="false"/> 자동커밋 되니까 이거 지워야 함


@Component
public class MessageDAO {
	
	@Autowired
	private JdbcTemplate template; 
	//장점 : close를 알아서 하기 때문에 try-resource 할 필요 없음 //커밋도 자동 //커넥션 만들 필요 없음 //preparedstatement필요없음
	
	public int insert(MessageDTO dto) {
		String sql = "insert into message values(message_seq.nextval,?,?)";
		return template.update(sql, dto.getName(), dto.getMessage()); // =executeUpdate()
		
		//가변인수 : 여러개가 계속 올 수 있는 것(Object...args) >> (?,?)와 같이 ?가 여러개니까
	}
	
	public List<MessageDTO> selectAll() { //자바에는 없는 콜백방식을 흉내냄
		String sql = "select * from message";
		//하나만 꺼내는 경우
//		template.queryForObject(sql, new RowMapper<MessageDTO>()); //while 없음
		//여러 레코드를 꺼내는 경우
//		template.query(sql, new RowMapper<MessageDTO>());
		return template.query(sql, new RowMapper<MessageDTO>() { //이 메서드가 while을 지닌다는 전제를 가지고 있음, 아래 mapRow메서드를 돌려주는 것
		//결과값으로 이 자체를 리턴시킴

			@Override
			public MessageDTO mapRow(ResultSet rs, int rn) throws SQLException { //rn(rowNum)은 별로 쓸 일이 없음 //레코드가 몇 번째인지 알 필요 없기 때문
				MessageDTO dto = new MessageDTO();
				dto.setSeq(rs.getInt("seq"));
				dto.setName(rs.getString("name"));
				dto.setMessage(rs.getString("message"));
				
				System.out.println(rn); //몇 번 라인을 뽑아내고 있는지
				
				return dto;
			}
			
		}); //resultset을 어떤 데이터타입으로 명시할건지 정보를 줘야 함 = new RowMapper<MessageDTO>()
		//RowMapper는 추상클래스?인터페이스?, 이 클래스 안에 있는 특정 메서드가 추상메서드라 오류가 나는 것
		//(1.추상 메서드를 구현 2.상속받은 클래스도 추상클래스로 만들기) =  1번으로 실행
		//클래스를 만들고 상속받아서 오버라이드 하는 번거로운 방법이 아니라, interface().메서드()로 바로 오버라이딩 시켜버리는 익명클래스 방식으로 함
	}
	
	//하나의 값만 원할 때
	public int selectCount() {
		String sql = "select count(*) as cnt from message";
		return template.queryForObject(sql, Integer.class); //Integer.class처럼 형을 명시해줌
	}
	
}
