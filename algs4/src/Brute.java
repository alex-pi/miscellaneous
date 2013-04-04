/**
 * User: pi
 * Date: 3/22/13
 * Time: 3:13 PM
 */
public class Brute {

    public static void main(String[] args) {
        Point[] points = new Point[]{new Point(3, 2), new Point(4, 3),
                                        new Point(5, 4), new Point(6, 5)};

        for(int pi = 0; pi < points.length ; pi++) {
            int count = 0;
            double slopepq;
            double slopepx;
            for(int comps = 0, pj = 0; comps < points.length ;) {
                if(pj >= points.length) pj = 0;
                slopepq = points[pi].slopeTo(points[pj]);
                slopepx = points[pi].slopeTo(points[++pj]);
            }
        }
    }
}
