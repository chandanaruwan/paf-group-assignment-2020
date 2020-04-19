package com;

import model.HospitalDoctor;

import java.sql.SQLException;

///For REST Service
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

//For JSON
import com.google.gson.*;

//For XML
import org.jsoup.*;
import org.jsoup.parser.*;
import org.jsoup.nodes.Document;

@Path("/HospitalDoctor")
public class HospitalDoctorService {


	HospitalDoctor doctorObj = new HospitalDoctor();
	@GET
	@Path("/")
	@Produces(MediaType.TEXT_HTML)
	public String readHospitalDoctor()
	{
	 return doctorObj.readHospitalDoctors();
    } 
	
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String insertHospitalDoctor(@FormParam("doctorid") String doctorid,
	@FormParam("doctorname") String doctorname,
	@FormParam("phone") int phone,
	@FormParam("specialty") String specialty,
	@FormParam("experience") String experience) throws SQLException
	{
		String output =doctorObj.insertHospitalDoctor(doctorid, doctorname, phone, specialty,experience);
	   return output;
	}

	
	@PUT
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String updateHospitalDoctor(String hospitaldoctorData)
	{
	//Convert the input string to a JSON object
	JsonObject hospitaldoctorObject = new JsonParser().parse(hospitaldoctorData).getAsJsonObject();
	//Read the values from the JSON object
	String doctorid = hospitaldoctorObject.get("doctorid").getAsString();
	String doctorname= hospitaldoctorObject.get("doctorname").getAsString();
	int phone= hospitaldoctorObject.get("phone").getAsInt();
	String specialty= hospitaldoctorObject.get("specialty").getAsString();
	String experience=hospitaldoctorObject.get("experience").getAsString();
	String output = doctorObj.updateHospitalDoctor(doctorid, doctorname, phone, specialty, experience);
	return output;
	}
	
	
	@DELETE
	@Path("/")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteHospitalDoctor(String hospitaldoctorData)
	{
	//Convert the input string to an XML document
	Document doc = Jsoup.parse(hospitaldoctorData, "", Parser.xmlParser());
	//Read the value from the element <HospitalID>
	String doctorid = doc.select("doctorid").text();
	String output = doctorObj.deleteHospitalDoctor(doctorid);
	return output;
	}
}	