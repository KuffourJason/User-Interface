package v2.Model;

import com.cloudant.client.api.CloudantClient;

public class Model {

	private Students students;	//Instance to handle student crap
	private Courses courses;	//Instance to handle courses crap
	private Admins admins;		//instance to handle admins crap
	
	/**
	 * 
	 */
	public Model(){
		CloudantClient account = new CloudantClient("eyeofthetiger", "eyeofthetiger", "eng40000");
		this.students = new Students(account);
		this.courses = new Courses(account);
		this.admins = new Admins(account);
		this.getData();
	}
	
		
	/**
	 * 
	 */
	private void getData(){
		Thread s = new Thread(this.students);
		Thread a = new Thread(this.courses );
		Thread c = new Thread(this.admins );
		
		s.start();
		a.start();
		c.start();
		
		try 
		{
			s.join();
			a.join();
			c.join();
		} 
		catch (InterruptedException e) {}
	}
	
	
	public void updateStudents(){
		
	}
	
	public void updateAdmins(){
		
	}
	
	public void updateCourses(){
		
	}

	public static void main(String args[]){
		Model model = new Model();
		model.getData();
	}
}
