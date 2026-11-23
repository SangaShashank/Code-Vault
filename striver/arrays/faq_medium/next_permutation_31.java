/*he next permutation of an array of integers is the next lexicographically greater permutation of its integer. More formally, if all the permutations of the array are sorted in one container according to their lexicographical order, then the next permutation of that array is the permutation that follows it in the sorted container. If such arrangement is not possible, the array must be rearranged as the lowest possible order (i.e., sorted in ascending order).

Examples:

The next permutation of arr = [1, 2, 3] is [1, 3, 2].
The next permutation of arr = [2, 3, 1] is [3, 1, 2].
The next permutation of arr = [3, 2, 1] is [1, 2, 3] because [3, 2, 1] does not have a lexicographical larger rearrangement.
Given an array of integers nums, find the next permutation of nums.

The replacement must be in place and use only constant extra memory.

 

Example 1:

Input: nums = [1,2,3]
Output: [1,3,2]
Example 2:

Input: nums = [3,2,1]
Output: [1,2,3]
Example 3:

Input: nums = [1,1,5]
Output: [1,5,1]
 

Constraints:

1 <= nums.length <= 100
0 <= nums[i] <= 100 */
import java.util.*;
public class next_permutation_31{
    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int arr[] = new int[n];
        for (int i=0;i<n;i++) arr[i] = s.nextInt();
        int res [] = app1(arr,n);
        for (int x : res){
            System.out.print(x + " ");
        }
    }
    public static int [] app1(int arr[], int n){
        // break point kavalli 1st 
        int index = -1;
        for (int i= n-2;i>=0;i--) { // vekala nundi ravali 
            if(arr[i] <arr[i+1]){
                index = i; 
                break;
            }
        }
        if(index == -1 ){
           reverse(arr,0,n-1);
          return arr;
        }
        // swap with least smallest greater element 
        for (int i=n-1;index <=i;i++){ // aa index varake ravali kada 
            if(arr[i]> arr[index]){
                int temp = arr[i];
                arr[i] = arr[index];
                arr[index] = temp;
                break; // ofc only oka element ee kada 
            }
        }
        // last ki reverse cheayli kada
        reverse(arr,index +1, n-1); 
        return arr;
    }
    public static void reverse(int arr[], int l, int h){
        while(l<h){
            int temp = arr[l];
            arr[l] = arr[h];
            arr[h] = temp;
            l++; h--;
        }
    }
}