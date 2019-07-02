<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.3.0/sockjs.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/stomp.js/2.3.3/stomp.min.js"></script>
<title>Insert title here</title>
</head>
<body>
	<div class="contents">
		
	</div>
	<input type="text" id="message">
	<button id="send">send</button>
	
	<script>
		//서버로부터 response url을 통해 내뱉어지는 데이터를 구독하겠다(datainputstream while 돌리는 개념)
		var socket = new SockJS("/webchat"); //불특정 다수의 클라이언트가 어떤 브라우저를 쓸지 모를 때 //""에는 endpoint 주소
// 		var socket = new WebSocket();
		var client = Stomp.over(socket);
		client.connect({}, function(resp){
			console.log(resp);
			client.subscribe("/response", function(msg){ //msg는 고정, body는 클라이언트 재량
// 				console.log(msg);
			
// 				console.log(msg.body); //제이슨으로 받았기 때문에 abc만 뽑혀나옴
				
// 				var result = JSON.parse(msg.body);
// 				console.log(result.name + ":" + result.message);

				var line=$("<div></div>");
				var result = JSON.parse(msg.body);
				line.append(result.name + ":" + result.message);
				$('.contents').append(line);
			});
		}); //첫번째 인자는 리퀘스트의 header정보(쓸데없음), {}인 이유는 key, value 
		
		//메세지 보내기(write utf 개념)
		$('#send').on('click', function(){
			var msg=$('#message').val();
			$('#message').val("");
// 			client.send("/app/chat", {}, msg); //url //header정보 //보낼 데이터(제이슨, 스트링)
			client.send("/app/chat", {}, JSON.stringify({message:msg})); //스트링 타입으로 날라가지만 받을 때 제이슨처럼 생겼으면 스스로 파싱 -> stringify로 묶어줌
		});
		
		//여기까지 실행하면 콘솔창에 뜸
		//n {command: "MESSAGE", headers: {…}, body: "abc", ack: ƒ, nack: ƒ} //제이슨 객체로 받음
	</script>
</body>
</html>