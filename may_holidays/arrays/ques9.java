/*Given two strings s and t, return true if s is a subsequence of t, or false otherwise.
A subsequence of a string is a new string that is formed from the original
 string by deleting some (can be none) of the characters without disturbing the 
 relative positions of the remaining characters. 
 (i.e., "ace" is a subsequence of "abcde" while "aec" is not).
Example 1:
Input: s = "abc", t = "ahbgdc"
Output: true
Example 2:

Input: s = "axc", t = "ahbgdc"
Output: false
 

Constraints:

0 <= s.length <= 100
0 <= t.length <= 104
s and t consist only of lowercase English letters.
 

Follow up: Suppose there are lots of incoming s, say s1, s2, ..., sk where k >= 109, and you want to check one by one to see if t has its subsequence. In this scenario, how would you change your code*/import java.util.*;
public class ques9 {
    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        String s1 = s.nextLine();
        String s2 = s.nextLine();
        int i=0 , j=0;
        boolean res = app_2(s1,s2,i,j);
        System.out.print(res);
        while(i<s1.length()){
            if(j == s2.length()){
                System.out.print("true");
                return;
            }
            if(s1.charAt(i)==(s2.charAt(j))){
                i++; j++;
            }
            j++;
        }
    }
    public static boolean app_2(String s1,String s2 , int i, int j){
        if(j==s2.length()){
            return true;
        }
        if(i==s1.length()) return false;
        if(s1.length() ==  s2.length()){
            return app_2(s1,s2,i++,j++); // recursive call
        }
        else{
            return app_2(s1,s2,i,j++);
        }
    }
}
