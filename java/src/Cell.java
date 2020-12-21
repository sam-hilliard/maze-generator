public class Cell {

    private Boolean visited;
    private Boolean walls[];  // top, right, bottom, left

    public Cell() {
        visited = false;
        walls = new Boolean[] {true, true, true, true};
    }

    public boolean hasWall(int wallPos) {
        return walls[wallPos];
    }

    public void destroyWall(int wallPos) {
        walls[wallPos] = false;
    }

    public void makeVisited() {
        visited = true;
    }

    public boolean isVisited() {
        return visited;
    }
}
