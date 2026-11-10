//anagram
/*A cybersecurity system needs to verify whether two encrypted messages contain exactly the same 
characters in the same frequency but possibly in different orders.
You are given two strings s and t.
Your task is to determine whether string t is an anagram of string s.
Two strings are said to be anagrams if:
They contain the same characters.
Each character appears the same number of times
The order of characters does not matter.
Return true if t is an anagram of s, otherwise return **false`.

Input Format:
First line: String s
Second line: String t

Output Format
Print true if t is an anagram of s
Print false otherwise
Output must be in lowercase.

Constraints
1 ≤ s.length ≤ 5 × 10^4
1 ≤ t.length ≤ 5 × 10^4
s and t consist only of lowercase English letters.


sample Test Case 1:
input=listen
silent
output=true

Sample Test Case 2:
input=hello
bello
output=false
*/ 

import java.util.*;

public class fds14 {
    public static void anacheck(String s1,String t){
        s1 = s1.toLowerCase();
        t = t.toLowerCase();
        if(s1.length()!= t.length()){
            System.out.print(false);
            return;
        }
        Map <Character,Integer> m = new HashMap<>();
        //System.out.println(s1);
        for (char c : s1.toCharArray()){
            m.put(c,m.getOrDefault(c,0) + 1); // to find freq 
        }
        System.out.println(m);
        for (char c : t.toCharArray()){
            if(!m.containsKey(c)){
                System.out.println(false);
                return ; // kotha alaphabet ravaddu kada 
            }
            m.put(c,m.get(c)-1); // zero down cheddam ani idea kada 
        }
        System.out.println(m);
        for (int v : m.values()){
            if(v!=0){
                System.out.println(false); // freq different ayithe zero radu 
                return ; 
            }
        }
    }
    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        String s1 = s.nextLine();
        String t = s.nextLine();
        anacheck(s1,t);
    }
}
// other codes deepa 1
