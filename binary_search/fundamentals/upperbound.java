/*Given a sorted array of nums and an integer x, write a program to find the upper bound of x.

The upper bound of x is defined as the smallest index i such that nums[i] > x.

If no such index is found, return the size of the array.

Example 1:
Input : n= 4, nums = [1,2,2,3], x = 2

Output:3

Explanation:

Index 3 is the smallest index such that arr[3] > x.

Example 2:
Input : n = 5, nums = [3,5,8,15,19], x = 9

Output: 3

Explanation:

Index 3 is the smallest index such that arr[3] > x.*/
import java.util.*;
public class upperbound{
    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int arr [] = new int[n];
        for(int i=0;i<n;i++) arr[i] = s.nextInt();
        int target = s.nextInt();
        System.out.println(app1(arr,n,target));
    }
    public static int app1(int arr[],int n,int target){
        int low = 0, high = n-1;
        int res = n; 
        while(low<=high){
            int mid = low + (high-low)/2;
            if(arr[mid]>target){
                res = mid;
                high = mid-1;
            }
            else{
           low = mid +1;
            }
            // bs laga 3 cases avasram ledu ee design lo 
        }
        return res;
    }
}