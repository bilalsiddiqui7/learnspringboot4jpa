<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="/addAlien">
  <label for="aid">Alien id:</label><br>
  <input type="text" name="aid"><br>
  <label for="aname">Alien name:</label><br>
  <input type="text" name="aname"><br>
  <label for="tech">Technology name:</label><br>
  <input type="text" name="tech"><br><br>
  <input type="submit" value="Submit">
</form> 
<br>
<h2>To search the alien with their id use the below form:</h2>
<form action="/getAlien">
  <label for="aid">Alien id:</label><br>
  <input type="text" name="aid"><br><br>
  <input type="submit" value="Submit">
</form> 
</body>
</html>