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

    /**
     * Creates the divisions appearing across one row of the maze. Ceilings have
     * different ascii representation than walls, so a boolean is used to switch between
     * construction methods. Used as a helper method in teh toString method that creates
     * an ascii representation of the entire maze.
     * @param cells  an array of cell objects that will have the borders constructed around them
     * @param isCeiling  determines which ascii representation of a separator to use
     * @return String  the ascii representation of the separator to added to output
     */
    private String buildWalls(Cell[] cells, boolean isCeiling) {
        String walls = "";
        int index = 0;
        int wallPos = isCeiling ? 0 : 3;

        while (index < cells.length) {
            Cell cell = cells[index];
            if (cell.hasWall(wallPos)) {
                if (wallPos == 0) {
                    walls += String.format("%4s", "*---");
                }
                else {
                    walls += String.format("%-4s", "|");
                }
            }
            index++;
        }

        return walls;
    }

    /**
     * Used to create an ascii representation of the maze.
     * @return String an ascii representation of the maze.
     */
    public String toString() {
        String output = "";

        for (Cell[] cells : maze) {
            output += buildWalls(cells, true);
            output += "\n";
            output += buildWalls(cells, false);
            output += "\n";
        }

        return output;
    }
}
