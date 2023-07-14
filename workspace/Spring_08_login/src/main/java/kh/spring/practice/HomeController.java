package kh.spring.practice;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;

import kh.spring.dao.BoardDAO;
import kh.spring.dao.MembersDAO;
import kh.spring.dto.BoardDTO;
import kh.spring.dto.MembersDTO;

@Controller
public class HomeController {

  @Autowired
  MembersDAO mdao;
  @Autowired
  BoardDAO bdao;

  @Autowired
  HttpSession session;
  @Autowired
  HttpServletRequest request;


  @RequestMapping("/")
  public String home() {
    return "index";
//		return "profile";
  }

  @RequestMapping("/Join")
  public String join() {
    return "join";
  }

  @RequestMapping("/joinDone")
  public String joinDone(MembersDTO dto) {
    int result = mdao.insert(dto);
    if (result > 0) {
      return "profile";
    } else {
      return "error";
    }
  }

  @ResponseBody
  @RequestMapping("/idDupAjax")
  public String idDupAjax(HttpServletRequest request) {
    String result = mdao.idDup(request.getParameter("key"));
//		System.out.println(result);
    return result;
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
  @RequestMapping("/profile")
  public String profile(MultipartFile image) {
    System.out.println(image);
    String uploadPath = session.getServletContext().getRealPath("resources");
    System.out.println(uploadPath + " : " + image.getSize());

    String prof = System.currentTimeMillis() + "_image.png";
    try {
      image.transferTo(new File(uploadPath + "/" + prof));
      session.setAttribute("img", "resources/" + prof);
    } catch (Exception e) {
      e.printStackTrace();
    }
//		return "profile";
    return "resources/" + prof;
  }

  @ResponseBody
  @RequestMapping("/picture")
  public String[] picture(MultipartFile image[]) {
    String uploadPath = session.getServletContext().getRealPath("resources");

    String list[] = new String[image.length];
    for (int i = 0; i < image.length; i++) {
      try {
        String prof = System.currentTimeMillis() + "_" + i + "_image.png";
        image[i].transferTo(new File(uploadPath + "/" + prof));
        list[i] = "resources/" + prof;
        System.out.println("resources/" + prof);
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    return list;
  }


  @RequestMapping("/logout")
  public String logout() {
    session.invalidate();
    return "logout";
  }

  @RequestMapping("/board")
  public String board() {
    int firstPost = 1;
    int endPost = firstPost * 10;
    List<BoardDTO> lists = bdao.selectByPage(firstPost, endPost);
    String navi = bdao.getNavi(firstPost);
    session.setAttribute("navi", navi);
    session.setAttribute("lists", lists);
    return "board";
  }

  @RequestMapping("/paging")
  public String paging(int currentPage) {
    int pageNum = currentPage;
    System.out.println(currentPage);
    int end = currentPage * 10;
    int first = end - 9;
    List<BoardDTO> dto = bdao.selectByPage(first, end);
    request.setAttribute("lists", dto);
    String navi = bdao.getNavi(pageNum);
    request.setAttribute("navi", navi);
    request.setAttribute("currentPage", currentPage);
    return "board";
  }

  @RequestMapping("/write")
  public String write() {
    return "write";
  }

  @RequestMapping("/writeDone")
  public ModelAndView writeDone(BoardDTO dto) {
    bdao.insertBoard(dto);
    ModelAndView mav = new ModelAndView();
    mav.addObject("list", dto);
    mav.setViewName("post");
    return mav;
  }

  @RequestMapping("/clickTitle")
  public String clickTitle(int seq) {
    BoardDTO list = bdao.clickTitle(seq);
    session.setAttribute("list", list);
    return "post";
  }

  @ResponseBody
  @RequestMapping("/fileUpload")
  public String fileUpload(MultipartFile image) {
    System.out.println(image);
    String uploadPath = session.getServletContext().getRealPath("resources");
    System.out.println(uploadPath);
    String name = System.currentTimeMillis() + "_image.png";
    try {
      image.transferTo(new File(uploadPath + "/" + name));
    } catch (Exception e) {
      e.printStackTrace();
    }
    return "resources/" + name;
  }

  @ResponseBody
  @RequestMapping("/snail")
  public String sanil(BoardDTO dto) {
    System.out.println(dto.getSnail());
    System.out.println(dto.getTitle());
    System.out.println(dto.getContents());
    return "write";
  }

}
