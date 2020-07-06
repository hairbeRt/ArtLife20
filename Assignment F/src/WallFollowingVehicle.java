//Follows a wall at the right side of the wall
public class WallFollowingVehicle extends GridCar{
	
	public void generateMove(GridState G) {
		/*Behavior: Find the leftmost left neighboring block or the block infront (i.e. 5,6,7 or 0) that is wall.
		 * If found, then move to leftmost free block right of said block.
		 * If blocks 5,6,7 are occupied and 0 is free, move forward. Else move to leftmost free block right of 0.
		 * If none of the conditions apply, all eight neighboring blocks are walls and the vehicle halts.
		 */
		doesMove = false;
		orientationChange = 0;
		boolean[] neighborhood = G.getNeighborhood();
		if(neighborhood[5]) {
			for(int i = 1; i < 8; i++) {
				if(!neighborhood[(5+i)%8]) {
					doesMove = true;
					orientationChange = (5+i)%8;
					return;
				}
			}
		}
		if(neighborhood[6]) {
			for(int i = 1; i < 8; i++) {
				if(!neighborhood[(6+i)%8]) {
					doesMove = true;
					orientationChange = (6+i)%8;
					return;
				}
			}
		}
		if(neighborhood[7]) {
			for(int i = 1; i < 8; i++) {
				if(!neighborhood[(7+i)%8]) {
					doesMove = true;
					orientationChange = (7+i)%8;
					return;
				}
			}
		}
		if(neighborhood[0]) {
			for(int i = 1; i < 8; i++) {
				if(!neighborhood[i]) {
					doesMove = true;
					orientationChange = i;
					return;
				}
			}
		} else {
			doesMove = true;
			orientationChange = 0;
		}
		
	}
}
