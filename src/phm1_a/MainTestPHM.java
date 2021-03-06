package phm1_a;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.Scanner;

/**
 * Example of how to use the PHM algorithm from the source code.
 * @author Philippe Fournier-Viger, 2016
 */
public class MainTestPHM {

	public static void main(String [] arg) throws IOException{
		String output = "output/1_a.txt";

		// =======================
		// EXAMPLE FROM THE ARTICLE : 
		String input = fileToPath("DB_UtilityPerHUIs.txt");
		int min_utility = 20;   
		int minPeriodicity = 1;  // minimum periodicity parameter (a number of transactions)
		int maxPeriodicity = 3;  // maximum periodicity parameter (a number of transactions)
		int minAveragePeriodicity = 1;  // minimum average periodicity (a number of transactions)
		int maxAveragePeriodicity = 2;  // maximum average periodicity (a number of transactions)
		// =======================
		
		// Applying the PHM algorithm
		int k;
		System.out.println("Enter the value of k: ");
		Scanner in = new Scanner(System.in);
		k = in.nextInt();
		in.close();
		AlgoPHM algorithm = new AlgoPHM(k);
		// To disable some optimizations:
		//algorithm.setEnableEUCP(false); 
		//algorithm.setEnableESCP(false);
		
		// Run the algorithm
		algorithm.runAlgorithm(input, output, min_utility, 
				minPeriodicity, maxPeriodicity, minAveragePeriodicity, 
				maxAveragePeriodicity);
		
		// Print statistics about the execution of the algorithm
		algorithm.printStats();

	}

	public static String fileToPath(String filename) throws UnsupportedEncodingException{
		URL url = MainTestPHM.class.getResource(filename);
		 return java.net.URLDecoder.decode(url.getPath(),"UTF-8");
	}
}
