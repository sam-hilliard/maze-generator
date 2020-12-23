import java.util.Scanner;

public class Driver {

    public static void main(String[] args) {
        /*Scanner prompt = new Scanner(System.in);
        System.out.print("Enter the maze's height: ");
        int height = prompt.nextInt();
        System.out.print("Enter the maze's width: ");
        int width = prompt.nextInt();*/

        MazeGen mazeGen = new MazeGen(4, 4);
        System.out.println(mazeGen);
    }
}
