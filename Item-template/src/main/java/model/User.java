package model;
import java.sql.*; 
public class User
{ 
	private Connection connect() 
	{ 
		Connection con = null; 
		
		try
		{ 
			Class.forName("com.mysql.jdbc.Driver"); 
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/user", "root", ""); 
			
			
			
		} 
		catch (Exception e) 
		{ 
			e.printStackTrace(); 
		} 
	return con; 
	}
	
	
	public String readUser() 
	{ 
		String output = ""; 
		
		try
		{ 
			Connection con = connect(); 
			if (con == null) 
			{ 
				return "Error while connecting to the database for reading."; 
			} 
			
			// Prepare the html table to be displayed
			output = "<table border='1'><tr><th>User Name</th> <th>Gender</th><th>Email</th>"+ " <th>Update</th><th>Remove</th></tr>"; 
			String query = "select * from user"; 
			Statement stmt = con.createStatement(); 
			ResultSet rs = stmt.executeQuery(query); 
			
			// iterate through the rows in the result set
			while (rs.next()) 
			{ 
				String userID = Integer.toString(rs.getInt("userID")); 
				String userName = rs.getString("userName"); 
				String gender = rs.getString("gender"); 
				String email = rs.getString("email"); 
	
				// Add into the html table
				output += "<tr><td><input id='hidItemIDUpdate' name='hidUserIDUpdate' type='hidden' value='" + userID+ "'>"  + "</td>"; 
				output += "<td>" + userName + "</td>"; 
				output += "<td>" + gender + "</td>"; 
				output += "<td>" +email + "</td>"; 
	 
				// buttons
				output += "<td><input name='btnUpdate' type='button' value='Update' class='btnUpdate btn btn-secondary' data-userid='" + userID + "'></td>"
						+ "<td><input name='btnRemove' type='button' value='Remove' class='btnRemove btn btn-danger' data-userid='" + userID + "'></td></tr>"; 
			} 
			con.close(); 
			// Complete the html table
			output += "</table>"; 
		} 
		catch (Exception e) 
		{ 
			output = "Error while reading the users."; 
			System.err.println(e.getMessage()); 
		} 
		return output; 
	 } 
	
	
	public String insertUser( String name, String gender, String email) 
	 { 
		String output = ""; 
		
	 try
	 { 
		 Connection con = connect(); 
		 if (con == null) 
		 { 
			 return "Error while connecting to the database for inserting."; 
		 } 
		 
		 // create a prepared statement
		 String query = " insert into users (`userID`,`userName`,`gender`,`email`)" + " values (?, ?, ?, ?)";
		 PreparedStatement preparedStmt = con.prepareStatement(query); 
			 
		 // binding values
		 preparedStmt.setInt(1, 0); 
		 preparedStmt.setString(2, name); 
		 preparedStmt.setString(3, gender); 
		 preparedStmt.setString(4, email); 
			 
		// execute the statement
		 preparedStmt.execute(); 
		 con.close(); 
		 String newUser = readUser(); 
		 output = "{\"status\":\"success\", \"data\": \"" + newUser + "\"}"; 
		 } 
		 catch (Exception e) 
		 { 
			 output = "{\"status\":\"error\", \"data\": \"Error while inserting the user.\"}"; 
			 System.err.println(e.getMessage()); 
		 } 
		 	 return output; 
		 }
	public String updateItem(String userID,  String name, String gender, String email) 
		 { 
		 	String output = ""; 
		 	try
		 	{ 
		 		Connection con = connect(); 
		 		if (con == null) 
		 		{ 
		 			return "Error while connecting to the database for updating."; 
		 		} 
			 	// create a prepared statement
			 	String query = "UPDATE user SET userCode=?,userName=?,gender=?,email=? WHERE userID=?"; 
			 	PreparedStatement preparedStmt = con.prepareStatement(query); 
			 	// binding value
			 	preparedStmt.setString(1, name); 
			 	preparedStmt.setString(2, gender);  
			 	preparedStmt.setString(3, email); 
			 	preparedStmt.setInt(4, Integer.parseInt(userID)); 
			 	// execute the statement
			 	preparedStmt.execute(); 
			 	con.close(); 
			 	String newUser = readUser(); 
			 	output = "{\"status\":\"success\", \"data\": \"" + newUser + "\"}"; 
		 } 
		 catch (Exception e) 
		 { 
			 output = "{\"status\":\"error\", \"data\": \"Error while updating the user.\"}"; 
			 System.err.println(e.getMessage()); 
		 } 
		 return output; 
		 } 


		public String deleteItem(String userID) 
		 { 
		 String output = ""; 
		 try
		 { 
			 Connection con = connect(); 
			 if (con == null) 
			 { 
				 return "Error while connecting to the database for deleting."; 
			 } 
				 // create a prepared statement
				 String query = "delete from user where userID=?"; 
				 PreparedStatement preparedStmt = con.prepareStatement(query); 
				 // binding values
				 preparedStmt.setInt(1, Integer.parseInt(userID)); 
				 // execute the statement
				 preparedStmt.execute(); 
				 con.close(); 
				 String newUser = readUser(); 
				 output = "{\"status\":\"success\", \"data\": \"" + newUser + "\"}"; 
		 } 
		 catch (Exception e) 
		 { 
			 output = "{\"status\":\"error\", \"data\": \"Error while deleting the user.\"}"; 
			 System.err.println(e.getMessage()); 
		 } 
		 return output; 
		 } 
}