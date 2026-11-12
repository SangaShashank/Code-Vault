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
*/
import java.util.*;
public class Longest_Consecutive_Sequence_128{
    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        String s1 [] = s.nextLine().split(",");
        HashSet <Integer> h = new HashSet<>();
        ArrayList <Integer > l = new ArrayList<>();
        for (String i : s1){
            h.add(Integer.parseInt(i)); // ee step nen revison lo marchipoyina 
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
//approch 2:
/*public static int app2(int arr[]) {

        Arrays.sort(arr);

        int longest = 1;
        int c = 1;

        for(int i = 1; i < arr.length; i++) {

            if(arr[i] == arr[i-1]) {
                continue;
            }

            if(arr[i] == arr[i-1] + 1) {
                c++;
            }
            else {
                c = 1;
            }

            longest = Math.max(longest, c);
        }

        return arr.length == 0 ? 0 : longest; //idhi show kosam 
    } */    
