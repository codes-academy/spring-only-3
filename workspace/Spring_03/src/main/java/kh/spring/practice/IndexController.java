package kh.spring.practice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class IndexController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		// '/'를 친 사람이 원하는 것 : 첫 페이지가 나오는 것 (or 내 아이디, 개인정보를 받아서 화면에 뿌려준다?)
		//어디로 가라는 요청을 처리해 줘야 함
		// dispatcher / sendredirect...
		//dao작업을 할 게 없기 때문에 보내주기만 하면 됨
		
		//특이점은 리턴값이 ModelAndView 자료형이라는 것
		//do get, post에서는 "어디로 가라"가 끝이나, 
		//스프링은 요청을 받으면 컨트롤러를 결과 받아서 뷰 리졸브로 보내는 등, ds를 중심으로 왔다갔다를 반복하고 있으므로 단번에 포워딩이나 리다이렉트를 할 수 없음
		//즉, ModelAndView를 디스패처가 받을 수 있는 방식으로 가공해 줘야 함
		
		//가공처리
		ModelAndView mav = new ModelAndView();
				//어디로 갈 것이냐 : 뷰 페이지
				//어떤 내용을 가지고 갈 것이냐 : 
		mav.setViewName("WEB-INF/index.jsp"); // ""의 경로로 보내겠다
		
//		return null;
		return mav;
		//하지만 포워딩, 리다이렉트라는 것을 어떻게 알까?
		//현재 이 방식이 포워딩임
		//이 시점에서 index.jsp를 만들어 실행하면 404가 뜸
		
		//*리다이렉트 : 클라이언트에게 접속을 권함, url을 타고 들어오는 방식이기 때문에 못 보냄
	}

}
