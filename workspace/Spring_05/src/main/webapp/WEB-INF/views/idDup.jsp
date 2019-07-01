<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p id="p"></p>
	<script>
		if(${result==null}){
			document.getElementById('p').innerHTML=opener.document.getElementById("id").value+'는 사용할 수 있습니다'
		}else{
			document.getElementById('p').innerHTML=opener.document.getElementById("id").value+'는 사용할 수 없습니다'
		}
	</script>

</body>
</html>