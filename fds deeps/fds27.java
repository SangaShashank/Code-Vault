/*Playing with numbers is fun!!
Given an array of integers and a number k
, find the maximum sum among all contiguous subarrays whose sum is less than or equal to k.
 Return the maximum such sum possible.

Approach:
Use a Variable Sliding Window. 
Expand right by adding elements to the current sum. When the sum exceeds k,
 shrink the window from the left. Track the maximum valid sum throughout the traversal.
Sample Input and Output 1:
arr = [1, 2, 3, 4, 5]
k   = 9
Output: 9
Explanation: [4,5] = 9 which is <= 9, and is the maximum possible

Sample Input and Output 2:
arr = [3, 1, 4, 1, 5, 9, 2, 6]
k   = 10
Output: 10
Explanation: [4,1,5] = 10 which is the maximum sum <= k

Sample Input and Output 3:
arr = [2, 4, 6, 8]
k   = 5
Output: 4
Explanation: Only single elements qualify; maximum is 4

Concept: Variable Sliding Window — expand right, shrink left when sum > k
 */
//jaya
import java.util.*;

class fds27 {
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = s.nextInt();
        }
        int k = s.nextInt();
        int sum = 0, max = 0;
        int l= 0;
        for (int i=0;i< n;i++) {
            sum += a[i];
            while (sum > k && l<=i) {
                sum -= a[l];
                l++;
            }
            if (sum <= k) {
                max = Math.max(max, sum);
            }
        }
        System.out.println(max);
    }
}
// koncham manchiga
int sum = 0;
int res = Integer.MIN_VALUE;
int left = 0;
for (int right = 0;right<n;right++){
    sum += arr[right];
    while(sum >k) sum -= arr[left]; left --;
    res = Math.max(sum,res);
}
return res;