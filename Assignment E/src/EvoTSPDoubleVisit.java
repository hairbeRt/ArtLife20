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
	protected int cutoff;
	protected Random r;
	
	public abstract double getFitness(TSPDoubleVisitTour T);
	
	//Constructor initializes random population
	public EvoTSPDoubleVisit(GeomSpace G, int populationSize, int cutoff) {
		this.groundSpace = G;
		this.populationSize = populationSize;
		this.cutoff = cutoff;
		this.r = new Random();
		
		this.population = new TSPDoubleVisitTour[this.populationSize];
		for(int i = 0; i < this.populationSize; i++) {
			population[i] = new TSPDoubleVisitTour(G.getSize(), true);
		}
	}
	
	//Sorts the population by fitness
	protected void sortByFitness() {
		Arrays.sort(this.population, Comparator.comparingDouble(this::getFitness));
	}
	
	//We decided to allow up to two parents
	protected abstract TSPDoubleVisitTour generateOffspring(int parentA, int parentB);
	protected abstract void doMutation(int pos);
	
	public void doEvoStep() {
		int A,B;
		this.sortByFitness();
		for(int i = 0; i < cutoff; i++) {
			//It is explicitly allowed to have one parent (A==B)
			A = cutoff+r.nextInt(this.populationSize-cutoff);
			B = cutoff+r.nextInt(this.populationSize-cutoff);
			this.population[i] = this.generateOffspring(A, B);
			this.doMutation(i);
		}
	}
	
	public double getBestFitness() {
		this.sortByFitness();
		return getFitness(this.population[this.populationSize-1]);
	}
	
}