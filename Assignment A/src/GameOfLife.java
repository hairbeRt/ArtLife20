
public class GameOfLife implements CellularAutomatonRule {
	private int width = 101;
	private int height = 82;
	private boolean[][] tempgrid;
	private boolean[] neighbors;
	
	public GameOfLife(){
		tempgrid = new boolean[width][height];
		neighbors = new boolean[8];
	}
	
	private void generateRelativeNeighbors(AutomatonState state, int posw, int posh) {//What else other than hardcoding?
		neighbors[0] = state.getCellRelative(posw, posh, -1, -1);
		neighbors[1] = state.getCellRelative(posw, posh, -1, 0);
		neighbors[2] = state.getCellRelative(posw, posh, -1, 1);
		neighbors[3] = state.getCellRelative(posw, posh, 0, -1);
		neighbors[4] = state.getCellRelative(posw, posh, 0, 1);
		neighbors[5] = state.getCellRelative(posw, posh, 1, -1);
		neighbors[6] = state.getCellRelative(posw, posh, 1, 0);
		neighbors[7] = state.getCellRelative(posw, posh, 1, 1);
	}
	
	private int getAmountLivingNeighbors() {//Neighbors have to be generated beforehand
		int result = 0;
		for(boolean cell : neighbors) {
			if(cell) result++;
		}
		return result;
	}
	
	public void transferState(AutomatonState state) {
		int aliveNeighbors;
		//Initialize tempgrid consisting of dead cells
		for(int posw = 0; posw < width; posw++) {
			for(int posh = 0; posh < height; posh++) {
				tempgrid[posw][posh] = false;
			}
		}		
		//Iterate over all positions and see, which cells live according to rules of game of life
		for(int posw = 0; posw < width; posw++) {
			for(int posh = 0; posh < height; posh++) {
				generateRelativeNeighbors(state, posw, posh);
				aliveNeighbors = getAmountLivingNeighbors();
				
				if(state.getCell(posw, posh)) {//Behavior for alive cell: Alive iff amount of living neighbors is 2 or 3
					if(aliveNeighbors == 2 || aliveNeighbors == 3) tempgrid[posw][posh] = true;
				} else {//Behavior for dead cell: Alive iff amount of living neighbors is exactly 3
					if(aliveNeighbors == 3) tempgrid[posw][posh] = true;
				}
			}
		}
		
		//Update the grid of the state
		for(int posw = 0; posw < width; posw++) {
			for(int posh = 0; posh < height; posh++) {
				state.setCell(posw, posh, tempgrid[posw][posh]);
			}
		}
	}

}
