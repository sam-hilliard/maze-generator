import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

/**
 * Implements the Depth-First-Search Algorithm to
 * generate a maze of specified height and width.
 * Used in conjunction with the App class to graphically
 * display generated mazes to the user.
 *
 * @author Sam Hilliard
 * @version 0.0
 */
public class MazeGen {

    private Cell[][] maze;

    public MazeGen(int height, int width) {
        maze = new Cell[height][width];

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                maze[i][j] = new Cell(i, j);
            }
        }
    }

    /**
     * Responsible for generating a maze using depth first search.
     * @return Cell[][]  a randomly generated maze represented by Cell objects
     */
    // TODO: finish implementation
    public Cell[][] generate() {
        LinkedList<Cell>  visited = new LinkedList<>();

        while(true) {
            Cell curCell = getRandomCell(true);
            Cell adjCell = getAdjacent(curCell);

            break;
        }

        return maze;
    }

    /**
     * Returns a random cell adjacent to the current cell (either left, right, up, or down from
     * the current cell) to be joined by a path in the maze generation process.
     * @param cell  the current cell
     * @return Cell  the random adjacent cell
     */
    private Cell getAdjacent(Cell cell) {
        Random randGen = new Random();
        ArrayList<Cell> neighbors = getNeighbors(cell);
        int randIndex = randGen.nextInt(neighbors.size());

        return neighbors.get(randIndex);
    }

    /**
     * Returns all possible neighbors of a cell that aren't visited and are within
     * the bounds of the maze. This list is then used as a basis for choosing a random
     * adjacent cell.
     * @param cell  the cell to find the neighbors of
     * @return ArrayList<Cell>  the list of possible neighbors
     */
    private ArrayList<Cell> getNeighbors(Cell cell) {
        ArrayList<Cell> neighbors = new ArrayList<>();

        // traverses each direction up(0), left(1), down(2), right(3)
        for (int i = 0; i < 4; i++) {
            int row = cell.row;
            int col = cell.col;

            switch (i) {
                case 0:
                    row++;
                case 1:
                    col++;
                case 2:
                    row--;
                case 3:
                    col--;
            }

            // neighbor is only considered if it is within the bounds of the maze and
            // is not visited
            if (row > 0 && row < maze.length) {
                if (col > 0 && col < maze[row].length) {
                    Cell adjacent = maze[row][col];

                    if (!adjacent.isVisited()) {
                        neighbors.add(adjacent);
                    }
                }
            }
        }

        return neighbors;
    }

    /**
     * Randomly selects a cell within the maze.
     * @return Cell  the randomly selected cell
     */
    private Cell getRandomCell(boolean isStart) {
        Random randGen = new Random();
        int randRow = randGen.nextInt(maze.length);
        int randColumn = isStart ? 0 : randGen.nextInt(maze[randRow].length);

        return maze[randRow][randColumn];
    }

    /**
     * Getter for maze object.
     * @return Cell[][]  the maze in its current state
     */
    // TODO: make sure this is actually needed
    public Cell[][] getMaze() {
        return maze;
    }
}
