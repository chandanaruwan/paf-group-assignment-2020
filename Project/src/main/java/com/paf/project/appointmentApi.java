package com.paf.project;


import java.sql.SQLException;
import java.util.ArrayList;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;



@Path("/onlineappointment")

public class appointmentApi {
	
	private static final String String = null;

	@GET
	@Path("/appointmentdetails")
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public ArrayList<Appointment> getAllPayment() throws Exception
	{
		appointmentHandler handler = new appointmentHandler();
		return handler.getAllAppoinment();
	}
	
	@GET
	@Path("user/{id}")
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_JSON})
	public Appointment getFromId(@PathParam("id") String id) throws SQLException
	{
		appointmentHandler handler = new appointmentHandler();
		return handler.getAppointmentDetails(id);
	}
	
	@POST
	@Path("/saveappointment")
	public String inerstAppointment(Appointment a) throws SQLException
	{
		appointmentHandler handler = new appointmentHandler();
		String s = handler.insertAppointmentDetails(a);
		
		return s;
	}
	
	@DELETE
	@Path("/deleteAppointment/{id}")
	public String deletePayment(@PathParam("id") String id) throws SQLException
	{
		appointmentHandler handler = new appointmentHandler();
		String s = handler.deleteAppointmentDetails(String );
		return s;
	}
	
	@PUT
	@Path("/updateappointment")
	public String updatePayment(Appointment a) throws SQLException
	{
		appointmentHandler handler = new appointmentHandler();
		String s = handler.updatePaymentDeails(a);
		return s;
	}
	
	

	
	
	

}
