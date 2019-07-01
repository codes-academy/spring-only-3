package kh.spring.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import kh.spring.dao.SellerDAO;
import kh.spring.dto.SellerDTO;

@Component
public class SellerDAOImpl implements SellerDAO{

	@Autowired
	private JdbcTemplate template;
	
	public int insert(SellerDTO dto) throws Exception{
		String sql = "insert into seller values(seller_seq.nextval, ?, ?)";
		return template.update(sql, new Object[] {dto.getBid(), dto.getPid()});
	}
	
}
