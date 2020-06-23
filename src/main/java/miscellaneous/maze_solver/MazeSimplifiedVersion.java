package miscellaneous.maze_solver;

import edu.princeton.cs.algs4.FordFulkerson;
import sun.font.FontRunIterator;

import java.util.concurrent.ForkJoinPool;

/**
 * @Author Tom
 * @Date 2020/6/23 21:01
 * @Version 1.0
 * @Description
 */
public class MazeSimplifiedVersion {
    public static void main(String[] args) {
        //define a map
        int[][] map = new int[10][9];
        //1 means wall, all sides are wall

        //set left and right to 1
        for (int i = 0; i < 10; i++) {
            map[i][0] = 1;
            map[i][8] = 1;
        }
        //set up and bottom to 1
        for (int i = 0; i < 9; i++) {
            map[0][i] = 1;
            map[9][i] = 1;
        }

        //set fence
        map[3][1] = 1;
        map[3][2] = 1;
        map[3][3] = 1;
        map[3][4] = 1;
        map[3][5] = 1;
        map[5][8] = 1;
        map[5][7] = 1;
        map[5][6] = 1;
        map[5][5] = 1;
        map[5][4] = 1;
        //print map
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }

        setWay(map, 1, 1);

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }


    }
    //i, j: start point
    //start coordinate: (1,1) end coordinate: (8,7)
    //map[i][j] value:
    // 0: path and not visited,
    // 1: wall
    // 2: visited and part of the path
    // 3: visited but not able to reach
    // direction: bottom - right - up - left

    public static boolean setWay(int[][] map, int i, int j){
        if(map[8][7] == 2)
            return true;
        if(map[i][j] == 0){
            map[i][j] = 2;
            if(setWay(map,i + 1, j))
                return true;
            else if(setWay(map, i, j+1))
                return true;
            else if(setWay(map, i-1, j))
                return true;
            else if(setWay(map, i, j-1))
                return true;
            else
                map[i][j] = 3;
                return  false;
        }else
            return false;
    }


}
