package kh.spring.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.spring.dto.SellerDTO;

@Repository
public class SellerDAO {

	@Autowired
	private SqlSessionTemplate sst;
	
	public int insert() {
		SellerDTO dto = new SellerDTO();
		dto.setBid("ggg");
		dto.setPid("ggg");
		return sst.insert("SellerDAO.insert", dto);
	}
	
}
