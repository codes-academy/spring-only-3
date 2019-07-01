package kh.spring.practice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class HomeController {
	
	@Autowired
	private HttpSession session;
	
	@RequestMapping("/")
	public String home() {
		session.setAttribute("data", "data");
		return "home";
	}
	
	@RequestMapping("webchat")
	public String webChat() {
		return "webchat";
	}
	
	//�����ϰ� ����ϱ� ���ؼ� requestmapping�� �ƴ�, ���ο� ���� �ʿ��� -> Ŭ���� ����
	

}
