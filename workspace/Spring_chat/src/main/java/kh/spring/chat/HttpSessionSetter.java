package kh.spring.chat;

import javax.servlet.http.HttpSession;
import javax.websocket.HandshakeResponse;
import javax.websocket.server.HandshakeRequest;
import javax.websocket.server.ServerEndpointConfig;

public class HttpSessionSetter extends ServerEndpointConfig.Configurator { //ServerEndpointConfig.Configurator = 이너클래스 //클래스 안에 있는 클래스를 상속받음
  @Override
  public void modifyHandshake(ServerEndpointConfig sec, HandshakeRequest request, HandshakeResponse response) {
    // 통신을 연결하기 위해 서로 사전에 주고받는 정보(이렇게 연결을 할 것이다 - 이렇게 연결을 받을 것이다 // 정보를 주고받으며 네트워크 패킷이 오가는 과정을 거침 = handshake)

    //세션정보를 가져옴
    HttpSession hsession = (HttpSession) request.getHttpSession();
//		sec.getUserProperties().put("httpSession", hsession);
    //세션을 넣은 다음 webchat @onopen에 endpointconfig로 매개변수 받아줌

    System.out.println(hsession);
    System.out.println(sec);
    System.out.println(sec.getUserProperties());
  }
}
