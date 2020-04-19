package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Patient {
	

	
	private Connection connect()
	{
	Connection con = null;
	try
	{
	Class.forName("com.mysql.jdbc.Driver");

	con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/hospitalmanagement", "root", "");
	}
	catch (Exception e)
	{
		e.printStackTrace();
	}
	return con;
	}
	
	
	public String readItems()
	{
	String output = "";
	try
	{
	Connection con = connect();
	if (con == null)
	{return "Error while connecting to the database for reading."; }
	
	output = "<table border=\"1\"><tr><th>PatientID</th><th>FirstName</th><th>LastName</th><th>Nic</th><th>Sex</th><th>Address</th><th>Phone</th><th>Email</th><th>Update</th><th>Remove</th></tr>";
	String query = "select * from customer";
	Statement stmt = con.createStatement();
	ResultSet rs = stmt.executeQuery(query);
	
	while (rs.next())
	{
	String patientID = Integer.toString(rs.getInt("patientID"));
	String fname = rs.getString("fname");
	String lname = rs.getString("lname");
	String nic = rs.getString("nic");
	String sex = rs.getString("sex");
	String address = rs.getString("address");
	String phone = rs.getString("phone");
	String email = rs.getString("email");
	
	
	output += "<tr><td>" + patientID + "</td>";
	output += "<td>" + fname + "</td>";
	output += "<td>" + lname + "</td>";
	output += "<td>" + nic + "</td>";
	output += "<td>" + sex + "</td>";
	output += "<td>" +address + "</td>";
	output += "<td>" + phone+ "</td>";
	output += "<td>" + email+ "</td>";
	
	/*output += "<td><input name=\"btnUpdate\" type=\"button\"value=\"Update\" class=\"btn btn-secondary\"></td>"+ "<td><form method=\"post\" action=\"patient.jsp\">"+ "<input name=\"btnRemove\" type=\"submit\" value=\"Remove\"class=\"btn btn-danger\">"
	+ "<input name=\"patientID\" type=\"hidden\" value=\"" + patientID+ "\">" + "</form></td></tr>";
	}
	*/
	
	output += "<td><input name=\"btnUpdate\" type=\"button\"value=\"Update\" class=\"btn btn-secondary\"></td>"+ "<td><form method=\"post\" action=\"patient.jsp\">"+ "<input name=\"btnRemove\" type=\"submit\" value=\"Remove\"class=\"btn btn-danger\">"
			 + "</form></td></tr>";
			}
	con.close();
	
	
	output += "</table>";
	}
	catch (Exception e)
	{
	output = "Error Occured reading the Customer Details";
	System.err.println(e.getMessage());
	}
	return output;
	}
	
	
	
	
	
	public String insertPatient(String fname, String lname, String nic, String sex,String address,String phone,String email,String password)
	{
	String output = "";
	try
	{
	Connection con = connect();
	if (con == null)
	{return "Error while connecting to the database for inserting."; 
	}
	
	
	String query = " insert into customer(`patientID`,`fname`,`lname`,`nic`,`sex`,`address`,`phone`,`email`,`password`)"+ "values(?,?,?,?,?,?,?,?,?)";
	PreparedStatement preparedStmt = con.prepareStatement(query);
	preparedStmt.setInt(1,0);
	preparedStmt.setString(2,fname);
	preparedStmt.setString(3,lname);
	preparedStmt.setString(4,nic);
	preparedStmt.setString(5,sex);
	preparedStmt.setString(6,address);
	preparedStmt.setString(7,phone);
	preparedStmt.setString(8,email);
	preparedStmt.setString(9,password);
	
	preparedStmt.execute();
	con.close();
	output = "Patient Details Inserted successfully";
	}
	catch (Exception e)
	{
	output = "Error while inserting the Patient Details.Check Again.";
	System.err.println(e.getMessage());
	}
	return output;
	
	}
	 
	
	public String updatePatient(String patientID, String fname, String lname, String nic, String sex,String address, String phone,String email,String password)
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
	
	String query = "UPDATE customer SET fname=?,lname=?,nic=?,sex=?,address=?,phone=?,email=?,password=? WHERE patientID=?";
	PreparedStatement preparedStmt = con.prepareStatement(query);
	// binding values
	preparedStmt.setString(1, fname);
	preparedStmt.setString(2, lname);
	preparedStmt.setString(3, nic);
	preparedStmt.setString(4, sex);
	preparedStmt.setString(5, address);
	preparedStmt.setString(6, phone);
	preparedStmt.setString(7, email);
	preparedStmt.setString(8, password);
	preparedStmt.setInt(9, Integer.parseInt(patientID));
	// execute the statement
	preparedStmt.execute();
	con.close();
	output = "Updated successfully";
	}
	catch (Exception e)
	{
	output = "Error Occured updating the Customer Details.";
	System.err.println(e.getMessage());
	}
	return output;
	}
	
	
	
	public String deletePatient(String patientID)
	{
	String output = "";
	try
	{
	Connection con = connect();
	if (con == null)
	{return "Error while connecting to the database for deleting."; }
	// create a prepared statement
	String query = "delete from customer where patientID=?";
	PreparedStatement preparedStmt = con.prepareStatement(query);
	// binding values
	preparedStmt.setInt(1, Integer.parseInt(patientID));
	// execute the statement
	preparedStmt.execute();
	con.close();
	output = "Deleted successfully";
	}
	catch (Exception e)
	{
	output = "Error while removing the Patient OF our Database. Check Again.";
	System.err.println(e.getMessage());
	}
	return output;
	}
	
	
}


