/*560. Subarray Sum Equals K
Attempted
Medium
Topics
premium lock icon
Companies
Hint
Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.

A subarray is a contiguous non-empty sequence of elements within an array.

 

Example 1:

Input: nums = [1,1,1], k = 2
Output: 2
Example 2:

Input: nums = [1,2,3], k = 3
Output: 2
 

Constraints:

1 <= nums.length <= 2 * 104
-1000 <= nums[i] <= 1000
-107 <= k <= 107*/
//works only if all numbers are positive 
/*public class Subarray_Sum_Equals_K_560{
    public int subarraySum(int[] nums, int k) {
        int l = 0;
        int sum = 0;
        int count = 0;
        for(int r=0;r<nums.length;r++){
            sum += nums[r];
            while(sum >k) {
                sum -= nums[l];
                l++;
            }
            if(sum == k) count ++;
        }
        return count;
    }
}*/
import java.util.HashMap;

public class Subarray_Sum_Equals_K_560 {

    // BRUTE: O(n^3) time, O(1) space
    // Try every (i, j) pair and re-add the elements each time.
    public static int bruteForce(int[] nums, int k) {
        int count = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {            // start index
            for (int j = i; j < n; j++) {        // end index
                int sum = 0;
                for (int x = i; x <= j; x++) {   // recompute sum of nums[i..j]
                    sum += nums[x];
                }
                if (sum == k) count++;
            }
        }
        return count;
    }

    // BETTER: O(n^2) time, O(1) space
    // Fix the start, extend the end, and keep a running sum (no re-adding).
    public static int better(int[] nums, int k) {
        int count = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += nums[j];                  // extend the window by one
                if (sum == k) count++;           // don't break: negatives/zeros can still hit k later
            }
        }
        return count;
    }

    // OPTIMAL: O(n) time, O(n) space
    // Prefix sum + HashMap (prefixSum -> frequency).
    public static int optimal(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);                           // empty prefix

        int sum = 0;
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            int need = sum - k;
            if (map.containsKey(need)) {
                count += map.get(need);
            }

            if (map.containsKey(sum)) {
                map.put(sum, map.get(sum) + 1);
            } else {
                map.put(sum, 1);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3};
        int[] b = {1, -1, 0};
        System.out.println(bruteForce(a, 3) + " " + better(a, 3) + " " + optimal(a, 3)); // 2 2 2
        System.out.println(bruteForce(b, 0) + " " + better(b, 0) + " " + optimal(b, 0)); // 3 3 3
    }
}
//https://claude.ai/share/a9423622-27be-4d92-831c-ee94e009a0d7
