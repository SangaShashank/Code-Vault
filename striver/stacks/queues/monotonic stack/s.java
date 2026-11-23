/*31. Sum of Subarray Minimums
Given an array of integers arr of size n, 
calculate the sum of the minimum value in each (contiguous) subarray of arr. 
Since the result may be large, return the answer modulo 109 +7.

Example 1:
Input: arr = [3, 1, 2, 5]

Output: 18

Explanation: The minimum of subarrays: [3], [1], [2], [5], [3, 1], [1, 2], [2, 5], [3, 1, 2], [1, 2, 5], [3, 1, 2, 5] are 3, 1, 2, 5, 1, 1, 2, 1, 1, 1 respectively and their sum is 18.

Example 2:
Input: arr = [2, 3, 1]

Output: 10

Explanation: The minimum of subarrays: [2], [3], [1], [2,3], [3,1], [2,3,1] are 2, 3, 1, 2, 1, 1 respectively and their sum is 10. */
import java.util.*;
public class s {
    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int arr[] = new int[n];
        for (int i=0;i<n;i++) arr[i ] = s.nextInt();
        System.out.print(app1(arr,n));
    }
    // brute ultra pro 
    public static int app1(int arr[], int n ){
        double  mod = Math.pow(10,9)+7;
        int sum = 0;
        for (int i=0;i<n;i++){
            for (int j = i;j<n;j++){
                int min = Integer.MAX_VALUE;
                for (int k =i;k<=j;k++){
                    min = Math.min(min,arr[k]);
                }
                System.out.println(" min now : " + min);
                sum += min;
                sum = sum % (int) mod; // question wants athi 
            }
        }
        return sum ;
    }
}