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
//	private HttpSession session; //오류 ERROR: org.springframework.web.socket.messaging.WebSocketAnnotationMethodMessageHandler - Unhandled exception from message handler method
	
//	@RequestMapping() //http
	@MessageMapping("/chat") //ws
	@SendTo("/response") //"chat"으로 들어와 ~작업을 한 후 "response"로 내뱉은 다음, send to로 "response"를 구독하고 있는 사람들에게 보내라
//	public String messageProc(String message) {
//		System.out.println(message);
//		return "abc";
//	}
	public MessageDTO messageProc(StompHeaderAccessor sha, MessageDTO dto) {
		System.out.println(sha.getSessionAttributes().get("id"));
//		dto.setName("jack");
		dto.setName(sha.getSessionAttributes().get("id").toString());
		
//		System.out.println(session.getAttribute("id")); //오류 ERROR: org.springframework.web.socket.messaging.WebSocketAnnotationMethodMessageHandler - Unhandled exception from message handler method
		
		System.out.println(dto.getName()); //null
		System.out.println(dto.getMessage()); //input message 나옴
		return dto; //{"name":"jack","message":"hello"}
		//리턴은 messageDTO타입인데 클라이언트가 받은 것은 json타입
	}
}

//1. 스프링 웹소켓 추가
//2. jackson 추가
//3. 브로커를 만든다 - 연결 시 채팅 메세지를 어디로 보내는지, 응답은 어떻게 할건지