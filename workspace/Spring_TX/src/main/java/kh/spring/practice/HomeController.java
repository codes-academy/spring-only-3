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
  BuyService2 bservice; //�������� ���� new�� �� ���� �������� �ν����� ���� �� ������ ����

  @RequestMapping("/")
  public String home() {
    return "home";
  }

//	@RequestMapping("buy.do")
//	public String buyProc(PayDTO dto) {
//		try(
//			Connection con = this.ds.getConnection(); //pdao, sdao �� �� Ŀ�ؼ� �ϳ��� �����ϰ� ��
//				){
//			pdao.insert(dto);
//			sdao.insert(new SellerDTO(0, "jack", dto.getPid()));
////			sdao.insert(new SellerDTO(0, (String)session.getAttribute("id"), dto.getPid()));
//			//seq, ������, ��ǰ����
//		}catch(Exception e) {
//			e.printStackTrace(); 
//			//rollback�� �Ͼ�� �ϴ� ����
//			return "error";
//		}
//		//commit�� �Ͼ�� �ϴ� ����
//		return "home";
//	}

//	@RequestMapping("buy.do")
//	public String buyProc(PayDTO dto) {
//		Connection con = null;
//		try{
//			con = this.ds.getConnection();
//			pdao.insert(con, dto);
//			sdao.insert(con, new SellerDTO(0, "jackffffffffffffffffffffffffffffffffffffffffff", dto.getPid())); //���ܸ� �߻���Ű�� pdao, sdao �� �� ���� ���� �ʴ� ���� �� �� ����(�ѹ�Ǿ� �� �� �Է��� ���� ����)
////			sdao.insert(new SellerDTO(0, (String)session.getAttribute("id"), dto.getPid()));
//			//seq, ������, ��ǰ����
//			con.commit(); //<property name="defaultAutoCommit" value="false"/>
//		}catch(Exception e) {
//			e.printStackTrace(); 
//			//rollback�� �Ͼ�� �ϴ� ����
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
//		//commit�� �Ͼ�� �ϴ� ����
//		return "home";
//	}

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
