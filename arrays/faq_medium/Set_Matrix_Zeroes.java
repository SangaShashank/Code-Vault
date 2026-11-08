//package PLACEMENTS.striver.arrays.faq_medium;
/*Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0. You must do it in place.

Example 1:
Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]

Output: [[1,0,1],[0,0,0],[1,0,1]]

Explanation:

Element at position (1,1) is 0, so set entire row 1 and column 1 to 0.

Example 2:
Input: matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]

Output: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]

Explanation:

There are two zeroes: (0,0) and (0,3).

Row 0 → all elements become 0
Column 0 and column 3 → all elements become 0 */
// pasting form striver sheet
class Solution {
    public void setZeroes(int[][] matrix) {
       ArrayList<Integer> pos = new ArrayList<>(); 
        // Your code goes here
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j] == 0){
                    // make rows zero 
                    pos.add(i); pos.add(j);
                    
                }
            }
        }
        zero_down(matrix,pos);
    }
        public static void zero_down(int [][] matrix,ArrayList<Integer> pos){
            for(int i=0;i<pos.size();i = i+2){
                for(int k = 0;k<matrix[0].length;k++) matrix [pos.get(i)][k] = 0;
                    for(int k=0;k<matrix.length;k++) matrix [k][pos.get(i+1)] =0;
            }
        }
    }