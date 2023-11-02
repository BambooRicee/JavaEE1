<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ru">
<head>
<meta charset="UTF-8">
<!-- Настройка viewport -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- Bootstrap CSS -->
<link rel="stylesheet" href="css/bootstrap.min.css">
<title>Управление футбольной командой</title>
</head>
<body>
<div  class="container-fluid">
<jsp:include page="/views/header.jsp" />
<div  class="container">
<br><br><br>
<div class="list-group text-center py-3 px-3">
<h2 style="color: #008000" >Функции системы</h2>
<ul class="list-group list-group-flush">
<li class="list-group-item list-group-item-success"><a href="#" style="color: #008000">Игроки футбольной команды</a>
<li class="list-group-item list-group-item-dark"><a href="#" style="color: #008000">Позиции</a>
</ul>
 </div>
<br><br>
</div>
<jsp:include page="/views/footer.jsp" />
</div>
</body>
</html>