package v2.Controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.trolltech.qt.gui.QApplication;
import v2.Model.JSONhandler;
import v2.Model.Model;
import v2.View.*;

/**
 * @author jason
 * 
 * This is a singleton class that instantiates both the Model class and the View
 */
public class Controller {

	private static Controller control = null; //the single instance of the Controller class
	protected Model model;	                  //the model which contains all the backend of the class
	protected MainView view;               //the view of the UI
	
	private Map<String, AdminTabs> adminTab;
	
	/**
	 * The constructor creates instances of the model and the main UI view
	 */
	private Controller(){
		model = new Model();
		view = new MainView();
		adminTab = new HashMap<String, AdminTabs>();
	}
	
	/**
	 * @return - the single instance of the controller
	 */
	public static Controller getInstance(){
		if( control == null){
			control = new Controller();
		}
		return control;
	}
	
	/**
	 * This methods connects the view and the model together. It connects all the slots of the
	 * view to the model
	 */
	public void setUP(){		
		this.view.nc.label.setText("yeah boy what's up");
	}
	
	public void hello(String y){
		System.out.println( y);
	}
	
	public boolean deleteAdmin(String macAddress){
		return model.deleteAdmin(macAddress);
	}
	
	public boolean deleteCourse(String courseId){
		return model.deleteCourse(courseId);
	}
	
	public boolean deleteStudent(String id){
		return model.deleteStudent(id);
	}
	
	public boolean createCourse(String id, String name, String period, String location){
		return model.newCourse(id, name, period, location);
	}
	
	public boolean createStudent(String macAddress, String studentId, String firstname, String lastname, ArrayList<String> timetable){
		return model.newStudent(macAddress, studentId, firstname, lastname, timetable);
	}
	
	public boolean createAdmin( String macAddress, String adminId, String firstname, String lastname, ArrayList<String> timetable  ){
		return model.newAdmin(macAddress, adminId, firstname, lastname, timetable);
	}
	
	public Map<String, String> getPeriods(int period){
		return model.getPeriods(period);
	}
	
	public void initial_display(){
		
		Map<String, ArrayList<JSONhandler>> t = model.retrieveStudents();
		for( String r: t.keySet() ){
			
			if( t.get(r).get(1).toString("user_first_name").equals("nothing")) continue;
			StudentTabs s = new StudentTabs();
			s.setupUi(view.stuScrollWidget);
   		    s.fname.connectSlotsByName();
   		    s.lname.connectSlotsByName();
   		    s.absents.connectSlotsByName();
   		    s.lates.connectSlotsByName();
   		    s.id.connectSlotsByName();
			s.fname.setText(t.get(r).get(1).toString("user_first_name") );
			s.lname.setText(t.get(r).get(1).toString("user_last_name") );
			s.lates.setText(t.get(r).get(1).toString("user_number_of_lates"));
			s.absents.setText(t.get(r).get(1).toString("user_number_of_absences"));
			s.id.setText(t.get(r).get(1).toString("user_id"));
			
			s.cStatus.connectSlotsByName();
			s.currClass.connectSlotsByName();
			s.curLocation.connectSlotsByName();
			s.p1.connectSlotsByName();
			s.p2.connectSlotsByName();
			s.p3.connectSlotsByName();
			s.p4.connectSlotsByName();

			s.cStatus.setText(t.get(r).get(0).toString("user_status"));
			s.currClass.setText(t.get(r).get(0).toString("user_current_class"));
			s.curLocation.setText(t.get(r).get(0).toString("user_location"));
			s._id = t.get(r).get(0).toString("_id");
			
			String time[] = t.get(r).get(1).extractToArray("user_timetable");
			if( time.length > 6){
				s.p1.setText(time[0]);
				s.p2.setText(time[2]);
				s.p3.setText(time[4]);
				s.p4.setText(time[6]);
			}
		}
		
		
		
		
		Map<String, JSONhandler> v = model.retrieveCourses();
		for( String r: v.keySet() ){
			
			if( v.get(r).toString("class_name").equals("nothing")) continue;
			CourseTabs s = new CourseTabs();
			s.setupUi(view.cScrollWidget );
   		    s.cname.connectSlotsByName();
   		    s.id.connectSlotsByName();
   		    s.period.connectSlotsByName();
   		    s.start.connectSlotsByName();
   		    s.location.connectSlotsByName();
   		    s.duration.connectSlotsByName();
   		    
			s.cname.setText(v.get(r).toString("class_name") );
			s.start.setText(v.get(r).toString("class_time_start") );
			s.id.setText(v.get(r).toString("_id") );
			s.duration.setText(v.get(r).toString("duration") );
			s.location.setText(v.get(r).toString("class_location") );
			s.period.setText(v.get(r).toString("class_period") );
			s._id = v.get(r).toString("_id") ;
		}
		
		Map<String, JSONhandler> u = Controller.getInstance().model.retrieveAdmin();
		for( String r: u.keySet() ){
			
			if( u.get(r).toString("admin_first_name").equals("nothing")) continue;
			AdminTabs s = new AdminTabs();
			s.setupUi(view.adminScrollWidget );
			
   		    s.fname.connectSlotsByName();
   		    s.lname.connectSlotsByName();
   		    s.id.connectSlotsByName();
			s.fname.setText(u.get(r).toString("admin_first_name") );			
			s.lname.setText(u.get(r).toString("admin_last_name") );
			s.id.setText(u.get(r).toString("admin_id"));
			s._id = u.get(r).toString("_id");
			s.cStatus.connectSlotsByName();
			s.currclass.connectSlotsByName();
			s.location.connectSlotsByName();
			s.p1.connectSlotsByName();
			s.p2.connectSlotsByName();
			s.p3.connectSlotsByName();
			s.p4.connectSlotsByName();
			s.cStatus.setText(u.get(r).toString("admin_status"));
			s.currclass.setText(u.get(r).toString("admin_current_class"));
			s.location.setText(u.get(r).toString("admin_location"));
			
			String time[] = u.get(r).extractToArray("admin_timetable");
			if( time.length > 5){
				s.p1.setText(time[0]);
				s.p2.setText(time[2]);
				s.p3.setText(time[4]);
				s.p4.setText(time[6]);
			}
			AdminTabs wt = s;
			adminTab.put(s._id, wt);
		}
	}
	
	public void updateAdminView(){
		System.out.println(adminTab.size());
		for( String k: adminTab.keySet() ){
			AdminTabs bye = adminTab.remove(k);
			bye.holder.hide();
			bye.holder.close();
		}
	}
	
	/**
	 * The method creates and displays the UI
	 */
	public void activate(String args[]){
		//this.setUP();
		view.activate(args);
		this.initial_display();
		QApplication.execStatic();
	}
	
	public static void main(String args[]){
		Controller t = Controller.getInstance();
		t.activate(args);
	}
	
}





