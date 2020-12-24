import java.awt.*;
import javax.swing.*;

public class App {

    private JFrame window;
    private JPanel container;
    private BoxLayout layout;
    private Display display;
    private JButton btn_generate, btn_solve;

    public App() {
        window = new JFrame("Maze Generator");
        container = new JPanel();
        layout = new BoxLayout(container, BoxLayout.Y_AXIS);
        display = new Display();
        btn_generate = new JButton("Generate");
        btn_solve = new JButton("Solve");
    }

    public void initUI() {
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        container.setLayout(layout);
        container.add(display);
        container.add(btn_generate);
        container.add(btn_solve);
        window.add(container);
        window.pack();
        window.setVisible(true);
    }

    public void drawMaze() {
        MazeGen mazeGen = new MazeGen(10, 10);
        display = new Display(mazeGen.getMaze());
    }
}
