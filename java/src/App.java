import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;

public class App {

    private JFrame window;
    private JPanel main_container, btn_container;
    private Display display;
    private JButton btn_generate, btn_solve;

    public App() {
        window = new JFrame("Maze Generator");
        main_container = new JPanel();
        btn_container = new JPanel();
        display = new Display();
        btn_generate = new JButton("Generate");
        btn_solve = new JButton("Solve");
    }

    public void initUI() {
        btn_generate.addActionListener(e -> display.drawMaze((new MazeGen(65, 100)).getMaze()));

        btn_container.setLayout(new BoxLayout(btn_container, BoxLayout.X_AXIS));
        btn_container.add(btn_generate);
        btn_container.add(btn_solve);

        main_container.setLayout(new BoxLayout(main_container, BoxLayout.Y_AXIS));
        main_container.add(display);
        main_container.add(btn_container);

        window.add(main_container);
        window.pack();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
    }
}
