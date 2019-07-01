package kh.spring.practice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import kh.spring.dto.MembersDTO;

@Component
@Aspect
public class Adviser {
	

	@Autowired
	private HttpSession session;
	
	@Around("execution(* kh.spring.practice.HomeController.join(..))")
	public Object loginCheck(ProceedingJoinPoint pjp) throws Throwable{
//		MembersDTO dto = (MembersDTO)session.getAttribute("loginInfo");
		
//		if(dto == null) {
		if(session.getAttribute("id") == null) {
			ModelAndView mav = new ModelAndView();
			mav.addObject("msg", "로그인을 먼저 진행해주세요");
			mav.setViewName("index");
			return mav; //리턴값이 ModelAndView므로 execution(* kh.spring.practice.HomeController.join(..)) 여기 포함되는 애들도 ModelAndView로 리턴값을 바꿔야 함
		} else {
			return pjp.proceed();
		}
	}
	
	//로그인을 안 했는데 다른 페이지(마이페이지, 게시판 등..) 으로 이동할 때, 로그인 페이지로 돌아오며 로그인을 하라는 문구가 뜸
	
	

	
}
