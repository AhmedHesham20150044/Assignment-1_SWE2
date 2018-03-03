package RESTful_API;

import java.util.Scanner;

public class Assignment1_SWE2 {

	private static Scanner scanner;

	public static void main(String[] args) {
		
		Assignment1_SWE2.running();
	
	}
	
	public static void running() {
		String chosen = "" ;
		
		do {
			
			
			System.out.println("\n\n\t\t\tRESTFul API \n");
			System.out.println("\t 1 -> Running APIXU API");
			System.out.println("\t 2 -> Running Fixer API ");
			System.out.print("\t 3 -> Exit \n\n\t\t>>>   ");
			
			scanner = new Scanner(System.in);
			chosen = scanner.nextLine();
			
			if( chosen.equals("1") ) {
				APIXU_Controler XU = new APIXU_Controler() ;
				XU.APIXU_Run();
			}
			else if( chosen.equals("2") ) {
				Fixer_API_Viwer fixer = new Fixer_API_Viwer() ;
				fixer.fixerAPIRun();
			}
			else if ( chosen.equals("3") )
				System.out.println("\n\n\n\t\t Exit .......");
			else
				System.out.println("\n\n\t\twrong chosen......");
			
		}while ( !(chosen.equals("3"))  );
	}
	
	
		

}
