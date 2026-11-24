/*iven a circular integer array nums (i.e., the next element of nums[nums.length - 1] is nums[0]), return the next greater number for every element in nums.

The next greater number of a number x is the first greater number to its traversing-order next in the array, which means you could search circularly to find its next greater number. If it doesn't exist, return -1 for this number.

 

Example 1:

Input: nums = [1,2,1]
Output: [2,-1,2]
Explanation: The first 1's next greater number is 2; 
The number 2 can't find next greater number. 
The second 1's next greater number needs to search circularly, which is also 2.
Example 2:

Input: nums = [1,2,3,4,3]
Output: [2,3,4,-1,4]
 

Constraints:

1 <= nums.length <= 104
-109 <= nums[i] <= 109 */
import java.util.*;

public class Next_Greater_Element_II_503 {

    // Brute: O(n^2) time, O(1) extra space (excluding output)
    static int[] brute(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = -1;
            for (int k = 1; k < n; k++) {
                int idx = (i + k) % n;
                if (nums[idx] > nums[i]) {
                    res[i] = nums[idx];
                    break;
                }
            }
        }
        return res;
    }

    // Better: doubled array + monotonic stack. O(n) time, O(n) space (copy + stack)
    //idi emo nijanga array ni create chestunndi 
    static int[] better(int[] nums) {
        int n = nums.length;
        int[] dbl = new int[2 * n];
        for (int i = 0; i < 2 * n; i++) dbl[i] = nums[i % n];

        int[] res = new int[n];
        Deque<Integer> st = new ArrayDeque<>();
        for (int i = 2 * n - 1; i >= 0; i--) {
            while (!st.isEmpty() && st.peek() <= dbl[i]) st.pop();
            if (i < n) res[i] = st.isEmpty() ? -1 : st.peek();
            st.push(dbl[i]);
        }
        return res;
    }

    // Optimal: virtual doubling with i % n. O(n) time, O(n) space (stack only)
    // virtual double anukoni ,  just traversal kosam index's chalu kada 
    static int[] optimal(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Deque<Integer> st = new ArrayDeque<>();
        for (int i = 2 * n - 1; i >= 0; i--) {
            int cur = nums[i % n];
            while (!st.isEmpty() && st.peek() <= cur) st.pop();
            if (i < n) res[i] = st.isEmpty() ? -1 : st.peek();
            st.push(cur);
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) nums[i] = sc.nextInt();

        System.out.println("Brute   : " + Arrays.toString(brute(nums)));
        System.out.println("Better  : " + Arrays.toString(better(nums)));
        System.out.println("Optimal : " + Arrays.toString(optimal(nums)));
        sc.close();
    }
}