<%@page import="model.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Items Management</title>
<link rel="stylesheet" href="Views/bootstrap.min.css">
<script src="Components/jquery-3.2.1.min.js"></script>
<script src="Components/items.js"></script>
</head>

<body> 
	<div class="container"><div class="row"><div class="col-6"> 
	<h1>User Management V10.1</h1>
	
	<form id="formUser" name="formUser">
	 
		  User name: 
		 <input id="userName" name="userName" type="text" 
		 class="form-control form-control-sm">
		 <br> Gender: 
		 <input id="gender" name="gender" type="text" 
		 class="form-control form-control-sm">
		 <br> Email: 
		 <input id="email" name="email" type="text" 
		 class="form-control form-control-sm">
		 <br>
		 <input id="btnSave" name="btnSave" type="button" value="Save" 
		 class="btn btn-primary">
		 <input type="hidden" id="hidUserIDSave" 
		 name="hidUserIDSave" value="">
	</form>
	
	<div id="alertSuccess" class="alert alert-success"></div>
	<div id="alertError" class="alert alert-danger"></div>
	<br>
	<div id="divUserGrid">
	 <%
	 User userObj = new User(); 
	  out.print(userObj.readUser());
	 %>
	</div>
	</div> </div> </div> 
</body>
</html>