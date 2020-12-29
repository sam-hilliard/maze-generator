/**
 * Holds information of each individual cell or pixel
 * of a generated maze necessary for the operation of
 * both the Depth-First-Search and Breadth-First-Search
 * implementations to generate and solve the maze respectively.
 *
 * @author Sam Hilliard
 * @version 0.0
 */
public class Cell {

    private boolean visited;
    private boolean walls[];  // top, right, bottom, left

    public Cell() {
        visited = false;
        walls = new boolean[] {true, true, true, true};
    }

    public boolean hasWall(int wallPos) {
        return walls[wallPos];
    }

    public boolean isVisited() {
        return visited;
    }

    public void markVisited() {
        visited = true;
    }
}
