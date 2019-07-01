<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
	<script src="https://code.jquery.com/jquery-3.4.0.min.js"></script>
</head>
<body>
	파일 업로드는 반드시 post 방식(파일 업로드는 url을 통해 할 수 없음)
	바이트형 배열로 이루어진 파일을 어떻게 스트링 값으로 받을 수 있을까?
	클라이언트에서도, 서버에서도 모두 파일을 보내는 거라는 적절한 라이브러리가 필요함
	<form action="upload.file" method="post" enctype="multipart/form-data">
		<input type="file" name="file1">
		<input type="file" name="file2">
		<input type="file" name="file3">
		<input type="submit">
	</form>
	<br>
	<hr>
		<form action="profile.file" method="post" enctype="multipart/form-data">
			<input type="file" name="profile"><input type="submit">
		</form>
	<hr>
	<br>
	<button id="toFileList">파일목록</button>
	<script>
		$('#toFileList').on('click', function(){
			$(location).attr('href', 'list.file');
		});
	</script>
</body>
</html>