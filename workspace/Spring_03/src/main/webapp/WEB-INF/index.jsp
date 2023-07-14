<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>Insert title here</title>
</head>
<body>
<div class="container">
  <button id="toInput">Input</button>
  <button id="toOutput">Output</button>
</div>

<script>
  document.getElementById("toInput").onclick = function () {
    location.href = "inputForm.do";
  }
  document.getElementById("toOutput").onclick = function () {
    location.href = "outputProc.do";
  }
</script>

<!-- 	------------------------------------------------------------ -->

<img src="/resources/1.jpeg"> <br>
이미지 파일을 어떻게 넣어야 할까? <br>
예를 들어, src="a.jpg" 라고 써 넣으면 클라이언트한테 날라감 <br>
>> 이미지 태그는 사용자가 원하건 그렇지 않건 리퀘스트(요청)을 날림 <br>
>> 사이트 접속하면 로고, 광고 등이 출력되는 게 이미지 태그 때문임 <br>
>> 존재하지 않는 임의의 이미지를 띄우고 브라우저를 보면 network에 a.jap가 기재되 있는 것을 볼 수 있음 <br>

>> 그럼 resources 폴더에 넣고 실행하면 될까? > no <br>
>> 이미지에 대한 매핑 정보가 없기 때문에 이미지 그냥 띄우면 오류남 -> context.xml에서 따로 설정해줌 <br>

</body>
</html>