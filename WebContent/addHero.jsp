<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Hero</title>
</head>
<body>
	<form method="POST" action="dhController">
	

		<b>Enter Hero Name:</b>
		<input type="text" name="heroName" required="required"> <br><br>

		<b>Attack Type:</b>
		<input type="radio" name="atkType" value = "Melee" required="required"> Melee
		<input type="radio" name="atkType" value = "Range"> Range <br><br>
		
		<b>Primary Attribute:</b>
		<input type="radio" name="mainStats" value = "Strength" required="required"> Strength
		<input type="radio" name="mainStats" value = "Agility"> Agility
		<input type="radio" name="mainStats" value = "Intelligent"> Intelligent <br><br>
		
		<b>Base Stats:</b><br>
		
		HP:
		<input type="number" step="any" name="baseHP" 
			oninput="this.value = Math.abs(this.value)" required="required"> <br>
	
		MP:
		<input type="number" step="5" name="baseMP" 
			oninput="this.value = Math.abs(this.value)" required="required"> <br>
	
		Armor:
		<input type="number" step="1" name="baseArmor" required="required"> <br>
	
		Movement Speed:
		<input type="number" step="5" name="baseMS" value="100" 
			oninput="this.value = Math.abs(this.value)" required="required"> <br>
			
		Strength:
		<input type="number" step="1" name="baseStr" 
			oninput="this.value = Math.abs(this.value)" required="required"> <br>
			
		Agility:
		<input type="number" step="1" name="baseAgi" 
			oninput="this.value = Math.abs(this.value)" required="required"> <br>
			
		Intelligent:
		<input type="number" step="1" name="baseInt" 
			oninput="this.value = Math.abs(this.value)" required="required"> <br><br>
			
		<b>Stats Gain Per Level:</b><br>
		
		Strength:
		<input type="number" step="0.1" name="strGain" 
			oninput="this.value = Math.abs(this.value)" required="required"> <br>
			
		Agility:
		<input type="number" step="0.1" name="agiGain" 
			oninput="this.value = Math.abs(this.value)" required="required"> <br>
			
		Intelligent:
		<input type="number" step="0.1" name="intGain" 
			oninput="this.value = Math.abs(this.value)" required="required"> <br>
	
		<input type="submit" name="Submit" value="Add Hero"/>

	</form>
</body>
</html>