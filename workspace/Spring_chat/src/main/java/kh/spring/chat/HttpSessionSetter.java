package kh.spring.chat;

import javax.servlet.http.HttpSession;
import javax.websocket.HandshakeResponse;
import javax.websocket.server.HandshakeRequest;
import javax.websocket.server.ServerEndpointConfig;

public class HttpSessionSetter extends ServerEndpointConfig.Configurator { //ServerEndpointConfig.Configurator = �̳�Ŭ���� //Ŭ���� �ȿ� �ִ� Ŭ������ ��ӹ���
  @Override
  public void modifyHandshake(ServerEndpointConfig sec, HandshakeRequest request, HandshakeResponse response) {
    // ����� �����ϱ� ���� ���� ������ �ְ�޴� ����(�̷��� ������ �� ���̴� - �̷��� ������ ���� ���̴� // ������ �ְ������ ��Ʈ��ũ ��Ŷ�� ������ ������ ��ħ = handshake)

    //���������� ������
    HttpSession hsession = (HttpSession) request.getHttpSession();
//		sec.getUserProperties().put("httpSession", hsession);
    //������ ���� ���� webchat @onopen�� endpointconfig�� �Ű����� �޾���

    System.out.println(hsession);
    System.out.println(sec);
    System.out.println(sec.getUserProperties());
  }
}
