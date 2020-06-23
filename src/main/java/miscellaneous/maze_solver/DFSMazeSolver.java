package miscellaneous.maze_solver;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author Tom
 * @Date 2020/6/23 13:16
 * @Version 1.0
 * @Description
 */
public class DFSMazeSolver {
    private static final int[][] DIRECTIONS = {{0,1}, {1,0},{0,-1}, {-1,0}};

    public List<Coordinate> solve(Maze maze){
        ArrayList<Coordinate> path = new ArrayList<>();
        if(explore(maze,maze.getStart().getX(), maze.getStart().getY(), path))
            return path;
        return Collections.emptyList();

    }

    private boolean explore(Maze maze, int row, int col, List<Coordinate> path){
        if(!maze.isValidLocation(row, col) || maze.isWall( row, col) || maze.isExplored(row, col))
            return false;

        path.add(new Coordinate(row, col));
        maze.setVisited(row, col, true);

        if(maze.isExit(row, col))
            return true;

        for (int[] direction : DIRECTIONS) {
            Coordinate nextCoordinate = getNextCoordinate(row, col, direction[0], direction[1]);
            if(explore(maze, nextCoordinate.getX(), nextCoordinate.getY(), path))
                return true;
        }
        path.remove(path.size() - 1);
        return false;
    }
    private Coordinate getNextCoordinate(int row, int col, int x, int y){
        return new Coordinate(row +x, col + y);
    }
}
