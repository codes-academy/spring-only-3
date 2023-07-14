<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>Insert title here</title>
</head>
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
<body>
<form action="/joinDone" method="post">
  <table border="1">
    <tr>
      <td>아이디</td>
      <td><input type="text" name="id" id="id"></td>
      <button type="button" id="idDup">아이디 중복확인</button>
    </tr>
    <tr>
      <td>프로필사진 첨부</td>
      <td><input type="file" name="image"></td>
    <tr>
    <tr>
      <td>비밀번호</td>
      <td><input type="text" name="pw"></td>
    </tr>
    <tr>
      <td>이름</td>
      <td><input type="text" name="name"></td>
    </tr>
    <tr>
      <td>전화번호</td>
      <td><input type="text" name="tel"></td>
    </tr>
    <tr>
      <td><input type="submit" value="가입하기"></td>
      <td><input type="reset"></td>
    </tr>
  </table>
  <p id="result"></p>
</form>

<script>
  $('#id').on('input', function () {
    $.ajax({
      url: ""
    }).done(function (resp) {
      $('#result').append(resp);
    });
  });
  document.getElementById('idDup').addEventListener('click', function () {
    var id = document.getElementById('id').value;
    window.open('/idDup?id=' + id);
  });
</script>
</body>
</html>