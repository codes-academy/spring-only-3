package kh.spring.dao;

import kh.spring.dto.PayDTO;

public interface PayDAO {

	public int insert(PayDTO dto) throws Exception;
}
