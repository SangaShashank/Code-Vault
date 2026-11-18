import java.util.Arrays;

/**
 * LeetCode 53 - Maximum Subarray
 * All approaches in one file: Brute -> Better -> Optimal (Kadane's)
 */
public class MaxSubArray_53{

    // ---------------------------------------------------------------
    // 1) BRUTE FORCE
    // Try every (i, j) pair and sum the elements with a third loop.
    // Time: O(n^3)   Space: O(1)
    // ---------------------------------------------------------------
    static int bruteForce(int[] nums) {
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                int sum = 0;
                for (int k = i; k <= j; k++) {
                    sum += nums[k];
                }
                res = Math.max(res, sum);
            }
        }
        return res;
    }

    // ---------------------------------------------------------------
    // 2) BETTER (your approach)
    // Fix the start i, extend the end j, keep a running sum.
    // Time: O(n^2)   Space: O(1)   -> TLE at n = 10^5
    // ---------------------------------------------------------------
    static int better(int[] nums) {
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                res = Math.max(res, sum);
            }
        }
        return res;
    }

    // ---------------------------------------------------------------
    // 3) OPTIMAL - Kadane's Algorithm
    // cur = best sum of a subarray ending at the current index.
    // A negative running prefix only hurts, so drop it (reset to 0).
    // Update res BEFORE the reset so all-negative arrays work.
    // Time: O(n)   Space: O(1)
    // ---------------------------------------------------------------
    static int kadane(int[] nums) {
        int cur = 0;
        int res = Integer.MIN_VALUE;
        for (int x : nums) {
            cur += x;
            res = Math.max(res, cur);
            if (cur < 0) cur = 0;
        }
        return res;
    }

    // Kadane's, equivalent DP form: extend or start fresh at nums[i].
    static int kadaneDP(int[] nums) {
        int cur = nums[0];
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            cur = Math.max(nums[i], cur + nums[i]);
            res = Math.max(res, cur);
        }
        return res;
    }

    // ---------------------------------------------------------------
    // Quick tests
    // ---------------------------------------------------------------
    public static void main(String[] args) {
        int[][] tests = {
            {-2, 1, -3, 4, -1, 2, 1, -5, 4},  // 6
            {1},                              // 1
            {5, 4, -1, 7, 8},                 // 23
            {-3, -1, -2},                     // -1 (all negatives)
            {0, 0, 0},                        // 0
            {-1, 0, -2}                       // 0
        };
        for (int[] t : tests) {
            System.out.println(Arrays.toString(t)
                + " -> brute=" + bruteForce(t)
                + ", better=" + better(t)
                + ", kadane=" + kadane(t)
                + ", kadaneDP=" + kadaneDP(t));
        }
    }
}