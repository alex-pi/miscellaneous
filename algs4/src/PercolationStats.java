/**
 * User: pi
 * Date: 2/13/13
 * Time: 9:27 AM
 */
public class PercolationStats {

    private int T;
    private double[] thresholds;

    public PercolationStats(int N, int T) {
        if (N < 1 || T < 1)
            throw new IllegalArgumentException();
        this.T = T;
        this.thresholds = new double[T];
        double numNodes = N*N;

        for (int t = 0; t < T; t++) {
            Percolation percolation = new Percolation(N);
            int openCount = 0;

            while (!percolation.percolates()) {
                int r, c;
                do {
                    r = StdRandom.uniform(N) + 1;
                    c = StdRandom.uniform(N) + 1;
                } while(percolation.isOpen(r, c));

                percolation.open(r, c);
                openCount++;
            }
            double threshold = (double) openCount/numNodes;
            this.thresholds[t] = threshold;
            //StdOut.println(percolation);
        }
    }

    public double mean() {
        return StdStats.mean(this.thresholds);
    }

    public double stddev() {
        return StdStats.stddev(this.thresholds);
    }

    public double confidenceLo() {
        double mean = this.mean();
        double dev = this.stddev();

        return mean - (1.96*dev/Math.sqrt(T));
    }

    public double confidenceHi() {
        double mean = this.mean();
        double dev = this.stddev();

        return mean + (1.96*dev/Math.sqrt(T));
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int t = Integer.parseInt(args[1]);

        Stopwatch sw = new Stopwatch();
        PercolationStats per = new PercolationStats(n, t);
        StdOut.printf("mean                     = %1$.10f\n", per.mean());
        StdOut.printf("stddev                   = %1$.10f\n", per.stddev());
        StdOut.printf("95%% confidence interval  = %1$.10f, %2$.10f\n"
                , per.confidenceLo(), per.confidenceHi());
        StdOut.printf("Elapsed time             = %1$f seconds", sw.elapsedTime());
    }
}
