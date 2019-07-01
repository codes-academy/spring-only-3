package kh.spring.practice;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import kh.spring.dao.MembersDAO;
import kh.spring.dao.MessageDAO;
import kh.spring.dto.MembersDTO;
import kh.spring.dto.MessageDTO;
import kh.spring.dto.TempDTO;
import kh.spring.service.Services;

@Controller
public class HomeController {
	
	@Autowired
	MessageDAO dao;
	@Autowired
	Services ser;
	@Autowired
	MembersDAO mdao;
	@Autowired
	HttpSession session;
	
	@RequestMapping("/")
	public String home() {
		return "home";
	}
	
	@RequestMapping("insert")
	public String insert() {
		dao.insert();
		return "home";
	}
	@RequestMapping("select")
	public String select() {
		List<MessageDTO> list = dao.select();
		for(MessageDTO tmp : list) {
			System.out.println(tmp.getSeq() + " : " + tmp.getName() + " : " + tmp.getMessage());
		}
		return "home";
	}
//	@RequestMapping("selectOne")
//	public String selectOne() {
//		MessageDTO dto = dao.selectBySeq();
//		System.out.println(dto.getSeq() + " : " + dto.getName() + " : " + dto.getMessage());
//		return "home";
//	}
	@RequestMapping("selectOne")
	public String selectOne() {
		TempDTO dto = dao.selectBySeq();
		System.out.println(dto.getNum() + " : " + dto.getId() + " : " + dto.getContents());
		return "home";
	}
	@RequestMapping("update")
	public String update() {
		dao.update();
		return "home";
	}
	@RequestMapping("delete")
	public String delete() {
		dao.delete();
		return "home";
	}
	
	@RequestMapping("tx")
//	@Transactional("txManager")
	public String tx() {
		try {
			ser.service();
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "home";
	}
	
	@RequestMapping("myself")
	public String myself(MembersDTO dto) {
		mdao.insert(dto);
//		List<MembersDTO> list = mdao.select();
//		session.setAttribute("list", list);
		return "home";
	}
	
}
