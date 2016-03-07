package v2.Controller;

import java.util.ArrayList;
import java.util.Map;

import com.trolltech.qt.gui.QApplication;

import v2.Model.JSONhandler;
import v2.Model.Model;
import v2.View.StudentTabs;
import v2.View.MainView;
import v2.View.AdminTabs;
import v2.View.CourseTabs;

/**
 * @author jason
 * 
 * This is a singleton class that instantiates both the Model class and the View
 */
public class Controller {

	private static Controller control = null; //the single instance of the Controller class
	private Model model;	                  //the model which contains all the backend of the class
	private MainView view;               //the view of the UI
	
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

	}
	
	public void hello(String y){
		System.out.println( y);
	}
	
	public void display(){
		Map<String, ArrayList<JSONhandler>> t = model.retrieveStudents();
		
		for( String r: t.keySet() ){
			StudentTabs s = new StudentTabs();
			s.setupUi(view.stuScrollWidget);
   		    s.fname.connectSlotsByName();
   		    s.lname.connectSlotsByName();
			s.fname.setText(t.get(r).get(1).toString("user_first_name") );
			s.lname.setText(t.get(r).get(1).toString("user_last_name") );
		}
		
		Map<String, JSONhandler> u = model.retrieveAdmin();
		
		for( String r: u.keySet() ){
			AdminTabs s = new AdminTabs();
			s.setupUi(view.adminScrollWidget );
   		    s.fname.connectSlotsByName();
   		    s.lname.connectSlotsByName();
			s.fname.setText(u.get(r).toString("admin_first_name") );
			s.lname.setText(u.get(r).toString("admin_last_name") );
		}
		
		Map<String, JSONhandler> v = model.retrieveCourses();
		
		for( String r: v.keySet() ){
			CourseTabs s = new CourseTabs();
			s.setupUi(view.cScrollWidget );
   		    s.cname.connectSlotsByName();
   		    s.id.connectSlotsByName();
			s.cname.setText(v.get(r).toString("class_name") );
			s.id.setText(v.get(r).toString("_id") );
		}
	}
	
	/**
	 * The method creates and displays the UI
	 */
	public void activate(String args[]){
		view.activate(args);
		this.setUP();
		this.display();
		QApplication.execStatic();
	}
	
	public static void main(String args[]){
		Controller t = Controller.getInstance();
		t.activate(args);
	}
	
}




/*
 * 	IMPLEMENT THE SEARCH FUNCTIONALITY
 *  ADD THE MAIN UI WINDOW TO THE VIEW PACKAGE
 *  EDIT THE CONFIG DATABASE AND USE A SPECIFIC NUMBER OF PERIODS
 *  ADD METHOD IN THE CONFIG FILE THAT RETURNS THE START TIME FOR EACH PERIOD
 *  EDIT THE OTHER UI PAGES TO REFLECT THE CHANGES IN THE DB
 *  CREATE METHODS IN THE MODEL THAT WILL UPDATE 
 * 
 */










