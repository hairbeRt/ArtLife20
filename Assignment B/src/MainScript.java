/**
 * 
 * @author Jonas
 *
 */

import java.util.Scanner;
import java.io.PrintWriter;

public class MainScript {

	public static void main(String[] args) throws Exception{
		
		Scanner sysin = new Scanner(System.in);
		System.out.print("Print data into: ");
		String filename = sysin.next();
		System.out.print("Simulate how many timesteps: ");
		int amtSteps = sysin.nextInt();
		System.out.print("Enter the eight parameters a-h for the system seperated by space: ");
		Population pop = new Population(sysin.nextDouble(),sysin.nextDouble(),sysin.nextDouble(),sysin.nextDouble(),sysin.nextDouble(),sysin.nextDouble(),sysin.nextDouble(),sysin.nextDouble());
		System.out.print("Enter the initial populations for predators and prey seperated by space: ");
		pop.setCurrentPredators(sysin.nextDouble());
		pop.setCurrentPrey(sysin.nextDouble());
		sysin.close();
		
		PrintWriter fileout = new PrintWriter(filename);
		for(int i = 0; i < amtSteps; i++) {
			fileout.println(i + " " + pop);
			pop.doTransitionStep();
		}
		
		fileout.close();
	}

}