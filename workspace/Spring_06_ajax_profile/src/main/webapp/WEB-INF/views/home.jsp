<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
</head>
<body>
	네트워크 탭을 보면 한글자 입력할 때마다 리퀘스트가 뜨는 것을 볼 수 있음<br>
	내가 보낸 요청 = header<br>
	response에 소스코드가 출력된 것을 알 수 있음<br>
	<img src="/resources/1.PNG">
	<img src="/resources/2.PNG">
	<br>
	<br>
	500번 대 에러 = 서버측 잘못(개발자 도구를 보는 의미가 없음) <br>
	<br>
	<br>
	- 예외 -<br>
	1. ajax.doc이라고 했을 때(url오류) = 404오류<br>
	2. 백엔드, 즉 controller에 예외를 발생시켰을 때(integer) = 500 오류<br>
	
	<input type="text" id="val">
	<script>
		$('#val').on("input", function(){
			$.ajax({
				url:"ajax.do",
				dataType:"json"
			}).done(function(resp){
				console.log(resp[0]); //{seq: 1, name: "Jane", message: "Hello"}
			}).fail(function(){//실패했을 시
				//디플리케이트(error-버전이 업데이트되면 사라질 수도 있음)
				console.log(resp); //url을 잘못 입력했을 때 등 - 404가 뜰 때
				//(서버가 try catch예외 처리하면 예외가 아님)
				//(근데 throw로 넘겼을 때-예외)
				//ajax의 fail은 예외를 타고 나가버리는 경우
			});
		});
	</script>
</body>
</html>