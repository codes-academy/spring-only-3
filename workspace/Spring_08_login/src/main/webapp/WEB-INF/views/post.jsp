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
  <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
          integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
          crossorigin="anonymous"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
          integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
          crossorigin="anonymous"></script>
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
          integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
          crossorigin="anonymous"></script>
  <style>
    @import url('https://fonts.googleapis.com/css?family=Orbitron:400,900|Pacifico|Song+Myung');

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

    #tit {
      font-weight: bold;
      font-size: 25px;
      font-family: 'Song Myung', serif;
      color: #555;
      overflow: hidden;
      text-overflow: ellipsis;
      white-space: nowrap;
    }

    #wrt {
      height: 450px;
      word-wrap: break-word;
      overflow-y: auto;
      text-align: left;
      padding: 50px 70px;
    }
  </style>
</head>
<body>
<script>
  $(function () {
    $('#list').on("click", function () {
      $.ajax({
// 				$('.snail:nth-child(1)')
      });
      location.href = '/board';
    });
  });
</script>


<div id="bg">
  <div class="container-fluid pb-5">
    <div class="row text-center mr-3 ml-3 pt-5">
      <div class="col-lg-9 col-md-9 col-sm-12 col-xs-12 rounded-lg border p-5 my1">
        <h1 class="mb-4">Read Post</h1>
        <hr>
        <div class="row">
          <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 rounded-lg border mt-3 p-5 my2">
            <div id="tit">${list.title}</div>
            <hr>
            <div id="postinfo">
              <img src="img/face.png">${id} &nbsp;&nbsp;<img src="img/date.png">${list.writedate }
            </div>
            <div class="row">
              <div id='wrt' class="col-lg-12 col-md-12 col-sm-12 col-xs-12 rounded-lg border mt-2 p-4">
                ${list.contents }
              </div>
            </div>
          </div>
        </div>
        <button type="button" id='del' class="btn btn-outline-light mt-5 mr-2">Delete Post</button>
        <button type="button" id='list' class="btn btn-outline-light mt-5">Board List</button>
      </div>
    </div>
  </div>
</div>

</body>
</html>