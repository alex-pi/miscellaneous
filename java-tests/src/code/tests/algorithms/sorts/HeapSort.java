/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package code.tests.algorithms.sorts;

import java.util.Arrays;

/**
 *
 * @author Alejandro Pimentel
 */
public class HeapSort {
    
    public static void main (String... args){
        HeapSort hs = new HeapSort();
        
        int[] nums = {8,3,4,6,2,5,7,9};
        
        // We need a heap first, douh!
        Heap heap = new Heap(nums);
        System.out.println(heap);
        System.out.println("Levels of this binary heap: " + heap.getLevels());
        
        // We copy our heap array, keeping our heap instance untouched.
        int[] h = Arrays.copyOf(heap.getHeap(), heap.getHeap().length);
        
        // Now we can actually do heap sort
        hs.sort(h);
        for (int i : h) {
            System.out.print(i+",");
        }
    }
    
    void sort(int... heap){
        for(int i = heap.length-1 ; i>0 ; i--){
            swap(0, i, heap);
            // Every time we swap elements we need to fix the heap.
            fixFromTop(0, i-1, heap);
        }
    }
    
    public void fixFromTop(int fix, int limit, int...heap){
        int[] children = calculateChildren(fix);
        int left = children[0], right = children[1];
        int swapKey = -1;
        if(left <= limit && right <= limit && (heap[left] > heap[fix] || heap[right] > heap[fix])){
            swapKey = (heap[left] > heap[right])? left:right;
        } else if(left <= limit && heap[left] > heap[fix]) {
            swapKey = left;
        } else if(right <= limit && heap[right] > heap[fix]) {
            swapKey = right;
        }
        if(swapKey != -1){
            swap(swapKey, fix, heap);
            fixFromTop(swapKey, limit, heap);
        }            
    }
    
    public int[] calculateChildren(int i){
        int[] children = {2*i+1,2*i+2};
                
        return children;
    }
    
    static class Heap {
        
        private int[] heap;
        
        public Heap(int... nums) {
           if(nums.length == 0) throw new IllegalArgumentException("A heap of size 0 is not allowed.");
           heap = Arrays.copyOf(nums, nums.length);
           buildHeap();           
        }
        
        private void buildHeap() {
            for(int i = 1 ; i < heap.length ; i++){
                int parent = calculateParent(i);

                fixHeap(i, parent);
            }            
        }

        public int calculateParent(int i){
            if(i % 2 != 0)
                return (i-1)/2;
            else
                return (i-2)/2;        
        }

        private void fixHeap(int fix, int parent){
            if(parent >= 0 && heap[fix] > heap[parent]) {
                swap(fix, parent, heap);
                fixHeap(parent, calculateParent(parent));
            }        
        }
        
        public int getLevels(){
            return (int)(Math.ceil(Math.log(heap.length+1) / Math.log(2)));
        }
        
        @Override
        public String toString(){
            StringBuilder sb = new StringBuilder();
            for(int i = 0 ; i < heap.length ; i++){
                sb.append(heap[i]).append(",");
            }
            
            return sb.toString();
        }
        
        public int[] getHeap(){
            return this.heap;
        }
    }

    public static void swap(int j, int k, int... arr){
        arr[j] ^= arr[k];
        arr[k] ^= arr[j];
        arr[j] ^= arr[k];
    } 
}
