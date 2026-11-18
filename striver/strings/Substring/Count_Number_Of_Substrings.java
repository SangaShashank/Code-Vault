/*Count Number of Substrings
You are given a string s consisting of lowercase English letters from 'a' to 'j'.

A substring is considered valid if at most one character occurs an odd number of times in that substring.

Return the total number of valid substrings in s.

A substring is a contiguous, non-empty sequence of characters within a string.

Example 1:
Input: s = "aba"

Output: 4

Explanation: The valid substrings are "a", "b", "a", and "aba". Each contains at most one character with an odd frequency.

Example 2:
Input: s = "aabb"

Output: 9

Explanation: There are 10 substrings in total. The only invalid substring is "ab", where both 'a' and 'b' occur an odd number of times. Hence, the answer is 9.

Now Your Turn!
Pick the correct output for the given input
Input: s = "abca"


3

5

4

2
Still unsure what the problem is asking ?

Let’s go through a few more examples, step by step, to make it clearer.

Constraints:
1 <= s.length <= 105
s consists only of lowercase English letters from 'a' to 'j'. */
import java.util.*;
public class Count_Number_Of_Substrings{
    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        String  st = s.nextLine();
        char c [] = st.toCharArray();
        System.out.println(app1(c));
    }
    public static int app1(char [] c ){
        int count = 0;
        for(int i=0;i<c.length;i++){
            for(int j=i;j<c.length;j++){
                if(check_odd(c,i,j)) count ++;
            }
        }
        return count;
    }
    public static boolean check_odd(char c[],int i,int j){
        int count = 0;
        HashMap<Character,Integer> m = new HashMap<>();
        for(int k = i;k<=j;k++){
            char element = c[k];
            m.put(element,m.getOrDefault(element,0)+1);
        }
        for (char element:m.keySet()){
            if(m.get(element)%2 == 1) count ++;
            if(count>1) return false;
        }
        //System.out.print(m);
        return true;
    }
}