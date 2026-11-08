/*707. Find row with maximum 1's
Given a non-empty grid mat consisting of only 0s and 1s, where all the rows are sorted in ascending order, find the index of the row with the maximum number of ones.
If two rows have the same number of ones, consider the one with a smaller index. If no 1 exists in the matrix, return -1.
Example 1:
Input : mat = [ [1, 1, 1], [0, 0, 1], [0, 0, 0] ]
Output: 0
Explanation: The row with the maximum number of ones is 0 (0 - indexed).
Example 2:
Input: mat = [ [0, 0], [0, 0] ]
Output: -1
Explanation: The matrix does not contain any 1. So, -1 is the answer.*/
//package PLACEMENTS.striver.binary_search.2d array;
import java.util.*;

public class Find_Row_with_Maximum_1s {
    public static void main(String args[])    {
        Scanner s = new Scanner(System.in);
        int m= s.nextInt();
        int n = s.nextInt();
        int arr [][] = new int [m][n];
        for (int i=0;i<m;i++) {
            for (int j=0;j<n;j++){
                arr[i][j] = s.nextInt();
            }
    }
    System.out.println(app1(arr));
    System.out.println(app2(arr));
}
public static int app1(int arr[][]){
    int best_ones = 0; // ee intializations chala chala imp 
    int best_row = -1; 
    for(int i=0;i<arr.length;i++){
        int res = calc_no_of_ones(arr[i]);
        if(res> best_ones){
            best_ones = res;
            best_row = i;
        }
    }
    return best_row;
}
public static int calc_no_of_ones(int arr[]){
    int low = 0, high = arr.length-1;
    int res = -1;
    while(low <= high) {
        int mid = low + (high - low )/2;
        if(arr[mid]== 1){
            res = mid;
            high = mid-1;
        }
        else { low = mid +1;}
    }
    if(res == -1) return 0;
    return arr.length - res; // no of ones 
    }
    public static int app2(int arr[][]){
        int i=0, j = arr[0].length-1; // start with top right 
        int best_row = -1;
        while(i<= arr.length-1 && j>= 0){
            if(arr[i][j] == 1){
                best_row = i;
                j--;
            }
            else{
                i++;
            }
        }
       return best_row;
    }
}
