package code.coursera.algorithms.w1;

/**
 * User: pi
 * Date: 2/7/13
 * Time: 10:08 AM
 *
 * An implementation of Weighted Quick Union using path compression (WQUPC) in its
 * simple one-pass variant.
 *
 * This keeps the tree flat. In fact, in practice this algorithm behaves as linear.
 *
 * This algorithm has worst-time of N + M lg* N
 *
 */
public class WeightedQuickUnionPathCompression {

    private int[] id;
    private int[] size;

    public WeightedQuickUnionPathCompression(int n){
        id = new int[n];
        size = new int[n];
        for(int i = 0; i < n; i++){
            id[i] = i;
            size[i] = 1;
        }
    }

    public int root(int p){
        while(p != id[p]) {
            if(id[p] != id[id[p]]){
                size[id[p]] -= size[p];
                // every time we visit a node, we compress the tree.
                // p points to its grandparent now.
                id[p] = id[id[p]];
            }
            p = id[p];
        }

        return p;
    }

    public WeightedQuickUnionPathCompression union(int p, int q){
        int kp = root(p);
        int kq = root(q);

        if(size[kq] > size[kp]){
            id[kp] = kq;
            size[kq] += size[kp];
        } else {
            id[kq] = kp;
            size[kp] += size[kq];
        }

        return this;
    }

    public boolean connected(int p, int q){
        return root(p) == root(q);
    }

    public int[] getId() {
        return id;
    }

    public int[] getSize() {
        return size;
    }
}
