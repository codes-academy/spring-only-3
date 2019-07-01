package kh.spring.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import kh.spring.dto.PayDTO;
import kh.spring.dto.SellerDTO;
import kh.spring.service.BuyService;

@Component
public class BuyServiceImpl implements BuyService{
	
	@Autowired
	private PayDAOImpl pdao;
	@Autowired
	private SellerDAOImpl sdao;
	
	@Transactional("txManager")
	public void buy(PayDTO dto) throws Exception{
		pdao.insert(dto);
		sdao.insert(new SellerDTO(0, "jack", dto.getPid())); 
	}
	
	
}
