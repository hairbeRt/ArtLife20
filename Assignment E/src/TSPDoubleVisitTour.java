import java.util.Random;

public class TSPDoubleVisitTour {
	private final int size;
	private int[] tourstops;
	
	//Initializes based on a random tour
	public TSPDoubleVisitTour(int size, boolean initialize) {
		this.size = size;
		this.tourstops = new int[2*size];
		
		//If initialize flag is set, generate a random tour. Else continue with an allocated but uninitialized array
		if(initialize) {	
			for(int i = 0; i < size; i++) {
				this.tourstops[2*i] = i;
				this.tourstops[2*i + 1] = i;
			}
			
			//Linear array shuffle
			Random r = new Random();
			for(int i = 0; i < 2*size; i++) {
				this.swap(i, i+r.nextInt(2*size - i));
			}
		}
	}
	
	//Deep copy
	public TSPDoubleVisitTour(TSPDoubleVisitTour T) {
		this.size = T.size;
		this.tourstops = new int[2*this.size];
		for(int i = 0; i < 2*this.size; i++) {
			this.tourstops[i] = T.tourstops[i];
		}
	}
	
	//Programmer must guarantee that resulting tour is still a Double-visit-tour!
	public void setStop(int pos, int val) {
		this.tourstops[pos] = val;
	}
	
	public void swap(int i, int j) {
		int temp = this.tourstops[j];
		this.tourstops[j] = this.tourstops[i];
		this.tourstops[i] = temp;
	}
	
	public int getSize() {
		return this.size;
	}
	
	public double getTourLength(GeomSpace G) {
		//Add up all point-distances of route taken. Don't forget last distance, because we implement a cycle
		double result = 0;
		for(int i = 0; i+1 < 2*size; i++) {
			result += G.getDistance(this.tourstops[i], this.tourstops[i+1]);
		}
		result += G.getDistance(this.tourstops[0], this.tourstops[(2*size) - 1]);
		
		return result;
	}
	
	public void eliminateTrivialStops() {
		//Needed for second EA. Eliminate stopping twice at the same city by swapping with a neighboring element
		//This is part of the inheritance/recombination steps
		
		for(int i = 0; i+1 < 2*size; i++) {
			if(this.tourstops[i] == this.tourstops[i+1]) {
				if(i == 2*size - 2) {
					//Cannot swap with next element because it is the last pair.
					this.swap(i, i-1);
				} else {
					this.swap(i, i+2);
				}
			}
		}
	}
}
