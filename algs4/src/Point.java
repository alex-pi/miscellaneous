/*************************************************************************
 * Name:
 * Email:
 *
 * Compilation:  javac Point.java
 * Execution:
 * Dependencies: StdDraw.java
 *
 * Description: An immutable data type for points in the plane.
 *
 *************************************************************************/

import java.util.Comparator;

public class Point implements Comparable<Point> {

    // compare points by slope
    public final Comparator<Point> SLOPE_ORDER = new Comparator<Point>() {
        @Override
        public int compare(Point p1, Point p2) {
            if(p1 == null || p2 == null) throw new IllegalArgumentException("Points must not be null.");
            double p0p1Slope = slopeTo(p1);
            double p0p2Slope = slopeTo(p2);

            if(p0p1Slope < p0p2Slope) return -1;
            if(p0p1Slope > p0p2Slope) return 1;
            return 0;
        }
    };       // YOUR DEFINITION HERE

    private final int x;                              // x coordinate
    private final int y;                              // y coordinate

    // create the point (x, y)
    public Point(int x, int y) {
        /* DO NOT MODIFY */
        this.x = x;
        this.y = y;
    }

    // plot this point to standard drawing
    public void draw() {
        /* DO NOT MODIFY */
        StdDraw.point(x, y);
    }

    // draw line between this point and that point to standard drawing
    public void drawTo(Point that) {
        /* DO NOT MODIFY */
        StdDraw.line(this.x, this.y, that.x, that.y);
    }

    // slope between this point and that point
    public double slopeTo(Point that) {
        if(this.compareTo(that) == 0) return Double.NEGATIVE_INFINITY;
        if(this.y == that.y) return 0;
        if(this.x == that.y) return Double.POSITIVE_INFINITY;

        double numerator = that.y - this.y;
        double denominator = that.x - that.x;

        return numerator / denominator;
    }

    // is this point lexicographically smaller than that one?
    // comparing y-coordinates and breaking ties by x-coordinates
    public int compareTo(Point that) {
        if(that == null || this.y > that.y)
            return 1;
        if(this.y < that.y) return -1;

        return this.x - that.x;
    }

    // return string representation of this point
    public String toString() {
        /* DO NOT MODIFY */
        return "(" + x + ", " + y + ")";
    }

    // unit test
    public static void main(String[] args) {
        /* YOUR CODE HERE */
    }
}
