$(document).ready(function()
{ 
 $("#alertSuccess").hide(); 
 $("#alertError").hide(); 
}); 

// SAVE ============================================
$(document).on("click", "#btnSave", function(event) 
{ 
// Clear status msges-------------
 $("#alertSuccess").text(""); 
 $("#alertSuccess").hide(); 
 $("#alertError").text(""); 
 $("#alertError").hide(); 
 
// Form validation----------------
var status = validateUserForm();

// If not valid-------------------
if (status != true) 
 { 
 $("#alertError").text(status); 
 $("#alertError").show(); 
 return; 
 } 
// If valid----------------------
var user = getUserCard($("#txtName").val().trim(), 
 $('input[name="rdoGender"]:checked').val(), 
 $("#email").val()); 
$("#colUser").append(user);
 
 $("#alertSuccess").text("Saved successfully."); 
 $("#alertSuccess").show(); 
 
 $("#formUser")[0].reset(); 
}); 

// REMOVE==========================================
$(document).on("click", ".remove", function(event) 
{ 
	 $(this).closest(".user").remove(); 
	 
	 $("#alertSuccess").text("Removed successfully."); 
	 $("#alertSuccess").show(); 
});

// CLIENT-MODEL=================================================================
function validateUserForm() 
{ 
	// NAME
	if ($("#txtName").val().trim() == "") 
	 { 
		return "Insert user name."; 
	 } 
	// GENDER
	if ($('input[name="rdoGender"]:checked').length === 0) 
	 { 
		return "Select gender."; 
	 } 
	// Email
	
	if ($("#email").val().trim() == "") 
	 { 
		return "Insert Email address."; 
	 } 
	return true; 
} 
function getUserCard(name, gender, email) 
{ 
	var title = (gender == "Male") ? "Mr." : "Ms."; 
	
	var user = ""; 
	user += "<div class=\"user card bg-light m-2\" style=\"max-width: 10rem; float: left;\">"; 
	user += "<div class=\"card-body\">"; 
	user += title + " " + name + ","; 
	user += "<br>"; 
	user += email + " email"; 
	user += "</div>"; 
	user += "<input type=\"button\" value=\"Remove\" class=\"btn btn-danger remove\">"; 
	user += "</div>"; 
	return user; 
}