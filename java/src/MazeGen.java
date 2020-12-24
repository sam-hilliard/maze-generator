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

    public Cell[][] getMaze() {
        return maze;
    }
}
