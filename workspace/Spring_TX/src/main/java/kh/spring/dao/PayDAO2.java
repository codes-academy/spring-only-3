package kh.spring.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import kh.spring.dto.PayDTO;

@Component
public class PayDAO2 {

	@Autowired
	private JdbcTemplate template;
	
	public int insert(PayDTO dto) throws Exception{
		String sql = "insert into pay values(pay_seq.nextval, ?, ?)";
		return template.update(sql, new Object[] {dto.getPid(), dto.getPname()});
	}
	
}
