<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>Insert title here</title>
  <script src="https://code.jquery.com/jquery-3.4.1.js"></script>
</head>
<body>
<input type="button" value="login" id="login">
<input type="button" value="mypage" id="mypage">
<input type="button" value="logout" id="logout">
<script>
  $('input').on('click', function () {
    $(location).attr('href', $(this).val() + "?id=test");
  });
</script>
</body>
</html>