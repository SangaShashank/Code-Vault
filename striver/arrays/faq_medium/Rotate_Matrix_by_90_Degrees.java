/*Given an N * N 2D integer matrix, rotate the matrix by 90 degrees clockwise.

The rotation must be done in place, meaning the input 2D matrix must be modified directly.

Example 1:
Input: matrix = [[1, 2, 3], [4, 5, 6], [7, 8, 9]]
Output: matrix = [[7, 4, 1], [8, 5, 2], [9, 6, 3]]
Example 2:
Input: matrix = [[0, 1, 1, 2], [2, 0, 3, 1], [4, 5, 0, 5], [5, 6, 7, 0]]
Output: matrix = [[5, 4, 2, 0], [6, 5, 0, 1], [7, 0, 3, 1], [0, 5, 1, 2]]
Now Your Turn!
Pick the correct output for the given input
Input: matrix = [[1, 1, 2], [5, 3, 1], [5, 3, 5]]
[[2, 1, 5], [1, 3, 3], [1, 5, 5]]
[[5,3, 5], [1, 3, 5], [2, 1, 1]]
[[5, 5, 1], [3, 3, 1], [5, 1, 2]]
[[5, 3, 5], [1, 3, 5], [1, 1, 2]]
Still unsure what the problem is asking ?

Let’s go through a few more examples, step by step, to make it clearer.

Constraints:
n == matrix.length.
n == matrix[i].length.
1 <= n <= 100.
-104 <= matrix[i][j] <= 104
Advertisements

*/
// ee code array laga adigthey ney 

import java.util.*;
public class Rotate_Matrix_by_90_Degrees {
public static void main(String args[])    {
    Scanner s = new Scanner(System.in);
    int n = s.nextInt();
    int arr [][] = new int[n][n];
    for(int i=0;i<n;i++){
        for(int j=0;j<n;j++) arr[i][j] = s.nextInt();
    }
    app1(arr,n);
    for (int i=0;i<n;i++){
        for(int j=0;j<n;j++){
            System.out.print(arr[i][j]+" ");
        }
        System.out.println();
    }
}
public static int [][] app1(int arr[][], int n){
    // transpose cheddam :
    for (int i=0;i<n;i++){
        for(int j=i+1;j<n;j++){ // i+1 anta not zero (sad)
            int temp = arr[i][j];
            arr[i][j] = arr[j][i];
            arr[j][i] = temp;
            
        }
    }
    // reeverse evry row
    for(int i=0;i<n;i++){
        int left = 0, right = n-1;
        while(left<right)
        {
            int temp = arr[i][left];
            arr[i][left] = arr[i][right];
            arr[i][right] = temp;
            right --; left ++;
        } 
    }
    return arr;
}
}
