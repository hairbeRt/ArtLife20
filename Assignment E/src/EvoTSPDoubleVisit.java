import java.util.Arrays;
import java.util.Random;
import java.util.Comparator;

//Implements abstractly an evolutionary algorithm of Type "(Lambda+Mu)"
//Will always try to maximize fitness! Be sure to modify fitness function accordingly

/*
 * Details of this framework:
 * -Fitness evaluation: Done by an unspecified F
 * -External selection: Elitist with cutoff
 * -Parent selection: Random (equally distributed) among all parents
 * -Inheritance and mutation: Unspecified
 */
public abstract class EvoTSPDoubleVisit {
	protected final int populationSize;
	protected TSPDoubleVisitTour[] population;
	protected GeomSpace groundSpace;
	protected int amtOffspring;
	protected Random r;
	
	public abstract double getFitness(TSPDoubleVisitTour T);
	
	//Constructor initializes random population
	public EvoTSPDoubleVisit(GeomSpace G, int populationSize, int amtOffspring) {
		this.groundSpace = G;
		this.populationSize = populationSize;
		this.amtOffspring = amtOffspring;
		this.r = new Random();
		
		this.population = new TSPDoubleVisitTour[this.populationSize];
		for(int i = 0; i < this.populationSize; i++) {
			population[i] = new TSPDoubleVisitTour(G.getSize(), true);
		}
		this.sortByFitness();
	}
	
	//Sorts the population by fitness
	//Worse individuals first, best individuals last
	//population[0] = worst individial; population[populationSize-1] = best individual, population[amtOffspring] = worst parent
	protected void sortByFitness() {
		Arrays.sort(this.population, Comparator.comparingDouble(this::getFitness));
	}
	
	//We decided to allow up to two parents
	protected abstract TSPDoubleVisitTour generateOffspring(int parentA, int parentB);
	protected abstract void doMutation(int pos);
	
	public void doEvoStep() {
		int A,B;
		for(int i = 0; i < amtOffspring; i++) {
			//It is explicitly allowed to have one parent (A==B)
			A = amtOffspring+r.nextInt(this.populationSize-amtOffspring);
			B = amtOffspring+r.nextInt(this.populationSize-amtOffspring);
			this.population[i] = this.generateOffspring(A, B);
			this.doMutation(i);
		}
		this.sortByFitness();
	}
	
	public double getBestFitness() {
		return getFitness(this.population[this.populationSize-1]);
	}
	
	public double getMeanParentFitness() {
		double result = 0;
		for(int i = amtOffspring; i < this.populationSize; i++) {
			result += this.getFitness(this.population[i]);
		}
		
		return result/(populationSize-amtOffspring);
	}
	
	public double getWorstParentFitness() {
		return getFitness(this.population[amtOffspring]);
	}
	
}
