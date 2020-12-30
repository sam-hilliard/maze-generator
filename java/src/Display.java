import java.awt.*;

/**
 * An extension of the java.awt.Canvas class
 * to be used to display the maze to the user.
 *
 * @author Sam Hilliard
 * @version 0.0
 */

public class Display extends Canvas {

    private Cell[][] maze;

    public Display() {
        setBackground(Color.LIGHT_GRAY);
        setSize(1101, 716);
        maze = new Cell[0][0];
    }

    /**
     * Draws a grid of squares to the Display as a graphical
     * representation of the maze.
     * @param g  the graphics object that draws components to
     *           the Display
     */
    @Override
    public void paint(Graphics g) {

        // padding for the maze
        final int OFFSET = 1;
        final int SIDE_LEN = 10;
        int x = OFFSET, y = OFFSET;
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                Cell cell = maze[i][j];

                // cell drawn here
                g.setColor(getCellColor(cell));
                g.fillRect(x, y, SIDE_LEN, SIDE_LEN);

                // wall drawn here
                g.setColor(Color.CYAN);
                int xOffset = x + SIDE_LEN;
                int yOffset = y + SIDE_LEN;
                if (isGap(i, j, true)) {
                    g.drawLine(xOffset, y, xOffset, yOffset);
                }
                if (isGap(i, j, false)) {
                    xOffset += OFFSET;
                    g.drawLine(x, yOffset, xOffset, yOffset);
                }

                x += SIDE_LEN + OFFSET;
            }
            x = OFFSET;
            y += SIDE_LEN + OFFSET;
        }
    }

    /**
     * Determines the color the cell to be drawn.
     * blue = path, grey = wall, green = start, red = end; yellow = solution
     * @param cell  the current cell of the maze used to determine what color
     *              it should be painted
     * @return Color  the color the cell should be painted
     */
    private Color getCellColor(Cell cell) {
        Color cellColor;

        if (cell.isVisited()) {
            cellColor = Color.CYAN;

            if (cell.isStart()) {
                cellColor = Color.GREEN;
            }

            if (cell.isEnd()) {
                cellColor = Color.RED;
            }
        }
        else {
            cellColor = Color.DARK_GRAY;
        }

        return cellColor;
    }

    /**
     * Checks to see whether or not there is a gap between two cells.
     * In other words: is there a path connecting the nodes?
     * @param row  the row number the cell is stored at in the maze
     * @param col  the column number the cell is stored at in the maze
     * @param isVert  input as true if we want to check for a vertical wall
     *                 and false if checking for a horizontal wall
     * @return boolean  results to true if there is a gap between two cells and
     *                  false otherwise
     */
    private boolean isGap(int row, int col, boolean isVert) {
        Cell current = maze[row][col];
        Cell neighbor;

        // checking for gap to the right
        if (isVert) {
            if (col + 1 < maze[row].length) {
                neighbor = maze[row][col + 1];
                return !current.hasWall(1) && !neighbor.hasWall(3);
            }
        }
        // checking for gap below
        else {
            if (row + 1 < maze.length) {
                neighbor = maze[row + 1][col];
                return !current.hasWall(2) && !neighbor.hasWall(3);
            }
        }

        return false;
    }

    /**
     * Updates the maze instance variable and draws the new
     * instance to the Display. Implemented to display a newly
     * generated maze each time the user instructs the application
     * to do so.
     * @param maze  the maze to be drawn to the Display.
     */
    public void drawMaze(Cell[][] maze) {
        this.maze = maze;
        repaint();
    }
}
