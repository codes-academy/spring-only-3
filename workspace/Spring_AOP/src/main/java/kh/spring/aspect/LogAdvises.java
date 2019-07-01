//package kh.spring.aspect;
//
//import java.text.SimpleDateFormat;
//import java.util.Arrays;
//
//import org.aspectj.lang.JoinPoint;
//import org.aspectj.lang.Signature;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Before;
//import org.aspectj.lang.annotation.Pointcut;
//import org.springframework.stereotype.Component;
//
//@Component
//@Aspect //어드바이저로서, aop와 관련이 있다는 뜻
//public class LogAdvises {
//	
//	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
//	
//	// return package .. Controller .. Method(매개변수)
////	@Before("execution(* *())")
////	@Before("execution(* *(..))") //..=있을수도 있고 없을수도 있고
////	@Before("execution(* kh.spring.practice.MemberController.log*())") //메서드 실행 전, 실행 도중, 실행 후 중 어디 끼워넣을 건지 선택("execution(리턴값 표현식)") // *=모든 것(String 등으로 써도 됨)
//	//execution(* kh.spring.practice.MemberController.*()) = 전부 하고싶을 때 log 떼면 됨(log=log로 시작하는 메서드)
////	@Before("execution(* kh.spring.practice.MemberController.log*(String, ..))") //첫번째 매개변수는 String, 나머지는 있거나 없거나
////	@Before("execution(* kh.spring.practice.MemberController.*()) || execution(* kh.spring.practice.MemberController.*())")
////	public void pringLog(JoinPoint jp) {
////		System.out.println(jp.getArgs()[0]); //null point exception
////		for(Object o : jp.getArgs()) {
////			System.out.println(o);
////		}
////		System.out.println(sdf.format(System.currentTimeMillis()) + " 에 수행");
////	} //모든 컨트롤러의 특정 기능 대상으로 사용할 어드바이스 -> aop 표현식으로 구분
//	
//	
//	//어드바이스 메서드는 스프링에 의해 호출되는 것
//	//내가 원하는 인자값을 넘길 수는 없지만, 어드바이스 메서드 자체가 스스로 가지는 매개변수가 있음
//	//JoinPoint = pointcut before시점 실행될때 얻을 수 있는 정보를 모아서 JoinPoint에 넣어줌
//	
//	
//	@Pointcut("execution(* kh.spring.practice.MemberController.*(..))") 
//	public void memberCut() {
//	}
//	@Pointcut("execution(* kh.spring.practice.MemberController.*())") 
//	public void member2Cut() {
//	}
//	@Before("memberCut() || member2Cut()") //before의 리턴값은 의미가 없음 
//	public void member(JoinPoint jp) {
//		for(Object o : jp.getArgs()) {
//			System.out.println(o); //MemberController 에 인자값이 있어야 함(매개변수)
//		} //메서드 인자값 //before가 실행되면 인자값을 가져옴
//		
//		System.out.println("전달된 인자값 : " + Arrays.toString(jp.getArgs()));
//		Signature sign = jp.getSignature(); //메서드 인자값
//		
//		StringBuilder sb = new StringBuilder();
//		sb.append(sdf.format(System.currentTimeMillis()) + "에 ");
//		sb.append(sign.getName() + "메서드 실행됨");
//		
//		System.out.println(sb.toString()); //클래스 정보
//		
//		System.out.println(jp.getTarget()); //타켓클래스
//		System.out.println(sign.toShortString()); //길게 메서드 이름 가져오기(메서드 풀 경로)
//		
//		//로그인 유무를 검사
//		//하지만 before로는 메서드를 통제할 수 없음
//	}
////	(결과 :) 
////	test
////	전달된 인자값 : [test]
////	2019/06/24 12:24:26에login메서드 실행됨
////	전달된 인자값 : []
////	2019/06/24 12:24:33에mypage메서드 실행됨
////	전달된 인자값 : []
////	2019/06/24 12:24:35에logout메서드 실행됨
//
//	//----------------------------------------------------------------------------
//	
//	//around 는 before + after
//	
//	
//	//----------------------------------------------------------------------------
//	
////	@Pointcut("execution(* kh.spring.practice.*.log*())") 
////	public void memberCut() {
////		System.out.println(sdf.format(System.currentTimeMillis() + " 에 수행"));
////	}
////	@Pointcut("execution(* kh.spring.practice.*.log*())") 
////	public void member2Cut() {
////		System.out.println(sdf.format(System.currentTimeMillis() + " 에 수행"));
////	}
////	@Before("memberCut() && member2Cut()") 
////	public void memberCut() {
////		System.out.println(sdf.format(System.currentTimeMillis() + " 에 수행"));
////	}
////	@Before("!memberCut()") //memberCut()이 아닐 때 
////	public void memberCut() {
////		System.out.println(sdf.format(System.currentTimeMillis() + " 에 수행"));
////	}
//	
//}
