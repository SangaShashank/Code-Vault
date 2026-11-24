/*You are given an m x n integer matrix matrix with the following two properties:

Each row is sorted in non-decreasing order.
The first integer of each row is greater than the last integer of the previous row.
Given an integer target, return true if target is in matrix or false otherwise.

You must write a solution in O(log(m * n)) time complexity. */
import java.util.*;
public class  Search_a_2D_Matrix_74{
    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        int m = s.nextInt();
        int n = s.nextInt();
        int arr[][] = new int [m][n];
        for(int i=0;i<m;i++){
            for (int j = 0;j<n;j++) arr[i][j] = s.nextInt();
        }
        int target = s.nextInt();
        System.out.print(app1(arr,target,m,n));
        System.out.print(app2(arr,target,m,n));
    }
    public static boolean app1(int arr[][], int target , int m ,int n){
        int proper_row = -1;
        for (int i=0;i<m;i++){
            if(arr[i][n-1]>= target && arr[i][0]<= target) { // anntey chance unndi 
                proper_row= i;
                return do_bs(arr,proper_row,n, target);
        }
    }
    return false;
}
public static boolean do_bs(int arr[][], int i , int n, int target){
    int low = 0, high = n-1;
    while(low <= high ){
        int mid = low + (high - low )/2;
        if (arr[i][mid] == target) return true;
        else if (arr[i][mid]>target ) high = mid -1;
        else low = mid +1;
    }
    return false;
}
public static boolean app2(int arr[][], int target,int m,int n){
    //floor concept of bs 
    int proper_row = floor_bs(arr, target,m);
    if (proper_row == -1) return false;
    return do_bs(arr, proper_row, n, target);
}
public static int  floor_bs(int [][]arr,int target,int m){
    int low = 0, high = m-1;
    while(low <= high ){
        int mid = low + (high - low )/2;
        if (arr[mid][0] == target){
            return mid;
        }
        else if (arr[mid][0]>target) high = mid -1;
        else low = mid +1;
    }
     return high <0 ? -1 : high;
}
}
/*import java.util.*;

public class Search_a_2D_Matrix_74 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] arr = new int[m][n];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                arr[i][j] = sc.nextInt();
        int target = sc.nextInt();

        System.out.println("Brute (O(m*n))              : " + brute(arr, target, m, n));
        System.out.println("Better 1 (row scan + BS)    : " + rowScanBS(arr, target, m, n));
        System.out.println("Better 2 (staircase)        : " + staircase(arr, target, m, n));
        System.out.println("Optimal 1 (floor BS + BS)   : " + twoBS(arr, target, m, n));
        System.out.println("Optimal 2 (flatten, one BS) : " + flattenBS(arr, target, m, n));
    }

    // 1. Brute: O(m*n) time, O(1) space
    public static boolean brute(int[][] arr, int target, int m, int n) {
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (arr[i][j] == target) return true;
        return false;
    }

    // 2. Better: O(m + log n) time, O(1) space
    //paina chudu
    public static boolean rowScanBS(int[][] arr, int target, int m, int n) {
        for (int i = 0; i < m; i++) {
            if (arr[i][0] <= target && target <= arr[i][n - 1])
                return binarySearchRow(arr, i, n, target);
        }
        return false;
    }

    // 3. Better: O(m + n) time, O(1) space
    //idhi bale unndi 
    public static boolean staircase(int[][] arr, int target, int m, int n) {
        int i = 0, j = n - 1;
        while (i < m && j >= 0) {
            if (arr[i][j] == target) return true;
            else if (arr[i][j] < target) i++;
            else j--;
        }
        return false;
    }

    // 4. Optimal: O(log m + log n) = O(log(m*n)) time, O(1) space
    //paina chudu 
    public static boolean twoBS(int[][] arr, int target, int m, int n) {
        int low = 0, high = m - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid][0] == target) return true;
            else if (arr[mid][0] > target) high = mid - 1;
            else low = mid + 1;
        }
        if (high < 0) return false;          // smaller than every first element
        return binarySearchRow(arr, high, n, target);
    }

    // 5. Optimal: O(log(m*n)) time, O(1) space
    public static boolean flattenBS(int[][] arr, int target, int m, int n) {
        int low = 0, high = m * n - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int val = arr[mid / n][mid % n];
            if (val == target) return true;
            else if (val < target) low = mid + 1;
            else high = mid - 1;
        }
        return false;
    }

    // helper: standard binary search on one row
    public static boolean binarySearchRow(int[][] arr, int row, int n, int target) {
        int low = 0, high = n - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[row][mid] == target) return true;
            else if (arr[row][mid] > target) high = mid - 1;
            else low = mid + 1;
        }
        return false;
    }
} */
//https://claude.ai/share/b5af05c2-8044-4e89-906f-ac177b91ab1a