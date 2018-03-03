package RESTful_API;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HTTPConnection {

	public static StringBuffer connect (String uri) {
		
		URL obj;
		BufferedReader in ;
		try {
			
			obj = new URL(uri);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();
			int responsecode = con.getResponseCode() ;
			System.out.println("\nString  'Get' request to URL : " + uri);
			System.out.println("Response code : " + responsecode );
			in = new BufferedReader ( 
					new InputStreamReader (con.getInputStream())) ;
			String inputLine ;
					
			StringBuffer response = new StringBuffer() ;
			while ((inputLine = in.readLine()) != null ) {
				response.append (inputLine) ;
			}
			in.close();
			return response ;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	
	}
 }
