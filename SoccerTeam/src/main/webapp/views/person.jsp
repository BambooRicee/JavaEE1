<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ page import="domain.Role"%>
<%@ page import="domain.Person"%>
<!DOCTYPE html>

<html>
<meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
<title>Игроки футбольной команды</title>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Persons</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<!-- Bootstrap CSS -->
<link rel="stylesheet" href="css/bootstrap.min.css">
<!-- jQuery -->
<script defer src="js/jquery.min.js"></script>
<!-- Bootstrap JS + Popper JS -->
<script defer src="js/bootstrap.min.js"></script>
</head>
<body>
<body>
<div class="container-fluid">
<jsp:include page="/views/header.jsp" />
<div class="container-fluid">
<div class="row justify-content-start ">
<div class="col-8 border bg-light px-4">
<h3>Список игроков</h3>
<table class="table">
<thead>
<th scope="col">Код</th>
<th scope="col">Фамилия</th>
<th scope="col">Имя</th>
<th scope="col">Позиция</th>
<th scope="col">Дата рождения</th>
<th scope="col">Рост</th>
<th scope="col">Вес</th>
<th scope="col"></th>
<th scope="col"></th>
</thead>
<tbody>
<c:forEach var="person" items="${persons}">
<tr>
<td>${person.getId()}</td>
<td>${person.getLastName()}</td>
<td>${person.getFirstName()}</td>
<td>${person.getRole()}</td>
<td>${person.getBirthday()}</td>
<td>${person.getHeight()}</td>
<td>${person.getWeight()}</td>

<td width="20">
<a href="<c:url value="/editperson?id=${person.getId()}"/>"
role="button" class="btn btn-outline-primary">
<img alt="Редактировать" src="images/icon-edit.png">
</a></td>
<td width="20">
<a href="<c:url value="/deleteperson?id=${person.getId()}" />"
role="button" class="btn btn-outline-primary">
<img alt="Удалить" src="images/icon-delete.png"
onclick="return confirm('Удалить игрока с кодом: '+${person.getId()}+'?')">
</a></td>
</tr>
</c:forEach>
</tbody>
</table>
</div>
<div class="col-4 border px-4">
<form method="POST" action="">
<h3>Новый игрок</h3>
<br>
<div class="mb-3 row">
<label for="lastname" class="col-sm-3 col-form-label">Фамилия</label>
<div class="col-sm-7">
<input type="text" class="form-control" id="staticLastname" name="lastname" />
</div>
</div>
<div class="mb-3 row">
<label for="firstname"class="col-sm-3 col-form-label">Имя</label>
<div class="col-sm-7">
<input type="text" class="form-control" id="staticFirstname" name="firstname" />
</div>
</div>
<div class="mb-3 row">
<label for="rolename" class="col-sm-3 col-form-label">Позиция</label>
<div class="col-sm-7">
<select name="role" class="form-control">
<option>Выберите позицию</option>
<c:forEach var="role" items="${roles}">
<option value="${role}">
<c:out value="${role.getNamerole()}"></c:out>
</option>
</c:forEach>
</select>
</div>
</div>
<div class="mb-3 row">
<label for="birthday" class="col-sm-3 col-form-label">Дата рождения</label>
<div class="col-sm-7">
<input type="text" class="form-control" id="staticbirthday" name="birthday" />
</div>
</div>
<div class="mb-3 row">
<label for="height" class="col-sm-3 col-form-label">Рост
</label>
<div class="col-sm-7">
<input type="text" class="form-control" id="staticheight" name="height" />
</div>
</div>
<div class="mb-3 row">
<label for="weight" class="col-sm-3 col-form-label">Вес
</label>
<div class="col-sm-7">
<input type="text" class="form-control" id="staticweight" name="weight" />
</div>
</div>
<p>
<br>
<button type="submit" class="btn btn-success">Добавить</button>
</p>
</form>
</div>
</div>
</div>
<jsp:include page="/views/footer.jsp" />
</div>
</body>
</html>