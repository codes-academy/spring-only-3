<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <script src="https://code.jquery.com/jquery-3.4.1.js"></script>
  <title>Index</title>
</head>
<body>
<button id="toInput">Input</button>
<button id="toOutput">Output</button>

<script>
  $("#toInput").on("click", function () {
    $(location).attr("href", "inputForm");
  });
  $("#toOutput").on("click", function () {
    $(location).attr("href", "outputProc");
  });
</script>

</body>
</html>