import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;
import java.io.PrintWriter;

public class MainScript {

	public static void main(String[] args) throws java.io.FileNotFoundException{
		ArrayList<Integer> xList = new ArrayList<Integer>();
		ArrayList<Integer> yList = new ArrayList<Integer>();
		
		//Usual IO-stuff. Request some information from user and read the data.
		Scanner consoleIn = new Scanner(System.in);
		System.out.print("Read grid from file: ");
		String fileName = consoleIn.next();
		Scanner fileIn = new Scanner(new File(fileName));
		System.out.print("Amound of steps to run: ");
		int amtSteps = consoleIn.nextInt();
		//Ignore first line
		fileIn.nextLine();
		while(fileIn.hasNext()) {
			xList.add(fileIn.nextInt());
			yList.add(fileIn.nextInt());
			fileIn.nextLine();
		}
		fileIn.close();
		consoleIn.close();
		
		//We choose to implement a Wall-following vehicle. Position and orientation of Car as given in assignment sheet.
		GridCar C = new WallFollowingVehicle();
		GridState G = new GridState(48,17,4);
		
		//Copy xList and yList into array. With so many inserts while reading, still faster than having arrays in the first place
		int[] xArr = new int[xList.size()];
		int[] yArr = new int[yList.size()];
		
		for(int i = 0; i < xArr.length; i++) {
			xArr[i] = xList.remove(0);
			yArr[i] = yList.remove(0);
		}
		G.setWalls(xArr, yArr);
		
		//Print car position line for line into output file and do one more time step
		PrintWriter fileOut = new PrintWriter("PA-F-robot.path");
		for(int i = 0; i < amtSteps; i++) {
			fileOut.println(G.getCarX() + " " + G.getCarY() + " " + G.getCarOrientation());
			G.doStep(C);
		}
		fileOut.close();
	}

}
