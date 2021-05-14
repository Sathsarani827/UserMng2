<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<title>User details</title>
<link rel="stylesheet" href="Views/bootstrap.min.css">
<script src="Components/jquery-3.2.1.min.js"></script>
<script src="Components/main.js"></script>
</head>


<body>
	<div class="container">
	<div class="row">
	<div class="col-8">
	 
 	<h1 class="m-3">User details</h1>
 
 	<form id="formUser">
 
	 <!-- NAME -->
	 <div class="input-group input-group-sm mb-3">
	 	<div class="input-group-prepend">
	 	<span class="input-group-text" id="lblName">Name: </span>
	 </div>
	 
	 <input type="text" id="txtName" name="txtName">
	 </div>
	 
	 <!-- GENDER -->
	 <div class="input-group input-group-sm mb-3">
	 	<div class="input-group-prepend">
	 	<span class="input-group-text" id="lblName">Gender: </span>
	 </div>
	 
	 &nbsp;&nbsp;Male 
	<input type="radio" id="rdoGenderMale" name="rdoGender" value="Male">
	 &nbsp;&nbsp;Female
	  
	<input type="radio" id="rdoGenderFemale" name="rdoGender" value="Female">
	 </div>
	 
	 <!-- Email -->
	 <div class="input-group input-group-sm mb-3">
	 	<div class="input-group-prepend">
	 	<span class="input-group-text" id="lblEmail">Email: </span>
	 </div>
	 
	 <input type="text" id="txtEmail" name="txtEmail">
	 
	 </div>
	 
	 <div id="alertSuccess" class="alert alert-success"></div>
	 <div id="alertError" class="alert alert-danger"></div>
	 
	<input type="button" id="btnSave" value="Save" class="btn btn-primary">
	
	</form>
</div>
</div>
 
<br>
<div class="row">
	<div class="col-12" id="colUser">
 
</div>

</div>
</div>
</body>
</html>
