package miscellaneous.maze_solver;

import com.sun.org.apache.xml.internal.dtm.ref.DTMAxisIterNodeList;
import sun.plugin.dom.html.ns4.HTMLFormCollection;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @Author Tom
 * @Date 2020/6/23 10:12
 * @Version 1.0
 * @Description
 */
public class Maze {
    private static final int ROAD = 0;
    private static final int WALL = 1;
    private static final int START = 2;
    private static final int EXIT = 3;
    private static final int PATH = 4;

    private int[][] maze;
    private boolean[][] visited;
    private Coordinate start;
    private Coordinate exit;

    public Maze(File maze) throws FileNotFoundException {
        Scanner scanner = new Scanner(maze);
        String text = "";
        while(scanner.hasNextLine()){
            text += scanner.nextLine() + "\n";
        }
        initializeMaze(text);
    }
    private void initializeMaze(String text){
        if(text == null || text.trim().length() == 0)
            throw new IllegalArgumentException("Empty input data");

        String[] lines = text.split("[\r]?\n");
        maze = new int[lines.length][lines[0].length()];
        visited = new boolean[lines.length][lines[0].length()];


        for(int row = 0; row < getHigh(); row++){
            if(lines[row].length()!=getWith())
                throw new IllegalArgumentException("Line " + (row + 1) + "wrong length ( was " + lines[row].length() + ", but should be " + getWith());
            for(int col = 0; col < getWith(); col++){
                char c = lines[row].charAt(col);
                if(c == '#'){
                    maze[row][col] = WALL;
                }else if(c == 'S'){
                    maze[row][col] = START;
                    start = new Coordinate(row, col);
                }else if(c == 'E'){
                    maze[row][col] = EXIT;
                    exit = new Coordinate(row, col);
                }else
                    maze[row][col] = ROAD;
            }
        }

    }

    private int getHigh(){
        return maze.length;
    }

    private int getWith(){
        return maze[0].length;
    }

    public Coordinate getStart(){
        return start;
    }

    public Coordinate getExit(){
        return exit;
    }

    public boolean isStart(int x, int y){
        return x == start.getX() && y == start.getY();
    }

    public boolean isExit(int x, int y){
        return x == exit.getX() && y == exit.getY();
    }

    public boolean isExplored(int x, int y){
        return visited[x][y];
    }

    public boolean isWall(int x, int y){
        return maze[x][y] == WALL;
    }

    public void setVisited(int row, int col, boolean value){
        visited[row][col] = value;
    }

    public boolean isValidLocation(int row, int col){
        if(row >=0 && row < getHigh() && col >= 0 && col < getWith())
            return true;
        return false;
    }

    public void printPath(List<Coordinate> list){
        int[][] tempMaze = Arrays.stream(maze).map(int[]::clone).toArray(int[][]::new);
        for (Coordinate coordinate : list) {
            if(isStart(coordinate.getX(), coordinate.getY()) || isExit(coordinate.getX(), coordinate.getY()))
                continue;
            tempMaze[coordinate.getX()][coordinate.getY()] = PATH;
        }

        System.out.println(toString(tempMaze));
    }

    private String toString(int[][] maze){
        StringBuilder result = new StringBuilder();
        for (int row = 0; row < getHigh(); row++) {
            for (int col = 0; col < getWith(); col++) {
                if(maze[row][col] == ROAD)
                    result.append(' ');
                else if(maze[row][col] == WALL)
                    result.append('#');
                else if(maze[row][col] == START)
                    result.append('S');
                else if(maze[row][col] == EXIT)
                    result.append('E');
                else
                    result.append('.');
            }
            result.append('\n');
        }
        return result.toString();
    }

    public void reset(){
        for (int i = 0; i < visited.length; i++) {
            Arrays.fill(visited[i],false);
        }
    }

}
