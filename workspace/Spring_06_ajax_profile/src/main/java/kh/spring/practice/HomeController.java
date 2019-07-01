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
	
	//value = "/", method = RequestMethod.GET -> ����Ʈ, �� �� �� ǥ��� �͸� ����Ѵٴ� ��
	//������ ��� ����� ����Ѵٴ� ��
	
	//����Ʈ ����� �� �ٲٴ� ��� : /login?id=?.... = ������ �̷��� �ڵ��ۼ��� ������ ����, ũ�ν�����Ʈ��ũ���ð� ����
	//���� �� ��, post������θ� ����ؼ� get������� ������� ��û�� ������ �� ����
	
	@RequestMapping("/")
	public String home() {
//		return "home";
		return "index";
	}
	
//	@ResponseBody //ajax �񵿱�
//	@RequestMapping("/ajax.do")
//	public String ajaxProc() {
//		System.out.println("AJAX ��������");
////		return ""; //ajax�� �񵿱�� ������ ������ �������� �־�� �� ������ ����(�������� ���������� �Ͼ�� ��) //�̷��� ���� home.jsp�� ���� �ҽ��ڵ尡 ���ϵǰ� ��
//		return "home";
//	}
	
	

	//���� �޼��� ������� ��������?
	//gson
//	@ResponseBody 
//	@RequestMapping("/ajax.do")
//	public String ajaxProc() {
//		MessageDTO dto = new MessageDTO();
//		dto.setSeq(1);
//		dto.setName("jack");
//		dto.setMessage("ajax!");
////		return dto; //�� dto�� string ���·� �ٲ�(���ϰ� string�� �ٲ��� ����)
//		return new Gson().toJson(dto); //network response = {"seq":1,"name":"jack","message":"ajax!"}
//	}
	
	//�������� dto�� ��������?
	@ResponseBody 
	@RequestMapping("/ajax.do")
	public String ajaxProc() {
		List<MessageDTO> arr = new ArrayList();
		arr.add(new MessageDTO(1, "Jane", "Hello"));
		arr.add(new MessageDTO(2, "Mike", "Spring"));
		arr.add(new MessageDTO(3, "Susan", "Ajax"));
		
		//������ ���� �����
		Integer.parseInt("abc"); //try catch�� �����Ƿ� ���ܰ� �Ʒ��� �������� �� �ƴ� throw�� ��������, Ŭ���̾�Ʈ ������ ���� ��
		
		return new Gson().toJson(arr); //[{"seq":1,"name":"Jane","message":"Hello"},{"seq":2,"name":"Mike","message":"Spring"},{"seq":3,"name":"Susan","message":"Ajax"}]
		//list�� ���Ͻ�Ű�� �ڵ����� �迭�� �������
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
