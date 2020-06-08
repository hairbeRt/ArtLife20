import java.util.HashSet;
import java.util.HashMap;
import java.lang.StringBuffer;

public class LindenmayerSystem {
	private HashSet<Character> constants;
	private HashSet<Character> variables;
	private String axiom;
	private HashMap<Character,String> productionRules;
	
	public LindenmayerSystem() {
		constants = new HashSet<Character>();
		variables = new HashSet<Character>();
		productionRules = new HashMap<Character,String>();
		axiom = "";
	}
	
	//Guarantee disjointness of C and V while building the sets
	public void addConstant(char c) {
		if(!constants.contains(c) && !variables.contains(c)) {
			constants.add(c);
		}
	}
	
	public void addVariable(char c) {
		if(!constants.contains(c) && !variables.contains(c)) {
			variables.add(c);
		}
	}
	
	public void setAxiom(String s) {
		//Actually gets copied because of immutability, so no worries
		axiom = s;
	}
	
	public void addProductionRule(char in, String out) {
		//Guarantee that out only consists of variables and constants
		char c;
		for(int i = 0; i < out.length(); i++) {
			c = out.charAt(i);
			if(!variables.contains(c) && !constants.contains(c)) return;
		}
		//Guarantee that in is a variable and that there is only one rule per variable
		if(variables.contains(in) && !productionRules.containsKey(in)) {
			productionRules.put(in, out);
		}
	}
	
	public String[] produceWords(int amtSteps) {
		//Successively generate each step, output them all as array (result[i] is word after i-th replacement step)
		String[] result = new String[amtSteps+1];
		result[0] = axiom;
		StringBuffer wordBuffer = new StringBuffer();
		char c;
		
		for(int step = 0; step < amtSteps; step++) {
			//Clear buffer
			wordBuffer.setLength(0);
			//Build the next word character for character
			for(int i = 0; i < result[step].length(); i++) {
				c = result[step].charAt(i);
				if(productionRules.containsKey(c)) {
					//If there is a rule for c, replace c with the string associated with it
					wordBuffer.append(productionRules.get(c));
				} else {
					//If there is no rule for c, do not change
					wordBuffer.append(c);
				}
			}
			result[step+1] = wordBuffer.toString();
		}
		
		return result;
	}
	
	//Some example-systems, if no keyword-match, returns an empty system
	public static LindenmayerSystem example(String key) {
		LindenmayerSystem result = new LindenmayerSystem();
		
		//Generate fibonacci sequence as length of string
		if(key.equals("PARENT_CHILD_POPULATION")) {
			result.addVariable('C');
			result.addVariable('A');
			result.setAxiom("C");
			result.addProductionRule('C', "A");
			result.addProductionRule('A', "CA");
		}
		
		//Koch snowflake
		if(key.equals("KOCH_SNOWFLAKE")) {
			result.addVariable('F');
			result.addConstant('+');
			result.addConstant('-');
			result.setAxiom("F--F--F");
			result.addProductionRule('F', "F+F--F+F");
		}
		
		//Dragon curve
		if(key.equals("DRAGON_CURVE")) {
			result.addVariable('A');
			result.addVariable('B');
			result.addConstant('+');
			result.addConstant('-');
			result.addConstant('F');
			result.setAxiom("FA");
			result.addProductionRule('A', "A+BF+");
			result.addProductionRule('B', "-FA-B");
		}
		
		//Cantor set
		if(key.equals("CANTOR_DUST")) {
			result.addVariable('A');
			result.addVariable('B');
			result.setAxiom("A");
			result.addProductionRule('A', "ABA");
			result.addProductionRule('B', "BBB");
		}
		
		return result;
	}
}
