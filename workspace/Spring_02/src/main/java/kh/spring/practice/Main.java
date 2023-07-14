package kh.spring.practice;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import kh.spring.interfaces.Tv;

public class Main {
  public static void main(String[] args) {
    AbstractApplicationContext ctx = new GenericXmlApplicationContext("context.xml");
    //삼성 tv 생성됨

//		Tv tv = ctx.getBean(Tv.class);
//		tv.powerOn();
    //삼성 tv 생성됨
    //삼성 Tv 켜짐

//		Tv tv2 = (Tv)ctx.getBean("sam");
//		tv2.powerOn();
    //삼성 tv 생성됨
    //삼성 Tv 켜짐

//		Tv tv = ctx.getBean(Tv.class); //tv 어노테이션이 여러개인데, id할당이 되지 않았을 경우 에러
//		tv.powerOn();

//		Tv tv = (Tv)ctx.getBean("lg"); //스피커의 어노테이션 또한 여러개일 경우
//		tv.powerOn();

    System.out.println("-----------");
    Tv tv = (Tv) ctx.getBean("lg"); //스피커의 어노테이션에 id를 부여, 구분해줌
    tv.powerOn();

  }
}
