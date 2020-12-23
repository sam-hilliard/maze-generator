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

    private StringBuilder addRow(Cell[] cells, boolean isHorizontal, boolean isBottomBorder) {
        StringBuilder row = new StringBuilder();

        for (int i = 0; i < cells.length; i++) {
            Cell cell = cells[i];

            // horizontal separation
            if (isHorizontal) {
                int wallPos = isBottomBorder ? 3 : 0;

                row.append("+");
                if (cell.hasWall(wallPos)) {
                    row.append("---");
                }

                // remaining '+' that gets left out
                if (i == cells.length - 1) {
                    row.append("+");
                }
            }
            //vertical separation
            else {
                if (cell.hasWall(3)) {
                    row.append(String.format("%-2s", "|"));
                }

                if (cell.isMarked()) {
                    row.append(String.format("%-2s","*"));
                } else {
                    row.append(String.format("%-2s"," "));
                }

                // remaining '|' that gets left out
                if (i == cells.length - 1 && cell.hasWall(1)) {
                    row.append(String.format("%-2s", "|"));
                }
            }
        }
        row.append("\n");

        return row;
    }

    /**
     * Used to create an ascii representation of the maze.
     * @return String an ascii representation of the maze.
     */
    public String toString() {
        StringBuilder output = new StringBuilder();

        for (Cell[] cells: maze) {
            // walls above
            output.append(addRow(cells, true, false));

            // walls to the left
            output.append(addRow(cells, false, false));
        }
        // adding bottom border
        output.append(addRow(maze[maze.length - 1], true, true));

        return output.toString();
    }
}
