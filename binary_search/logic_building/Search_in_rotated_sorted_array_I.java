/*Given an integer array nums, sorted in ascending order (with distinct values) and a target value k. The array is rotated at some pivot point that is unknown. Find the index at which k is present and if k is not present return -1.

Example 1:
Input : nums = [4, 5, 6, 7, 0, 1, 2], k = 0

Output: 4

Explanation: Here, the target is 0. We can see that 0 is present in the given rotated sorted array, nums. Thus, we get output as 4, which is the index at which 0 is present in the array.

Example 2:
Input: nums = [4, 5, 6, 7, 0, 1, 2], k = 3

Output: -1

Explanation: Here, the target is 3. Since 3 is not present in the given rotated sorted array. Thus, we get the output as -1.Given an integer array nums, sorted in ascending order (with distinct values) and a target value k. The array is rotated at some pivot point that is unknown. Find the index at which k is present and if k is not present return -1.

Example 1:
Input : nums = [4, 5, 6, 7, 0, 1, 2], k = 0

Output: 4

Explanation: Here, the target is 0. We can see that 0 is present in the given rotated sorted array, nums. Thus, we get output as 4, which is the index at which 0 is present in the array.

Example 2:
Input: nums = [4, 5, 6, 7, 0, 1, 2], k = 3

Output: -1

Explanation: Here, the target is 3. Since 3 is not present in the given rotated sorted array. Thus, we get the output as -1. */
//Search_in_rotated_sorted_array-I
import java.util.*;
public class Search_in_rotated_sorted_array_I{
    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++) arr[i] = s.nextInt();
        int target = s.nextInt();
        System.out.println(shrewwni(arr,n,target));

    }
    public static int shrewwni(int arr[], int n,int target){
        int low = 0, high = n-1;
        while(low<= high){
            int mid = low + (high - low)/2;
            if(arr[mid] == target) return mid;
            else if(arr[low] <=arr[mid]){ // left sorted
                if(arr[low]<=target && arr[mid]>=target){
                     high = mid -1;
                }
                else {
                    low = mid +1;
                }
            }
            else{ // right sorted
                if(arr[high]>=target && arr[mid]<=target){
                    low = mid +1;
                }
                else{
                    high = mid -1;
                }
            }
        }
        return -1;
    }
}