package kh.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import kh.spring.dao.PayDAO2;
import kh.spring.dao.SellerDAO2;
import kh.spring.dto.PayDTO;
import kh.spring.dto.SellerDTO;

@Component
public class BuyService2 {

  @Autowired
  private PayDAO2 pdao;
  @Autowired
  private SellerDAO2 sdao;

  @Transactional("txManager") //""안에는 내가 만든 트랜잭션 이름
  public void buy(PayDTO dto) throws Exception {
    pdao.insert(dto);
//		sdao.insert(new SellerDTO(0, "jack", dto.getPid())); 
    sdao.insert(new SellerDTO(0, "jackㅓㅓㅓㅓㅓㅓㅓㅓㅓㅓㅓㅓㅓㅓㅓㅓㅓㅓㅓ", dto.getPid())); //인위적으로 예외를 발생시켰지만 값이 들어감 : jdbc template은 트랜잭션 처리를 하지 않음
    //context.xml 에 <bean id="txManager" class="org.springframework.jdbc.datasource.DataSourceTransactionManager"></bean>추가
  }


}
