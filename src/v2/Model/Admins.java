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
 * This class handles all the information related to the admins db 
 */
public class Admins implements Runnable{

	private Database admin_db;
	/**
	 * 
	 */
	private Map<String, JSONhandler> admins;
	
	/**
	 * @param con - The Cloudant database to connect to 
	 * 
	 * This method creates the database connections and initializes the storage structures
	 */
	public Admins(CloudantClient con){
		this.admin_db = con.database("administrator_info", false);
		this.admins = new HashMap<String, JSONhandler>();
	}
	
	/**
	 * This method pulls all the dynamic and static information from the database
	 */
	public void getData(){
		//gets list of all admnis in the database and stores the result in an arraylist
		JsonObject listDyn = new JsonObject();
    	listDyn = admin_db.findAny(listDyn.getClass(), "https://eyeofthetiger.cloudant.com/administrator_info/_all_docs");
    	JSONhandler ad = new JSONhandler( listDyn );
    	ArrayList<String> list = ad.extractFromArray( "rows", "id");
    	
    	JSONhandler d; //to store each fetched paged from the db for both static and dynamic
    	
    	//gets all the admni's info and adds it to the maps
    	for( String f: list ){
    		d = new JSONhandler( admin_db.find(JsonObject.class, f) );
    		
    		this.admins.put(f, d);
    	}
	}
	
	
	/**
	 * @param id - The admin with id/mac address id to be deleted from the database
	 * 
	 * This method must first update the database to ensure the latest revision value is up to date
	 * 
	 */
	public void deleteAdmin(String id){
		this.getData();	//updates the maps to the latest revision number
		this.admin_db.remove(this.admins.remove(id).instance);  		//removes the admni with id from the dynamic database
	}
	
	
	/**
	 * @param macAddress	- the new admin's bluetooth tracking tag
	 * @param admniId		- the new admni's id
	 * @param firstname		- the new admni's first name
	 * @param lastname		- the new admni's last name
	 * @param timetable		- the new admni's timetable
	 */
	public void createAdmin( String macAddress, String adminId, String firstname, String lastname, ArrayList<String> timetable ){
		
		//adds the new admni to the static info database
		JSONhandler add = new JSONhandler(new JsonObject());
		add.addData("_id", macAddress);
		add.addData("admin_first_name", firstname);
		add.addData("admin_last_name", lastname);
		add.addData("admin_id", adminId);
		add.addData("admin_number_of_absences", "0");
		add.addData("admin_number_of_lates", "0");
		add.addData("admin_timetable", timetable); 
		add.addData("admin_location", "0"); 
		
		this.admin_db.save(add.instance);
	}
	
	/**
	 * @param id - the new admni's id
	 * @return - a boolean indicating the id is already in use
	 */
	public boolean invalidId(String id){
		return !this.admin_db.findByIndex("\"selector\": { \"user_id\": \" "+ id + "\" }" , JsonObject.class).isEmpty();
	}
	
	/**
	 * @param mac - the mac address of the bluetooth tracking card
	 * @return - a boolean indicating whether the mac address is already in use.
	 */
	public boolean invalidMac(String mac){
		
		//checks if the mac address is already in use
		if( this.admin_db.contains(mac) ){
			return true;
		}
		return false;
	}
	
	
	public Map<String, JSONhandler> getDynamicInfo(){
		return this.admins;
	}
	
	@Override
	public void run() {
		this.getData();
	}
}
