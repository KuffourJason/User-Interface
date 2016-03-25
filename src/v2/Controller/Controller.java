package v2.Controller;

import java.util.ArrayList;
import java.util.Map;

import com.trolltech.qt.core.QObject;
import com.trolltech.qt.gui.QApplication;
import com.trolltech.qt.gui.QIcon;
import com.trolltech.qt.gui.QMessageBox;
import com.trolltech.qt.gui.QPixmap;

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
	 
	/**
	 * The constructor creates instances of the model and the main UI view
	 */
	private Controller(){
		model = new Model();
		view = new MainView();
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
	
	/**
	 * @param y
	 */
	public void hello(String y){
		System.out.println( y);
	}
	
	/**
	 * @param macAddress
	 * @return
	 */
	public boolean deleteAdmin(String macAddress){
		return model.deleteAdmin(macAddress);
	}
	
	/**
	 * @param courseId
	 * @return
	 */
	public boolean deleteCourse(String courseId){
		return model.deleteCourse(courseId);
	}
	
	/**
	 * @param id
	 * @return
	 */
	public boolean deleteStudent(String id){
		return model.deleteStudent(id);
	}
	
	/**
	 * @param id
	 * @param name
	 * @param period
	 * @param location
	 * @return
	 */
	public boolean createCourse(String id, String name, String period, String location){
		return model.newCourse(id, name, period, location);
	}
	
	public Map<String, String> getConfigSettings(){
		
		return null;
	}
	
	/**
	 * @param macAddress
	 * @param studentId
	 * @param firstname
	 * @param lastname
	 * @param timetable
	 * @return
	 */
	public boolean createStudent(String macAddress, String studentId, String firstname, String lastname, ArrayList<String> timetable){
		return model.newStudent(macAddress, studentId, firstname, lastname, timetable);
	}
	
	/**
	 * @param macAddress
	 * @param adminId
	 * @param firstname
	 * @param lastname
	 * @param timetable
	 * @return
	 */
	public boolean createAdmin( String macAddress, String adminId, String firstname, String lastname, ArrayList<String> timetable  ){
		return model.newAdmin(macAddress, adminId, firstname, lastname, timetable);
	}
	
	public void updateConfig(String schoolEnd, String schoolStart, String firstStart, String secondStart, String luStart, String thirdStart, String fourthStart){
		model.updateConfig( schoolEnd, schoolStart, firstStart, secondStart, luStart, thirdStart, fourthStart);
	}
	
	public Map<String, String> getConfigInfo(){
		return model.getConfig();
	}
	/**
	 * @param period
	 * @return
	 */
	public Map<String, String> getPeriods(int period){
		return model.getPeriods(period);
	}
	
	/**
	 * 
	 */
	public void initial_display(){
		this.studentDisplay();
		this.classDisplay();
		this.adminDisplay();
	}
	
	/**
	 * 
	 */
	public void updateAdminView(){
		for( QObject t: view.adminScrollWidget.findChildren() ){
			if( t.getClass().getName().equals("com.trolltech.qt.gui.QWidget") ){
				t.dispose();
			}
		}
		model.refreshAdminData();
		this.adminDisplay();
	}
	
	/**
	 * 
	 */
	public void updateClassView(){
		for( QObject t: view.cScrollWidget.findChildren() ){
			if( t.getClass().getName().equals("com.trolltech.qt.gui.QWidget") ){
				t.dispose();
			}
		}
		model.refreshClassData();
		this.classDisplay();
	}
	
	/**
	 * 
	 */
	public void updateStudentView(){
		for( QObject t: view.stuScrollWidget.findChildren() ){
			if( t.getClass().getName().equals("com.trolltech.qt.gui.QWidget") ){
				t.dispose();
			}
		}
		model.refreshStudentData();
		this.studentDisplay();
	}
	
	public void work(){
		view.notifyAll();
		view.tabWidget.setEnabled(true);
		view.tabWidget.notifyAll();
	}
	
	/**
	 * @param index
	 */
	public void refresh(int index){
		QMessageBox t = new QMessageBox();
		t.setWindowIcon(new QIcon(new QPixmap("classpath:admin_resource/eot_icon.png")));
		t.setWindowTitle("Refreshed");
		
		if( index == 0){
			t.setText("Administrator Info Refreshed");
			this.updateAdminView();
			t.exec();			
		}
		else if( index == 1){
			t.setText("Course Info Refreshed");
			this.updateClassView();
			t.exec();
		}
		else{
			t.setText("Student Info Refreshed");
			this.updateStudentView();
			t.exec();
		}
	}
	
	/**
	 * 
	 */
	public void studentDisplay(){
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

   		    s.deleteButton.connectSlotsByName();
   		    s.expandButton.connectSlotsByName();
			s.fname.setText(t.get(r).get(1).toString("user_first_name") );
			s.lname.setText(t.get(r).get(1).toString("user_last_name") );
			s.lates.setText(t.get(r).get(1).toString("user_number_of_lates"));
			s.absents.setText(t.get(r).get(1).toString("user_number_of_absences"));
			s.id.setText(t.get(r).get(1).toString("user_id"));
			
			s.cStatus.connectSlotsByName();
			s.currClass.connectSlotsByName();
			s.curLocation.connectSlotsByName();
   		    s.entryTime.connectSlotsByName();
   		    s.exitTime.connectSlotsByName();
			/*
			s.p1.connectSlotsByName();
			s.p2.connectSlotsByName();
			s.p3.connectSlotsByName();
			*/
			s.p4.connectSlotsByName();
			
			ArrayList<String> status = t.get(r).get(0).toArray("user_status");
			if( status.size() > 1){
				s.cStatus.setText(status.get(0));
				s.entryTime.setText(status.get(1));
				s.exitTime.setText(status.get(2));
			}
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
			s.holder.lower();
			view.stuScrollWidget.lower();
			
		}
	}
	
	/**
	 * 
	 */
	public void classDisplay(){
		Map<String, JSONhandler> v = model.retrieveCourses();
		Map<String, String> info = this.getConfigInfo();
		
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
			s.id.setText(v.get(r).toString("_id") );
			s.location.setText(v.get(r).toString("class_location") );
			s.period.setText(v.get(r).toString("class_period") );
			s._id = v.get(r).toString("_id") ;
			
			if( v.get(r).toString("class_period").equals("1") ){
				s.start.setText(info.get("first"));
				s.duration.setText(info.get("second"));
			}
			else if( v.get(r).toString("class_period").equals("2") ){
				s.start.setText(info.get("second"));
				s.duration.setText(info.get("third") );
			}
			else if( v.get(r).toString("class_period").equals("3") ){
				s.start.setText(info.get("third"));
				s.duration.setText(info.get("lunchStart") );
			}
			else if( v.get(r).toString("class_period").equals("4") ){
				s.start.setText(info.get("fourth"));
				s.duration.setText(info.get("end") );
			}
		}
	}
	
	/**
	 * 
	 */
	public void adminDisplay(){
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
	    com.trolltech.qt.Utilities.loadQtLibrary("QtCore");
	    com.trolltech.qt.Utilities.loadQtLibrary("QtGui");
	    com.trolltech.qt.Utilities.loadQtLibrary("QtXml");
	    com.trolltech.qt.Utilities.loadQtLibrary("QtSql");
	    com.trolltech.qt.Utilities.loadQtLibrary("QtSvg");
		Controller t = Controller.getInstance();
		t.activate(args);
	}
	
}





