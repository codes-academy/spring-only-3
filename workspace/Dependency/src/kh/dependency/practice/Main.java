package kh.dependency.practice;

import kh.dependency.factory.TvFactory;
import kh.dependency.interfaces.Tv;
import kh.dependency.items.LgTV;

public class Main {
  public static void main(String[] args) {
//		SamsungTV tv = new SamsungTV();
//		tv.powerOn();
//		tv.getModel();
//		tv.getPrice();

    //tv를 바꿀 경우, 위 코드를 변경해야 함
//		LgTV tv = new LgTV(); 
//		tv.turnOn();
//		tv.getModel();
//		tv.getPrice(); //의존성이 높은 코드

    //1. 인터페이스 사용
    Tv tv = new LgTV();
    tv.powerOn();

    //2. 팩토리패턴 사용
    Tv tv2 = TvFactory.getInstance("lg");
    tv.powerOn();

    //3. cmd
    Tv tv3 = TvFactory.getInstance(args[0]); //samsung
    //단점 : cmd를 거쳐야 한다, 많은 수의 배열을 다룰 수 없다, 디테일한 설정이 어렵다


    //스프링 : 설정파일(xml문서)에 내가 만들어야 한 인스턴스를 만든 다음 넣음, 소스코드 바깥에 만들었기 때문에 쓸 때는 가져오기만 하면 됨
  }
}
