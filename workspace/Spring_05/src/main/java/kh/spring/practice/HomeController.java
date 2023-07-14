package kh.spring.practice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kh.spring.dao.MembersDAO;
import kh.spring.dto.MembersDTO;

@Controller
public class HomeController {

  @Autowired
  MembersDAO mdao;

  @Autowired
  HttpSession session;

  @RequestMapping("/")
  public String index() {
    return "index";
  }

  @RequestMapping("/Join")
  public String join() {
    return "join";
  }

  @RequestMapping("/joinDone")
  public String joinDone(MembersDTO dto) {
    int result = mdao.insert(dto);
    if (result > 0) {
      return "index";
    } else {
      return "error";
    }
  }

  @RequestMapping("/idDup")
  public String idDup(HttpServletRequest request) {
    String result = mdao.idDup(request.getParameter("id"));
    request.setAttribute("result", result);
    return "idDup";
  }

  @RequestMapping("/login")
  public String login(HttpServletRequest request) {
    String id = request.getParameter("id");
    String pw = request.getParameter("pw");
    System.out.println(id + ":" + pw);
    boolean result = mdao.login(id, pw);
    if (result) {
      session.setAttribute("id", id);
      return "index";
    } else {
      return "error";
    }
  }

  @ResponseBody
  @RequestMapping("/idDupAjax")
  public String idDupAjax(HttpServletRequest request) {
    String result = mdao.idDup(request.getParameter("key"));
//		if(result!=null) {
//			return "1";
//		}else {
//			return "2";
//		}
    return result;
  }

}
