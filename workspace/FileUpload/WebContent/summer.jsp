<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Summernote</title>
  <link href="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.css" rel="stylesheet">
  <script src="http://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.js"></script>
  <script src="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.js"></script>
  <link href="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.12/summernote.css" rel="stylesheet">
  <script src="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.12/summernote.js"></script>
</head>
<body>
<div id="summernote"><p>Hello Summernote</p></div>
<button type="button" id="btn">제출
  <button>
    <script>
      $("#summernote").summernote({
        height: 400,          // 기본 높이값
        minHeight: null,      // 최소 높이값(null은 제한 없음)
        maxHeight: null,      // 최대 높이값(null은 제한 없음)
        focus: true,          // 페이지가 열릴때 포커스를 지정함
        lang: 'ko-KR',
        //onlmageUpload callback함수 -> 미설정시 data형태로 에디터 그대로 삽입

        callbacks: {
          onImageUpload: function (files, editor, welEditable) {
            var data = new FormData();
            //<form></form>
            data.append('file', files[0]);
            //<form><input type=file></form>
            $.ajax({
              url: "upload.file",
              data: data,
              type: "post",
              cache: false,
              contentType: false,
              enctype: "multipart/form-data",
              processData: false
            }).done(function (resp) {
              $(".note-editable").append("<img src='" + resp + "' name='img'>");
              console.log(resp);
            });
// 	              console.log(files + editor + welEditable);
          }
        }
      });
      document.getElementById('btn').addEventListener("click", function () {
        window.open("img.file?img=" + $(".note-editable").html(), "_self", "");
      });
    </script>
</body>
</html>