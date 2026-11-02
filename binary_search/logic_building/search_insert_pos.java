/*Given a sorted array of nums consisting of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

Example 1:
Input: nums = [1, 3, 5, 6], target = 5

Output: 2

Explanation: The target value 5 is found at index 2 in the sorted array. Hence, the function returns 2.

Example 2:
Input: nums = [1, 3, 5, 6], target = 2

Output: 1

Explanation: The target value 2 is not found in the array. However, it should be inserted at index 1 to maintain the sorted order of the array.*/
import java.util.*;
public class search_insert_pos{
    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++) arr[i] = s.nextInt();
        int target = s.nextInt();
        System.out.println(bs(arr,n,target));
    }
    public static int bs(int arr[], int n , int target){
        int low = 0, high = n-1;
        while(low<= high){
            int mid = low + (high - low )/2;
            if(arr[mid] == target){
                return mid;
            }
            else if(arr[mid]<target){
                low = mid +1;
            }
            else {
                high = mid -1;
            }
        }
            return low; // the heart of the problem 
    }
}