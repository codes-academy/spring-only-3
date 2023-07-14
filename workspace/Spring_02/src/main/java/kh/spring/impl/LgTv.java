package kh.spring.impl;


import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import kh.spring.interfaces.Speaker;
import kh.spring.interfaces.Tv;

@Component("lg") //�Ｚ�� �̾� lg���� ������̼��� �ٴ� ��� ������ �� �� ���� //main���� tv.class�� ���� ��, 2���� �߰ߵǱ� ���� -> id�� �Ҵ��ؾ� ��
public class LgTv implements Tv {

  @Resource(name = "sony") //id�� ����� �� �ִ� autowired��� �����ϸ� ��
  private Speaker speaker;

  public LgTv() {
    System.out.println("lg tv ������");
  }

  @Override
  public void powerOn() {
    System.out.println("lg tv ����");
  }

}
