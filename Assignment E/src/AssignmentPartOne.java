//Fitness goal: Maximize path length.
//Only one parent, genome is cloned with a random amount of swaps as permutation
public class AssignmentPartOne extends EvoTSPDoubleVisit{

	public AssignmentPartOne(GeomSpace G, int popSize, int amtOffspring) {
		super(G, popSize, amtOffspring);
	}
	
	//Returns a copied instance
	@Override
	protected TSPDoubleVisitTour generateOffspring(int parentA, int parentB) {
		TSPDoubleVisitTour result = new TSPDoubleVisitTour(this.population[parentA]);
		return result;
	}

	
	//Do random swaps of stops. Amount of swaps determined by geometric distribution
	@Override
	protected void doMutation(int pos) {
		//Guarantee at least one swap
		int i = 0;
		while(i < 7) {
			this.population[pos].swap(r.nextInt(2*groundSpace.getSize()), r.nextInt(2*groundSpace.getSize()));
			i = r.nextInt(10);
		}
	}

	@Override
	public double getFitness(TSPDoubleVisitTour T) {
		return T.getTourLength(this.groundSpace);
	}
	
}
