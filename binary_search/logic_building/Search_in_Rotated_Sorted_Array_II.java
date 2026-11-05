/*Given an integer array nums, sorted in ascending order (may contain duplicate values) and a target value k. Now the array is rotated at some pivot point unknown to you. Return True if k is present and otherwise, return False.

Example 1:
Input : nums = [7, 8, 1, 2, 3, 3, 3, 4, 5, 6], k = 3

Output: True

Explanation: The element 3 is present in the array. So, the answer is True.

Example 2:
Input : nums = [7, 8, 1, 2, 3, 3, 3, 4, 5, 6], k = 10

Output: False

Explanation:The element 10 is not present in the array. So, the answer is False.*/
import java.util.*;
public class Search_in_Rotated_Sorted_Array_II{
    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int arr [] = new int[n];
        for(int i=0;i<n;i++) arr[i] = s.nextInt();
        int target = s.nextInt();
        System.out.println(app1(arr,n,target));
    }
    public static boolean app1(int arr[], int n ,int target){
        int low = 0 , high = n-1;
        while(low <=high){
            int mid = low + (high-low )/2;
            if(arr[mid] == target) return true;
            else if(arr[mid] == arr[low] && arr[mid] == arr[high]) { // heart of the problem 
                low++; high--;
            }
            else if(arr[mid] >= arr[low]){ // left is sorted 
                if(arr[mid]>= target && arr[low]<=target){
                    high = mid -1;

                }
                else {
                    low = mid +1;
                }
            }
            else{
                if(arr[high]>=target && arr[mid]<= target){
                    low = mid +1;
                }
                else {
                    high = mid -1;
                }
            }
        }
        return false ;
    }
}