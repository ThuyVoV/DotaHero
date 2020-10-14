<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Failed to Add Hero</title>
</head>
<body>
	<h1>Failed to Add Hero</h1>
	A hero with that name already exists
	<form action="addHeroPage.jsp">
		<input type="submit" value="back to add hero"> <br><br>
	</form>
	<a href="ViewHero?sort=hero_name">view Hero</a>
</body>
</html>