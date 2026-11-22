/*
LeetCode 3 - Longest Substring Without Repeating Characters

Given a string s, find the length of the longest substring
without repeating characters.

A substring is a contiguous non-empty sequence of characters within a string.

Example 1:
Input:  s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length 3.

Example 2:
Input:  s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length 1.

Example 3:
Input:  s = "pwwkew"
Output: 3
Explanation: The answer is "wke", length 3.
Note: "pwke" is a subsequence, not a substring.

Constraints:
0 <= s.length <= 5 * 10^4
s consists of English letters, digits, symbols and spaces.

Concept: Variable Sliding Window + HashSet / last-index array
Approach:
  Expand right, add char to the set.
  If the char is already in the window, shrink from left until it is removed.
  Track max (right - left + 1).

Time: O(n)   Space: O(min(n, 26)) / O(128)
*/
import java.util.*;
public class longest_substring_Without_Repeating_Characters_3{
  public static void main(String args[]){
    Scanner s = new Scanner(System.in);
    String k = s.nextLine();
    System.out.print(app1(k));
  }
  public static int app1(String k){
    char k1 [] = k.toCharArray();
    HashSet<Character> window = new HashSet<>();
    int left = 0;
    int result = Integer.MIN_VALUE;
    for(int right = 0;right<k1.length;right++){
      while(window.contains(k1[right])){
        window.remove(k1[left]);
        left++;
      }
      window.add(k1[right]);
      result =  Math.max(result, right-left+1);
    }
    return result;
  }
}