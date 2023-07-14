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
//@RequestMapping("/board") //Ÿ�� ������Ʈ : board�ؿ� �ִ� jsp���� �� ��Ʈ�ѷ��� ����
public class HomeController {

  @Autowired
  private HttpSession session; //������ �̷��� �־ ��

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
  }//�������� ���� �ѱ� ���� dto���� �ʵ��� �̸��� ��Ʈ����Ʈ �Ӽ��� ���缭 ������ ��(setter�� �ִٴ� ���� �Ͽ�)

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
