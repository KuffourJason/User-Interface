package v2.Controller;

import java.util.ArrayList;
import java.util.Map;

import com.trolltech.qt.gui.QApplication;

import v2.Model.JSONhandler;
import v2.Model.Model;
import v2.View.Ui_Form;
import v2.View.Ui_MainWindow;

/**
 * @author jason
 * 
 * This is a singleton class that instantiates both the Model class and the View
 */
public class Controller {

	private static Controller control = null; //the single instance of the Controller class
	private Model model;	                  //the model which contains all the backend of the class
	private Ui_MainWindow view;               //the view of the UI
	
	/**
	 * The constructor creates instances of the model and the main UI view
	 */
	private Controller(){
		model = new Model();
		view = new Ui_MainWindow();
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
	
	public void display(){
		Map<String, ArrayList<JSONhandler>> t = model.retrieveStudents();
		
		for( String r: t.keySet() ){
			Ui_Form s = new Ui_Form();
			s.setupUi(view.stuScrollWidget);
   		    s.fname.connectSlotsByName();
   		    s.lname.connectSlotsByName();
			s.fname.setText(t.get(r).get(1).toString("user_first_name") );
			s.lname.setText(t.get(r).get(1).toString("user_last_name") );
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










