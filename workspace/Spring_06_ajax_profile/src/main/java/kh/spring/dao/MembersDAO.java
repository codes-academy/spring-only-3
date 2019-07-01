package kh.spring.dao;

import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartRequest;

import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import kh.spring.dto.MembersDTO;

@Component
public class MembersDAO {

	@Autowired
	private JdbcTemplate template;

	@Autowired
	private HttpSession session;
	
	public int insert(MembersDTO dto) {
		String sql = "insert into members values(members_seq.nextval, ?, ?, ?, ?)";
		return template.update(sql, dto.getId(), dto.getPw(), dto.getName(), dto.getTel(), dto.getProfile());
	}
	
	public List<MembersDTO> select(){
		String sql = "select * from members";
		return template.query(sql, new RowMapper<MembersDTO>() {
			@Override
			public MembersDTO mapRow(ResultSet rs, int rn) throws SQLException {
				MembersDTO dto = new MembersDTO();
				dto.setId(rs.getString("id"));
				dto.setName(rs.getString("name"));
				dto.setTel(rs.getString("tel"));
				return dto;
			}
		});
	}

	public String idDup(String id) {
		String sql = "select id from members where id='" + id + "'";
			try {
				return template.queryForObject(sql, String.class);
			}catch(Exception e) {
				e.printStackTrace();
				return null;
			}
		}
	
	public boolean login(String id, String pw) {
		String sql = "select id from members where id='" + id + "' and pw='" + pw + "'";
		try {
			template.queryForObject(sql, String.class);
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}	
	}
	
	
}
