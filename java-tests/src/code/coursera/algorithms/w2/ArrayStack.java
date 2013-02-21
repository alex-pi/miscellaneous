package code.coursera.algorithms.w2;

/**
 * User: pi
 * Date: 2/19/13
 * Time: 11:48 AM
 */
public class ArrayStack<I extends Object> {

    private Object[] array;
    private int N = 0;

    public ArrayStack() {
        array = new Object[1];
    }

    public boolean isEmpty(){
        return N == 0;
    }

    public ArrayStack<I> push(I item) {
        if(N == array.length) resize(array.length * 2);
        array[N++] = item;

        return this;
    }

    public I pop() {
        if(N == 0) return null;
        I item = (I)array[--N];
        array[N] = null;
        if(N <= array.length/4) resize(array.length / 2);

        return item;
    }

    private void resize(int size) {
        Object[] newArray = new Object[size];

        System.arraycopy(array, 0, newArray, 0, N);

        this.array = newArray;
    }
}
