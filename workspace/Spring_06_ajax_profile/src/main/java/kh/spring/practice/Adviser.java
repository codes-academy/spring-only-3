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

  @Around("execution(* kh.spring.practice.HomeController.login(..))")
  public Object loginCheck(ProceedingJoinPoint pjp) throws Throwable {
//		MembersDTO dto = (MembersDTO)session.getAttribute("loginInfo");

    if (session.getAttribute("id") == null) {
      ModelAndView mav = new ModelAndView();
      mav.addObject("msg", "로그인을 먼저 진행해주세요");
      mav.setViewName("index");
      return mav;
    } else {
      return pjp.proceed();
    }
  }


//	@Around("execution(* kh.spring.practice.HomeController.*(..))")
//	public Object perfCheck(ProceedingJoinPoint pjp) {
//		long startTime = System.currentTimeMillis();
//		
//		ModelAndView mav = new ModelAndView();
//		
//		Object retVal = null;
//		try {
//			HttpServletRequest request = (HttpServletRequest) request.getSession();
//			MembersDTO dto = (MembersDTO) request.getSession().getAttribute("");
//			Object[] args = pjp.getArgs();
//			VisitBookDTO vdto = dao.selectOnBySeq((Integer)args[0]);
//			if(dto.getId().equals(vdto.getWriter())) {
//				return retVal = pjp.proceed();
//			}
//		} catch (Throwable e) {
//			e.printStackTrace();
//			mav.addObject("msg", "잘못된 접근입니다");
//			mav.setViewName("error");
//		} 
//		
//		long endTime = System.currentTimeMillis();
//		System.out.println((endTime - startTime) / 1000.0 + "초간 수행");
//		
////		return retVal;
//	}


}
