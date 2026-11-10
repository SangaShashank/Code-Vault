/*For two strings s and t, we say "t divides s" if and only if s = t + t + t + ... + t + t (i.e., t is concatenated with itself one or more times).

Given two strings str1 and str2, return the largest string x such that x divides both str1 and str2.

 

Example 1:

Input: str1 = "ABCABC", str2 = "ABC"

Output: "ABC"

Example 2:

Input: str1 = "ABABAB", str2 = "ABAB"

Output: "AB"

Example 3:

Input: str1 = "LEET", str2 = "CODE"

Output: ""

Example 4:

Input: str1 = "AAAAAB", str2 = "AAA"

Output: ""​​​​​​​

 

Constraints:

1 <= str1.length, str2.length <= 1000*/ 
import java.util.*;
public class ques6 {
    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        String s1 = s.nextLine();
        String s2 = s.nextLine();
        System.out.print(app_1(s1,s2));
        System.out.print(app_2(s1,s2));
    }
    public static String app_1(String s1,String s2){
        int n = s1.length();
        int m= s2.length();
        int l = Math.min(s1.length(),s2.length());
        String t = "";
        if(n>m){
             t = s2;
        }
        else {
            t = s1;
        }
        while(l>0){
            if(n%l == 0 && m%l == 0){ // anntey possiblity unndi 
                t = t.substring(0,l);
                String k = t.repeat(n/l);
                String j = t.repeat(m/l);
                if(k.equals(s1) && j.equals(s2)){
                    return t;
                }
            }
            l--; 
        }
        return "";
    }
    public static String app_2(String s1, String s2){
        if(!(s1+s2).equals(s2+s1)) return "";
        int gcd = gcd(s1.length(),s2.length());
        return s1.substring(0,gcd);
    }
    public static int gcd(int a, int b){
        if(b==0) return a;
        else{
            return gcd(b,a%b);
        }
    }
    
}
