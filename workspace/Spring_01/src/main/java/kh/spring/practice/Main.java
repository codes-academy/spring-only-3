package kh.spring.practice;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import kh.spring.impl.Fruits;
import kh.spring.impl.SamsungTv;
import kh.spring.interfaces.Tv;

public class Main {
  public static void main(String[] args) {
//		SamsungTv tv = new SamsungTv();

    AbstractApplicationContext ctx = new GenericXmlApplicationContext("context.xml"); //context.xml�� �о�鿩�� -> �ν��Ͻ� ������ ����
    //�������� ����� ������� ����

    //�����ڰ� ��ɳ��� : id=sam�� �����Ͷ�
//		ctx.getBean("sam");

    //�ڷ������� ��������
//		SamsungTv tv = ctx.getBean(SamsungTv.class);
//		tv.powerOn();
    //�����ϸ� 'samsungTv' ���� �����̶�� ������ ���� Ȯ���� �� ����
    //INFO : org.springframework.beans.factory.xml.XmlBeanDefinitionReader - Loading XML bean definitions from class path resource [context.xml]
    //INFO : org.springframework.context.support.GenericXmlApplicationContext - Refreshing org.springframework.context.support.GenericXmlApplicationContext@7960847b: startup date [Thu Jun 13 09:19:08 KST 2019]; root of context hierarchy

    //�������̽� �ڷ������� ��������
//		Tv tv2 = ctx.getBean(Tv.class); //context�� tv�ϳ��ۿ� ���� ������ ����, �������� ���� �� ������ tv�������̽��� ��ӹ޴� �� �������� ������
//		tv2.powerOn();
    //context.xml�� <bean id="lg" class="kh.spring.impl.LgTv">�� �ٲ�������, tv2�� �״�� ������
    //INFO : org.springframework.beans.factory.xml.XmlBeanDefinitionReader - Loading XML bean definitions from class path resource [context.xml]
    //INFO : org.springframework.context.support.GenericXmlApplicationContext - Refreshing org.springframework.context.support.GenericXmlApplicationContext@7960847b: startup date [Thu Jun 13 09:24:49 KST 2019]; root of context hierarchy

    //�׷��� tv�� �������� ��, ������
    //<bean id="lg" class="kh.spring.impl.LgTv">
    //<bean id="sam" class="kh.spring.impl.SamsungTv">
    //expected single matching bean but found 2: lg,sam
    //�ϳ��� �������̽��� ��ӹ��� �������� Ŭ������ �۵���ų �� ��Ÿ���� ����


    //1. xml ��� : xml���� �ڵ带 ����� ������ ���� ���
    //2. ������̼� ��� :
    //������ �ϳ��� �������� ���ϹǷ�, ���� �� ������ ��� ��


    //samsungtv�� �������� ������� ����Ŀ�� �����ϰ� �ִٰ� ��������

//		tv2.powerOn();
//		((SamsungTv)tv2).getSpeaker().volumeUp(); //�긮�� ����Ŀ : ������
    //speaker �������̽��� ���� �� : context���� ref�� britz�� ������ britz��, sony�� ������ sony�� ����


    //Fruits
//		Fruits f = (Fruits)ctx.getBean("fruits");
//		System.out.println(f.getNamesList());
//		System.out.println(f.getNamesMap());
//		System.out.println(f.getNamesSet());

//		Tv tv = ctx.getBean(Tv.class); //�� �������� �����ڰ� �������� �ʴٰ�, getBean�� �ϸ� ��μ� '�Ｚtv ������'�� ��µ�(lazy-init�� true�� �� ���)


    //������ : singleton / prototype�� ���� �ٸ� ���� Ȯ���� �� ����
    //�⺻������ singleton(ex. dao ����� ���� �׳� ������ ���� �Ǵ� ���)
    //��ü�� �ϳ��� �־�� �� �Ǵ� ����� �� prototype(����, ����ϱ� ���°� ����ϰ� �߻��ϴ� �͵�)
    Tv tv = ctx.getBean(Tv.class);
    tv.powerOn();
    tv = ctx.getBean(Tv.class);
    tv.powerOn();
    tv = ctx.getBean(Tv.class);
    tv.powerOn();
    tv = ctx.getBean(Tv.class);
    tv.powerOn();
  }
}
