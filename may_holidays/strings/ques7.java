/*Given two strings s and t, return true if s is a subsequence of t, or false otherwise.

A subsequence of a string is a new string that is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not).

 

Example 1:

Input: s = "abc", t = "ahbgdc"
Output: true
Example 2:

Input: s = "axc", t = "ahbgdc"
Output: false */
import java.util.*;
public class ques7{
    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        String s1 = s.nextLine();
        String t = s.nextLine();
        if(s1.length() >t.length()){{
            return ;
        }
        }
        int i=0,j=0;
        boolean res = app_2(s1,t,i,j);
        System.out.print(res);
        while(t.length()>j){
            if(s1.length()==i){
                System.out.print("true");
                return;
            }
            if(s1.charAt(i)==t.charAt(j)){
                i++;j++;
            }
            else{
                j++;
            }

        }
        if(s1.length()==i){
            System.out.print("True"); // this is an imp case 
        }
        else{
            System.out.print("False");
        }

    }
    public static boolean app_2(String s1,String t,int i,int j){
        if(s1.length()==i){
            return true;
        }
        else if (t.length()==j){
            return false;
        }
        else if(s1.charAt(i)==t.charAt(j)){
            //return app_2(s1,t,i++,j++); // mistake 
            return app_2(s1,t,i+1,j+1);
        }
        else{
            return app_2(s1,t,i,j+1);
        }
    }
}