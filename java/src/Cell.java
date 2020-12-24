public class Cell {

    private boolean visited;
    private boolean walls[];  // top, right, bottom, left

    public Cell() {
        visited = false;
        walls = new boolean[] {true, true, true, true};
    }

    public boolean hasWall(int wallPos) {
        return walls[wallPos];
    }

    public boolean isVisited() {
        return visited;
    }

    public void markVisited() {
        visited = true;
    }
}
