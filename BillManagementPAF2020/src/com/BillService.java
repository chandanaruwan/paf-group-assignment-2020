package com;

import model.Bill;

//For REST Service
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
//For JSON
import com.google.gson.*;
//For XML
import org.jsoup.*;
import org.jsoup.parser.*;
import org.jsoup.nodes.Document;

@Path("/Bills")
public class BillService {

	Bill BillObj = new Bill();

	@GET
	@Path("/")
	@Produces(MediaType.TEXT_HTML)
	public String readItems() {
		return BillObj.readBill();
	}

	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)

	public String insertBill(@FormParam("PayMethod") String PayMethod, @FormParam("Amount") String Amount,
			@FormParam("pid") String pid ) {
		String output = BillObj.insertBill(PayMethod, Amount, pid);
		return output;
	}
	
	@PUT
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String updateBill(String BillData)
	{
	
		//Convert the input string to a JSON object
	 JsonObject BillObject = new JsonParser().parse(BillData).getAsJsonObject();
	 
	//Read the values from the JSON object
	 String BillID = BillObject.get("BillID").getAsString();
	 String PayMethod = BillObject.get("PayMethod").getAsString();
	 String Amount = BillObject.get("Amount").getAsString();
	 String pid = BillObject.get("pid").getAsString();
	 
	 String output = BillObj.updateBill(BillID, PayMethod, Amount, pid);
	return output;
	}

	@DELETE
	@Path("/")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteBill(String BillData)
	{
	//Convert the input string to an XML document
	 Document doc = Jsoup.parse(BillData, "", Parser.xmlParser());

	//Read the value from the element <itemID>
	 String BillID = doc.select("BillID").text();
	 String output = BillObj.deleteBill(BillID);
	return output;
	}

	

}
