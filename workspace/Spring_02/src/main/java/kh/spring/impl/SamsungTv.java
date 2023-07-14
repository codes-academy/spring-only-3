package kh.spring.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import kh.spring.interfaces.Speaker;
import kh.spring.interfaces.Tv;

@Component("sam") //인스턴스를 만드는 것 //자신이 붙어있는 클래스의 인스턴스를 만들어버림
//무조건 만들어지는 건 아니고, 스프링에 알려줘야 함
//"sam" : 아이디 부여
@Scope("prototype")
public class SamsungTv implements Tv {

  @Autowired //DI
  @Qualifier("sam")
  private Speaker speaker;

  public SamsungTv() {
    System.out.println("삼성 tv 생성됨");
  }

  @Override
  public void powerOn() {
    System.out.println("삼성 Tv 켜짐");
    speaker.volumeUp();
  }

}
