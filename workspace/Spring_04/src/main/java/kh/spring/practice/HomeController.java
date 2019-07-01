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
		
//		return "WEB-INF/views/home.jsp";
		//������ ���(�����̷�Ʈ������ web-inf�� �� ���� �״ϱ�)
		
		
		//�� �����갡 ���� ���
		//WEB-INF/views/WEB-INF/views/home.jsp.jsp
		
		//����
		return "home";
		
	}
	
	@RequestMapping("/inputForm")
	public String toInputForm() {
		return "inputForm";
	}

	
	//���� �������� ������Ʈ�� �ʿ�����, ��� ������? = (HttpRequest request) �Ű������� ä����
//	@RequestMapping("/inputProc")
//	public String toInputProc(HttpServletRequest request) {
	public String toInputProc(String name, String message) { //�Ű������� �̸��� �Ѿ���� name�Ӽ��� ���絵 �� 
//		String name = request.getParameter("name");
//		String message = request.getParameter("message");
		System.out.println(name + " : " + message);
		return "home";
	}

//	public String toInputProc(String name, String message, HttpSession session) { //������ �߰��� ���� ����
//	} 
	//�������� ���ǰ��� �ѱ� ���� dto���� �ʵ��� �̸��� ��Ʈ����Ʈ �Ӽ��� ���缭 ������ ��(setter�� �ִٴ� ���� �Ͽ�)
	
	
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
			List<MessageDTO> list = mdao.select();
//			request.setAttribute("lists", list);
			ModelAndView mav = new ModelAndView();
			mav.addObject("lists", list);
			mav.setViewName("outputForm");
			return mav;
		} catch (Exception e) {
			e.printStackTrace();
//			return "error.jsp";
			return null;
		}
//		return "outputForm";
	}
	
}
