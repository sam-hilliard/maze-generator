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
        setSize(1202, 782);
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
        g.setColor(Color.DARK_GRAY);

        int x = 2, y = 2;
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                g.fillRect(x, y, 10, 10);
                x += 12;
            }
            x = 2;
            y += 12;
        }
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
