/*Given an array of positive integers and a number k, find the maximum sum of any contiguous subarray of size k.
Input:  arr = [2, 1, 5, 1, 3, 2], k = 3
Output: 9   // subarray [5, 1, 3]
Constraints: O(n) time. Do not use nested loops.
Hint
Hide follow-up
Mark solved
Explain solution ↗
Follow-up: What if k is larger than the array length? What if array has negative numbers? */
import java.util.*;
public class ques1{
    public static void main(String args[]){
        int a [] =  {2, 1, 5, 1, 3, 2};
        int k = 3, sum = 0;
        for(int i=0;i<k;i++){
            sum = sum + a[i];
        }
        int maxsum=Integer.MIN_VALUE;
        maxsum = Math.max(maxsum,sum);
        // ila show chese badalu direct ga maxsum = sum pettachu 
        int ans = 0;
        for(int i=k;i<a.length;i++){
            sum = sum - a[i-k] + a[i];
            maxsum = Math.max(maxsum,sum);
           
        }
        System.out.print(maxsum);
    }
}