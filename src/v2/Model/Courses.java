package v2.Model;

import java.util.*;

import com.cloudant.client.api.CloudantClient;
import com.cloudant.client.api.Database;
import com.google.gson.JsonObject;

import v1.JSONhandler;

/**
 * @author jason
 *
 * This class handles all the information related to the courses db
 */
public class Courses implements Runnable {

	private Database class_db;			//database instance for the class db
	private Map<String, JSONhandler> courses;	//map that holds all classes in the database
	
	/**
	 * @param client - the Cloudant client to connect to 
	 * 
	 * The constructor initializes the map that holds all courses and connects to 
	 * the class database
	 */
	public Courses(CloudantClient client){
		this.class_db = client.database("class_info", false);
		this.courses = new HashMap<String, JSONhandler>();
	}
	
	/**
	 * This method pulls all the courses in the db into the local map
	 */
	public void getData(){
		
		//gets the list of all coure ids in the database
		JSONhandler ad = new JSONhandler( this.class_db.findAny(JsonObject.class, "https://eyeofthetiger.cloudant.com/class_info/_all_docs" ));
	    ArrayList<String> list = ad.extractFromArray( "rows", "id");
	    
	    JSONhandler cour;
	    
	    //Gets each course info and stores in it the Map
	    for( String t: list){
	    	cour = new JSONhandler( this.class_db.find(JsonObject.class, t) );
	    	this.courses.put(t, cour);
	    }
	}
	
	/**
	 * @param id	- the id of the new course
	 * @param name	- the name of the new course
	 * @param start	- the start time to the course
	 * @param end	- the end of the new course
	 * @param location - the location of the new course
	 * 
	 * This method creates a new course in the database. You must first check if
	 * the id is valid before running this method
	 */
	public void createCourse(String id, String name, String start, String end, String location){
		
		//this creates a new course and sends it to the database
		JSONhandler add = new JSONhandler(new JsonObject());
		add.addData("_id", id);
		add.addData("class_name", name);
		add.addData("class_time_start", start);
		add.addData("class_time_end", end);
		add.addData("class_location", location);

		//saves the new course in the db
		this.class_db.save(add.instance);	
	}
	
	/**
	 * @param id - the course id to be deleted
	 * 
	 * his method must first update the database to ensure the latest revision value is up to date
	 */
	public void deleteCourse(String id){
		this.getData();
		this.class_db.remove( this.courses.remove(id) );
	}
	
	/**
	 * @param id - the candidate course id to check if it already exists in the
	 * 			   db
	 * @return - a boolean indicating whether the id is already in use
	 */
	public boolean isValid(String id){
		return !this.class_db.contains(id);
	}
	
	/**
	 * @param id - the course id to find the location for
	 * @return - the location of the course
	 */
	public String findLocation(String id){
		return this.courses.get(id).toString("class_location");
	}
	
	public Map<String, JSONhandler> getCourses(){
		return this.courses;
	}
	
	@Override
	public void run() {
		this.getData();
	}
}
