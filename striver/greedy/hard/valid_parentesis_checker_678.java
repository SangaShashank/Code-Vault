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
import java.util.*;
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
}