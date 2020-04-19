package com.paf.project;

import java.sql.*;

public class dbconnection 
{
	

	protected Connection con;

	
	public dbconnection() {
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");  
			Connection connect = null;
			connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/appointment?useTimezone=true&serverTimezone=UTC ","root","");
			con = connect;
			System.out.print("DB connection successfull...");
		
		}
		catch(Exception e)
		{
			System.out.print("DB connection error..."+e);
		}
	}
	
	public ResultSet getRs(String qry) throws SQLException {
		Statement st = getSt();
		ResultSet rs = st.executeQuery(qry);
		return rs;
	}
	
	public PreparedStatement getPs(String sql) throws SQLException {
		PreparedStatement ps = con.prepareStatement(sql);
		return ps;
	}

	public Statement getSt() throws SQLException {
		Statement st = con.createStatement();
		return st;
	}



	
}
				
	
	
	
	



