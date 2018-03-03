package RESTful_API;

import java.util.Scanner;

public class Fixer_API_Viwer {
	
	private Fixer_API fixer  ;
	private Scanner input  ;
	
	public Fixer_API_Viwer(){
		fixer = new Fixer_API() ;
		input = new Scanner(System.in) ;
	}
	
	private void getCurrenciesForEurosHistorical() {
		System.out.print("\t\t day >>>  ");
		String day = this.input.nextLine() ;
		System.out.print("\t\t month >>>  ");
		String month = this.input.nextLine() ;
		System.out.print("\t\t year >>>  ");
		String year = this.input.nextLine() ;
		
		fixer.getCurrenciesForEurosHistorical(day, month, year);	
	}
	
	private void getCurrenciesFor1() {
		System.out.print("\tenter the base >>>  ");
		String base = this.input.nextLine() ;
		this.fixer.getCurrenciesFor(base);
	}
	
	private void getCurrenciesFor2(){
		System.out.print("\tenter the base >>>  ");
		String base = this.input.nextLine() ;
		
		System.out.print("\tenter the number of Currencies >>>  ");
		int size = this.input.nextInt() ;
		this.input.nextLine() ;
		String[] bases = new String[size] ;
		for (int index = 0 ; index < size ; index++) {
			int counter = index + 1 ;
			System.out.print("\t\tCurrencies "+ counter + " >>>  ");
			bases[index] = this.input.nextLine() ;
		}
		
		this.fixer.getCurrenciesFor(base, bases);
		
	}
	
	private void getCurrenciesForEuros() {
		System.out.print("\tenter the number of Currencies >>>  ");
		int size = this.input.nextInt() ;
		this.input.nextLine() ;
		String[] bases = new String[size] ;
		for (int index = 0 ; index < size ; index++) {
			int counter = index + 1 ;
			System.out.print("\t\tCurrencies "+ counter + " >>>  ");
			bases[index] = this.input.nextLine() ;
		}
		
		this.fixer.getCurrenciesForEuros(bases);
	}
	
	public void fixerAPIRun(){
		String chosen = "" ;
		do {
			System.out.println("\n\n\t\t\tFixer API \n");
			System.out.println("\t 1 -> get Currencies For Euros");
			System.out.println("\t 2 -> get specific Currencies For Euros ");
			System.out.println("\t 3 -> get Currencies For Euros Historical");
			System.out.println("\t 4 -> get Currencies For specific base ");
			System.out.println("\t 5 -> get specific Currencies For specific base ");
			System.out.print("\t 6 -> back \n\n\t\t>>>   ");
			
			chosen = this.input.nextLine();
			
			if( chosen.equals("1") )
				this.fixer.getCurrenciesForEuros();
			else if( chosen.equals("2") )
				this.getCurrenciesForEuros();
			else if ( chosen.equals("3") )
				this.getCurrenciesForEurosHistorical();
			else if ( chosen.equals("4") )
				this.getCurrenciesFor1();
			else if ( chosen.equals("5") )
				this.getCurrenciesFor2();
			else if ( chosen.equals("6") )
				System.out.println("\n\n\n\t\t back .......");
			else
				System.out.println("\n\n\t\twrong chosen......");
			
		}while ( !(chosen.equals("6"))  );
	}
	
	

	
}
