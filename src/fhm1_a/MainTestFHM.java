package fhm1_a;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.Scanner;

/**
 * Example of how to use the FHM algorithm 
 * from the source code.
 * @author Philippe Fournier-Viger, 2014
 */
public class MainTestFHM {

	public static void main(String [] arg) throws IOException{
		
		String input = fileToPath("DB_Utility.txt");
		String output = "output/fhm1_b.txt";

		int min_utility = 30;  // 
		
		// Applying the HUIMiner algorithm
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the value of k");
		int k = in.nextInt();
		
		AlgoFHM fhm = new AlgoFHM(k);
		fhm.runAlgorithm(input, output, min_utility);
		fhm.printStats();

	}

	public static String fileToPath(String filename) throws UnsupportedEncodingException{
		URL url = MainTestFHM.class.getResource(filename);
		 return java.net.URLDecoder.decode(url.getPath(),"UTF-8");
	}
}
