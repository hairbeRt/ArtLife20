
//Implements a fixed finite subspace of R^2 with euclidean metric, all points having integer coordinates
public class GeomSpace {
	private final int size;
	private final int[][] coords;
	private final double[][] distanceMatrix;
	
	public GeomSpace(int size, int[][] coords) {
		double dist;
		
		this.size = size;
		this.coords = new int[size][2];
		
		for(int i = 0; i < size; i++) {
			this.coords[i][0] = coords[i][0];
			this.coords[i][1] = coords[i][1];
		}
		
		this.distanceMatrix = new double[size][size];
		for(int i = 0; i < size; i++) {
			this.distanceMatrix[i][i] = 0;
			for(int j = 0; j < i; j++) {
				dist = this.calculateDistance(i,j);
				this.distanceMatrix[i][j] = dist;
				this.distanceMatrix[j][i] = dist;
			}
		}
	}
	
	public int getSize() {
		return size;
	}
	
	public String getCoords(int id) {
		return "(" + this.coords[id][0] + "," + this.coords[id][1] + ")";
	}
	
	public int getX(int id) {
		return this.coords[id][0];
	}
	
	public int getY(int id) {
		return this.coords[id][1];
	}
	
	//Only to be used in the constructor to compute distance matrix
	private double calculateDistance(int idA, int idB) {
		int distX = this.coords[idA][0]-this.coords[idB][0];
		int distY = this.coords[idA][1]-this.coords[idB][1];
		return Math.sqrt((distX*distX) + (distY*distY));
	}
	
	//Query distance matrix
	public double getDistance(int idA, int idB) {
		return this.distanceMatrix[idA][idB];
	}
}
