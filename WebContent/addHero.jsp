<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Hero</title>
</head>
<body>
	<form method="POST" action="AddHeroController">
	
		<b>Enter Hero Name:</b>
		<input type="text" name="heroName" required="required"> <br>

		<b>Attack Type:</b>
		<input type="radio" name="atkType" value = "Melee" required="required"> Melee
		<input type="radio" name="atkType" value = "Range"> Range <br>
		
		<b>Primary Attribute:</b>
		<input type="radio" name="mainStats" value = "Strength" required="required"> Strength
		<input type="radio" name="mainStats" value = "Agility"> Agility
		<input type="radio" name="mainStats" value = "Intelligent"> Intelligent <br><br>
		
		<b>Base Stats:</b><br>
		
		HP:
		<input type="number" step="any" name="baseHP" value="0" 
			oninput="this.value = Math.abs(this.value)" required="required"> <br>
	
		MP:
		<input type="number" step="any" name="baseMP" value="0" 
			oninput="this.value = Math.abs(this.value)" required="required"> <br>
	
		Attack Damage:
		<input type="number" step="1" name="baseAtk" value="0" required="required"> <br>
		
		Armor:
		<input type="number" step="1" name="baseArmor" value="0" required="required"> <br>
	
		Movement Speed:
		<input type="number" step="any" name="baseMS" value="100" 
			oninput="this.value = Math.abs(this.value)" required="required"> <br>
			
		Strength:
		<input type="number" step="1" name="baseStr" value="0" 
			oninput="this.value = Math.abs(this.value)" required="required"> <br>
			
		Agility:
		<input type="number" step="1" name="baseAgi" value="0" 
			oninput="this.value = Math.abs(this.value)" required="required"> <br>
			
		Intelligent:
		<input type="number" step="1" name="baseInt" value="0" 
			oninput="this.value = Math.abs(this.value)" required="required"> <br><br>
			
		<b>Stats Gain Per Level:</b><br>
		
		Strength:
		<input type="number" step="0.1" name="gainStr" max="99.9" value="0" 
			oninput="this.value = Math.abs(this.value)" required="required"> <br>
			
		Agility:
		<input type="number" step="0.1" name="gainAgi" max="99.9" value="0" 
			oninput="this.value = Math.abs(this.value)" required="required"> <br>
			
		Intelligent:
		<input type="number" step="0.1" name="gainInt" max="99.9" value="0" 
			oninput="this.value = Math.abs(this.value)" required="required"> <br>
	
		<input type="submit" name="Submit" value="Add Hero"/> <br><br>
		
	</form>
	
	<a href="ViewHeroController">view Hero</a>
	
	
</body>
</html>