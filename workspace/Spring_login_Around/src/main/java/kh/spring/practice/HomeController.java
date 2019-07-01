package kh.spring.practice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import kh.spring.dao.MembersDAO;
import kh.spring.dto.MembersDTO;

@Controller
public class HomeController {

	@Autowired
	MembersDAO mdao;
	
	@Autowired
	HttpSession session;
	
	@RequestMapping("/")
	public String home() {
		return "index";
	}
	
	@RequestMapping("/Join")
	public ModelAndView join() {
		return new ModelAndView("join");
	}
	@RequestMapping("/joinDone")
	public String joinDone(MembersDTO dto) {
		int result = mdao.insert(dto);
		if(result>0) {
			return "index";
		}else {
			return "error";
		}
	}
	@ResponseBody
	@RequestMapping("/idDupAjax")
	public String idDupAjax(HttpServletRequest request) {
		String result = mdao.idDup(request.getParameter("key"));
		return result;
	}
	@RequestMapping("/login")
	public ModelAndView login(HttpServletRequest request) {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		System.out.println(id + ":" + pw);
		boolean result = mdao.login(id, pw);
		if(result) {
			session.setAttribute("id", id);
			return new ModelAndView("index");
		}else {
			return new ModelAndView("error");
		}
	}

	@RequestMapping("/logout")
	public String logout() {
		session.invalidate();
		return "index";
	}
}
