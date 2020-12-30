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
                maze[i][j] = new Cell();
            }
        }
    }

    public Cell[][] generate() {
        getStartCell();

        return maze;
    }

    private void getStartCell() {
        Random randGen = new Random();
        int randRow = randGen.nextInt(maze.length);

        Cell start = maze[randRow][0];
        start.makeStart();
        start.markVisited();
    }

    public Cell[][] getMaze() {
        return maze;
    }
}
