
public class AutomatonState {
	private int width = 101; //For this implementation fixed values are given
	private int height = 82;
	private boolean[][] grid; //Models the grid into living and dead cells
	
	public AutomatonState(){
		grid = new boolean[width][height]; //All initialized to false
	}
	
	public void setCell(int posw, int posh, boolean val) {//Absolute grid position
		grid[posw][posh] = val;
	}
	
	public boolean getCell(int posw, int posh) {//Absolute grid position
		return grid[posw][posh];
	}
	
	//The hacky double modulus is because Java returns negative values with a%n for values of a between -1 and -n+1
	public void setCellRelative(int posw, int posh, int offsetw, int offseth, boolean val) { //Relative position in torus topology
		grid[((posw+offsetw)%width + width)%width][((posh+offseth)%height + height)%height] = val;
	}
	
	public boolean getCellRelative(int posw, int posh, int offsetw, int offseth) {//Relative position in torus topology
		return grid[((posw+offsetw)%width + width)%width][((posh+offseth)%height + height)%height];
	}
	
	public int getAmountLivingCells() {
		int result = 0;
		for(boolean[] column : grid) {
			for(boolean cell : column) {
				if(cell) result++;
			}
		}
		return result;
	}
	
	public int getAmountDeadCells() {
		return width*height - this.getAmountLivingCells();
	}
	
	//Some nontrivial starting states to go for
	public static AutomatonState initiateStartingPattern(String keyword) {//Generates some known starting patterns based on keywords. Returns an empty grid if no keyword match
		AutomatonState result = new AutomatonState();
		if(keyword.equals("BLINKER")) {
			result.setCell(5, 5, true);
			result.setCell(5, 6, true);
			result.setCell(5, 7, true);
		}
		if(keyword.equals("GLIDER")) {
			result.setCell(10, 10, true);
			result.setCell(10, 11, true);
			result.setCell(10, 12, true);
			result.setCell(9, 10, true);
			result.setCell(8, 11, true);
		}
		if(keyword.equals("R-PENTOMINO")) {
			result.setCell(10, 10, true);
			result.setCell(10, 11, true);
			result.setCell(10, 12, true);
			result.setCell(9, 10, true);
			result.setCell(11, 11, true);
		}
		if(keyword.equals("GLIDER-GUN")) {
			//Collision boxes
			result.setCell(11, 14, true);
			result.setCell(11, 15, true);
			result.setCell(12, 14, true);
			result.setCell(12, 15, true);
			
			result.setCell(45, 16, true);
			result.setCell(45, 17, true);
			result.setCell(46, 16, true);
			result.setCell(46, 17, true);
			
			//Left collider
			result.setCell(21, 13, true);
			result.setCell(21, 14, true);
			result.setCell(21, 15, true);
			
			result.setCell(22, 12, true);
			result.setCell(22, 16, true);
			
			result.setCell(23, 11, true);
			result.setCell(23, 17, true);
			
			result.setCell(24, 11, true);
			result.setCell(24, 17, true);
			
			result.setCell(25, 14, true);
			
			result.setCell(26, 12, true);
			result.setCell(26, 16, true);
			
			result.setCell(27, 13, true);
			result.setCell(27, 14, true);
			result.setCell(27, 15, true);
			
			result.setCell(28, 14, true);
			
			//Right collider
			result.setCell(31, 15, true);
			result.setCell(31, 16, true);
			result.setCell(31, 17, true);
			
			result.setCell(32, 15, true);
			result.setCell(32, 16, true);
			result.setCell(32, 17, true);
			
			result.setCell(33, 14, true);
			result.setCell(33, 18, true);
			
			result.setCell(35, 13, true);
			result.setCell(35, 14, true);
			result.setCell(35, 18, true);
			result.setCell(35, 19, true);
		}
		if(keyword.equals("INFINITE-GROWTH")) {
			result.setCell(10, 10, true);
			result.setCell(11, 10, true);
			result.setCell(12, 10, true);
			result.setCell(14, 10, true);
			result.setCell(10, 11, true);
			result.setCell(13, 12, true);
			result.setCell(14, 12, true);
			result.setCell(11, 13, true);
			result.setCell(12, 13, true);
			result.setCell(14, 13, true);
			result.setCell(10, 14, true);
			result.setCell(12, 14, true);
			result.setCell(14, 14, true);
		}
		
		
		return result;
	}
	
	public void print() {
		for(int posh = 0; posh < height; posh++) {
			for(int posw = 0; posw < width; posw++) {
				System.out.print((grid[posw][posh]?"+":"-"));
			}
			System.out.println("");
		}
	}
}