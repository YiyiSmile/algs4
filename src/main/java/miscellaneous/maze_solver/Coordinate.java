package miscellaneous.maze_solver;

/**
 * @Author Tom
 * @Date 2020/6/23 10:07
 * @Version 1.0
 * @Description
 */
public class Coordinate {
    private int x,y;
    private Coordinate parent;

    public Coordinate(int x, int y) {
        this(x,y,null);
    }

    public Coordinate(int x, int y, Coordinate parent) {
        this.x = x;
        this.y = y;
        this.parent = parent;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Coordinate getParent() {
        return parent;
    }

    public void setParent(Coordinate parent) {
        this.parent = parent;
    }
}
