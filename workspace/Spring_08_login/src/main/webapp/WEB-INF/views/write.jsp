<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Insert title here</title>
  <script src="https://code.jquery.com/jquery-3.4.0.min.js"
          integrity="sha256-BJeo0qm959uMBGb65z40ejJYGSgR7REI4+CW1fNKwOg=" crossorigin="anonymous"></script>
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
        integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
          integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
          crossorigin="anonymous"></script>
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
          integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
          crossorigin="anonymous"></script>
  <style>
    @import url('https://fonts.googleapis.com/css?family=Orbitron:400,900|Pacifico');

    * {
      margin: 0 auto;
    }

    body, html {
      height: 100%;
      margin: 0;
    }

    #bg {
      position: fixed;
      overflow-y: auto;
      width: 100%;
      height: 100%;
      background-image: linear-gradient(to right bottom, #E3CEF6, #FA5882, #FF0080, #DF0174, #B40486);
      background-position: center;
      background-repeat: no-repeat;
      background-size: cover;
    }

    h1 {
      font-family: 'Orbitron', sans-serif;
      font-weight: bold;
      color: #fff;
      text-shadow: 0 0 5px #444;
    }

    .my1 {
      box-shadow: 0 5px 10px -5px #333;
    }

    .my2 {
      background: #fff;
    }

    #wrt {
      height: 450px;
      word-wrap: break-word;
      overflow-y: auto;
      text-align: left;
      padding: 50px;
    }

    textarea {
      display: none;
    }
  </style>
</head>
<body>
<script>
  window.onload = function () {
    document.getElementById('write').addEventListener("click", function () {
      var title = document.getElementById('title');
      var content = document.getElementById('wrt');
      var textarea = document.getElementById('textareaId');
      textarea.innerHTML = content.innerHTML;
      if (title.value != "" && content.value != "") {
        document.getElementById('writeForm').submit();
      } else {
        alert('Write title or content!');
      }
    });
    document.getElementById('list').addEventListener("click", function () {
      location.href = '/board';
    });
  }
</script>
<div id="bg">
  <div class="container-fluid pb-5">
    <div class="row text-center mr-3 ml-3 pt-5">
      <div class="col-lg-9 col-md-9 col-sm-12 col-xs-12 rounded-lg border p-5 my1">
        <form action="/writeDone" method="post" id="writeForm">
          <h1 class="mb-4">Posting</h1>
          <hr>
          <div class="row">
            <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 rounded-lg border mt-3 p-5 my2">
              <div class="input-group mb-3">
                <div class="input-group-prepend">
                  <button type="button" class="btn btn-outline-secondary">Category</button>
                  <button type="button" class="btn btn-outline-secondary dropdown-toggle dropdown-toggle-split"
                          data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    <span class="sr-only">Toggle Dropdown</span>
                  </button>
                  <div class="dropdown-menu">
                    <a class="dropdown-item" href="#">Humor</a>
                    <a class="dropdown-item" href="#">Society</a>
                    <a class="dropdown-item" href="#">Hobby</a>
                  </div>
                </div>
                <input type="text" id="title" name='title' class="form-control"
                       aria-label="Text input with segmented dropdown button" placeholder="Title for posting...">
              </div>
              <!-- 파일 -->
              <!-- 								<form action="fileUpload" method="post" enctype="multipart/form-data"> -->
              <input type="file" id="img" name="image">
              <button type="button" id="fileBtn">Send</button>
              <!-- 								</form> -->
              <script>
                $('#fileBtn').on('click', function () {
                  var data = new FormData();
                  data.append('image', $('#img')[0].files[0]);
                  $.ajax({
                    url: "/fileUpload",
                    data: data,
                    type: "post",
                    processData: false,
                    contentType: false,
                    enctype: "multipart/form-data"
                  }).done(function (resp) {
                    $("#wrt").append("<div class='snail'><img src='" + resp + "' name='snail'/></div>");
                    console.log(resp);
                  });
                });
              </script>
              <div class="row">
                <textarea id="textareaId" name='contents'></textarea>
                <div id='wrt' class="col-lg-12 col-md-12 col-sm-12 col-xs-12 rounded-lg border mt-3 p-4"
                     contenteditable=true>
                </div>
              </div>
            </div>
          </div>
        </form>
        <button type="button" id='write' class="btn btn-outline-light mt-5 mr-2">Write</button>
        <button type="button" id='list' class="btn btn-outline-light mt-5">Board List</button>
      </div>
    </div>
  </div>
</div>
</body>
</html>