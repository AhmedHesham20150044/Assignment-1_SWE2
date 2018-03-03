package RESTful_API;

public class Fixer_API {
	
	private String URI ;
	
	public Fixer_API () {
		this.URI = "http://api.fixer.io/" ;
	}
	
	private void callService (String uri) {
		StringBuffer response = HTTPConnection.connect(uri) ;
		if ( response == null) {
			System.out.println("URI is not valid ");
		}else {
			Fixer_API_Data result = Json_Translator.Translate(response);
			if (result == null)
				System.out.println("translate from JSON to NORMAL VARIABLE error ") ;
			else
				result.printObj();
		}
	}

	public void getCurrenciesForEuros(){
		String uri = "http://api.fixer.io/latest" ;
		this.callService(uri);
	}
	
	public void getCurrenciesForEuros(String [] bases) {
		String uri = "latest?symbols=" ;
		uri = this.URI + uri + bases[0] ;
		for (int index = 1 ; index < bases.length ; index++) {
			uri += "," + bases[index] ;
		}
		this.callService(uri);
	}

	public void getCurrenciesForEurosHistorical(String day , String month , String year) {
		String uri = this.URI + year + "-" + month + "-" + day ;
		this.callService(uri);
	}

	public void getCurrenciesFor (String base) {
		String uri = "latest?base=" ;
		uri = this.URI + uri + base ;
		this.callService(uri);
	}

	public void getCurrenciesFor (String base , String[] bases) {
		String uri = this.URI + "latest?base=" + base + "&symbols=" + bases[0] ;
		
		for (int index = 1 ; index < bases.length ; index++) {
			uri += "," + bases[index] ;
		}
		this.callService(uri);
	}
	
}
