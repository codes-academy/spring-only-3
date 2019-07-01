package kh.spring.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import kh.spring.dto.MessageDTO;

//<property name="defaultAutoCommit" value="false"/> �ڵ�Ŀ�� �Ǵϱ� �̰� ������ ��


@Component
public class MessageDAO {
	
	@Autowired
	private JdbcTemplate template; 
	//���� : close�� �˾Ƽ� �ϱ� ������ try-resource �� �ʿ� ���� //Ŀ�Ե� �ڵ� //Ŀ�ؼ� ���� �ʿ� ���� //preparedstatement�ʿ����
	
	public int insert(MessageDTO dto) {
		String sql = "insert into message values(message_seq.nextval,?,?)";
		return template.update(sql, dto.getName(), dto.getMessage()); // =executeUpdate()
		
		//�����μ� : �������� ��� �� �� �ִ� ��(Object...args) >> (?,?)�� ���� ?�� �������ϱ�
	}
	
	public List<MessageDTO> selectAll() { //�ڹٿ��� ���� �ݹ����� �䳻��
		String sql = "select * from message";
		//�ϳ��� ������ ���
//		template.queryForObject(sql, new RowMapper<MessageDTO>()); //while ����
		//���� ���ڵ带 ������ ���
//		template.query(sql, new RowMapper<MessageDTO>());
		return template.query(sql, new RowMapper<MessageDTO>() { //�� �޼��尡 while�� ���Ѵٴ� ������ ������ ����, �Ʒ� mapRow�޼��带 �����ִ� ��
		//��������� �� ��ü�� ���Ͻ�Ŵ

			@Override
			public MessageDTO mapRow(ResultSet rs, int rn) throws SQLException { //rn(rowNum)�� ���� �� ���� ���� //���ڵ尡 �� ��°���� �� �ʿ� ���� ����
				MessageDTO dto = new MessageDTO();
				dto.setSeq(rs.getInt("seq"));
				dto.setName(rs.getString("name"));
				dto.setMessage(rs.getString("message"));
				
				System.out.println(rn); //�� �� ������ �̾Ƴ��� �ִ���
				
				return dto;
			}
			
		}); //resultset�� � ������Ÿ������ ����Ұ��� ������ ��� �� = new RowMapper<MessageDTO>()
		//RowMapper�� �߻�Ŭ����?�������̽�?, �� Ŭ���� �ȿ� �ִ� Ư�� �޼��尡 �߻�޼���� ������ ���� ��
		//(1.�߻� �޼��带 ���� 2.��ӹ��� Ŭ������ �߻�Ŭ������ �����) =  1������ ����
		//Ŭ������ ����� ��ӹ޾Ƽ� �������̵� �ϴ� ���ŷο� ����� �ƴ϶�, interface().�޼���()�� �ٷ� �������̵� ���ѹ����� �͸�Ŭ���� ������� ��
	}
	
	//�ϳ��� ���� ���� ��
	public int selectCount() {
		String sql = "select count(*) as cnt from message";
		return template.queryForObject(sql, Integer.class); //Integer.classó�� ���� �������
	}
	
}
