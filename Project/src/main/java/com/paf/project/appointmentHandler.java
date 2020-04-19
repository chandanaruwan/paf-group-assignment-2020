package com.paf.project;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;






public class appointmentHandler {
	
	
	public ArrayList<Appointment> getAllAppoinment() throws SQLException
	{
		ArrayList <Appointment> list = new ArrayList();
		String qry = "SELECT * FROM `details` ORDER BY `details`.`app_id` ASC ";
		dbconnection newcon = new dbconnection();
		ResultSet rs = newcon.getRs(qry);
	
			while(rs.next())
			{
				Appointment a = new Appointment();
				
				a.setApp_id(rs.getString(1));
				a.setDoctor_id(rs.getString(2));
				a.setPatient_id(rs.getString(3));
				a.setPrescription(rs.getString(4));
				a.setDoc_notes(rs.getString(5));
				
				
				list.add(a);
			}
			
			newcon.con.close();
			return list;
			
	}
	
	public Appointment getAppointmentDetails(String id) throws SQLException
	{
		String qry = "SELECT * FROM `details` WHERE app_id = "+id+"";
		dbconnection db = new dbconnection();
		ResultSet rs = db.getRs(qry);
		Appointment a = new Appointment();
		
		while(rs.next())
		{
			a.setApp_id(rs.getString(1));
			a.setDoctor_id(rs.getString(2));
			a.setPatient_id(rs.getString(3));
			a.setPrescription(rs.getString(4));
			a.setDoc_notes(rs.getString(5));
			
			
			
			
		}
		db.con.close();
		
		return a;
	}
	
	public String insertAppointmentDetails(Appointment a) throws SQLException
	{
		dbconnection db = new dbconnection();
		String sql = "INSERT INTO `details` (`App_id`, `Doctor_id`,'Patient_id','Prescription','Doc_notes') VALUES (?,?,?,?,?)";
		PreparedStatement ps = db.getPs(sql);
		
		ps.setString(1, a.getApp_id());
		ps.setString(2, a.getDoctor_id());
		ps.setString(3, a.getPatient_id());
		ps.setString(4, a.getPrescription());
		ps.setString(5, a.getDoc_notes());
		
		if(!ps.execute())
		{
			db.con.close();
			return "successfully inserted";
		}
		else
		{
			db.con.close();
			return "insertion unsuccessful";
		}
		
		
	}
	
	public String deleteAppointmentDetails(String id) throws SQLException
	{
		dbconnection db = new dbconnection();
		String qry = "DELETE FROM `details` WHERE app_id = ?";
		PreparedStatement ps = db.getPs(qry);
		
		ps.setString(1,id);
		
		if(!ps.execute())
		{
			db.con.close();
			return  "successfully deleted";
		}
		else
		{
			db.con.close();
			return  "unsuccessful deletion";
		}
	}
	
	public String updatePaymentDeails(Appointment a)throws SQLException
	{
		dbconnection db = new dbconnection();
		String sql = "update details set App_id = ?, Doctor_id = ?,Patient_id = ?,Prescription = ?,Doc_notes = ? where App_id = ?";
	    PreparedStatement ps = db.getPs(sql);
	    ps.setString(1,a.getApp_id());
	    ps.setString(2,a.getDoctor_id());
	    ps.setString(3,a.getPatient_id());
	    ps.setString(4,a.getPrescription());
	    ps.setString(5,a.getDoc_notes());
	    
	    if(!ps.execute())
	    {
	    	db.con.close();
			return "Successfully Updated";
	    }
	    else
	    {
	    	db.con.close();
			return "Updation Unsuccessful";
	    }
	}
	 
	
	

	 
	
	
	
	
}
	
	
	
	
	
	
	
	
	
	
	
	


