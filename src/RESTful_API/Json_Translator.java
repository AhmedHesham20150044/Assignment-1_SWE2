package RESTful_API;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Json_Translator {
	
	public static Fixer_API_Data  Translate (StringBuffer response ) {
		Fixer_API_Data result = new Fixer_API_Data() ;
		try {
			JSONObject myresponse = new JSONObject(response.toString()) ;
			result.setBase( myresponse.getString("base"));
			result.setDate( myresponse.optString("date"));
			JSONObject rates = new JSONObject(myresponse.getJSONObject("rates").toString()) ;
			result.setRates(rates);
			return result ;
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			return null ;
		}	
	}
	
	public static APIXU_Current_Data TranslateTo_APIXU_Current(StringBuffer response) {
		
		APIXU_Current_Data result = new APIXU_Current_Data() ;
		try {
			JSONObject myresponse = new JSONObject(response.toString()) ;
			result.setLocation(myresponse.getJSONObject("location"));
			result.setCurrent(myresponse.getJSONObject("current"));
			return result ;
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			return null ;
		}
	}

	public static APIXU_Forecast_Data TranslateTo_APIXU_Forecast (StringBuffer response) {
		
		APIXU_Forecast_Data result = new APIXU_Forecast_Data() ;
		result.curr = TranslateTo_APIXU_Current(response);
		try {
			JSONObject myresponse = new JSONObject(response.toString()) ;
			JSONObject forecast = new JSONObject(myresponse.getJSONObject("forecast").toString()) ;
			JSONArray forecastday = forecast.getJSONArray("forecastday");
			result.setForecast(forecastday.getJSONObject(0));
			return result ;
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			return null ;
		}
		
		
		
	}
	
	
}
