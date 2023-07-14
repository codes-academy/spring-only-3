<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

  <script src="https://code.jquery.com/jquery-3.4.0.min.js"
          integrity="sha256-BJeo0qm959uMBGb65z40ejJYGSgR7REI4+CW1fNKwOg=" crossorigin="anonymous"></script>

  <title>Insert title here</title>
</head>
<style>
  div {
    border: 1px solid black;
    box-sizing: border-box;
  }

  .container {
    width: 400px;
    height: 500px;
    margin: 0 auto;
  }

  .contents {
    width: 100%;
    height: 90%;
    overflow-y: auto;
  }

  .control {
    width: 100%;
    height: 10%;
  }

  .control > input[type="text"] {
    height: 100%;
    width: 80%;
    box-sizing: border-box;
  }

  .control > input[type="button"] {
    height: 100%;
    width: 18%;
    box-sizing: border-box;
  }
</style>
<body>
서버가 클라이언트에게 뭔가 보내려면 필요한 것은 http 프로토콜, 즉 웹 통신이 아님 - 웹 소켓 프로토콜을 써야 함
(http는 서버-클라이언트 양자간)
양쪽 다 소켓이 만들어져야 함
클라이언트:자바x, 자바스크립트
<div class="container">
  <div class="contents">

  </div>
  <div class="control">
    <input type="text" id="input">
    <input type="button" id="send" value="send">
  </div>
</div>
<script>
  //클라이언트 영역
  var socket = new WebSocket("ws://192.168.60.16/chat");
  // 		var socket = new WebSocket("ws://localhost/chat"); //"" = 웹 소켓 서버가 어디에 있느냐 //배포 목적이라면 웹페이지 주소를 써야 함
  //프로토콜이 http가 아니라 ws이기 때면에 "/chat"이라고 써도 컨트롤러로 가지 않음

  //webchat연결작업
  //서버로부터 메세지가 도착한 경우
  socket.onmessage = function (evt) { //evt = 서버측에서 오는 이벤트
    $('.contents').append(evt.data); //메세지가 도착하면 .contents 부분에 받은 메세지를 삽입
    //evt.data = 서버로부터 오는 이벤트의 데이터
  }
  //클라이언트가 서버로 메세지를 보내는 경우
  $('#send').on('click', function () {
    var msg = $('#input').val();
    $('.contents').append("내가 보낸 메세지 : " + msg + "<br>");
    $('#input').val("");
    socket.send(msg);
  });
</script>
</body>
</html>