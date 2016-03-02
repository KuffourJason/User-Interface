package v2.Controller;

import v2.Model.Model;

/**
 * @author jason
 * 
 * This is a singleton class that instantiates both the Model class and the View
 */
public class Controller {

	private static Controller control = null; //the single instance of the Controller class
	private Model model;	//the model which contains all the backend of the class
	
	/**
	 * The constructor creates instances of the model and the main UI view
	 */
	private Controller(){
		model = new Model();
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
	
	/**
	 * The method creates and displays the UI
	 */
	public void activate(){
		
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










