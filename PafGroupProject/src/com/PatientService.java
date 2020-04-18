package com;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.parser.Parser;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import model.Patient;


@Path("/Patient")
public class PatientService {
	
	
	
    Patient cusObj = new Patient();
    
    @GET
    @Path("/")
    @Produces(MediaType.TEXT_HTML)

    public String readItems()
     {
       	
    	
    	return cusObj.readItems(); 
    	//return "Patient Registration" ;
    	}


	
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String insertPatient(
	@FormParam("fname") String fname,
	@FormParam("lname") String lname,
	@FormParam("nic") String nic,
	@FormParam("sex") String sex,
	@FormParam("address") String address,
	@FormParam("phone") String phone)
	{
		
		 Patient cusObj = new Patient();
		    
	String output = cusObj.insertPatient(fname,lname,nic,sex,address,phone);
	return output;
	}
	
	
	
	
	@PUT
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String updatePatient(String itemData)
	{
	
	JsonObject itemObject = new JsonParser().parse(itemData).getAsJsonObject();
	
	String patientID = itemObject.get("patientID").getAsString();
	String fname = itemObject.get("fname").getAsString();
	String lname = itemObject.get("lname").getAsString();
	String nic = itemObject.get("nic").getAsString();
	String sex = itemObject.get("sex").getAsString();
	String address = itemObject.get("address").getAsString();
	String phone = itemObject.get("phone").getAsString();

	String output = cusObj.updatePatient(patientID,fname,lname,nic,sex,address,phone);
	return output;
	}
	
	@DELETE
	@Path("/")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.TEXT_PLAIN)
	public String deletePatient(String itemData)
	{
	//Convert the input string to an XML document
	Document doc = Jsoup.parse(itemData, "", Parser.xmlParser());
	//Read the value from the element <itemID>
	String patient = doc.select("patientID").text();
	String output =cusObj.deletePatient(patient);
	return output;
	}
}


