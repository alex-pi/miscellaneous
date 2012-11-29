/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package code.tests.algorithms.sorts;

/**
 *
 * @author Alejandro Pimentel
 */
public class BubbleSort2 {
    
    public static void main(String... args) {
        BubbleSort2 bs = new BubbleSort2();
        
        int[] nums = {3,7,-1,0,14,-4,1,2,5,19};
        
        bs.sort(nums);
        for (int i : nums) {
            System.out.print(i+",");
        }
    }
    
    public void sort(int... nums){
        boolean swapped = true;
        
        int p = 0;
        for(; p<nums.length ; p++){
            if(!swapped)
                break;
            swapped = false;
            for(int j=0 ; j<(nums.length-p-1) ; j++) {
                if(nums[j] > nums[j+1]) {
                    swap(j, j+1, nums);
                    swapped = true;
                }
            }
        }
    }
    
    public void swap(int j, int k, int... arr){
        arr[j] ^= arr[k];
        arr[k] ^= arr[j];
        arr[j] ^= arr[k];
    }    

}
