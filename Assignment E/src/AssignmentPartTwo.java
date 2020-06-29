//Implements part two of the assignment
//Fitness function = 1/pathLength, because shorter pathlength should be better fitness
//Recombination step: Clone of one parent
//Mutation: Geometrically distributed amount of 3-cycles with random orientation

public class AssignmentPartTwo extends EvoTSPDoubleVisit {

	public AssignmentPartTwo(GeomSpace G, int popSize, int amtOffspring) {
		super(G, popSize, amtOffspring);
		for(TSPDoubleVisitTour T : this.population) {
			T.eliminateTrivialStops();
		}
	}
	
	@Override
	public double getFitness(TSPDoubleVisitTour T) {
		return -T.getTourLength(groundSpace);
	}

	@Override
	protected TSPDoubleVisitTour generateOffspring(int parentA, int parentB) {
		return new TSPDoubleVisitTour(population[parentA]);
	}

	@Override
	protected void doMutation(int pos) {
		int i = 0,index = 0;
		boolean orientation;
		
		while(i < 7) {
			i = r.nextInt(10);
			orientation = (r.nextInt(2)==0);
			index = r.nextInt(2*groundSpace.getSize());
			this.doThreeCycle(pos, index, orientation);
		}
		
	}

	//Cycles through three neighboring indices using swaps
	private void doThreeCycle(int individual, int start, boolean orientation) {
		if(orientation) {
			this.population[individual].swap(start, (start+2)%(2*groundSpace.getSize()));
			this.population[individual].swap((start+1)%(2*groundSpace.getSize()),(start+2)%(2*groundSpace.getSize()));
		} else {
			this.population[individual].swap((start+1)%(2*groundSpace.getSize()),(start+2)%(2*groundSpace.getSize()));
			this.population[individual].swap(start, (start+2)%(2*groundSpace.getSize()));
		}
		this.population[individual].eliminateTrivialStops();
	}
}
