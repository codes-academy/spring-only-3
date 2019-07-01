//package kh.spring.service;
//
//import java.sql.Connection;
//import java.sql.SQLException;
//
//import javax.sql.DataSource;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import kh.spring.dao.PayDAO;
//import kh.spring.dao.SellerDAO;
//import kh.spring.dto.PayDTO;
//import kh.spring.dto.SellerDTO;
//
//@Component
//public class BuyService {
//	
//	@Autowired
//	private PayDAO pdao;
//	@Autowired
//	private SellerDAO sdao;
//	
//	@Autowired
//	private DataSource ds;
//	
////	@Autowired
////	private HttpSession session; //������ ���� ������ ���� �ڵ� �ƴ�. ���̵� �̾Ƽ� ��Ʈ������ �ø�����..
//	
//	public void buy(PayDTO dto) {//Ʈ������ ���� ��Ȳ //�������̽��� ����� : �̷��� ���������� ���� ����� ��
//		Connection con = null;
//		try{
//			con = this.ds.getConnection();
//			pdao.insert(con, dto);
//			sdao.insert(con, new SellerDTO(0, "jack", dto.getPid())); 
//			con.commit();
//		}catch(Exception e) {
//			e.printStackTrace(); 
//			try {
//				con.rollback();
//			} catch (SQLException e1) {
//				e1.printStackTrace();
//			}
//		}finally {
//			try {
//				if(con!=null) con.close();
//			}catch(Exception e) {}
//		}
//	}
//	
//	
//}
