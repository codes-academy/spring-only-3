package kh.spring.impl;


import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import kh.spring.interfaces.Speaker;
import kh.spring.interfaces.Tv;

@Component("lg") //삼성에 이어 lg에도 어노테이션이 붙는 경우 문제가 될 수 있음 //main에서 tv.class를 썼을 때, 2개가 발견되기 때문 -> id를 할당해야 함
public class LgTv implements Tv {

  @Resource(name = "sony") //id를 명시할 수 있는 autowired라고 생각하면 됨
  private Speaker speaker;

  public LgTv() {
    System.out.println("lg tv 생성됨");
  }

  @Override
  public void powerOn() {
    System.out.println("lg tv 켜짐");
  }

}
