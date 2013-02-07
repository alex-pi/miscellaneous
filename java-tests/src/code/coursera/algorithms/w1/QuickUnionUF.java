package code.coursera.algorithms.w1;

/**
 * User: pi
 * Date: 2/7/13
 * Time: 10:08 AM
 */
public class QuickUnionUF {

    private int[] id;

    public QuickUnionUF(int n){
        id = new int[n];
        for(int i = 0; i < n; i++){
            id[i] = i;
        }
    }

    public QuickUnionUF(int... ids){
        id = new int[ids.length];
        System.arraycopy(ids, 0, id, 0, ids.length);
    }

    public int root(int p){
        while(p != id[p]) {
            p = id[p];
        }

        return id[p];
    }

    public QuickUnionUF union(int p, int q){
        id[root(p)] = root(q);

        return this;
    }

    public boolean connected(int p, int q){
        return root(p) == root(q);
    }

    public int[] getId() {
        return id;
    }
}
