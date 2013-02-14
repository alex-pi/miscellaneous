/**
 * User: pi
 * Date: 2/13/13
 * Time: 9:25 AM
 *
 */
public class Percolation {

    private int n;
    private int top;
    private int bottom;
    private int openCount;
    private boolean[][] grid;
    private WeightedQuickUnionUF wquf;

    public Percolation(int N) {
        this.n = N;
        this.grid = new boolean[N][N];
        this.top = n*n;
        this.bottom = n*n + 1;
        this.wquf = new WeightedQuickUnionUF((n*n)+2);
    }

    public void open(int i, int j) {
        checkBounds(i, j);
        int r = i-1;
        int c = j-1;
        if (isOpen(i, j)) return;
        boolean tryUp = (i-1 > 0);
        boolean tryDown = (i+1 <= n);
        boolean tryLeft = (j-1 > 0);
        boolean tryRight = (j+1 <= n);

        this.grid[r][c] = true;
        openCount++;
        int indexQU = r*n + c; 
        if (tryUp && isOpen(i-1, j)) {
            this.wquf.union(indexQU, (r-1)*n + c);
        }
        if (tryDown && isOpen(i+1, j)) {
            this.wquf.union(indexQU, (r+1)*n + c);
        }
        if (tryLeft && isOpen(i, j-1)) {
            this.wquf.union(indexQU, r*n + c-1);
        }
        if (tryRight && isOpen(i, j+1)) {
            this.wquf.union(indexQU, r*n + c+1);
        }
        
        if (i == 1)
            this.wquf.union(indexQU, top);
        if (i == n)
            this.wquf.union(indexQU, bottom);
    }

    private void checkBounds(int i, int j) {
        if (i < 1 || i > n || j < 1 || j > n)
            throw new IndexOutOfBoundsException("Out of bounds.");
    }

    public boolean isOpen(int i, int j) {
        checkBounds(i, j);
        return this.grid[i-1][j-1];
    }

    public boolean isFull(int i, int j) {
        checkBounds(i, j);
        int r = i-1;
        int c = j-1;
        return isOpen(i, j) && this.wquf.connected(top, r*n + c);
    }

    public boolean percolates() {
        return this.wquf.connected(top, bottom);
    }

    /*public int getOpenCount() {
        return openCount;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                char out = '\u2588';
                if (grid[i][j])
                    out = '\u2591';
                sb.append(out).append(" ");
            }
            sb.append("\n");
        }

        return sb.toString();
    }*/
}
