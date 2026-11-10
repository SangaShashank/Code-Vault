/*Given an array arr of n elements. The task is to reverse the given array. The reversal of array should be inplace.


Example 1

Input: n=5, arr = [1,2,3,4,5]



Output: [5,4,3,2,1]



Explanation: The reverse of the array [1,2,3,4,5] is [5,4,3,2,1]

Example 2

Input: n=6, arr = [1,2,1,1,5,1]



Output: [1,5,1,1,2,1]



Explanation: The reverse of the array [1,2,1,1,5,1] is [1,5,1,1,2,1]. */
import java.util.*;
public class reverse_of_array{
    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        if(n <= 0){
            return;
        }
        int arr[] = new int [n];
        for(int i=0;i<n;i++) arr[i] = s.nextInt();
        System.out.println(Arrays.toString(rev(arr,0,n-1)));
    }
    public static int [] rev(int arr [],int i,int j){
        if(i>=j){
            return arr;
        }
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        return rev(arr,i+1,j-1);
    }
} 
//https://claude.ai/share/65ae5ab2-23c3-4e10-922e-4e127ea8f858 
// 16-9-26
