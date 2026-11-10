/*A valid parentheses string is either empty "", "(" + A + ")", or A + B, where A and B are valid parentheses strings, and + represents string concatenation.

For example, "", "()", "(())()", and "(()(()))" are all valid parentheses strings.
A valid parentheses string s is primitive if it is nonempty, and there does not exist a way to split it into s = A + B, with A and B nonempty valid parentheses strings.

Given a valid parentheses string s, consider its primitive decomposition: s = P1 + P2 + ... + Pk, where Pi are primitive valid parentheses strings.

Return s after removing the outermost parentheses of every primitive string in the primitive decomposition of s.

 

Example 1:

Input: s = "(()())(())"
Output: "()()()"
Explanation: 
The input string is "(()())(())", with primitive decomposition "(()())" + "(())".
After removing outer parentheses of each part, this is "()()" + "()" = "()()()".
Example 2:

Input: s = "(()())(())(()(()))"
Output: "()()()()(())"
Explanation: 
The input string is "(()())(())(()(()))", with primitive decomposition "(()())" + "(())" + "(()(()))".
After removing outer parentheses of each part, this is "()()" + "()" + "()(())" = "()()()()(())".
Example 3:

Input: s = "()()"
Output: ""
Explanation: 
The input string is "()()", with primitive decomposition "()" + "()".
After removing outer parentheses of each part, this is "" + "" = "".
 

Constraints:

1 <= s.length <= 105
s[i] is either '(' or ')'.
s is a valid parentheses string.*/ import java.util.*;
public class ques8 {
    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        String s1 = s.nextLine();
        System.out.println(app_1(s1));
        System.out.print(app_2(s1));

    }
    public static String app_1(String s1){
        StringBuilder res = new StringBuilder();
        Stack<Character> st = new Stack<>();
        for(char c: s1.toCharArray()){
            if(c == '('){
                if(st.size() > 0){
                    res.append(c);
                }
                st.push(c);
            }
            else{
                if(st.size()> 1){
                    res.append(c);
                }
                st.pop();
            }
        }
        return res.toString();
    }
    public static StringBuilder app_2(String s1){ // dont do this , nen edo oorikey chesina , > **"Build with StringBuilder, return as String."**
        StringBuilder res = new StringBuilder();
        int depth = 0;
        for(char c : s1.toCharArray()){
            if(c == '('){
                if(depth > 0) res.append(c);
            
            depth++;
            }
            else{
                if(depth>1) res.append(c);
                depth --;
            }
        }
        return res;

    }
    
}
