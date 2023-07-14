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

@ServerEndpoint(value = "/chat", configurator = HttpSessionSetter.class) //ws://localhost/chat�� chat
//������ �����̳� �����Ͽ� ���� �ʾƼ� mvc2������ ��� ����
//(/)������ �־�� ��
public class WebChat {
  //�������� Ŭ���̾�Ʈ���� ������ ä�� ������ �Ѹ����� ��� ����ڵ��� ���� ������ �˰� �־�� ��
  private static Set<Session> clients = Collections.synchronizedSet(new HashSet<Session>()); //datainputstrea dataoutputstream�� ����
  //�׳� new HashSet()�� �ƴ϶� collection..�� ������ ����ȭ������(�߰��� ����ڰ� ���� ��..)

//	private MemberDTO dto;

  @OnMessage
  //Ŭ���̾�Ʈ ���� ������ �޼��尡 �����ϴ� ����
  public void onMessage(String message, Session session) throws Exception { //�Ѿ���� �޼���, �������� ���� 2������ ����
    synchronized (clients) { //collection.synchro..�� ������ �� �ǰ�, �̷��� ������ ��
      for (Session each : clients) {
        //clients����Ʈ���� ���� �Ѹ��� �̾Ƴ�
        if (each != session) {
//				each.getBasicRemote().sendText(dto.getId + ":" + message + "<br>");
          each.getBasicRemote().sendText(message + "<br>"); //dataoutputstream�� write����
        } //a�� ���� ������ a���� ���̱� ������, if�� ������ ����(���� ���� ������ �ٽ� ���� �������� �ʰ� - ���� ���� ������ �׳� ���� �ٿ��ֱ���)
      }
    }
  }

  //Ŭ���̾�Ʈ�� ����, ������ �̷��� ��
  @OnOpen
  public void onOpen(Session session, EndpointConfig ec) { //session=�������� ������ ��� ��ü
    HttpSession hsession = (HttpSession) ec.getUserProperties().get("httpSession"); //put�س��� ������ �������
//		System.out.println(hsession.getAttribute("data"));
//		this.dto = hsession.getAttribute("loginDTO"); //�������� Ŭ���̾�Ʈ�� ������ ������ �ؼ� ����
    clients.add(session);
    System.out.println("������ �߻�");
  }

  @OnClose
  public void onClose(Session session) {
    clients.remove(session);
  }

}
