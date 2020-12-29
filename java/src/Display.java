import javax.swing.*;
import java.awt.*;

public class Display extends Canvas {

    private Cell[][] maze;

    public Display() {
        setBackground(Color.LIGHT_GRAY);
        setSize(1202, 782);
        maze = new Cell[0][0];
    }

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

    public void drawMaze(Cell[][] maze) {
        this.maze = maze;
        repaint();
    }
}
