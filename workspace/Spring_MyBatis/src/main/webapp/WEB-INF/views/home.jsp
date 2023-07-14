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
<button id="insert">Insert</button>
<button id="select">Select</button>
<button id="selectOne">SelectOne</button>
<button id="update">Update</button>
<button id="delete">Delete</button>
<button id="tx">tx</button>

<form action="myself" method="post">
  id : <input type="text" name="id"><br>
  pw : <input type="text" name="pw"><br>
  name : <input type="text" name="name"><br>
  tel : <input type="text" name="tel"><br>
  <input type="submit">
</form>
<%-- 	<p>${msg }</p> --%>
<script>
  $("button").on('click', function () {
    $(location).attr('href', $(this).attr('id'));
  });
</script>
</body>
</html>