package algs4.exercises;

import edu.princeton.cs.algs4.StdDraw;

/******************************************************************************
 *  Compilation:  javac RightTriangle.java
 *  Execution:    java RightTriangle
 *  Dependencies: StdDraw.java
 *
 *  Draws a right triangle and a circumscribing circle.
 *
 ******************************************************************************/

public class RightTriangle {

    public static void main(String[] args) {
/*        StdDraw.square(.5, .5, .5);
        StdDraw.setPenColor(StdDraw.BLUE);
        StdDraw.line(.5, .5, .9, .5);
        StdDraw.line(.9, .5, .5, .8);
        StdDraw.line(.5, .8, .5, .5);
        StdDraw.circle(.7, .65, .25);*/
        StdDraw.setPenRadius(0.05);
        StdDraw.setPenColor(StdDraw.BLUE);
        StdDraw.point(0.5, 0.5);
        StdDraw.setPenColor(StdDraw.MAGENTA);
        StdDraw.line(0.2, 0.2, 0.8, 0.2);
    }
}