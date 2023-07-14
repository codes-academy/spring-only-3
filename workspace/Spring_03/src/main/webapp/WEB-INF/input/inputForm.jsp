<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>Insert title here</title>
</head>
<body>
Input

<form action="inputProc.do" method="post">
  <input type="text" name="name"><br>
  <input type="text" name="message"><br>
  <input type="submit" value="send">
  <button id="back">back</button>
</form>

<script>
  document.getElementById('back').onclick = function () {
    location.href = "/"; //돌아가기
// 			history.back(); //뒤로가기
  }
</script>
</body>
</html>