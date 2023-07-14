<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <script src="https://code.jquery.com/jquery-3.4.1.js"></script>
  <title>Insert title here</title>

  <style>
    body {
      text-align: center;
    }

    table {
      width: 500px;
      border-collapse: collapse;
    }

    .my {
      border: 1px solid black;
      width: 200px;
      height: 300px;
      margin-top: 50px;
    }

    #chatView {
      height: 170px;
      overflow-y: auto;
    }
  </style>
</head>
<body>
<script>
  window.onload = function () {
    document.getElementById("btn").addEventListener("click", function () {
      location.href = "/write";
    });
    $(".title").on('click', function () {
      $(location).attr('href', '/clickTitle?seq=' + $(this).parents().find('.seq').html());
    });
  }
</script>

<table border="1">
  <tr style="height:30px;">
    <td colspan="6">자유게시판</td>
  </tr>
  <tr>
    <th>글번호</th>
    <th>글제목</th>
    <th>작성자</th>
    <th>작성일</th>
    <th>조회수</th>
    <th>ip주소</th>
  </tr>

  <div id='list'>
    <c:forEach var="list" items="${lists }">
      <tr style="height:30px;">
        <td class="seq">${list.seq }</td>
        <td class="title">${list.title }</a></td>
        <td>${list.writer }</td>
        <td>${list.writedate }</td>
        <td>${list.viewcount }</td>
        <td>${list.ipaddr }</td>
      </tr>
    </c:forEach>
  </div>

  <!--     <tr style="height:450px;" id='nolist'> -->
  <!--         <td colspan="6" align="center">글이 없습니다</td> -->
  <!--     </tr> -->
  <tr style="height:30px;">
    <td colspan="6" align="center">${navi }</td>
  </tr>
  <tr style="height:30px;">
    <td colspan="6" align="right">
      <button type='button' id='btn'>글 쓰기</button>
    </td>
  </tr>
</table>

<div id="container" class="my">
  <div id="chatView"></div>
  <div id="chatInsert">
    <input type="text" id="input">
    <button id="chatBtn">chat!</button>
  </div>
</div>
<script>
  var socket = new WebSocket("ws://192.168.60.16/board");
  socket.onmessage = function (evt) {
    $('#chatView').append(evt.data);
  }
  $('#chatBtn').on("click", function () {
    var msg = $('#input').val();
    $('#chatView').append("내가 보낸 메세지 : " + msg + "<br>");
    $('#input').val("");
    socket.send(msg);
  });
</script>
</body>
</html>