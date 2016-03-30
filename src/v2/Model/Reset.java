package v2.Model;

import java.util.Map;

import com.cloudant.client.api.CloudantClient;
import com.cloudant.client.api.Database;
import com.cloudant.client.api.model.Response;

public class Reset {
	
	Map<String, JSONhandler> stu; 
	private Database dynam_db;

	
	public Reset( Map<String, JSONhandler> data, CloudantClient con){
		this.stu = data;
		this.dynam_db = con.database("dynamic_user_info", false);
	}

	public boolean reset(){
		Boolean success = true;
		
		for(String t: stu.keySet() ){
			stu.get(t).addData("user_status", "ABSENT");
			stu.get(t).addData("entry", "-");
			stu.get(t).addData("exit", "-");
			stu.get(t).addData("user_current_class", "-");
			stu.get(t).addData("user_location", "-");
			
			Response h = this.dynam_db.update(stu.get(t).instance);
			
			if( h.getError() != null){
				success = false;
			}
		}
		
		return success;
	}
}
