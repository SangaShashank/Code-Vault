//Find_minimum_in_Rotated_Sorted_Array
/*Given an integer array nums of size N, sorted in ascending order with distinct values, and then rotated an unknown number of times (between 1 and N), find the minimum element in the array.

Example 1:
Input : nums = [4, 5, 6, 7, 0, 1, 2, 3]

Output: 0

Explanation: Here, the element 0 is the minimum element in the array.

Example 2:
Input : nums = [3, 4, 5, 1, 2]

Output: 1

Explanation:Here, the element 1 is the minimum element in the array. */
import java.util.*;
public class Find_minimum_in_Rotated_Sorted_Array
{
    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int arr [] = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = s.nextInt();
        }
        System.out.println(app1(arr,n));
        System.out.print(app2(arr,n));
    }
    public static int app1(int arr[],int n){
        int low = 0, high = n-1;
        int res = Integer.MAX_VALUE;
        while(low<=high){
            int mid = low + (high -low)/2;
            if(arr[mid]>=arr[low]){
                res = Math.min(res,arr[low]);
                low = mid +1;
            }
            else{
                res = Math.min(res,arr[mid]);
                high = mid -1;
            }
        }
        return res;
    }
     public static int app2(int arr[],int n){
        int low = 0, high = n-1;
        int res = Integer.MAX_VALUE;
        while(low<=high){
            if(arr[low]<= arr[high]) return Math.min(res,arr[low]);
            int mid = low + (high -low)/2;
            if(arr[mid]>=arr[low]){
                res = Math.min(res,arr[low]);
                low = mid +1;
            }
            else{
                res = Math.min(res,arr[mid]);
                high = mid -1;
            }
        }
        return res;
    }
}