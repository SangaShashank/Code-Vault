/*402. Remove K Digits
Medium
Topics
premium lock icon
Companies
Given string num representing a non-negative integer num, and an integer k, return the smallest possible integer after removing k digits from num.

 

Example 1:

Input: num = "1432219", k = 3
Output: "1219"
Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.
Example 2:

Input: num = "10200", k = 1
Output: "200"
Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.
Example 3:

Input: num = "10", k = 2
Output: "0"
Explanation: Remove all the digits from the number and it is left with nothing which is 0.
 

Constraints:

1 <= k <= num.length <= 105
num consists of only digits.
num does not have any leading zeros except for the zero itself. */
import java.util.*;

public class Remove_K_Digits_402 {

    // helper: strip leading zeros, return "0" if nothing is left
    static String strip(String s) {
        int i = 0;
        while (i < s.length() && s.charAt(i) == '0') i++;
        String res = s.substring(i);
        return res.isEmpty() ? "0" : res;
    }

    // helper: is numeric string a smaller than b? (no leading zeros)
    static boolean isSmaller(String a, String b) {
        if (a.length() != b.length()) return a.length() < b.length();
        return a.compareTo(b) < 0;
    }

    // ---------- Method 1: BRUTE (try every keep/remove choice) ----------
    static String best;

    static void solve(String num, int idx, int k, StringBuilder cur) {
        if (idx == num.length()) {
            if (k == 0) {
                String cand = strip(cur.toString());
                if (best == null || isSmaller(cand, best)) best = cand;
            }
            return;
        }
        // keep this digit
        cur.append(num.charAt(idx));
        solve(num, idx + 1, k, cur);
        cur.deleteCharAt(cur.length() - 1);
        // remove this digit
        if (k > 0) solve(num, idx + 1, k - 1, cur);
    }

    static String removeKdigitsBrute(String num, int k) {
        best = null;
        solve(num, 0, k, new StringBuilder());
        return best;
    }

    // ---------- Method 2: BETTER (k rounds, remove first "peak" each time) ----------
    static String removeKdigitsBetter(String num, int k) {
        StringBuilder sb = new StringBuilder(num);
        for (int r = 0; r < k; r++) {
            int i = 0;
            while (i < sb.length() - 1 && sb.charAt(i) <= sb.charAt(i + 1)) i++;
            sb.deleteCharAt(i); // first digit larger than its next, or the last digit
        }
        return strip(sb.toString());
    }

    // ---------- Method 3: OPTIMAL (monotonic increasing stack) ----------
    static String removeKdigitsOptimal(String num, int k) {
        StringBuilder st = new StringBuilder(); // used as a stack
        for (char c : num.toCharArray()) {
            while (k > 0 && st.length() > 0 && st.charAt(st.length() - 1) > c) {
                st.deleteCharAt(st.length() - 1);
                k--;
            }
            st.append(c);
        }
        while (k > 0 && st.length() > 0) { // leftover k, remove from the end
            st.deleteCharAt(st.length() - 1);
            k--;
        }
        return strip(st.toString());
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter num: ");
        String num = sc.next();
        System.out.print("Enter k: ");
        int k = sc.nextInt();

        if (num.length() <= 20) { // brute is exponential, so only run on small input
            System.out.println("Brute   : " + removeKdigitsBrute(num, k));
        } else {
            System.out.println("Brute   : skipped (input too large)");
        }
        System.out.println("Better  : " + removeKdigitsBetter(num, k));
        System.out.println("Optimal : " + removeKdigitsOptimal(num, k));
        sc.close();
    }
}