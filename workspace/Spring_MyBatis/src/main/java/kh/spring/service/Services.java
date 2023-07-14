package kh.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kh.spring.dao.MessageDAO;
import kh.spring.dao.SellerDAO;

@Service
public class Services {

  @Autowired
  private MessageDAO mgsdao;
  @Autowired
  private SellerDAO serdao;

  @Transactional("txManager")
  public void service() throws Exception {
    mgsdao.insert();
    serdao.insert();
  }

}
