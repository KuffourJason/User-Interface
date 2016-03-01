package v2.Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import v1.JSONhandler;
import com.cloudant.client.api.CloudantClient;
import com.cloudant.client.api.Database;
import com.google.gson.JsonObject;

/**
 * @author jason
 *
 * This class handles all the information related to the students db 
 */
public class Students implements Runnable {

	private Database dynam_db;
	private Database stati_db;
	private Map<String, JSONhandler> dynamic;
	private Map<String, JSONhandler> stati;
	
	/**
	 * @param con - The Cloudant database to connect to 
	 * 
	 * This method creates the database connections and initializes the storage structures
	 */
	public Students(CloudantClient con){
		this.dynam_db = con.database("dynamic_user_info", false);
		this.stati_db = con.database("static_user_info", false);
		
		this.dynamic = new HashMap<String, JSONhandler>();
		this.stati   = new HashMap<String, JSONhandler>();
	}
	
	/**
	 * This method pulls all the dynamic and static information from the database
	 */
	public void getData(){
		//gets list of all students in the database and stores the result in an arraylist
		JsonObject listDyn = new JsonObject();
    	listDyn = dynam_db.findAny(listDyn.getClass(), "https://eyeofthetiger.cloudant.com/dynamic_user_info/_all_docs");
    	JSONhandler ad = new JSONhandler( listDyn );
    	ArrayList<String> list = ad.extractFromArray( "rows", "id");
    	
    	JSONhandler d, s; //to store each fetched paged from the db for both static and dynamic
    	
    	//gets all the student's info and adds it to the maps
    	for( String f: list ){
    		d = new JSONhandler( dynam_db.find(JsonObject.class, f) );
    		s = new JSONhandler( stati_db.find(JsonObject.class, f) );
    		
    		this.dynamic.put(f, d);
    		this.stati.put(f, s);
    	}
	}
	
	
	/**
	 * @param id - The student with id/mac address id to be deleted from the database
	 * 
	 * This method must first update the database to ensure the latest revision value is up to date
	 * 
	 */
	public void deleteStudent(String id){
		this.getData();	//updates the maps to the latest revision number
		this.dynam_db.remove(this.dynamic.remove(id).instance);  		//removes the student with id from the dynamic database
		this.stati_db.remove(this.stati.remove(id).instance  ); 		//removes the student with id from the static database
	}
	
	
	/**
	 * @param macAddress	- the new student's bluetooth tracking tag
	 * @param studentId		- the new student's id
	 * @param firstname		- the new student's first name
	 * @param lastname		- the new student's last name
	 * @param timetable		- the new student's timetable
	 */
	public void createStudent( String macAddress, String studentId, String firstname, String lastname, ArrayList<String> timetable ){
		
		//adds the new student to the static info database
		JSONhandler add = new JSONhandler(new JsonObject());
		add.addData("_id", macAddress);
		add.addData("user_first_name", firstname);
		add.addData("user_last_name", lastname);
		add.addData("user_id", studentId);
		add.addData("user_number_of_absences", "0");
		add.addData("user_number_of_lates", "0");
		add.addData("user_timetable", timetable); 
		
		/////////////////////////////////////////////////////////////////////
		///DO CLASS DATABASE FIRST AND ADD A METHOD FINDS A CLASS LOCATION BY COURSE ADD
		///THEN USE THAT METHOD TO ADD CLASS LOCATIONS TO THE TIMETABLE ARRAY AFTER EVERY LOCATION
		///THEN UPDATE JSONHANDLER TO APPROPIATELY PARSE THE TIMETABLE
		
		//adds the student to the dynamic database info
		JSONhandler add_dyn = new JSONhandler(new JsonObject());
		add_dyn.addData("_id", macAddress);
		add_dyn.addData("user_status", "0");
		add_dyn.addData("user_current_class", "0");
		add_dyn.addData("user_location", "0");
		add_dyn.addData("user_daily_attendance", "0");
		add_dyn.addData("rssi", "0");
		
		this.stati_db.save(add.instance);
		this.dynam_db.save(add_dyn.instance);
	}
	
	/**
	 * @param id - the new student's id
	 * @return - a boolean indicating the id is already in use
	 */
	public boolean invalidId(String id){
		return !this.stati_db.findByIndex("\"selector\": { \"user_id\": \" "+ id + "\" }" , JsonObject.class).isEmpty();
	}
	
	/**
	 * @param mac - the mac address of the bluetooth tracking card
	 * @return - a boolean indicating whether the mac address is already in use.
	 */
	public boolean invalidMac(String mac){
		
		//checks if the mac address is already in use
		if( this.dynam_db.contains(mac) || this.stati_db.contains(mac) ){
			return true;
		}
		return false;
	}
	
	
	public Map<String, JSONhandler> getDynamicInfo(){
		return this.dynamic;
	}
	
	public Map<String, JSONhandler> getStaticInfo(){
		return this.stati;
	}

	@Override
	public void run() {
		this.getData();
	}
	
}
