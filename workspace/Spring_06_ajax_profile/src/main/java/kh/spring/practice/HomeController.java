package kh.spring.practice;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import kh.spring.dao.MembersDAO;
import kh.spring.dto.MembersDTO;
import kh.spring.dto.MessageDTO;

@Controller
public class HomeController {

	@Autowired
	MembersDAO mdao;
	
	@Autowired
	HttpSession session;
	
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	//value = "/", method = RequestMethod.GET -> 포스트, 겟 둘 중 표기된 것만 허용한다는 뜻
	//없으면 모든 방식을 허용한다는 뜻
	
	//포스트 방식을 겟 바꾸는 방법 : /login?id=?.... = 하지만 이러면 자동작성될 여지가 있음, 크로스사이트스크립팅과 유사
	//글을 쓸 때, post방식으로만 허용해서 get방식으로 날라오는 요청을 무시할 수 있음
	
	@RequestMapping("/")
	public String home() {
//		return "home";
		return "index";
	}
	
//	@ResponseBody //ajax 비동기
//	@RequestMapping("/ajax.do")
//	public String ajaxProc() {
//		System.out.println("AJAX 동작했음");
////		return ""; //ajax는 비동기기 때문에 포워딩 페이지가 있어야 할 이유가 없음(포워딩은 서버측에서 일어나는 일) //이렇게 쓰면 home.jsp가 가진 소스코드가 리턴되게 됨
//		return "home";
//	}
	
	

	//여러 메세지 목록으로 보내려면?
	//gson
//	@ResponseBody 
//	@RequestMapping("/ajax.do")
//	public String ajaxProc() {
//		MessageDTO dto = new MessageDTO();
//		dto.setSeq(1);
//		dto.setName("jack");
//		dto.setMessage("ajax!");
////		return dto; //이 dto를 string 형태로 바꿈(리턴값 string은 바뀌지 않음)
//		return new Gson().toJson(dto); //network response = {"seq":1,"name":"jack","message":"ajax!"}
//	}
	
	//여러개의 dto를 넣으려면?
	@ResponseBody 
	@RequestMapping("/ajax.do")
	public String ajaxProc() {
		List<MessageDTO> arr = new ArrayList();
		arr.add(new MessageDTO(1, "Jane", "Hello"));
		arr.add(new MessageDTO(2, "Mike", "Spring"));
		arr.add(new MessageDTO(3, "Susan", "Ajax"));
		
		//강제로 예외 만들기
		Integer.parseInt("abc"); //try catch가 없으므로 예외가 아래로 떨어지는 게 아닌 throw로 나가버림, 클라이언트 오류를 보게 됨
		
		return new Gson().toJson(arr); //[{"seq":1,"name":"Jane","message":"Hello"},{"seq":2,"name":"Mike","message":"Spring"},{"seq":3,"name":"Susan","message":"Ajax"}]
		//list를 리턴시키니 자동으로 배열을 만들어줌
	}
	
	
	
	//------------------------------------------------------------

	@RequestMapping("/Join")
	public String join() {
		return "join";
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
	public String login(HttpServletRequest request) {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		System.out.println(id + ":" + pw);
		boolean result = mdao.login(id, pw);
		if(result) {
			session.setAttribute("id", id);
			return "index";
		}else {
			return "error";
		}
	}

	@RequestMapping("/logout")
	public String logout() {
		session.invalidate();
		return "index";
	}
}
