package RESTful_API;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.json.JSONException;
import org.json.JSONObject;

public class APIXU_Forecast_Data {
	
	public  APIXU_Current_Data curr ;
	private Map <String , Object> forecast ;
	
	public APIXU_Forecast_Data() {
		this.curr = new APIXU_Current_Data() ;
		this.forecast = new HashMap <> () ;
	}
	
	public void setForecast (JSONObject fore) {
		this.forecast.clear();
		String keys [] = JSONObject.getNames(fore);
		for (String  key : keys) {
			try {
				
				if (key.equals( "day" )) {
					JSONObject day =  new JSONObject(fore.getJSONObject("day").toString()) ;
					String [] dayKeys =  JSONObject.getNames(day);
					for (String  K : dayKeys) {
						if(K.equals( "condition" )) {
							continue ;
						}
						this.forecast.put(K ,day.get(K)) ;
					}
				}
				else if (key.equals( "astro" )) {
					JSONObject astro =  new JSONObject(fore.getJSONObject("astro").toString()) ;
					String [] dayKeys =  JSONObject.getNames(astro);
					for (String  K : dayKeys) {
						this.forecast.put(K ,astro.get(K)) ;
					}
				}
				else
					this.forecast.put(key ,fore.get(key)) ;
				
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}	
	}

	public void printObj() {
		this.curr.printObj();
		System.out.println( "\n\n\t\tForecast  is { ");
		Set<String> keys = this.forecast.keySet() ;
		for (String key : keys) {
			System.out.println( "\t\t\t" + key + "\t->\t" + this.forecast.get(key));
		}
		System.out.println("\t }");
	}
	
	
}
