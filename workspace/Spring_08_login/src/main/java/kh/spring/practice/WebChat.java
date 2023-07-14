package kh.spring.practice;

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


@ServerEndpoint(value = "/board", configurator = HttpSessionSetter.class)
public class WebChat {

  private static Set<Session> clients = Collections.synchronizedSet(new HashSet<Session>());
  private String id;

  @OnMessage
  public void onMessage(String message, Session session) throws Exception {
    synchronized (clients) {
      for (Session each : clients) {
        if (each != session) {
          each.getBasicRemote().sendText(id + ":" + message + "<br>");
        }
      }
    }
  }

  @OnOpen
  public void onOpen(Session session, EndpointConfig ec) {
    HttpSession hsession = (HttpSession) ec.getUserProperties().get("httpSession");
    this.id = (String) hsession.getAttribute("id");
    clients.add(session);
    System.out.println("접속자 발생");
  }

  @OnClose
  public void onClose(Session session) {
    clients.remove(session);
  }

}
