package kh.spring.practice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import kh.spring.dao.MessageDAO;
import kh.spring.dto.MessageDTO;


public class inputProcController implements Controller {

  @Autowired
  private MessageDAO mdao;


  @Override
  public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {

    String name = request.getParameter("name");
    String message = request.getParameter("message");


    System.out.println(name + " : " + message);

    ModelAndView mav = new ModelAndView();
//		mav.setViewName("WEB-INF/index.jsp"); //이렇게 되면 /로 포워딩됨
    //http://localhost/inputProc.do 주소창에 이렇게 뜸
    //f5 누르면 "찾고 있는 페이지에서 사용자가 입력한 정보를 사용했습니다. 해당 페이지로 돌아가면 기존 작업을 반복할 수 있습니다. 계속하시겠습니까?"가 뜨며 인풋 정보가 다시 출력됨


    try {
      int result = mdao.insert(new MessageDTO(0, name, message));
    } catch (Exception e) {
      e.printStackTrace();
      mav.setViewName("redirect:error.do");
      return mav;
    }


    //입력이 끝나 메인페이지로 돌려보낼 땐 - 리다이렉트
    //포워드는 리퀘스트를 가지고 이동하기 때문에 새로고침하면 살아있는 리퀘스트가 다시 한번 더 작동됨, url도 안 바뀜
    //주소가 input.do면, input.do에 삽입된 메서드가 있으므로 새로고침 하면 다시 한번 더 작동되는 것
    //나의 요청이 다른 페이지로 이어지는 경우 - 포워드
    //나의 요청이 다른 페이지로 이어지지 않는 경우 - 리다이렉트
    mav.setViewName("redirect:/"); //redirect:(가고싶은 url)
    //리다이렉트 할때는 매핑되어 있는 정보를 써 줘야 함
    //고객이 접속할 때는 주소창을 통해서만 접속할 수 있기 때문에 url패턴을 써 줘야 함

    return mav;
  }
}
