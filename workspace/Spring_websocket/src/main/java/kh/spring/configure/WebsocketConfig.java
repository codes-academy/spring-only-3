package kh.spring.configure;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.StompWebSocketEndpointRegistration;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;

//@Component //빈을 추가하기 위한 최상위 어노테이션
@Configuration
//특정 옵션을 설정하기 위한 빈으로 만들어짐
@EnableWebSocketMessageBroker
public class WebsocketConfig implements WebSocketMessageBrokerConfigurer {
  //인터페이스인데 override도 됨 - 디폴트 메서드는 추가가능(자바 1.8이후)
  @Override
  public void configureMessageBroker(MessageBrokerRegistry registry) {
    registry.setApplicationDestinationPrefixes("/app"); //app/chat 이 채팅 주소가 됨 - 빼도 되지만 일반 url과 구분하기 위함
    //endpoint는 연결정보일 뿐, 실제 메세지 전송 url은 따로 만들어짐
    registry.enableSimpleBroker("/response"); //클라이언트가 listen할 url(응답을 받을 url) - 구독 개념
  }

  @Override
  public void registerStompEndpoints(StompEndpointRegistry registry) {
    StompWebSocketEndpointRegistration ser = registry.addEndpoint("/webchat"); //클라이언트가 웹소켓을 통해 접속할 url패턴을 생성 (endpoint 생성)
    //ser은 세션정보를 공유할 때 사용
    ser.setAllowedOrigins("*"); //모든 crossorigin 이슈 끔
    ser.addInterceptors(new HttpSessionHandshakeInterceptor()); //세션정보를 가져옴 //클라이언트에게서 오는 패킷을 가로챔
    ser.withSockJS();
  }
}
//브로커