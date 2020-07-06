/*
 * Abstract car behavior.
 * Implement generateMove in the following way:
 * Read the neighborhood from G, save the car's behavior for the next step in doesMove and orientationChange.
 * Orientation according to rules specified in GridState
 */
public abstract class GridCar {
	protected boolean doesMove = false;
	protected int orientationChange = 0;
	
	public boolean doesMove() {
		return doesMove;
	}
	
	public int getOrientationChange() {
		return orientationChange;
	}

	public abstract void generateMove(GridState G);
}
