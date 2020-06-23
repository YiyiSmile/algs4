package miscellaneous.maze_solver;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

/**
 * @Author Tom
 * @Date 2020/6/23 18:41
 * @Version 1.0
 * @Description
 */
public class MazeDriver {
    public static void main(String[] args) throws FileNotFoundException {
        File maze1 = new File("src/main/resources/maze/maze1.txt");
        execute(maze1);

    }

    private static void execute(File file) throws FileNotFoundException {
        Maze maze = new Maze(file);
        dsf(maze);
    }
    private static void dsf(Maze maze){
        DFSMazeSolver dfs = new DFSMazeSolver();
        List<Coordinate> path = dfs.solve(maze);
        maze.printPath(path);
        maze.reset();
    }
}
