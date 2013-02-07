package code.coursera.algorithms.w1;

/**
 * Created with IntelliJ IDEA.
 * User: pi
 * Date: 2/7/13
 * Time: 8:04 AM
 * To change this template use File | Settings | File Templates.
 */
public class QuickFind {

    private int[] id;

    public QuickFind(int n){
        id = new int[n];
        for(int i = 0; i < n; i++){
            id[i] = i;
        }
    }

    public QuickFind union(int p, int q){
        for(int i = 0; i < id.length; i++){
            if(id[i] == id[p])
                id[i] = id[q];
        }

        return this;
    }

    public boolean connected(int p, int q){
        return id[p] == id[q];
    }

    public int find(int p){
        throw new UnsupportedOperationException();
    }

    public int count(){
        throw new UnsupportedOperationException();
    }

    public int[] getId() {
        return id;
    }

}
