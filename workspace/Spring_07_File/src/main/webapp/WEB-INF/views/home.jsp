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
multipart/form-data : 내가 보내는 데이터가 이렇게 생겼다는 것을 명시 <br>
네트워크 header에는 평범한 정보값들이 들어감 <br>
get방식은 body를 쓰지 않고 header만 이용해서 요청을 날림 <br>
그러나 post방식은 body도 쓰기 때문에 body, header 두 개의 영역으로 나뉘어 데이터가 넘어감 <br>
ㄴ 데이터를 보낼 때, 구분하기 위해 multipart로 일종의 구분선을 긋는 것(스트링 영역-name, 파일 영역-image 등을 나눠 서버가 받아 분류할 수 있도록 함)
<form action="upload6.do" method="post" enctype="multipart/form-data">
  <input type="text" name="name"><br>
  <input type="file" name="image"><br>
  <input type="submit" value="send">
</form>


<p><img src="${img }"/></p>
<p>ww<img src="resources/11.PNG"/></p>
</body>
</html>