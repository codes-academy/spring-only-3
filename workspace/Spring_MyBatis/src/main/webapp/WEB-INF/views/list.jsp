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
<c:forEach var="li" items="${list}">
  <span>${li.seq }</span>
  <span>${li.id }</span>
  <span>${li.pw }</span>
  <span>${li.name }</span>
  <span>${li.tel }</span><br>
</c:forEach>
</body>
</html>