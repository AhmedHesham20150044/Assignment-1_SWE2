package RESTful_API;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.json.JSONException;
import org.json.JSONObject;

public class APIXU_Current_Data {

	private Map <String , Object> location ;
	private Map <String , Object> current ;
	
	public APIXU_Current_Data() {
		location = new HashMap <> () ;
		current = new HashMap <> () ;
	}
	
	public void setLocation(JSONObject loc) {
		this.location.clear();
		String keys [] = JSONObject.getNames(loc);
		for (String  key : keys) {
			try {
				
				this.location.put(key ,loc.get(key)) ;
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void setCurrent(JSONObject curr) {
		this.current.clear();
		String keys [] = JSONObject.getNames(curr);
		for (String  key : keys) {
			try {
				
				if (key.equals( "condition" ))
					continue ;
				
				this.current.put(key ,curr.get(key)) ;
				
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
	}

	public Map<String, Object> getLocation (){
		return this.location ;
	}
	
	public Map<String, Object> getCurrent(){
		return this.current ;
	}
	
	public void printObj () {
		
		System.out.println( "\tLocation is { ");
		Set<String> keys = this.location.keySet() ;
		for (String key : keys) {
			System.out.println( "\t\t" + key + "\t->\t" + this.location.get(key));
		}
		System.out.println("\t }");
		
		System.out.println( "\t\tCurrent is { ");
		keys = this.current.keySet() ;
		for (String key : keys) {
			System.out.println( "\t\t\t" + key + "\t->\t" + this.current.get(key));
		}
		System.out.println("\t }");
	}
	
	
}
