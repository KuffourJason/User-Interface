package v2.Model;

import java.util.HashMap;
import java.util.Map;

import com.cloudant.client.api.CloudantClient;
import com.cloudant.client.api.Database;
import com.google.gson.JsonObject;

/**
 * @author jay
 *
 * This classes handles all things related to the configuration of the beacon software.
 * These include updating and pulling data from the database.
 */
public class Config implements Runnable{
	
	private Database configDB;		//the database that holds the configurations database
	private JSONhandler data;       //the configuration data obtained from the database
	
	/**
	 * @param client - the Cloudant account to connect that contains the database
	 * 				   config_info
	 * 
	 * The constructor creates an instance of the Config object which is responsible for
	 * accessing and modifying the configurations file in the database
	 */
	public Config(CloudantClient client){
		this.configDB = client.database("config_info", false);
	}

	/**
	 * This method pulls the configuration data from the cloudant database. This method
	 * must be executed before any config can be obtained. 
	 */
	public void getData(){
		//Searches for the page that contains the config info and sets it as the main JSONhandler data
		JSONhandler d = new JSONhandler(this.configDB.find(JsonObject.class, "configurations") ); 
		this.data = d;
	}
	
	/**
	 * @return - a map containing all the config settings in the database
	 */
	public Map<String, String> getConfig(){
		
		Map<String, String> data = new HashMap<String, String>();
		
		data.put("first", this.data.toString("first_period_start") );
		data.put("second",this.data.toString("second_period_start") );
		data.put("third", this.data.toString("third_period_start") );
		data.put("fourth",this.data.toString("fourth_period_start") );
		data.put("start", this.data.toString("school_start") );
		data.put("end", this.data.toString("school_end") );
		data.put("lunchStart", this.data.toString("lunch_start") );
		
		return data;
	}
	
	/**
	 * @param schoolEnd - the time the school ends
	 * @param schoolStart	- the time school starts
	 * @param firstStart	- the start time of the first period
	 * @param secondStart	- the start time of the second period
	 * @param thirdStart	- 
	 * @param fourthStart
	 *
	 * updates the configurations file in the database
	 */
	public void update(String schoolEnd, String schoolStart, String firstStart, String secondStart, String luStart, String thirdStart, String fourthStart){
		
		this.data.addData("school_end", schoolEnd);   //updates the field accordingly
		this.data.addData("school_start", schoolStart); //updates the field accordingly
		this.data.addData("lunch_start", luStart); //updates the field accordingly
		
		//updates the num_periods data field in the configuration field
		this.data.addData("first_period_start", firstStart);
		this.data.addData("second_period_start", secondStart);
		this.data.addData("third_period_start", thirdStart);
		this.data.addData("fourth_period_start", fourthStart);
		
		configDB.update(this.data.instance);
	}

	
	@Override
	public void run() {
		this.getData();		
	}
}
