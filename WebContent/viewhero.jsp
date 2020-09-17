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
            <caption><h2>List of Users</h2></caption>
            <tr>
                
                <th>Name</th>
                <th>atk</th>
                <th>stats</th>
            </tr>
            <c:forEach var="user" items="${heroList}">
                <tr>
                    <td><c:out value="${user.heroName}" /></td>
                    <td><c:out value="${user.atkType}" /></td>
                    <td><c:out value="${user.mainStats}" /></td>

                </tr>
            </c:forEach>
        </table>
</body>
</html>