<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dh.hero.Hero"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Hero Deleted Successfully!</title>
</head>
<body>
	<%	Hero hero = (Hero) session.getAttribute("hero"); %>
	<h1>successfully deleted hero: <%= hero.getHeroName() %></h1>
	
	<form action="addHeroPage.jsp">
		<input type="submit" value="back to add hero"> <br><br>
	</form>
	<a href="ViewHero?sort=hero_name">view Hero</a>
</body>
</html>