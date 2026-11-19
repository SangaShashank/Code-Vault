/*iven a string `s` containing only three types of characters: `'('`, `')'` and `'*'`, return `true` if `s` is valid.
The following rules define a valid string:

* Any left parenthesis `'('` must have a corresponding right parenthesis `')'`.
* Any right parenthesis `')'` must have a corresponding left parenthesis `'('`.
* Left parenthesis `'('` must go before the corresponding right parenthesis `')'`.
* `'*'` could be treated as a single right parenthesis `')'` or a single left parenthesis `'('` or an empty string `""`.

 
Example 1:

```
Input: s = "()"
Output: true

```

Example 2:

```
Input: s = "(*)"
Output: true

```

Example 3:

```
Input: s = "(*))"
Output: true

```

Example 4:

```
Input: s = "("
Output: false

```

 
Constraints:

* `1 <= s.length <= 100`
* `s[i]` is `'('`, `')'` or `'*'`.c */
/*import java.util.*;
public class valid_parentesis_checker_678{
    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        String st = s.nextLine();
        System.out.print(app1(st));
    }
    public static boolean app1(String st){
        Stack<Integer> open  = new Stack<>();
        Stack<Integer> star  = new Stack<>(); // positions undali kada
        int i=0;
        for (char x : st.toCharArray()){
            if(x == '(') open.push(i);
            else if(x == '*') star.push(i);
            else{
                //anntey pakka close bracket
                // try with open first 
                if(!open.isEmpty()) open.pop();
                else if(!star.isEmpty()) star.pop(); // star use cheddam 
                else return false; // anntey rendu levu
            }
            i++;
        }
        // last ki anni left over ni compelte cheayli 
        while(!open.isEmpty() && !star.isEmpty()){
            int openindex = open.pop();
            int starindex = star.pop();
            if(openindex>starindex) return false;
        }
        return open.isEmpty(); // koncham teveliga return 
    }
}*/
//claude generated :
import java.util.*;

public class valid_parentesis_checker_678 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        System.out.println("Brute Force Approach     : " + bruteForceApproach(s));
        System.out.println("Memoization (DP) Approach: " + memoizationApproach(s));
        System.out.println("Two Stacks Approach      : " + twoStacksApproach(s));
        System.out.println("Greedy Range Approach    : " + greedyRangeApproach(s));

        sc.close();
    }

    // ---------------------------------------------------------------
    // Approach 1: Brute Force (recursion, try all 3 choices for '*')
    // Time: O(3^k), k = number of '*'   Space: O(n) recursion stack
    // ---------------------------------------------------------------
    public static boolean bruteForceApproach(String s) {
        return bruteSolve(s, 0, 0);
    }

    private static boolean bruteSolve(String s, int i, int open) {
        if (open < 0) return false;                // too many ')'
        if (i == s.length()) return open == 0;     // all matched?

        char c = s.charAt(i);
        if (c == '(') {
            return bruteSolve(s, i + 1, open + 1);
        } else if (c == ')') {
            return bruteSolve(s, i + 1, open - 1);
        } else {                                   // '*'
            return bruteSolve(s, i + 1, open + 1)  // as '('
                || bruteSolve(s, i + 1, open - 1)  // as ')'
                || bruteSolve(s, i + 1, open);     // as empty
        }
    }

    // ---------------------------------------------------------------
    // Approach 2: Memoization (Top-down DP), same recursion + cache
    // Time: O(n^2)   Space: O(n^2) memo + O(n) stack
    // ---------------------------------------------------------------
    public static boolean memoizationApproach(String s) {
        int n = s.length();
        Boolean[][] memo = new Boolean[n + 1][n + 1];
        return memoSolve(s, 0, 0, memo);
    }

    private static boolean memoSolve(String s, int i, int open, Boolean[][] memo) {
        if (open < 0) return false;
        if (i == s.length()) return open == 0;
        if (memo[i][open] != null) return memo[i][open];

        char c = s.charAt(i);
        boolean res;
        if (c == '(') {
            res = memoSolve(s, i + 1, open + 1, memo);
        } else if (c == ')') {
            res = memoSolve(s, i + 1, open - 1, memo);
        } else {
            res = memoSolve(s, i + 1, open + 1, memo)
               || memoSolve(s, i + 1, open - 1, memo)
               || memoSolve(s, i + 1, open, memo);
        }
        return memo[i][open] = res;
    }

    // ---------------------------------------------------------------
    // Approach 3: Two Stacks (store indices of '(' and '*')
    // Time: O(n)   Space: O(n)
    // nenu already chesina paina 
    // ---------------------------------------------------------------
    public static boolean twoStacksApproach(String s) {
        Deque<Integer> open = new ArrayDeque<>();
        Deque<Integer> star = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                open.push(i);
            } else if (c == '*') {
                star.push(i);
            } else {                                // ')'
                if (!open.isEmpty()) open.pop();    // match real '(' first
                else if (!star.isEmpty()) star.pop(); // use '*' as '('
                else return false;                  // nothing to match
            }
        }

        // leftover '(' need a '*' AFTER them to act as ')'
        while (!open.isEmpty() && !star.isEmpty()) {
            if (open.pop() > star.pop()) return false;
        }
        return open.isEmpty();
    }

    // ---------------------------------------------------------------
    // Approach 4: Greedy Range [lo, hi] (Optimal)
    // Time: O(n)   Space: O(1)
    // ---------------------------------------------------------------
    public static boolean greedyRangeApproach(String s) {
        int lo = 0, hi = 0;   // min and max possible open count

        for (char c : s.toCharArray()) {
            if (c == '(') {
                lo++; hi++;
            } else if (c == ')') {
                lo--; hi--;
            } else {          // '*'
                lo--; hi++;
            }

            if (hi < 0) return false;   // too many ')' even if all '*' are '('
            if (lo < 0) lo = 0;         // negative open count is invalid
        }
        return lo == 0;
    }
}
//https://claude.ai/share/2f2ae02d-02ad-4b8f-b5b1-cc1de40700ab
