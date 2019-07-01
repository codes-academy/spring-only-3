package kh.spring.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class PerfCheckAdvice {
	//"executtion(* kh.spring.practice.MemberController.*(..))" <- 이게 포인트컷
	@Around("execution(* kh.spring.practice.MemberController.*(..))")
	public Object perfCheck(ProceedingJoinPoint pjp) {
		long startTime = System.currentTimeMillis();
		
		Object retVal = null;
		try {
			retVal = pjp.proceed(); //view, model리턴가능 -> 아직 모르기 때문에 리턴값을 오브젝트로 받음
			//pointcut 메서드가 실행되는 시점(내가 결정할 수 있음) //이걸 기준으로 위는 before, 아래는 after
			//예외 중 가장 강력한 throwable을 씀
		} catch (Throwable e) {
			e.printStackTrace();
		} 
		
		long endTime = System.currentTimeMillis();
		System.out.println((endTime - startTime) / 1000.0 + "초간 수행");
		
		return retVal; //pointCut 을 앞에서 한 번, 뒤에서 한 번 가로챘기 때문에
	}
	//자신이 끼어든 pointcut 메서드에 영향을 줄 수 있음(실행을 하지 않거나, 다르게 변화를 주거나) <-> before은 영향 못 줌
	
	// [결과]
//	0.019초간 수행
//	0.0초간 수행
//	0.0초간 수행
}
