<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dh.hero.Hero" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Hero</title>
</head>
<body>

	<% Hero hero = (Hero) session.getAttribute("hero"); %>
	<h1>Editing <%= hero.getHeroName() %></h1>
	<form method="POST" action="UpdateHero">
	
		<b>Enter Hero Name:</b>
		<input type="text" name="heroName" maxlength="30" required="required" value=<%= hero.getHeroName() %>> <br>

		<b>Attack Type:</b>
		<% if (hero.getAtkType().equals("Melee")){ %>
			<input type="radio" name="atkType" value = "Melee" required="required" checked> Melee
			<input type="radio" name="atkType" value = "Range"> Range <br>
		<% } else { %>
			<input type="radio" name="atkType" value = "Melee" required="required"> Melee
			<input type="radio" name="atkType" value = "Range" checked> Range <br>
		<% } %>
		
		<b>Primary Attribute:</b>
		<% if (hero.getMainStats().equals("Strength")){ %>
			<input type="radio" name="mainStats" value = "Strength" required="required" checked> Strength
			<input type="radio" name="mainStats" value = "Agility"> Agility
			<input type="radio" name="mainStats" value = "Intelligent"> Intelligent <br><br>
		<% } else if (hero.getMainStats().equals("Agility")){ %>
			<input type="radio" name="mainStats" value = "Strength" required="required"> Strength
			<input type="radio" name="mainStats" value = "Agility" checked> Agility
			<input type="radio" name="mainStats" value = "Intelligent"> Intelligent <br><br>
		<% } else { %>
			<input type="radio" name="mainStats" value = "Strength" required="required"> Strength
			<input type="radio" name="mainStats" value = "Agility" checked> Agility
			<input type="radio" name="mainStats" value = "Intelligent" checked> Intelligent <br><br>
		<% } %>
		
		<b>Base Stats:</b><br>
		
		HP:
		<input type="number" step="any" name="baseHP" value=<%= hero.getBaseHP() %>
			oninput="this.value = Math.abs(this.value)" required="required"> <br>
	
		MP:
		<input type="number" step="any" name="baseMP" value=<%= hero.getBaseMP() %>
			oninput="this.value = Math.abs(this.value)" required="required"> <br>
	
		Attack Damage:
		<input type="number" step="1" name="baseAtk" value=<%= hero.getBaseAtk() %> required="required"> <br>
		
		Armor:
		<input type="number" step="1" name="baseArmor" value=<%= hero.getBaseArmor() %> required="required"> <br>
	
		Movement Speed:
		<input type="number" step="any" name="baseMS" value=<%= hero.getBaseMS() %>
			oninput="this.value = Math.abs(this.value)" required="required"> <br>
			
		Strength:
		<input type="number" step="1" name="baseStr" value=<%= hero.getBaseStr() %>
			oninput="this.value = Math.abs(this.value)" required="required"> <br>
			
		Agility:
		<input type="number" step="1" name="baseAgi" value=<%= hero.getBaseAgi() %>
			oninput="this.value = Math.abs(this.value)" required="required"> <br>
			
		Intelligent:
		<input type="number" step="1" name="baseInt" value=<%= hero.getBaseInt() %>
			oninput="this.value = Math.abs(this.value)" required="required"> <br><br>
			
		<b>Stats Gain Per Level:</b><br>
		
		Strength:
		<input type="number" step="0.1" name="gainStr" max="99.9" value=<%= hero.getGainStr() %> 
			oninput="this.value = Math.abs(this.value)" required="required"> <br>
			
		Agility:
		<input type="number" step="0.1" name="gainAgi" max="99.9" value=<%= hero.getGainAgi() %> 
			oninput="this.value = Math.abs(this.value)" required="required"> <br>
			
		Intelligent:
		<input type="number" step="0.1" name="gainInt" max="99.9" value=<%= hero.getGainInt() %> 
			oninput="this.value = Math.abs(this.value)" required="required"> <br>
	
		<input type="submit" name="Submit" value="Update Hero"/> <br><br>
		
	</form>
	
	<form action="deleteConfirmPage.jsp">
		<input type="submit" value="Delete Hero"/> <br><br>
	</form>
	
	<a href="ViewHero?sort=hero_name">view Hero</a>
	
	
</body>
</html>