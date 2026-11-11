/*
A warehouse dispatch system recorded the outgoing shipment as a string s.
Each character in the string represents a type of item (lowercase English letters).
After delivery, the received shipment is recorded as string t.

It is observed that:
t contains all original items from s (possibly shuffled).
Exactly one extra item was mistakenly added during shipment.
Your task is to identify and return the extra item type.
 
 Input Format 
s = original_shipment
t = received_shipment

Output Format
extra_item

Return the single lowercase character that represents the extra item.
 Constraints
0 <= s.length <= 1000
t.length == s.length + 1
s and t consist only of lowercase English letters

Exactly one extra item exists in t

Sample Test Cases
Test Case1
input=programming
rprogramming
output=r
Test Case2
input=zzz
zzzz
output=z

*/
/*
//idhi ali bhai approach
// import java.util.*;
class fds15
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        String b = sc.nextLine();
        HashMap<Character, Integer> a1 = new HashMap<>();
        HashMap<Character, Integer> b1 = new HashMap<>();
        for(char i: a.toCharArray())
        {
            a1.put(i, a1.getOrDefault(i, 0)+1);
        }
        for(char j: b.toCharArray())
        {
            b1.put(j, b1.getOrDefault(j, 0)+1);
        }
        for(char k: b1.keySet())
        {
            int c1 = a1.getOrDefault(k, 0);
            int c2 = b1.get(k);
            if(c1<c2)
            {
                System.out.println(k);
            }
        }
    }
}*/
// lets do by freq array
// idhi nenu chesina 
import java.util.*;
public class Valid_Anagram_Application_242{
    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        String s1 = s.nextLine();
        String s2 = s.nextLine();
        int freq [] = new int [26];
        for (char c : s1.toCharArray()){
            freq[c - 'a']++;
        }
        for(char c : s2.toCharArray()) freq[c-'a']--;
        for (int i=0;i<freq.length;i++){
            if(freq[i]!=0){
            System.out.println((char)(i+97)); // wow noiceee
            return ;
                
            }
        }
    }
}