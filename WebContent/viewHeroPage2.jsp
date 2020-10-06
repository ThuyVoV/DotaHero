<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="dh.hero.Hero" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 	<a href="addHeroPage.jsp">Back</a>
 	
 	<table border="1">
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
			
		
		<% 
			List<Hero> heroList = (List<Hero>) session.getAttribute("heroList");
			for(Hero hero : heroList){
		%>
			<tr>
				<td><a href="GoToUpdateHero?hero=<%= hero.getHeroName() %>"> <%= hero.getHeroName() %> </a></td>
				<td><%= hero.getAtkType() %></td>
				<td><%= hero.getMainStats() %></td>
				<td><%= hero.getBaseHP() %></td>
				<td><%= hero.getBaseMP() %></td>
				<td><%= hero.getBaseAtk() %></td>
				<td><%= hero.getBaseArmor() %></td>
				<td><%= hero.getBaseMS() %></td>
				<td><%= hero.getBaseStr() %></td>
				<td><%= hero.getBaseAgi() %></td>
				<td><%= hero.getBaseInt() %></td>
				<td><%= hero.getGainStr() %></td>
				<td><%= hero.getGainAgi() %></td>
				<td><%= hero.getGainInt() %></td>
			</tr>
		<% } %>
		
	</table>
	
	<br><br>
	<a href="addHero.jsp">Add another hero</a>
</body>
</html>