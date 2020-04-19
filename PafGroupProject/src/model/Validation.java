package model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {

	//check first name and last name only with letters
	public static boolean isLettersOnly(String lname) {
	    String expression = "^[a-zA-Z.\\s]+"; 
	    return lname.matches(expression);        
	    }	
	
	//check whether the field is empty
	public boolean isempty(String field)
	{
	      if (field.length() == 0) {
             return true;
             }
        else
        { 
            return false;
        }
     }
	
	
	//check phone number
	 public boolean validTNO(String phone)
	 {
	     if(phone.length()==10 && phone.startsWith("0"))
	       {
	     	for(int i=0;i<10;i++)
	          {
	     		char c=phone.charAt(i);
	    			 if(!Character.isDigit(c))
	     				return false;
	     	  }
	    	return true;
	       }
	         else
	        return false;        
	 }
	 
	//check the NIC field
	 public boolean validID(String ID){

			 if(ID.length()==10 && ID.endsWith("V")|| ID.endsWith("v"))
   				 return true;
			   else
  				 return false;
                     }
	
	 //check  the email field
	 public boolean EmailValidation(String email){
	       boolean state;
	      Pattern p = Pattern.compile("^[A-Za-z0-9-]+(\\-[A-Za-z0-9])*@"
	                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9])");
	        Matcher m = p.matcher(email);

	        if (m.find())
	        {
	           state = true;
	        }else{
	           state = false; 
	        }

	        return state;
	    }
	
}
