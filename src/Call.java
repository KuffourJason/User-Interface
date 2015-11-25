import java.util.ArrayList;
import java.util.Arrays;
import com.cloudant.client.api.CloudantClient;
import com.cloudant.client.api.Database;
import com.google.gson.JsonObject;


public class Call {
	
	private CloudantClient client;
	
	public Call(){
		String account = "eyeofthetiger";//System.getenv("account");
		String pass =    "eng40000";//System.getenv("password");
    	this.client = new CloudantClient(account, account, pass);
	}
	
	public ArrayList<String[]> getAdminData(){
		Database db = this.client.database("administrator_info", false);
    	JsonObject res = new JsonObject();
    	res = db.findAny(res.getClass(), "https://eyeofthetiger.cloudant.com/administrator_info/_all_docs");
    	JSONhandler ad = new JSONhandler( res );
    	ArrayList<String> list = ad.extractFromArray( "rows", "id");
    	JSONhandler f;
    	
    	ArrayList<String[]> retur = new ArrayList<String[]>();
    	    	
    	for( String s: list){
    		f = new JSONhandler(db.find(JsonObject.class, s));
    		String ret[] = { f.toString("admin_first_name"), f.toString("admin_last_name"), f.toString("admin_timetable") };
    		retur.add(ret);
    	}
		return retur;
	}
	
	
	public ArrayList<String[]> getStudentData(){
		Database db = this.client.database("static_user_info", false);
    	JsonObject res = new JsonObject();
    	res = db.findAny(res.getClass(), "https://eyeofthetiger.cloudant.com/static_user_info/_all_docs");
    	JSONhandler ad = new JSONhandler( res );
    	ArrayList<String> list = ad.extractFromArray( "rows", "id");
    	JSONhandler f;
    	
    	ArrayList<String[]> retur = new ArrayList<String[]>();
    	    	
    	for( String s: list){
    		f = new JSONhandler(db.find(JsonObject.class, s));
    		String ret[] = { f.toString("user_first_name"), f.toString("user_last_name"), f.toString("user_timetable") };
    		retur.add(ret);
    	}
		return retur;
	}
	
	
	
	public ArrayList<String[]> getClassData(){
		Database db = this.client.database("class_info", false);
    	JsonObject res = new JsonObject();
    	res = db.findAny(res.getClass(), "https://eyeofthetiger.cloudant.com/class_info/_all_docs");
    	JSONhandler ad = new JSONhandler( res );
    	ArrayList<String> list = ad.extractFromArray( "rows", "id");
    	JSONhandler f;
    	
    	ArrayList<String[]> retur = new ArrayList<String[]>();
    	    	
    	for( String s: list){
    		f = new JSONhandler(db.find(JsonObject.class, s));
    		String ret[] = { f.toString("class_name"), f.toString("class_time_start"), f.toString("class_time_end"), f.toString("class_location") };
    		retur.add(ret);
    	}
		return retur;
	}
	
	
	
	
	public boolean createStudent(String first, String last, String timetable){
		
		Database db_dynamic = this.client.database("dynamic_user_info", false);
		Database db_static = this.client.database("static_user_info", false);

		String con = first + last;
		String fin = con;//Integer.decode(con) + "";
		String time[] = timetable.split(",");
		ArrayList<String> table = new ArrayList<String>( Arrays.asList(time));
		
		if( !db_static.contains(fin) ){
			JSONhandler add = new JSONhandler(new JsonObject());
			add.addData("_id", fin);
			add.addData("user_first_name", first);
			add.addData("user_last_name", last);
			add.addData("user_number_of_absences", "0");
			add.addData("user_number_of_lates", "0");
			add.addData("user_timetable", table);
			
			JSONhandler add_dyn = new JSONhandler(new JsonObject());
			add_dyn.addData("_id", fin);
			add_dyn.addData("user_status", "0");
			add_dyn.addData("user_current_class", "0");
			add_dyn.addData("user_location", "0");
			add_dyn.addData("user_daily_attendance", "0");
			
			db_static.save(add.instance);
			db_dynamic.save(add_dyn.instance);
			
			return true;
		}
		return false;
	}
	
	
	public boolean createAdmin(String first, String last, String timetable){
		
		Database db = this.client.database("administrator_info", false);
		
		String con = first + last;
		String fin = con;//Integer.decode(con) + "";
		String time[] = timetable.split(",");
		ArrayList<String> table = new ArrayList<String>( Arrays.asList(time));
		
		if( !db.contains(fin) ){
			JSONhandler add = new JSONhandler(new JsonObject());
			add.addData("_id", fin);
			add.addData("admin_first_name", first);
			add.addData("admin_last_name", last);
			add.addData("admin_location", "0");
			add.addData("admin_timetable", table);

			db.save(add.instance);			
			return true;
		}
		return false;
	}
	
	
	public boolean createClass(String name, String start, String end, String location){
		
		Database db = this.client.database("class_info", false);
		String con = (name + location).replaceAll(" ", "_");
		String fin = con;//Integer.decode(con) + "";
		
		if( !db.contains(fin) ){
			JSONhandler add = new JSONhandler(new JsonObject());
			add.addData("_id", fin);
			add.addData("class_name", name);
			add.addData("class_time_start", start);
			add.addData("class_time_end", end);
			add.addData("class_location", location);

			db.save(add.instance);			
			return true;
		}
		return false;
	}
	
	
}
