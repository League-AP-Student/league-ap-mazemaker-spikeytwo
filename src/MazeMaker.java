import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;


public class MazeMaker{
	
	private static int width;
	private static int height;
	
	private static Maze maze;
	
	private static Random randGen = new Random();
	private static Stack<Cell> uncheckedCells = new Stack<Cell>();
	
	
	public static Maze generateMaze(int w, int h){
		Cell randomCell;
		width = w;
		height = h;
		maze = new Maze(width, height);
		
		//select a random cell to start
		Random random= new Random();
		int randomW = random.nextInt(w);
		int randomH = random.nextInt(h);
		randomCell = maze.getCell(randomW , randomH );
		//call selectNextPath method with the randomly selected cell
		selectNextPath(randomCell);
		return maze;
	}

	private static void selectNextPath(Cell currentCell) {
		Cell rightCell;
		Cell leftCell;
		Cell downCell;
		Cell upCell;
		Random random = new Random();
		ArrayList<Cell> unvisitedCells = new ArrayList<Cell>();
		ArrayList<Cell> neighborCells = new ArrayList<Cell>();
		Cell unvisitedCell;
		// mark current cell as visited
currentCell.setBeenVisited( true);
		// check for unvisited neighbors
if(currentCell.getX()<maze.getWidth()-1) {
	rightCell = maze.getCell(currentCell.getX()+1, currentCell.getY());
	neighborCells.add(rightCell);
}
if(currentCell.getX()>0) {
	leftCell = maze.getCell(currentCell.getX()-1, currentCell.getY());
	neighborCells.add(leftCell);
}
if(currentCell.getY()>0) {
	upCell = maze.getCell(currentCell.getX(), currentCell.getY()-1);
	neighborCells.add(upCell);
}
if(currentCell.getY()<maze.getHeight()-1) {
	downCell = maze.getCell(currentCell.getX(), currentCell.getY()+1);
	neighborCells.add(downCell);
}
		for(Cell neighbor:neighborCells) {
			if(!neighbor.hasBeenVisited())
			unvisitedCells.add(neighbor); 
		}
		
		// if has unvisited neighbors,
		if(unvisitedCells.size()>0) {
			unvisitedCell = unvisitedCells.get(random.nextInt(unvisitedCells.size()));
			uncheckedCells.push(unvisitedCell);
			if(unvisitedCell.getX()>currentCell.getX()) {
				currentCell.setEastWall(false);
				unvisitedCell.setWestWall(false);
			}
			else if(unvisitedCell.getY()>currentCell.getY()) {
				currentCell.setSouthWall(false);
				unvisitedCell.setNorthWall(false);
			}
			else if(unvisitedCell.getX()<currentCell.getX()) {
				currentCell.setWestWall(false);
				unvisitedCell.setEastWall(false);
			}
			else{
				currentCell.setNorthWall(false);
				unvisitedCell.setSouthWall(false);
			}
				currentCell=unvisitedCell;
				currentCell.setBeenVisited(true);
				selectNextPath(currentCell);
			
		}if(!unvisitedCells.isEmpty()) {
			currentCell = uncheckedCells.pop();
			selectNextPath(currentCell);
		}
		
			// select one at random.
			// push it to the stack
			// remove the wall between the two cells
			// make the new cell the current cell and mark it as visited
		
			//call the selectNextPath method with the current cell
			
		// if all neighbors are visited
			//if the stack is not empty
				// pop a cell from the stack
				// make that the current cell
		
				//call the selectNextPath method with the current cell
	}

	private static void removeWalls(Cell c1, Cell c2) {
		
	}

	private static ArrayList<Cell> getUnvisitedNeighbors(Cell c) {
		return null;
	}
}