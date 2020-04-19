package model;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.*;


public class HospitalDoctor {


	 //A common method to connect to the DB
	
	public Connection connect()
	 {
	 Connection con = null;
	 try
	 {
	 Class.forName("com.mysql.jdbc.Driver");

	 //Provide the correct details: DBServer/DBName, username, password
	 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/doctor?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");
	 }
	 catch (Exception e)
	 {e.printStackTrace();}
	 return con;
	 } 
	
	public String insertHospitalDoctor(String doctorid, String doctorname, int phone, String specialty, String experience)
	 {
	 String output = ""; 
	 
	 try
	 {
	 Connection con = connect();
	 
	 		if (con == null)
	 		{return "Error while connecting to the database for inserting."; }
	 		// create a prepared statement
	 		String query = " insert into hospitaldoctors   "
	 		+ "(`doctorid`,`doctorname`,`phone`,`specialty`,`experience`)"
	 		+ " values (?, ?, ?, ?, ?)";
	 		PreparedStatement preparedStmt = con.prepareStatement(query);
	 		
	 		// binding values
	 		 preparedStmt.setString(1, doctorid);
	 		 preparedStmt.setString(2, doctorname);
	 		 preparedStmt.setInt(3, phone);
	 		 preparedStmt.setString(4, specialty);
	 		 preparedStmt.setString(5, experience); 
	 		// execute the statement
	 		 preparedStmt.execute();
	 		 con.close();
	 		 output = "Inserted successfully";
	 		 } 
	 catch (Exception e)
	 {
	 output = "Error while inserting the hospitaldoctor.";
	 System.err.println(e.getMessage());
	 }
	 return output;
	 } 
	 
	public String readHospitalDoctors()
	 {
	 String output = "";
	 try
	 {
	 Connection con = connect();
	 if (con == null)
	 {return "Error while connecting to the database for reading."; }
	 // Prepare the html table to be displayed
	 output = "<table border=\"1\"><tr><th>doctorid</th><th>doctorname</th><th>phone</th><th>specialty</th><th>experience</th><th>Update</th><th>Remove</th></tr>";
	 String query = "select * from hospitaldoctors";
	 Statement stmt = con.createStatement();
	 ResultSet rs = stmt.executeQuery(query);
	 // iterate through the rows in the result set
	 while (rs.next())
	 {
	 String doctorid = Integer.toString(rs.getInt("doctorid"));
	 String doctorname = rs.getString("doctorname");
	 String phone = Integer.toString(rs.getInt("phone"));
	 String specialty = rs.getString("specialty");
	 String experience = rs.getString("experience");
	
	 // Add into the html table
	 
	 output += "<tr><td>" + doctorid + "</td>";
	 output += "<td>" + doctorname + "</td>";
	 output += "<td>" + phone + "</td>";
	 output += "<td>" + specialty + "</td>";
	 output += "<td>" + experience + "</td>";
	 
	 // buttons
	 
	 output += "<td><input name=\"btnUpdate\" type=\"button\""
	 + "value=\"Update\" class=\"btn btn-secondary\"></td>"
	 + "<td><form method=\"post\" action=\"hospitaldoctor.jsp\">"
	 + "<input name=\"btnRemove\" type=\"submit\" value=\"Remove\""
	 + "class=\"btn btn-danger\">"
	 + "<input name=\"doctorid\" type=\"hidden\" value=\"" + doctorid
	 + "\">" + "</form></td></tr>";
	 }
	 con.close();
	 // Complete the html table
	 output += "</table>";
	 }
	 catch (Exception e)
	 {
	 output = "Error while reading the hospitaldoctors.";
	 System.err.println(e.getMessage());
	 }
	 return output;
	 } 
	
	public String updateHospitalDoctor(String doctorid, String doctorname, int phone, String specialty, String experience)
	 {
	 String output = "";
	 try
	 {
	 Connection con = connect();
	 if (con == null)
	 {return "Error while connecting to the database for updating."; }
	 // create a prepared statement
	 String query = "UPDATE hospitaldoctors SET doctorname=?,phone=?,specialty=?,experience=?"
	 + "WHERE doctorid=?";
	 PreparedStatement preparedStmt = con.prepareStatement(query);
	 // binding values
	 //preparedStmt.setString(1, doctorid);
	 preparedStmt.setString(2, doctorname);
	 preparedStmt.setInt(3, phone);
	 preparedStmt.setString(4, specialty);
	 preparedStmt.setString(5, experience);
	 preparedStmt.setInt(6, Integer.parseInt(doctorid));
	 
	 // execute the statement
	 preparedStmt.execute();
	 con.close();
	 output = "Updated successfully";
	 }
	 catch (Exception e)
	 {
	 output = "Error while updating the hospitaldoctor.";
	 System.err.println(e.getMessage());
	 }
	 return output;
	 }
	public String deleteHospitalDoctor(String doctorid)
	 {
	 String output = "";
	 try
	 {
	 Connection con = connect();
	 if (con == null)
	 {return "Error while connecting to the database for deleting."; }
	 // create a prepared statement
	 String query = "delete from hospitaldoctor where doctorid=?";
	 PreparedStatement preparedStmt = con.prepareStatement(query);
	 // binding values
	 preparedStmt.setInt(1, Integer.parseInt(doctorid));
	 // execute the statement
	 preparedStmt.execute();
	 con.close();
	 output = "Deleted successfully";
	 }
	 catch (Exception e)
	 {
	 output = "Error while deleting the hospitaldoctor.";
	 System.err.println(e.getMessage());
	 }
	 return output;
	 } 
   }


