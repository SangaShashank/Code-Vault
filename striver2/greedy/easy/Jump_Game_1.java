/*Given an array of integers nums, each element in the array represents the maximum jump length at that position. Initially starting at the first index of the array, determine if it is possible to reach the last index. Return true if the last index can be reached, otherwise return false.

Example 1:
Input : [2, 3, 1, 1, 4]

Output : true

Explanation : We can simply take Jump of 1 step at each index to reach the last index.

Example 2:
Input : [3, 2, 1, 0, 4]

Output : false

Explanation : No matter how you make jumps you will always reach the third index (0 base) of the array.

The maximum jump of index three is 0, So you can never reach the last index of array.

Example 3:
Input : [5, 3, 2, 1, 0]

Output:
true
Still unsure what the problem is asking ?

Let’s go through a few more examples, step by step, to make it clearer.

Constraints:
1 <= nums.length <= 104
0 <= nums[i] <= 105*/
import java.util.*;

public class Jump_Game_1{

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        int n = s.nextInt();

        int arr[] = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = s.nextInt();
        }

        System.out.println(app1(arr, n));
    }

    // Approach 1: Greedy
    // Time: O(n), Space: O(1)

    public static boolean app1(int arr[], int n) {

        int maxReach = 0;

        for(int i = 0; i < n; i++) {

            // Check whether current index is reachable
            if(i > maxReach) { // zero block chesindi ani artham 
                return false;
            }

            // Update maximum reachable index
            maxReach = Math.max(maxReach, i + arr[i]);

            // If last index is reachable
            if(maxReach >= n - 1) {
                return true;
            }
        }

        return true;
    }
}