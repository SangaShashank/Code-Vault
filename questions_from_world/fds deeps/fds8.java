/*Problem Statement:
Given two strings s and goal, return true if goal is a rotation of s, otherwise return false.

Example 1:
Input: s = "abcde", goal = "cdeab"
Output: true

Example 2:
Input: s = "abcde", goal = "abced"
Output: false

Example 3:
Input: s = "aa", goal = "aa"
Output: true



Constraints:

1 <= s.length, goal.length <= 100
s and goal consist of lowercase English letters */
import java.util.*;
class fds8{
    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        String k = s.next();
        k = k.toLowerCase();
        String t = s.next();
        t = t.toLowerCase();
        if (k.length() != t.length()){ // rotate cchhesina anntha matranna length maradu 
            System.out.print("false");
            return;
}
        String l = k + k;
        if(l.contains(t)){
            System.out.print("true");
        }
        else{
            System.out.print("false");
        }
    }
}