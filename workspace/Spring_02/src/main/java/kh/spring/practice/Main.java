package kh.spring.practice;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import kh.spring.interfaces.Tv;

public class Main {
  public static void main(String[] args) {
    AbstractApplicationContext ctx = new GenericXmlApplicationContext("context.xml");
    //�Ｚ tv ������

//		Tv tv = ctx.getBean(Tv.class);
//		tv.powerOn();
    //�Ｚ tv ������
    //�Ｚ Tv ����

//		Tv tv2 = (Tv)ctx.getBean("sam");
//		tv2.powerOn();
    //�Ｚ tv ������
    //�Ｚ Tv ����

//		Tv tv = ctx.getBean(Tv.class); //tv ������̼��� �������ε�, id�Ҵ��� ���� �ʾ��� ��� ����
//		tv.powerOn();

//		Tv tv = (Tv)ctx.getBean("lg"); //����Ŀ�� ������̼� ���� �������� ���
//		tv.powerOn();

    System.out.println("-----------");
    Tv tv = (Tv) ctx.getBean("lg"); //����Ŀ�� ������̼ǿ� id�� �ο�, ��������
    tv.powerOn();

  }
}
