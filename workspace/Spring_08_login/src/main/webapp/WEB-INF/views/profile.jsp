<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.4.0.min.js"
	integrity="sha256-BJeo0qm959uMBGb65z40ejJYGSgR7REI4+CW1fNKwOg="
	crossorigin="anonymous"></script>

</head>
<body>


	<form action="picture" method="post" enctype="multipart/form-data"
		id="ff">
		사진 첨부 <input type="file" name="image" id="prof" multiple/>
	</form>
	<p>
		<button type="button" id="fileBtn">button</button>
	</p>
	<script>
// 		var data = new FormData();
// 		data.append("image", $("#img")[0].files[0]);
		$('#fileBtn').on('click', function() {
			var data = new FormData($('#ff')[0]);
			for (var value of data.values()) {
				  console.log(value); 
			}
			$.ajax({
				url : "/picture",
				data : data,
				processData : false,
				contentType : false,
				// 			dataType:"json",
				type : "post",
				enctype : "multipart/form-data"
			}).done(function(resp) {
				for(var i=0; i<resp.length; i++){
					$("#dd").append("<img src='"+resp[i]+"' name='gg'>");
				}
// 				var arr[] = resp;
// 				for(var i=0; i<arr.length; i++){
// 					$("#dd").append("<img src='"+arr[i]+"' name='gg'>");
// 				}
// 				console.log(arr[0]);
// 				$("#dd").append("<img src='"+resp[i]+"' name='gg'>");
// 				console.log(resp[0]+resp[1]);
			});
		});
	</script>

	<p id="dd"></p>
</body>
</html>