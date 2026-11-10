/*
Imagine you are developing a customer complaint tracking system.
Each complaint is represented as a lowercase string S, where:
Each character represents a complaint category.
Some categories are repeated multiple times.
The system needs to identify the first complaint category that appears only once, 
so it can be prioritized.
If no such unique complaint category exists, return -1.

Problem Statement
Given a string S consisting of only lowercase English letters,
 return the index of the first non-repeating character in the string.
If no unique character exists, return -1.
 Input Format:
A single string S
Output Format:
An integer representing the index of the first non-repeating character.
If none exists, return -1.
⚙ Constraints:
1 <= S.length <= 10^5
S consists only of lowercase English letters.
Sample Test Cases
Sample Input-1:
leetcode
Sample Output-1:
0
Sample Input-2:
loveleetcode
Sample Output-2:
2
Sample Input-3:
aabb
Sample Output-3:
-1
*/
/* idhi shreni and jaya code 
import java.util.*;
class fds17

{


    public static void main(String args[])
    

{


        Scanner s= new Scanner(System.in);
        String m=s.nextLine().toLowerCase();
        Map<Character,Integer> an=new LinkedHashMap<>();
        for(char i:m.toCharArray())
        

{


            an.put(i,an.getOrDefault(i,0)+1);
        

}
       // System.out.println(an);
        boolean o=false;
        for(char i:an.keySet()){
            if(an.get(i)==1)
            {
                System.out.println(m.indexOf(i));
                o=true;
                return;
            

}
        

}
        if(o==false)
        

{


            System.out.println("-1");
        

}
        
    

}

}*/
//idhi na code 
// and we can do by freq array aslo 
import java.util.*;
class fds17{
    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        String s1 = s.nextLine();
        //System.out.print(s1[2]);
        HashMap <Character, Integer> m = new HashMap<>();
        for(char c: s1.toCharArray()){
            m.put(c,m.getOrDefault(c,0)+1);
        }
        for(int i=0;i<s1.length();i++){
            if((m.get(s1.charAt(i)).equals(1))){
                System.out.print(i);
                return ;
            }
        }
        System.out.println("-1");
    }
}