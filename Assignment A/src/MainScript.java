import java.util.Scanner;
import java.io.PrintWriter;

public class MainScript {

	public static void main(String[] args) throws Exception{ //Whatever lol
		CellularAutomatonRule r = new GameOfLife();
		
		//Get relevant inputs
		System.out.println("Possible initial states: BLINKER, GLIDER, R-PENTOMINO, GLIDER-GUN, INFINITE-GROWTH");
		System.out.print("Chose an initial state: ");
		Scanner sc = new Scanner(System.in);
		String initialState = sc.next();
		System.out.print("How many time-steps to plot: ");
		int amtSteps = sc.nextInt();
		System.out.print("Enter filename to print population data into: ");
		String fileName = sc.next();
		sc.close();
		
		//Successively generate each time step and print its population into chosen file
		PrintWriter filePrint = new PrintWriter(fileName);
		AutomatonState T = AutomatonState.initiateStartingPattern(initialState);
		filePrint.println("0 " + T.getAmountLivingCells());
		for(int count = 0; count < amtSteps; count++, r.transferState(T), filePrint.println(count + " " + T.getAmountLivingCells()));
		T.print();
		r.transferState(T);
		T.print();
		filePrint.close();
	}
}