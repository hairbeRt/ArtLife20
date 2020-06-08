import java.util.Scanner;

public class MainScript {

	public static void main(String[] args) {
		Scanner consoleIn = new Scanner(System.in);
		System.out.print("Choose example (\"EXAMPLE\") or define your own L-System (\"CUSTOM\"): ");
		String choice = consoleIn.next();
		if(choice.equals("EXAMPLE")) {
			runExampleSystem(consoleIn);
		}
		if(choice.equals("CUSTOM")) {
			runCustomSystem(consoleIn);
		}
		consoleIn.close();
	}
	
	public static void runExampleSystem(Scanner in) {
		//Run one of the examples from LindenmayerSystem.example()
		System.out.print("Choose an L-System between PARENT_CHILD_POPULATION, KOCH_SNOWFLAKE, DRAGON_CURVE, CANTOR_DUST: ");
		LindenmayerSystem exampleSystem = LindenmayerSystem.example(in.next());
		System.out.print("Amount of steps to print: ");
		int amtSteps = in.nextInt();
		String[] producedWords = exampleSystem.produceWords(amtSteps);
		for(int i = 0; i <= amtSteps; i++) {
			System.out.println(producedWords[i]);
		}
	}
	
	public static void runCustomSystem(Scanner in) {
		//Ask for all components explicitly and run
		LindenmayerSystem L = new LindenmayerSystem();
		char c;
		String s;
		System.out.print("Define variable symbols (except \";\"), separated by space, finish with \";\" (for example: A B ;): ");
		while((c=in.next().charAt(0)) != ';') {
			L.addVariable(c);
		}
		System.out.print("Define constant symbols (except \";\"), separated by space, finish with \";\" (for example: C D ;): ");
		while((c=in.next().charAt(0)) != ';') {
			L.addConstant(c);
		}
		System.out.print("Set the axiom string: ");
		L.setAxiom(in.next());
		System.out.print("Add production rules (format: F->T), separated by space, finish with \";\" (for example: A->AB B->BB ;): ");
		while(!(s=in.next()).equals(";")) {
			L.addProductionRule(s.charAt(0), s.substring(3));
		}
		System.out.print("Enter amount of time steps to print: ");
		int amtSteps = in.nextInt();
		String[] producedWords = L.produceWords(amtSteps);
		for(int i = 0; i <= amtSteps; i++) {
			System.out.println(producedWords[i]);
		}
	}

}
