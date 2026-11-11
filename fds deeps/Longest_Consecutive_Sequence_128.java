/*Given an array of integers, find the length of the longest
 subsequence such that elements in the subsequence are consecutive integers.
  The consecutive numbers can be in any order.

Sample Input and Output 1:
Input:  arr[] = {1, 9, 3, 10, 4, 20, 2}
Output: 4
Explanation: The subsequence 1, 2, 3, 4 is the longest consecutive subsequence

Sample Input and Output 2:
Input:  arr[] = {36, 41, 56, 35, 44, 33, 34, 92, 43, 32, 42}
Output: 5
Explanation: The subsequence 36, 35, 33, 34, 32 is the longest

Concept: Hashing / HashSet — O(n) approach
*/import java.util.*;
public class Longest_Consecutive_Sequence_128{
    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        String s1 [] = s.nextLine().split(",");
        HashSet <Integer> h = new HashSet<>();
        ArrayList <Integer > l = new ArrayList<>();
        for (String i : s1){
            h.add(Integer.parseInt(i));
        }
        //System.out.print(h);
        for (int i: h){
            if(!h.contains(i-1)){
                int c = 1;
                int j = i; // to go to next element 
                while(h.contains(j+1)){
                    c++;
                    j++;
                }
                l.add(c); // to track all the counts 
                //more correct : use math.max(c,res);
                }
            }
        l.sort(Collections.reverseOrder());
        System.out.print(l.get(0));
    }
    }