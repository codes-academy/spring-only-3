package kh.spring.chat;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpSession;
import javax.websocket.EndpointConfig;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint(value = "/chat", configurator = HttpSessionSetter.class) //ws://localhost/chat의 chat
//스프링 컨테이너 관리하에 있지 않아서 mvc2에서도 사용 가능
//(/)슬래시 넣어야 함
public class WebChat {
  //서버에서 클라이언트에게 각각의 채팅 내용을 뿌리려면 모든 사용자들의 소켓 정보를 알고 있어야 함
  private static Set<Session> clients = Collections.synchronizedSet(new HashSet<Session>()); //datainputstrea dataoutputstream이 포함
  //그냥 new HashSet()이 아니라 collection..인 이유는 동기화때문에(중간에 사용자가 나갈 시..)

//	private MemberDTO dto;

  @OnMessage
  //클라이언트 측에 서버의 메서드가 도착하는 순간
  public void onMessage(String message, Session session) throws Exception { //넘어오는 메세지, 연결정보 세션 2가지를 받음
    synchronized (clients) { //collection.synchro..만 있으면 안 되고, 이렇게 잡아줘야 함
      for (Session each : clients) {
        //clients리스트에서 각각 한명을 뽑아냄
        if (each != session) {
//				each.getBasicRemote().sendText(dto.getId + ":" + message + "<br>");
          each.getBasicRemote().sendText(message + "<br>"); //dataoutputstream의 write역할
        } //a가 보낸 내용이 a에도 보이기 때문에, if로 조건을 넣음(내가 보낸 내용은 다시 내게 도착하지 않게 - 내가 보낸 내용은 그냥 복사 붙여넣기함)
      }
    }
  }

  //클라이언트가 들어옴, 연결이 이뤄질 때
  @OnOpen
  public void onOpen(Session session, EndpointConfig ec) { //session=접속자의 정보를 담는 객체
    HttpSession hsession = (HttpSession) ec.getUserProperties().get("httpSession"); //put해놓은 정보가 들어있음
//		System.out.println(hsession.getAttribute("data"));
//		this.dto = hsession.getAttribute("loginDTO"); //서버에서 클라이언트가 누군지 지정을 해서 보냄
    clients.add(session);
    System.out.println("접속자 발생");
  }

  @OnClose
  public void onClose(Session session) {
    clients.remove(session);
  }

}
