<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>Insert title here</title>
</head>
<body>

<c:choose>
  <c:when test="${id==null}">
    <form action="/login" method="post">
      <table border="1">
        <tr>
          <td>로그인
          <td>
          <td><input type="text" name="id">
          <td>
        </tr>
        <tr>
          <td>비밀번호
          <td>
          <td><input type="text" name="pw">
          <td>
        </tr>
        <tr>
          <input type="submit" value="제출">
          <button type="button" id="join">회원가입</button>
        </tr>
      </table>
    </form>
    <p>${msg }</p>
  </c:when>
  <c:otherwise>
    ${id }님 환영합니다
    <button id="logout">로그아웃</button>
    <script>
      document.getElementById('logout').onclick = function () {
        location.href = "/logout";
      }
    </script>
  </c:otherwise>
</c:choose>


<script>
  document.getElementById('join').addEventListener('click', function () {
    location.href = "/Join";
  });
</script>
</body>
</html>