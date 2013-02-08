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
        int[][] matrix4 = {{1,2,3,4,5,6,7,8,9}};
        int[][] matrix5 = {};
        int[][] matrix6 = {{}};
        int[][] matrix7 = null;
        
        printDiags(matrix1);
        printDiags(matrix2);
        printDiags(matrix3);
        printDiags(matrix4);        
        printDiags(matrix5);
        printDiags(matrix6);
        printDiags(matrix7);
    }
    
    public static void printDiags(int[][] matrix){
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return;
        int cols = matrix[0].length;
        int rows = matrix.length;
        int diags = cols+rows-1;

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
