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
			mav.addObject("msg", "�α����� ���� �������ּ���");
			mav.setViewName("index");
			return mav; //���ϰ��� ModelAndView�Ƿ� execution(* kh.spring.practice.HomeController.join(..)) ���� ���ԵǴ� �ֵ鵵 ModelAndView�� ���ϰ��� �ٲ�� ��
		} else {
			return pjp.proceed();
		}
	}
	
	//�α����� �� �ߴµ� �ٸ� ������(����������, �Խ��� ��..) ���� �̵��� ��, �α��� �������� ���ƿ��� �α����� �϶�� ������ ��
	
	

	
}
