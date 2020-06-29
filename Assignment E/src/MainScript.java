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
		int[][] readCoords = MainScript.readPointsFromFile("Positions_PA-E.txt");
		int sz = readCoords.length;
		GeomSpace G = new GeomSpace(sz, readCoords);
		EvoTSPDoubleVisit alg = new AssignmentPartOne(G, 50, 20);
		PrintWriter resultOut = new PrintWriter("result.txt");
		for(int i = 0; i < 10000; i++) {
			alg.doEvoStep();
			resultOut.println(i + " " + alg.getBestFitness());
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
