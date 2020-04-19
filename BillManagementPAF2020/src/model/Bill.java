package model;

import java.sql.*;

public class Bill {

	// A common method to connect to the DB
	private Connection connect() {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");

			// Provide the correct details: DBServer/DBName, username, password
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/bills", "root", "");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}

	public String insertBill(String PayMethod, String Amount, String pid ) {

		String output = "";
		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for inserting.";
			}
			// create a prepared statement
			String query = " insert into bills(`BillID`,`PayMethod`,`Amount`,'pid')" + " values (?, ?, ?, ?)";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			// binding values
			preparedStmt.setInt(1, 0);
			preparedStmt.setString(2, PayMethod);
			preparedStmt.setDouble(3, Double.parseDouble(Amount));
			preparedStmt.setInt(4, Integer.parseInt(pid));
			
			// execute the statement
			preparedStmt.execute();
			con.close();
			output = "Inserted successfully";

		} catch (Exception e) {
			output = "Error while inserting the item.";
			System.err.println(e.getMessage());
		}
		return output;
	}

	public String readBill() {

		String output = "";

		try {
			Connection con = connect();
			if (con == null) {

				return "Error while connecting to the database for reading.";
			}

			// Prepare the HTML table to be displayed

			output = "<table border=\"1\"><tr><th>Payment Method</th><th>Amount</th><th>pid</th><th>Update</th><th>Remove</th></tr>";

			String query = "select * from bills";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			// iterate through the rows in the result set

			while (rs.next()) {
				String BillID = Integer.toString(rs.getInt("BillID"));
				String PayMethod = rs.getString("PayMethod");
				String Amount = Double.toString(rs.getDouble("Amount"));
				String pid = rs.getString("pid");

				// Add into the HTML table

				output += "<tr><td>" + PayMethod + "</td>";
				output += "<td>" + Amount + "</td>";
				output += "<td>" + pid + "</td>";

				// buttons *****
				output += "<td><input name=\"btnUpdate\" type=\"button\"value=\"Update\" class=\"btn btn-secondary\"></td>"
						+ "<td><form method=\"post\" action=\"bills.jsp\">"
						+ "<input name=\"btnRemove\" type=\"submit\" value=\"Remove\"class=\"btn btn-danger\">"
						+ "<input name=\"BillID\" type=\"hidden\" value=\"" + BillID + "\">" + "</form></td></tr>";
			}
			con.close();
			// Complete the HTML table
			output += "</table>";
		} catch (Exception e) {
			output = "Error while reading the items.";
			System.err.println(e.getMessage());
		}
		return output;
	}

	public String updateBill(String BillID, String PayMethod, String Amount, String pid){
		
	 String output = "";
	 
	 try
	 {
	 Connection con = connect();
	 if (con == null){
		 return "Error while connecting to the database for updating."; 
		 
	 }
	 
	 // create a prepared statement
	 String query = "UPDATE bills SET PayMethod=?,Amount=?,pid=? WHERE BillID=?";
	 PreparedStatement preparedStmt = con.prepareStatement(query);
	 // binding values
	 preparedStmt.setString(1, PayMethod);
	 preparedStmt.setDouble(2, Double.parseDouble(Amount));
	 preparedStmt.setInt(4, Integer.parseInt(pid));
	 preparedStmt.setInt(4, Integer.parseInt(BillID));
	 
	 // execute the statement
	 preparedStmt.execute();
	 con.close();
	 output = "Updated successfully";
	 }
	 catch (Exception e)
	 {
	 output = "Error while updating the item.";
	 System.err.println(e.getMessage());
	 }
	 return output;
	 }

	public String deleteBill(String BillID) {

		String output = "";
		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for deleting.";
			}
			// create a prepared statement
			
			String query = "delete from bills where BillID = ?";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			
			// binding values
			preparedStmt.setInt(1, Integer.parseInt(BillID));
			
			// execute the statement
			preparedStmt.execute();
			con.close();
			output = "Deleted successfully";
		} catch (Exception e) {
			output = "Error while deleting the item.";
			System.err.println(e.getMessage());
		}
		return output;
	}

}
