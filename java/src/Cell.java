public class Cell {

    private boolean visited;
    private boolean marked;
    private boolean walls[];  // top, right, bottom, left

    public Cell() {
        visited = false;
        walls = new boolean[] {true, true, true, true};
    }

    public boolean hasWall(int wallPos) {
        return walls[wallPos];
    }

    public void destroyWall(int wallPos) {
        walls[wallPos] = false;
    }

    public void markVisited() {
        visited = true;
    }

    public boolean isMarked() { return marked; }

    public boolean isVisited() {
        return visited;
    }
}
