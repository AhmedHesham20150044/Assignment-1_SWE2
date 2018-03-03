package RESTful_API;

import java.util.Scanner;

public class APIXU_Controler {
	
	private String URI = "http://api.apixu.com/v1/forecast.json?key=76da4b40c7c54b8a873221847180103&q=" ;
	private Scanner scanner;
	
	private void CurrentWeather (String city) {
		StringBuffer response = HTTPConnection.connect(this.URI + city) ;
		if ( response == null) {
			System.out.println("URI is not valid ");
		}else {
			APIXU_Current_Data result = Json_Translator.TranslateTo_APIXU_Current(response);
			if (result == null)
				System.out.println("translate from JSON to NORMAL VARIABLE error ") ;
			else
				result.printObj();
		}		
	}
	
	
	private void ForecastWeather (String city) {
		StringBuffer response = HTTPConnection.connect(this.URI + city) ;
		if ( response == null) {
			System.out.println("URI is not valid ");
		}else {
			APIXU_Forecast_Data result = Json_Translator.TranslateTo_APIXU_Forecast(response);
			if (result == null)
				System.out.println("translate from JSON to NORMAL VARIABLE error ") ;
			else
				result.printObj();
		}		
	}
	
	
	public void APIXU_Run() {
		String chosen = "" ;
		do {
			System.out.println("\n\n\t\t\tAPIXU API \n");
			System.out.println("\t 1 -> Current Weather");
			System.out.println("\t 2 -> Forecast Weather ");
			System.out.print("\t 3 -> back \n\n\t\t>>>   ");
			
			scanner= new Scanner(System.in);
			chosen = scanner.nextLine();
			
			if( chosen.equals("1") ) {
				System.out.print("\n\n\n\t\tenter city name please  >>> " ) ;
				String city = scanner.nextLine();
				this.CurrentWeather(city);
			}
			else if( chosen.equals("2") ) {
				System.out.print("\n\n\n\t\tenter city name please  >>> " ) ;
				String city = scanner.nextLine();
				this.ForecastWeather(city);
			}
			else if ( chosen.equals("3") )
				System.out.println("\n\n\n\t\t back .......");
			else
				System.out.println("\n\n\t\twrong chosen......");
			
		}while ( !(chosen.equals("3"))  );
	}
	
	
}
