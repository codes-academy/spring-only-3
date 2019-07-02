package kh.spring.stomp;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Controller;

import kh.spring.dto.MessageDTO;

@Controller
public class ChatController {
	
//	@Autowired
//	private HttpSession session; //���� ERROR: org.springframework.web.socket.messaging.WebSocketAnnotationMethodMessageHandler - Unhandled exception from message handler method
	
//	@RequestMapping() //http
	@MessageMapping("/chat") //ws
	@SendTo("/response") //"chat"���� ���� ~�۾��� �� �� "response"�� ������ ����, send to�� "response"�� �����ϰ� �ִ� ����鿡�� ������
//	public String messageProc(String message) {
//		System.out.println(message);
//		return "abc";
//	}
	public MessageDTO messageProc(StompHeaderAccessor sha, MessageDTO dto) {
		System.out.println(sha.getSessionAttributes().get("id"));
//		dto.setName("jack");
		dto.setName(sha.getSessionAttributes().get("id").toString());
		
//		System.out.println(session.getAttribute("id")); //���� ERROR: org.springframework.web.socket.messaging.WebSocketAnnotationMethodMessageHandler - Unhandled exception from message handler method
		
		System.out.println(dto.getName()); //null
		System.out.println(dto.getMessage()); //input message ����
		return dto; //{"name":"jack","message":"hello"}
		//������ messageDTOŸ���ε� Ŭ���̾�Ʈ�� ���� ���� jsonŸ��
	}
}

//1. ������ ������ �߰�
//2. jackson �߰�
//3. ���Ŀ�� ����� - ���� �� ä�� �޼����� ���� ��������, ������ ��� �Ұ���