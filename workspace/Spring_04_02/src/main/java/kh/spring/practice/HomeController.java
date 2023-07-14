package kh.spring.practice;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kh.spring.dao.MessageDAO;
import kh.spring.dto.MessageDTO;


@Controller
//@RequestMapping("/board") //타입 리퀘스트 : board밑에 있는 jsp들은 이 컨트롤러로 들어옴
public class HomeController {

  @Autowired
  private HttpSession session; //세션은 이렇게 넣어도 됨

  @Autowired
  private MessageDAO mdao;

  @RequestMapping("/")
  public String index() {
    return "home";
  }

  @RequestMapping("/inputForm")
  public String toInputForm() {
    return "inputForm";
  }

  @RequestMapping("/inputProc")
  public String inputProc(MessageDTO dto) {
    try {
      mdao.insert(dto);
    } catch (Exception e) {
      e.printStackTrace();
      return "error";
    }
    System.out.println(
      dto.getName() + " : " +
        dto.getMessage() + " : " +
        dto.getSeq());
    return "home";
  }//여러가지 값을 넘길 때는 dto만들어서 필드의 이름을 어트리뷰트 속성과 맞춰서 넣으면 됨(setter가 있다는 전제 하에)

  @RequestMapping("/outputProc")
  public ModelAndView outputProc(HttpServletRequest request) {
    try {
      List<MessageDTO> list = mdao.selectAll();
      ModelAndView mav = new ModelAndView();
      mav.addObject("lists", list);
      mav.setViewName("outputForm");
      return mav;
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

}
