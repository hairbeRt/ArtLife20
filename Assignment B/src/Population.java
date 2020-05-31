/**
 * 
 * @author Jonas
 *
 */
public class Population {
	
	private double currentPredators;
	private double currentPrey;
	
	//Population transition parameters
	private double a,b,c,d,e,f,g,h;

	//Constructor and getters/setters
	public Population(double a, double b, double c, double d, double e, double f, double g, double h) {
		super();
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
		this.e = e;
		this.f = f;
		this.g = g;
		this.h = h;
	}

	public double getCurrentPredators() {
		return currentPredators;
	}

	public void setCurrentPredators(double currentPredators) {
		this.currentPredators = currentPredators;
	}

	public double getCurrentPrey() {
		return currentPrey;
	}

	public void setCurrentPrey(double currentPrey) {
		this.currentPrey = currentPrey;
	}

	public double getA() {
		return a;
	}

	public void setA(double a) {
		this.a = a;
	}

	public double getB() {
		return b;
	}

	public void setB(double b) {
		this.b = b;
	}

	public double getC() {
		return c;
	}

	public void setC(double c) {
		this.c = c;
	}

	public double getD() {
		return d;
	}

	public void setD(double d) {
		this.d = d;
	}

	public double getE() {
		return e;
	}

	public void setE(double e) {
		this.e = e;
	}

	public double getF() {
		return f;
	}

	public void setF(double f) {
		this.f = f;
	}

	public double getG() {
		return g;
	}

	public void setG(double g) {
		this.g = g;
	}

	public double getH() {
		return h;
	}

	public void setH(double h) {
		this.h = h;
	}
	/*
	 * Interesting stuff begins here!
	 * --------------------------------------
	 */
	
	/**
	 * Returns the current population as a string (predators first, prey second, seperated by space).
	 */
	public String toString() {
		return this.currentPredators + " " + this.currentPrey;
		
	}
	
	/**
	 * Does one transition of the predator-prey relationship
	 * to the given parameters and current populations.
	 */
	public void doTransitionStep() {
		double oldPredators = this.currentPredators, oldPrey = this.currentPrey;
		this.currentPredators = 
				oldPredators + 
				a*oldPredators + 
				b*oldPrey + 
				e*oldPredators*oldPredators +
				g*oldPredators*oldPrey;
		this.currentPrey =
				oldPrey +
				c*oldPredators +
				d*oldPrey +
				f*oldPrey*oldPrey +
				h*oldPredators*oldPrey;
	}
}