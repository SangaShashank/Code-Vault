// ============================================
// Given a string, find the length of the longest substring that contains no vowels (a, e, i, o, u).

// Approach:
// Use a Variable Sliding Window with two pointers left and right. Expand right freely across the string. When a vowel is encountered, reset left to right + 1. Track the maximum window size throughout.

// Constraints:
// 1 <= length of string <= 50

// Sample Input and Output 1:
// Input:  ttrrcaamppttz
// Output: 4
// Explanation: 'pptt' is the longest window with no vowels (length 4)

// Sample Input and Output 2:
// Input:  aeiou
// Output: 0

// Sample Input and Output 3:
// Input:  rhythm
// Output: 6
// Explanation: Entire string has no vowels

// Concept: Variable Sliding Window — expand right, reset left on vowel hit
//ali bhai 
import java.util.*;
class fds30
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        String s=sc.nextLine().toLowerCase();
        int left=0,right=0;
        int maxLen=0;
        for(right=0;right<s.length();right++)
        {
            char ch=s.charAt(right);
            if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u')
            {
                left=right+1;
            }
            else
            {
                maxLen=Math.max(maxLen,right-left+1);
            }
            
            
        }
        System.out.println(maxLen);
    }
}