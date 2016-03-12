package v2.Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.cloudant.client.api.CloudantClient;

/**
 * @author jay
 *
 *	This class acts as the access point to the lower level classes i.e Students, Admins, Courses and config
 */
public class Model {

	private Students students;	//Instance to handle student crap
	private Courses courses;	//Instance to handle courses crap
	private Admins admins;		//instance to handle admins crap
	private Config config;		//instance to handle configurations
	
	/**
	 * The constructor connects to the cloudant database and begins pulling all the information from all 4 databases
	 */
	public Model(){
		CloudantClient account = new CloudantClient("eyeofthetiger", "eyeofthetiger", "eng40000");
		this.students = new Students(account);
		this.courses = new Courses(account);
		this.admins = new Admins(account);
		this.config = new Config(account);
		this.getData();
	}
		
	/**
	 * This method creates 4 threads to obtain data from the database concurrently
	 */
	private void getData(){
		Thread s = new Thread(this.students);
		Thread a = new Thread(this.courses );
		Thread c = new Thread(this.admins );
		Thread co = new Thread(this.config);
		s.start();
		a.start();
		c.start();
		co.start();
		
		try 
		{
			a.join();
			c.join();
			co.join();
			s.join();
		} 
		catch (InterruptedException e) {}
	}
	
	/**
	 * @param macAddress - the macAddress of the new admin's tag
	 * @param studentId	- the new admins id
	 * @param firstname	- the admins first name
	 * @param lastname	- the admins last name
	 * @param timetable	- the new admins timetable
	 * @return	- a boolean indicating whether the update succeeded
	 */
	public boolean newStudent(String macAddress, String studentId, String firstname, String lastname, ArrayList<String> timetable ){
		boolean result;
		
		//checks if the mac address or the admin id isn't being used
		if( this.students.isValidId(studentId) && this.students.isValidMac(macAddress) ){
			ArrayList<String> timeLoc = new ArrayList<String>();
			
			//adds the location of the class to after each class in the array
			for( String classID: timetable){
				if( classID == null) {
					timeLoc.add("spare");
					timeLoc.add("-");
				}
				else{
					String location = this.courses.findLocation(classID);
					timeLoc.add(classID);
					timeLoc.add(location);
				}
			}
			this.students.createStudent(macAddress, studentId, firstname, lastname, timeLoc);
			result = true;
		}
		else{
			result = false;
		}
		return result;
	}
	
	/**
	 * @param macAddress - the macAddress of the new admin's tag
	 * @param adminId	- the new admins id
	 * @param firstname	- the admins first name
	 * @param lastname	- the admins last name
	 * @param timetable	- the new admins timetable
	 * @return	- a boolean indicating whether the update succeeded
	 */
	public boolean newAdmin(String macAddress, String adminId, String firstname, String lastname, ArrayList<String> timetable){
		boolean result;
		
		//checks if the mac address or the admin id isn't being used
		if( this.admins.isValidId(adminId) && this.admins.isValidMac(macAddress) ){
			ArrayList<String> timeLoc = new ArrayList<String>();
			
			//adds the location of the class to after each class in the array
			for( String classID: timetable){
				if( classID == null) {
					timeLoc.add("spare");
					timeLoc.add("-");
				}
				else{
					String location = this.courses.findLocation(classID);
					timeLoc.add(classID);
					timeLoc.add(location);
				}
			}
			
			this.admins.createAdmin(macAddress, adminId, firstname, lastname, timeLoc);
			result = true;
		}
		else{
			result = false;
		}
		return result;
	}
	
	/**
	 * @param id	- the id of the new course
	 * @param name	- the name of the new course
	 * @param period - the peroid of the class
	 * @param location	- the location of the course
	 * @return	- a boolean indicating whether the update was successful or not
	 */
	public boolean newCourse(String id, String name, String period, String location){
		boolean result;
		
		//checks if the course id isn't being used
		if( this.courses.isValid(id) ){
			this.courses.createCourse(id, name, period, location);
			result = true;
		}
		else{
			result = false;
		}
		return result;
	}
	
	/**
	 * @param macAddress - the macAddress of the student to be deleted
	 * @return - a boolean indicating that the student has been deleted
	 */
	public boolean deleteStudent(String macAddress){
		boolean result = false;
		
		//checks if the mac address is currently being used
		if( !this.students.isValidMac(macAddress) ){
			this.students.deleteStudent(macAddress);
			result = true;
		}
		return result;
	}

	/**
	 * @param macAddress - the macAddress of the admin to be deleted
	 * @return - a boolean indicating that the admin has been deleted
	 */
	public boolean deleteAdmin(String macAddress){
		boolean result = false;
		
		//checks if the mac address is currently being used
		if( !this.admins.isValidMac(macAddress) ){
			this.admins.deleteAdmin(macAddress);
			result = true;
		}
		return result;
	}
	
	/**
	 * @param courseId - the id of the course to be deleted
	 * @return	- a boolean indicating that the course has been deleted
	 */
	public boolean deleteCourse(String courseId){
		boolean result = false;
		
		//checks if the course id is currently being used
		if( !this.courses.isValid(courseId) ){
			this.courses.deleteCourse(courseId);
			result = true;
		}
		return result;
	}
	
	/**
	 * @return - a map containing an arraylist of both the students dynamic and static information stored by mac address.
	 * The first index stores the dynamic info while the second stores the static info
	 */
	public Map<String, ArrayList<JSONhandler> > retrieveStudents(){
		
		Map<String, JSONhandler> dy = this.students.getDynamicInfo();	//gets the dynamic info
		Map<String, JSONhandler> st = this.students.getStaticInfo();	//gets the static info
		
		//Creates the result map
		Map<String, ArrayList<JSONhandler> > result = new HashMap<String, ArrayList<JSONhandler> >();
		ArrayList<JSONhandler> inner;	//Creates the inner array that is stored in the map
		
		//Stores both the static and dynamic info in the database
		for( String k: dy.keySet() ){
			inner = new ArrayList<JSONhandler>();
			inner.add( dy.get(k) );
			inner.add( st.get(k) );
			result.put(k, inner);
		}
		return result;
	}
	
	/**
	 * @return - a map containing a list of admins stored by mac address
	 */
	public Map<String, JSONhandler> retrieveAdmin(){
		return this.admins.getAdminInfo();
	}
	
	/**
	 * @return - a map containing the list of courses stored by the course id
	 */
	public Map<String, JSONhandler> retrieveCourses(){
		return this.courses.getCourses();
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
	 */
	public void updateConfig(int lunchLength, String schoolEnd, String schoolStart, int grace, String firstStart, String secondStart, String thirdStart, String fourthStart){
		this.config.update(lunchLength, schoolEnd, schoolStart, grace, firstStart, secondStart, thirdStart, fourthStart);			
	}
	
	/**
	 * @return - the start time of all four periods
	 */
	public ArrayList<Integer> getConfigPeriodStart(){
		return this.config.getPeriodStart();
	}
	
	/**
	 * @return - the time the school starts
	 */
	public String getConfigSchoolStart(){
		return this.config.getSchoolStart();
	}
	
	/**
	 * @return - the time the school ends
	 */
	public String getConfigSchoolEnd(){
		return this.config.getSchoolEnd();
	}

	/**
	 * @return - the length of each lunch period
	 */
	public int getConfigLunchLength(){
		return this.config.getLunchLength();
	}
	
	public Map<String, String> getPeriods(int period){
		return courses.getPeriods(period);
	}
	
	public void refreshAdminData(){
		this.admins.run();
	}
	
	public void refreshClassData(){
		this.courses.run();
	}
	
	public void refreshStudentData(){
		this.students.run();
	}
}
