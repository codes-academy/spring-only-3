package kh.spring.practice;

import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import kh.spring.dao.PayDAO;
import kh.spring.dao.SellerDAO;
import kh.spring.dto.PayDTO;
import kh.spring.impl.BuyServiceImpl;

//pay
// seq / pid / pname

@Controller
public class HomeController {

  @Autowired
  private PayDAO pdao;
  @Autowired
  private SellerDAO sdao;

  @Autowired
  private DataSource ds;

  @Autowired
  private HttpSession session;

  @Autowired
  BuyServiceImpl bservice; //스프링을 쓰며 new를 쓸 때는 스프링이 인식하지 못할 수 있으니 주의

  @RequestMapping("/")
  public String home() {
    return "home";
  }

  @RequestMapping("buy.do")
  public String buyProc(PayDTO dto) {
//		BuyService2 b = new BuyService(); //스프링에 의해 만들어진 클래스가 아니고, 내가 만든 거기 때문에 오류날 수 있음
    try {
      bservice.buy(dto);
    } catch (Exception e) {
      e.printStackTrace();
      return "error";
    }
    return "home";
  }


}
