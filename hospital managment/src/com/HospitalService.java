package com;

import javax.swing.text.Document;
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
import org.jsoup.parser.Parser;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import model.Hospital;

@Path("/Hospital")

public class HospitalService {
	Hospital hospitalObj = new Hospital();

	@GET
	@Path("/")
	@Produces(MediaType.TEXT_HTML)
	public String readItems() {
		return hospitalObj.readItems();
	}

	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String insertHospital(@FormParam("hospitalCode") String hospitalCode,
			@FormParam("hospitalName") String hospitalName, @FormParam("hospitalEmail") String hospitalEmail,
			@FormParam("hospitalDesc") String hospitalDesc, @FormParam("hospitalDistrict") String hospitalDistrict,
			@FormParam("hospitalTel") String hospitalTel) {
		String output = hospitalObj.insertHospital(hospitalCode, hospitalName, hospitalEmail, hospitalDesc,
				hospitalDistrict, hospitalTel);
		return output;
	}

	@PUT
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String updateHospital(String hospitalData) {
		// Convert the input string to a JSON object
		JsonObject hospitalObject = new JsonParser().parse(hospitalData).getAsJsonObject();
		// Read the values from the JSON object
		String hospitalID = hospitalObject.get("hospitalID").getAsString();
		String hospitalCode = hospitalObject.get("hospitalCode").getAsString();
		String hospitalName = hospitalObject.get("hospitalName").getAsString();
		String hospitalEmail = hospitalObject.get("hospitalEmail").getAsString();
		String hospitalDesc = hospitalObject.get("hospitalDesc").getAsString();
		String hospitalDistrict = hospitalObject.get("hospitalDesc").getAsString();
		String hospitalTel = hospitalObject.get("hospitalTel").getAsString();

		String output = hospitalObj.updateHospital(hospitalID, hospitalCode, hospitalName, hospitalEmail, hospitalDesc,hospitalDistrict, hospitalTel);
		return output;
	}


	
	
	@DELETE
	@Path("/")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteHospital(String hospitalData)
	{
	//Convert the input string to an XML document
	org.jsoup.nodes.Document doc = Jsoup.parse(hospitalData, "", Parser.xmlParser());
	//Read the value from the element <itemID>
	String hospitalID = doc.select("hospitalID").text();
		String output = hospitalObj.deleteHospital(hospitalID);
		return output;
	}

}
