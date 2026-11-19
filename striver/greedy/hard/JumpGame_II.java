/*09. Jump Game II
You are given a 0-indexed array nums of length n representing your maximum jump capability from each index.

You start at index 0. Each element nums[i] represents the maximum number of steps you can jump forward from index i.

Your goal is to reach the last index of the array (nums[n - 1]) using the minimum number of jumps.

Return the minimum number of jumps required to reach the last index.

You can assume that it is always possible to reach the last index.

Example 1:
Input: nums = [2,3,1,1,4]

Output: 2

Explanation:

Jump from index 0 → 1 → 4 (2 jumps).

Example 2:
Input: nums = [2,3,0,1,4]

Output: 2

Explanation:

Jump from index 0 → 1 → 4.

Now Your Turn!
Pick the correct output for the given input
Input: nums = [5,9,3,2,1,0,2,3,3,1,0,0]


2

3

4

5
Still unsure what the problem is asking ?

Let’s go through a few more examples, step by step, to make it clearer.

Constraints:
1 <= nums.length <= 10⁴
0 <= nums[i] <= 1000
It is guaranteed that you can reach the last index. */
import java.util.*;

public class JumpGame_II {

    // ---------- 1. BRUTE: try every jump from every index ----------
    // Time: exponential ~ O(k^n)   Space: O(n) stack
    static int brute(int index, int jumps, int[] nums) {
        if (index >= nums.length - 1) return jumps;

        int mini = Integer.MAX_VALUE;
        for (int i = 1; i <= nums[index]; i++) {
            mini = Math.min(mini, brute(index + i, jumps + 1, nums));
        }
        return mini;                       // MAX_VALUE if dead end
    }

    // ---------- 2. BETTER: memoization, f(i) = min jumps from i to end ----------
    // Time: O(n * k) -> O(n^2) worst   Space: O(n) dp + O(n) stack
    static int better(int i, int[] nums, int[] dp) {
        if (i >= nums.length - 1) return 0;
        if (dp[i] != -1) return dp[i];

        int best = Integer.MAX_VALUE;
        for (int j = 1; j <= nums[i]; j++) {
            int sub = better(i + j, nums, dp);
            if (sub != Integer.MAX_VALUE)  // avoid 1 + MAX_VALUE overflow
                best = Math.min(best, 1 + sub);
        }
        return dp[i] = best;
    }

    // ---------- 3. OPTIMAL: greedy "levels" (implicit BFS) ----------
    // Time: O(n)   Space: O(1)
    static int optimal(int[] nums) {
        int jumps= 0, l= 0, r= 0;
        while(r<nums.length-1){
            int farthest = 0;
            for(int i = l;i<=r;i++){ // less than or equal to unntadi pakka
                farthest = Math.max(i+nums[i], farthest);

            }
            l = r +1 ; // only okkate min possible kada 
            r = farthest; // motham entha max possible ani 
            jumps ++; // fathest ayina min ayina jumps matram increese by one 
        }

        return jumps;
    }                                 

    // ---------- main: initialize inputs and call each approach ----------
    public static void main(String[] args) {
        int[][] tests = {
            {2, 3, 1, 1, 4},                       // expected 2
            {2, 3, 0, 1, 4},                       // expected 2
            {0},                                   // expected 0 (n = 1)
            {5, 9, 3, 2, 1, 0, 2, 3, 3, 1, 0, 0}   // the "pick the output" case
        };

        for (int[] nums : tests) {
            int[] dp = new int[nums.length];
            Arrays.fill(dp, -1);

            System.out.println("nums = " + Arrays.toString(nums));
            System.out.println("  brute   : " + brute(0, 0, nums));
            System.out.println("  better  : " + better(0, nums, dp));
            System.out.println("  optimal : " + optimal(nums));
        }
    }
}
//https://claude.ai/share/b3c4e26d-1470-4369-a1d2-d43e2173d669