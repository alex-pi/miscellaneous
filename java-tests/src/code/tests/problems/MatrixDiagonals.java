/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package code.tests.problems;

/**
 *
 * @author Alejandro Pimentel
 */
public class MatrixDiagonals { 
    
    public static void main(String... args){
        int[][] matrix1 = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        int[][] matrix2 = {{1,2,3},{6,7,8},{10,11,12}};
        int[][] matrix3 = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16},{17,18,19,20}};
        
        printDiags(matrix1);
        printDiags(matrix2);
        printDiags(matrix3);
        
    }
    
    public static void printDiags(int[][] matrix){
        int cols = matrix[0].length;
        int rows = matrix.length;
        int diags = Math.abs(cols+rows-1);

        int rb = 0;
        for(int i = 1 ; i <= diags ; i++){
            int r = (i>cols)? ++rb:rb; 
            int c = (i>cols)? cols-1:i-1;
            while(r < rows && c >= 0){
                System.out.print(matrix[r][c] + " ");
                r++; c--;
            }
            System.out.println();
        }
        System.out.println("-----END-----");
    }

}
