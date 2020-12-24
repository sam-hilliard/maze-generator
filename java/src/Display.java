import javax.swing.*;
import java.awt.*;

public class Display extends Canvas {
    private Cell[][] maze;

    public Display() {
        setBackground(Color.GRAY);
        setSize(1000, 750);
        maze = new Cell[0][0];
    }

    public Display(Cell[][] maze) {
        setBackground(Color.GRAY);
        setSize(1000, 750);
        this.maze = maze;
    }

    @Override
    public void paint(Graphics g) {
        int x = 0, y = 0;
        int height = 10, width = 10;

        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                g.drawRect(x, y, width, height);
                g.setColor(Color.CYAN);
                g.fillRect(x, y, width, height);
                x += 11;
            }
            y += 11;
        }
    }
}
