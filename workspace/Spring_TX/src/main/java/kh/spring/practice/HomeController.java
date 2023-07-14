package kh.spring.practice;

import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import kh.spring.dao.PayDAO;
import kh.spring.dao.SellerDAO;
import kh.spring.dto.PayDTO;
import kh.spring.service.BuyService2;

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
  BuyService2 bservice; //스프링을 쓰며 new를 쓸 때는 스프링이 인식하지 못할 수 있으니 주의

  @RequestMapping("/")
  public String home() {
    return "home";
  }

//	@RequestMapping("buy.do")
//	public String buyProc(PayDTO dto) {
//		try(
//			Connection con = this.ds.getConnection(); //pdao, sdao 가 이 커넥션 하나를 공유하게 됨
//				){
//			pdao.insert(dto);
//			sdao.insert(new SellerDTO(0, "jack", dto.getPid()));
////			sdao.insert(new SellerDTO(0, (String)session.getAttribute("id"), dto.getPid()));
//			//seq, 고객정보, 상품정보
//		}catch(Exception e) {
//			e.printStackTrace(); 
//			//rollback이 일어나야 하는 시점
//			return "error";
//		}
//		//commit이 일어나야 하는 시점
//		return "home";
//	}

//	@RequestMapping("buy.do")
//	public String buyProc(PayDTO dto) {
//		Connection con = null;
//		try{
//			con = this.ds.getConnection();
//			pdao.insert(con, dto);
//			sdao.insert(con, new SellerDTO(0, "jackffffffffffffffffffffffffffffffffffffffffff", dto.getPid())); //예외를 발생시키면 pdao, sdao 둘 다 값이 들어가지 않는 것을 알 수 있음(롤백되어 둘 다 입력이 되지 않음)
////			sdao.insert(new SellerDTO(0, (String)session.getAttribute("id"), dto.getPid()));
//			//seq, 고객정보, 상품정보
//			con.commit(); //<property name="defaultAutoCommit" value="false"/>
//		}catch(Exception e) {
//			e.printStackTrace(); 
//			//rollback이 일어나야 하는 시점
//			try {
//				con.rollback();
//			} catch (SQLException e1) {
//				e1.printStackTrace();
//			}
//			return "error";
//		}finally {
//			try {
//				if(con!=null) con.close();
//			}catch(Exception e) {}
//		}
//		//commit이 일어나야 하는 시점
//		return "home";
//	}

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
