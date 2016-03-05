package v2.Model;

import java.util.ArrayList;

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
	 * @return - the start times of the four periods in the school
	 * This methods returns the start times of each of the four periods
	 */
	public ArrayList<Integer> getPeriodStart(){
		//obtains the number of periods in the config database
		ArrayList<Integer> t = new ArrayList<Integer>();
		t.add( Integer.parseInt( this.data.toString("first_period_start")) );
		t.add( Integer.parseInt( this.data.toString("second_period_start")) );
		t.add( Integer.parseInt( this.data.toString("third_period_start")) );
		t.add( Integer.parseInt( this.data.toString("fourth_period_start")) );
		return t;
	}
	
	/**
	 * @return - the school start time
	 * This method returns the start time of the school
	 */
	public String getSchoolStart(){
		return this.data.toString("school_start");
	}
	
	/**
	 * @return - the school end time
	 * This method returns the end time of the school
	 */
	public String getSchoolEnd(){
		return this.data.toString("school_end");
	}
	
	/**
	 * @return - the length of one lunch period
	 */
	public int getLunchLength(){
		return Integer.parseInt( this.data.toString("lunch_length") );
	}
	
	/**
	 * @return - the starting time of the lunch period
	 */
	public String getLunchStart(){
		return this.data.toString("lunch_start");
	}
	
	/**
	 * @param lunchLength - the length of the lunch period
	 * @param schoolEnd - the time the school ends
	 * @param schoolStart	- the time school starts
	 * @param grace	- the time between the start and end of a class
	 * @param firstStart	- the start time of the first period
	 * @param secondStart	- the start time of the second period
	 * @param thirdStart	- 
	 * @param fourthStart
	 *
	 * updates the configurations file in the database
	 */
	public void update(int lunchLength, String schoolEnd, String schoolStart, int grace, String firstStart, String secondStart, String thirdStart, String fourthStart){
		
		this.data.addData("lunch_length", lunchLength + "");
		this.data.addData("school_end", schoolEnd);   //updates the field accordingly
		this.data.addData("school_start", schoolStart); //updates the field accordingly
		
		//updates the num_periods data field in the configuration field
		this.data.addData("first_period_start", firstStart);
		this.data.addData("second_period_start", firstStart);
		this.data.addData("third_period_start", firstStart);
		this.data.addData("fourth_period_start", firstStart);
		
		this.data.addData("grace_period", grace + "");		
		configDB.update(this.data.instance);
	}

	
	@Override
	public void run() {
		this.getData();		
	}
}
