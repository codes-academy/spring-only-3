package kh.spring.practice;


import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberController {
	
//	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
	
	@RequestMapping("login")
	public String login(String id) {
//		System.out.println(sdf.format(System.currentTimeMillis()) + "�� Login ����");
		return "home";
	}
	
	@RequestMapping("logout")
	public String logout() {
//		System.out.println(sdf.format(System.currentTimeMillis()) + "�� Logout ����");
		return "home";
	}
	
	@RequestMapping("mypage")
	public String mypage() {
//		System.out.println(sdf.format(System.currentTimeMillis()) + "�� Mypage ����");
		return "home";
	}
	
}
