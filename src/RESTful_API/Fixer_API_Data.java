package RESTful_API;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class Fixer_API_Data {
	
	private String base ;
	private String date ;
	private Map <String , Double> rates ;
	
	public Fixer_API_Data() {
		this.base = "" ;
		this.date = "" ;
		rates = new HashMap <> () ;
	}
	
	public void setBase(String base) {
		this.base = base ;
	}
	
	public void setDate(String date) {
		this.date = date ;
	}
	
	public void setRates (JSONObject rates ) {
		this.rates.clear();
		String keys [] = JSONObject.getNames(rates);
		for (String  key : keys) {
			try {
				this.rates.put(key, rates.getDouble(key)) ;
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
	}
	
	public String getBase() {
		return this.base ;
	}
	
	public String getDate() {
		return this.date ;
	}
	
	public Map<String, Double> getRates() {
		return this.rates ;
	}
	
	public void printObj () {
		System.out.println( "\tbase is -> " + this.base);
		System.out.println( "\tdate is -> " + this.date);
		System.out.println( "\trates is { ");
		Set<String> keys = this.rates.keySet() ;
		for (String key : keys) {
			System.out.println( "\t\t" + key + "\t->\t" + this.rates.get(key));
		}
		System.out.println("\t }");
	}
	
	
	

}
