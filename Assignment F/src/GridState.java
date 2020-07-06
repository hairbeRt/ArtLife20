
public class GridState {
	private boolean[][] grid; //x first, y second. False = free, True = wall
	
	//Car position
	private int carX;
	private int carY;
	private int carOrientation;
	/*
	 * Definition of carOrientation: Car is C
	 * 
	 * 7 0 1
	 * 6 C 2
	 * 5 4 3
	 */
	
	public GridState(int carStartX, int carStartY, int carStartOrientation) {
		this.grid = new boolean[50][50]; //Initialised as false i.e. free
		this.carX = carStartX;
		this.carY = carStartY;
		this.carOrientation = carStartOrientation;
	}
	
	public int getCarX() {
		return carX;
	}



	public int getCarY() {
		return carY;
	}



	public int getCarOrientation() {
		return carOrientation;
	}



	public void setWalls(int[] xArr, int[] yArr) {
		if(xArr.length != yArr.length) return;
		
		int l = xArr.length;
		for(int i = 0; i < l; i++) {
			this.grid[xArr[i]][yArr[i]] = true;
		}
	}
	
	public boolean[] getNeighborhood() {
		//Get neighborhood with correct orientation (if orientation is 2 (right), result[0] is the block absolutely right of the car.
		boolean[] result = new boolean[8];
		result[0] = grid[carX][carY+1];
		result[1] = grid[carX+1][carY+1];
		result[2] = grid[carX+1][carY];
		result[3] = grid[carX+1][carY-1];
		result[4] = grid[carX][carY-1];
		result[5] = grid[carX-1][carY-1];
		result[6] = grid[carX-1][carY];
		result[7] = grid[carX-1][carY+1];
		
		boolean[] temp = result.clone(); //Copy
		for(int i = 0; i < 8; i++) {
			result[i] = temp[(i+this.carOrientation) % 8];
		}
		
		return result;
	}
	
	//Moves the car one step according to the car's (abstract neighborhood rules)
	public void doStep(GridCar C) {//First change orientation, then move or don't
		C.generateMove(this);
		
		boolean doesMove = C.doesMove();
		int orientationChange = C.getOrientationChange();
		this.carOrientation = (this.carOrientation + orientationChange) % 8;
		
		//Changes in coordinate depending on direction
		int[] xChange = {0,1,1,1,0,-1,-1,-1};
		int[] yChange = {1,1,0,-1,-1,-1,0,1};
		
		if(doesMove) {
			this.carX += xChange[this.carOrientation];
			this.carY += yChange[this.carOrientation];
		}
		
	}
}
