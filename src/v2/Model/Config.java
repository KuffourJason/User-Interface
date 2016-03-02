package v2.Model;

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
	 * @return - the number of periods in the school
	 * This methods returns the number of periods specified in the config database
	 */
	public int getNumPeriods(){
		//obtains the number of periods in the config database
		return Integer.parseInt( this.data.toString("num_periods") );
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
	 * @return - the number of lunch periods  the school currently has
	 */
	public int getNumLunches(){
		return Integer.parseInt( this.data.toString("num_lunches") );
	}
	
	/**
	 * @return - the length of one lunch period
	 */
	public int getLunchLength(){
		return Integer.parseInt( this.data.toString("lunch_length") );
	}
	
	/**
	 * @param numLunches - the number of lunch periods that the school will have
	 * @param lunchLength - the length of one lunch period
	 * @param schEndHour - the hour when school should ends
	 * @param schEndMinute - the minute school should ends
	 * @param schStartHour - the hour when school should start
	 * @param schStartMinute - the minute school should start
	 * @param numPeriod - the number of periods that the configuration file
	 * should be updated with
	 * 
	 * updates the configurations file in the database
	 */
	public void update(int numLunches, int lunchLength, int schEndHour, int schEndMinute, int schStartHour, int schStartMinute, int numPeriod){
		
		this.data.addData("num_lunches", numLunches + "");
		this.data.addData("lunch_length", lunchLength + "");
		
		String finEnd = schEndHour + ":" + schEndMinute;		//combines the hour and minute into time format
		this.data.addData("school_end", finEnd);   //updates the field accordingly
		
		String finStart = schStartHour + ":" + schStartMinute;		//combines the hour and minute into time format
		this.data.addData("school_start", finStart); //updates the field accordingly
		
		//updates the num_periods data field in the configuration field
		this.data.addData("num_periods", numPeriod + "");
		
		configDB.update(this.data.instance);
	}

	
	@Override
	public void run() {
		this.getData();		
	}
}
