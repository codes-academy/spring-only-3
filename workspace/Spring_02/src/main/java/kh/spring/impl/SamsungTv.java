package kh.spring.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import kh.spring.interfaces.Speaker;
import kh.spring.interfaces.Tv;

@Component("sam") //�ν��Ͻ��� ����� �� //�ڽ��� �پ��ִ� Ŭ������ �ν��Ͻ��� ��������
//������ ��������� �� �ƴϰ�, �������� �˷���� ��
//"sam" : ���̵� �ο�
@Scope("prototype")
public class SamsungTv implements Tv {

  @Autowired //DI
  @Qualifier("sam")
  private Speaker speaker;

  public SamsungTv() {
    System.out.println("�Ｚ tv ������");
  }

  @Override
  public void powerOn() {
    System.out.println("�Ｚ Tv ����");
    speaker.volumeUp();
  }

}
