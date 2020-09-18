<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>view hero</title>
</head>
<body>
 	inside viewhero.jsp view hero test
 	
 	<table border="1" cellpadding="5">
		<caption><h2>List of Heroes</h2></caption>
			<tr>
				<th>Name</th>
				<th>Attack Type</th>
				<th>Main Attribute</th>
				<th>Base HP</th>
				<th>Base MP</th>
				<th>Base Attack Damage</th>
				<th>Base Armor</th>
				<th>Base Movement Speed</th>
				<th>Base Strength</th>
				<th>Base Agility</th>
				<th>Base Intelligent</th>
				<th>Strength Gain</th>
				<th>Agility Gain</th>
				<th>Intelligent Gain</th>
			</tr>
		<c:forEach var="hero" items="${heroList}">
			<tr>
				<td><c:out value="${hero.heroName}" /></td>
				<td><c:out value="${hero.atkType}" /></td>
				<td><c:out value="${hero.mainStats}" /></td>
				<td><c:out value="${hero.baseHP}" /></td>
				<td><c:out value="${hero.baseMP}" /></td>
				<td><c:out value="${hero.baseAtk}" /></td>
				<td><c:out value="${hero.baseArmor}" /></td>
				<td><c:out value="${hero.baseMS}" /></td>
				<td><c:out value="${hero.baseStr}" /></td>
				<td><c:out value="${hero.baseAgi}" /></td>
				<td><c:out value="${hero.baseInt}" /></td>
				<td><c:out value="${hero.gainStr}" /></td>
				<td><c:out value="${hero.gainAgi}" /></td>
				<td><c:out value="${hero.gainInt}" /></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>