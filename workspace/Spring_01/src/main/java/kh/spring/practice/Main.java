package kh.spring.practice;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import kh.spring.impl.Fruits;
import kh.spring.impl.SamsungTv;
import kh.spring.interfaces.Tv;

public class Main {
  public static void main(String[] args) {
//		SamsungTv tv = new SamsungTv();

    AbstractApplicationContext ctx = new GenericXmlApplicationContext("context.xml"); //context.xml을 읽어들여라 -> 인스턴스 생성된 상태
    //개발자의 명령을 대기중인 상태

    //개발자가 명령내림 : id=sam을 가져와라
//		ctx.getBean("sam");

    //자료형으로 가져오기
//		SamsungTv tv = ctx.getBean(SamsungTv.class);
//		tv.powerOn();
    //실행하면 'samsungTv' 전원 켜짐이라고 나오는 것을 확인할 수 있음
    //INFO : org.springframework.beans.factory.xml.XmlBeanDefinitionReader - Loading XML bean definitions from class path resource [context.xml]
    //INFO : org.springframework.context.support.GenericXmlApplicationContext - Refreshing org.springframework.context.support.GenericXmlApplicationContext@7960847b: startup date [Thu Jun 13 09:19:08 KST 2019]; root of context hierarchy

    //인터페이스 자료형으로 가져오기
//		Tv tv2 = ctx.getBean(Tv.class); //context에 tv하나밖에 없기 때문에 가능, 의존도를 낮춘 건 맞지만 tv인터페이스를 상속받는 게 여러개면 에러남
//		tv2.powerOn();
    //context.xml을 <bean id="lg" class="kh.spring.impl.LgTv">로 바꿨을때도, tv2는 그대로 실행함
    //INFO : org.springframework.beans.factory.xml.XmlBeanDefinitionReader - Loading XML bean definitions from class path resource [context.xml]
    //INFO : org.springframework.context.support.GenericXmlApplicationContext - Refreshing org.springframework.context.support.GenericXmlApplicationContext@7960847b: startup date [Thu Jun 13 09:24:49 KST 2019]; root of context hierarchy

    //그러나 tv가 여러개일 시, 에러남
    //<bean id="lg" class="kh.spring.impl.LgTv">
    //<bean id="sam" class="kh.spring.impl.SamsungTv">
    //expected single matching bean but found 2: lg,sam
    //하나의 인터페이스를 상속받은 여러개의 클래스를 작동시킬 때 나타나는 오류


    //1. xml 방식 : xml에서 코드를 만들고 가져다 쓰는 방식
    //2. 어노테이션 방식 :
    //완전히 하나로 독립하지 못하므로, 보통 두 가지를 섞어서 씀


    //samsungtv가 컴포지션 방식으로 스피커를 내장하고 있다고 가정하자

//		tv2.powerOn();
//		((SamsungTv)tv2).getSpeaker().volumeUp(); //브리츠 스피커 : 볼륨업
    //speaker 인터페이스를 만든 후 : context에서 ref를 britz로 넣으면 britz로, sony를 넣으면 sony로 동작


    //Fruits
//		Fruits f = (Fruits)ctx.getBean("fruits");
//		System.out.println(f.getNamesList());
//		System.out.println(f.getNamesMap());
//		System.out.println(f.getNamesSet());

//		Tv tv = ctx.getBean(Tv.class); //이 이전에는 생성자가 생성되지 않다가, getBean을 하면 비로소 '삼성tv 생성됨'이 출력됨(lazy-init을 true로 한 결과)


    //스코프 : singleton / prototype이 각각 다른 것을 확인할 수 있음
    //기본적으로 singleton(ex. dao 만들어 놓고 그냥 가져다 쓰면 되는 경우)
    //객체가 하나만 있어서는 안 되는 경우일 땐 prototype(쓰기, 기록하기 상태가 빈번하게 발생하는 것들)
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
