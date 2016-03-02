package v2.Controller;

import v2.Model.Model;

public class Controller {

	private static Controller control = null;
	private Model model;
	
	/**
	 * 
	 */
	private Controller(){
		model = new Model();
	}
	
	/**
	 * @return
	 */
	public static Controller getInstance(){
		if( control == null){
			control = new Controller();
		}
		return control;
	}
	
	public void setUP(){
		
	}
	
}
