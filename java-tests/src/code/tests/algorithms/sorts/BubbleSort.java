/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package code.tests.algorithms.sorts;

/**
 *
 * @author Alejandro Pimentel
 */
public class BubbleSort {
    
    public static void main(String... args){
        BubbleSort bs = new BubbleSort();
        
        int[] nums = {3,7,-1,0,14,-4,1,2,5,19};
        
        int[] r = bs.sort(nums);
        for (int i : nums) {
            System.out.print(i+",");
        }
        System.out.println("phases: " + r[0] + " movs: " + r[1] + " tries: " + r[2]);
        
        int[] nums2 = {1,2,3,4,5,6,7,8,9,10};
        
        r = bs.sort(nums2);
        for (int i : nums2) {
            System.out.print(i+",");
        }
        System.out.println("phases: " + r[0] + " movs: " + r[1] + " tries: " + r[2]);
        
        int[] nums3 = {10,9,8,7,6,5,4,3,2,1};
        
        r = bs.sort(nums3);
        for (int i : nums3) {
            System.out.print(i+",");
        }
        System.out.println("phases: " + r[0] + " movs: " + r[1] + " tries: " + r[2]);
    }
    
    public int[] sort(int... nums){
        boolean switched = true;
        
        int p = 0;
        int movs = 0;
        int tries = 0;
        for(; p<nums.length ; p++){
            if(!switched)
                break;
            switched = false;
            for(int j=0 ; j<(nums.length-p-1) ; j++) {
                tries++;
                if(nums[j] > nums[j+1]) {
                    switchElems(j, j+1, nums);
                    switched = true;
                    movs++;
                }
            }
        }
        int[] r = {p, movs, tries};
        return r;
    }
    
    public void switchElems(int j, int k, int... arr){
        int a = arr[j];
        arr[j] = arr[k];
        arr[k] = a;
    }    

}
