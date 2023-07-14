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
  BuyServiceImpl bservice; //�������� ���� new�� �� ���� �������� �ν����� ���� �� ������ ����

  @RequestMapping("/")
  public String home() {
    return "home";
  }

  @RequestMapping("buy.do")
  public String buyProc(PayDTO dto) {
//		BuyService2 b = new BuyService(); //�������� ���� ������� Ŭ������ �ƴϰ�, ���� ���� �ű� ������ ������ �� ����
    try {
      bservice.buy(dto);
    } catch (Exception e) {
      e.printStackTrace();
      return "error";
    }
    return "home";
  }


}
