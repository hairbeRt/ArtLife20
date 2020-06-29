import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;
import java.io.PrintWriter;

public class MainScript {
	
	//Parse the given input file
	public static int[][] readPointsFromFile(String filename) throws java.io.FileNotFoundException{
		//First line doesn't specify amount of points, so I'll make a list and transfer into an array afterwards
		ArrayList<Integer> xList = new ArrayList<Integer>();
		ArrayList<Integer> yList = new ArrayList<Integer>();
		
		Scanner sc = new Scanner(new File(filename));
		//Ignore first line
		sc.nextLine();
		while(sc.hasNext()) {
			//Ignore first 'id' token
			sc.nextInt();
			//Add coordinates to lists
			xList.add(sc.nextInt());
			yList.add(sc.nextInt());
			//Go to end of line
			sc.nextLine();
		}
		sc.close();
		int amtPoints = xList.size();
		int[][] coords = new int[amtPoints][2];
		for(int i = 0; i<amtPoints; i++) {
			coords[i][0] = xList.get(i);
			coords[i][1] = yList.get(i);
		}
		return coords;
	}
	
	
	public static void main(String[] args) throws java.io.FileNotFoundException{
		//Read in all necessary input
		EvoTSPDoubleVisit alg;
		Scanner consoleIn = new Scanner(System.in);
		int[][] readCoords = MainScript.readPointsFromFile("Positions_PA-E.txt");
		int sz = readCoords.length;
		GeomSpace G = new GeomSpace(sz, readCoords);
		System.out.print("Minimize (\"min\") or maximize (\"max\") length of tour: ");
		String mode = consoleIn.next();
		System.out.print("Size of population: ");
		int popSz = consoleIn.nextInt();
		System.out.print("Amount of individuals killed/Amount of offspring per generation: ");
		int amtOffspring = consoleIn.nextInt();
		System.out.print("Amount of steps: ");
		int amtSteps = consoleIn.nextInt();
		System.out.print("Save results to: ");
		String outFilename = consoleIn.next();
		consoleIn.close();
		
		//Depending on mode, run part one or part two of the exercise
		if(mode.equals("max")) {
			alg = new AssignmentPartOne(G, popSz, amtOffspring);
		} else if(mode.equals("min")) {
			alg = new AssignmentPartTwo(G, popSz, amtOffspring);
		} else {
			System.out.println("Wrong mode entered!");
			return;
		}
		
		//File to print results to
		PrintWriter resultOut = new PrintWriter(outFilename);
		for(int i = 0; i < amtSteps; i++) {
			alg.doEvoStep();
			resultOut.println(i + " " + alg.getBestFitness() + " " + alg.getMeanParentFitness() + " " + alg.getWorstParentFitness());
		}
		resultOut.close();
		
		//Test to see if we have actually read the correct coordinates
		/*
		for(int i = 0; i < sz; i++) {
			System.out.println(G.getCoords(i));
		}
		*/
	}
}
