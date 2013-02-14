package code.coursera.algorithms.w1;

/**
 * User: pi
 * Date: 2/7/13
 * Time: 10:08 AM
 *
 * Represents a tree using a simple array, the elements of the
 * array are integers from 0-n. The hierarchical relation is as follows:
 *
 * id[i] is the parent element of i,
 * if id[i] is equals to i, it means i is a root element.
 *
 * So we can reach the root of any element doing:
 *
 * id[id[id[...[i]]]] as many times as needed.
 *
 * This implementation avoids large and skinny trees when
 * performing unions by checking the size (weight) of the
 * trees which contain the elements we are connecting.
 *
 * The weight is the number of descendants + 1 (the node itself).
 *
 * Running time:
 *
 * Depth of any node x is at most log2 N
 *
 * Find: takes time proportional to the depth of p and q
 * Union: takes constant time, (when given roots).
 *
 */
public class WeightedQuickUnion {

    private int[] id;
    private int[] size;

    public WeightedQuickUnion(int n){
        id = new int[n];
        size = new int[n];
        for(int i = 0; i < n; i++){
            id[i] = i;
            size[i] = 1;
        }
    }

    public int root(int p){
        while(p != id[p]) {
            p = id[p];
        }

        return p;
    }

    public WeightedQuickUnion union(int p, int q){
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
