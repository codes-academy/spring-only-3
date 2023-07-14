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

  @Transactional("txManager") //""�ȿ��� ���� ���� Ʈ����� �̸�
  public void buy(PayDTO dto) throws Exception {
    pdao.insert(dto);
//		sdao.insert(new SellerDTO(0, "jack", dto.getPid())); 
    sdao.insert(new SellerDTO(0, "jack�ääääääääääääääääää�", dto.getPid())); //���������� ���ܸ� �߻��������� ���� �� : jdbc template�� Ʈ����� ó���� ���� ����
    //context.xml �� <bean id="txManager" class="org.springframework.jdbc.datasource.DataSourceTransactionManager"></bean>�߰�
  }


}
