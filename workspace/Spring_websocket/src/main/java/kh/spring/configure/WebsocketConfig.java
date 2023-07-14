package kh.spring.configure;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.StompWebSocketEndpointRegistration;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;

//@Component //���� �߰��ϱ� ���� �ֻ��� ������̼�
@Configuration
//Ư�� �ɼ��� �����ϱ� ���� ������ �������
@EnableWebSocketMessageBroker
public class WebsocketConfig implements WebSocketMessageBrokerConfigurer {
  //�������̽��ε� override�� �� - ����Ʈ �޼���� �߰�����(�ڹ� 1.8����)
  @Override
  public void configureMessageBroker(MessageBrokerRegistry registry) {
    registry.setApplicationDestinationPrefixes("/app"); //app/chat �� ä�� �ּҰ� �� - ���� ������ �Ϲ� url�� �����ϱ� ����
    //endpoint�� ���������� ��, ���� �޼��� ���� url�� ���� �������
    registry.enableSimpleBroker("/response"); //Ŭ���̾�Ʈ�� listen�� url(������ ���� url) - ���� ����
  }

  @Override
  public void registerStompEndpoints(StompEndpointRegistry registry) {
    StompWebSocketEndpointRegistration ser = registry.addEndpoint("/webchat"); //Ŭ���̾�Ʈ�� �������� ���� ������ url������ ���� (endpoint ����)
    //ser�� ���������� ������ �� ���
    ser.setAllowedOrigins("*"); //��� crossorigin �̽� ��
    ser.addInterceptors(new HttpSessionHandshakeInterceptor()); //���������� ������ //Ŭ���̾�Ʈ���Լ� ���� ��Ŷ�� ����è
    ser.withSockJS();
  }
}
//���Ŀ