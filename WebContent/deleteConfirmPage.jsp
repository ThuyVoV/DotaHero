<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dh.hero.Hero" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% Hero hero = (Hero) session.getAttribute("hero"); %>

	<form action="DeleteHero">
		type in "Delete <%= hero.getHeroName() %>" <br>
		<input type="text"> <br><br>
		
		<input type="submit" value="Delete Hero">
	</form>
	
	<br><br>
	<a href="GoToUpdateHero?hero=<%= hero.getHeroName() %>"> Back to edit <%= hero.getHeroName() %> </a>
	
</body>
</html>