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
 	<a href="addHero.jsp">Back</a>
 	
 	<table border="1" cellpadding="5">
		<caption><h2>List of Heroes</h2></caption>
			<tr>
				<th><a href="ViewHeroController?sort=hero_name">Name</a></th>
				<th><a href="ViewHeroController?sort=atk_type">Attack Type</a></th>
				<th><a href="ViewHeroController?sort=main_stats">Main Attribute</a></th>
				<th><a href="ViewHeroController?sort=base_hp">Base HP</a></th>
				<th><a href="ViewHeroController?sort=base_mp">Base HP</a></th>
				<th><a href="ViewHeroController?sort=base_atk">Base Attack Damage</a></th>
				<th><a href="ViewHeroController?sort=base_armor">Base Armor</a></th>
				<th><a href="ViewHeroController?sort=base_ms">Base Movement Speed</a></th>
				<th><a href="ViewHeroController?sort=base_str">Base Strength</a></th>
				<th><a href="ViewHeroController?sort=base_agi">Base Agility</a></th>
				<th><a href="ViewHeroController?sort=base_int">Base Intelligent</a></th>
				<th><a href="ViewHeroController?sort=gain_str">Strength Gain</a></th>
				<th><a href="ViewHeroController?sort=gain_agi">Agility Gain</a></th>
				<th><a href="ViewHeroController?sort=gain_int">Intelligent Gain</a></th>

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