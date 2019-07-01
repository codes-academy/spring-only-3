//package kh.spring.practice;
//
//import javax.servlet.http.HttpSession;
//
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.Around;
//import org.aspectj.lang.annotation.Aspect;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import org.springframework.web.servlet.ModelAndView;
//
//@Component
//@Aspect
//public class Adviser {
//	@Around("execution(* kh.spring.practice.HomeController.*(..))")
//	public Object perfCheck(ProceedingJoinPoint pjp) {
//		long startTime = System.currentTimeMillis();
//		
//		Object retVal = null;
//		try {
//			retVal = pjp.proceed();
//		} catch (Throwable e) {
//			e.printStackTrace();
//		} 
//		
//		long endTime = System.currentTimeMillis();
//		System.out.println((endTime - startTime) / 1000.0 + "초간 수행");
//		
//		return retVal;
//	}
//	
//	
//}
