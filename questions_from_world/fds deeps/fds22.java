/*
Imagine you are developing a digital newspaper system.
A user wants to create a custom news headline (ransomNote) 
using letters available from a printed newspaper page (magazine).
Rules:
Each letter from the magazine can be used only once.
You must determine whether the headline can be constructed using available letters.
If possible → return true
Otherwise → return false

Problem Statement

Given two strings:
ransomNote
magazine

Return true if ransomNote can be constructed using letters from magazine.
Otherwise, return false.

Each character in magazine can only be used once.

 Input Format:
First line  : ransomNote
Second line : magazine
Output Format:
Print true or false

Constraints:
1 <= ransomNote.length, magazine.length <= 10^5
Both strings consist of only lowercase English letters.

Sample Test Cases
Testcase1
input=aaa
aa
output=false

Testcase2
input=abc
cba
output:true

*/
import java.util.*;
class fds22{
    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        String ran = s.nextLine();
        String mag = s.nextLine();
        //int res =freqarray_apporach(mag,ran));
        int res = freqmap_approach(mag,ran);
        System.out.println(res == 1);   // direct ga function lo kuda print cheyaachu 
        //but oorikey show kosam converting int results into boolean 
    }
   public static int freqarray_apporach(String mag,String ran){
        mag =mag.toLowerCase();
        ran = ran.toLowerCase();
        if(mag.length()<ran.length()){
            return 0;                    // see fds book 
        }
        int freq [] = new int [26];// freq array , java by default initilizes with zero kada 
        for (char c : mag.toCharArray()){
            freq[c-'a']++; // see in fds note book
            
        }
        for (char c: ran.toCharArray()){
            freq[c-'a']--;
            
        }
        for (int i=0;i<freq.length;i++){
            if(freq[i]<0) 
            return 0;
        }
        return 1; 
    }
    public static int freqmap_approach(String mag,String ran){
        mag = mag.toLowerCase();
        ran = ran.toLowerCase();
        if(mag.length()<ran.length())
        return 0;
        
        Map <Character, Integer> m = new HashMap<>();
        for (char c : mag.toCharArray()){
            //m.put(c,c.getOrDefault(c,0)+1); okavela idhi marchipothey try this noob way
            if(m.containsKey(c)){
                m.put(c,m.get(c)+1);
                }
            else {
            m.put(c,1); 
            }
        }
        //System.out.print(m);
    for (char c : ran.toCharArray()){
        if(!m.containsKey(c)){
            return 0;
        }
        m.put(c,m.get(c)-1);
        }
    for(int val : m.values()){
        if (val<0){
            return 0; // checking over use of char 
        }
    }
    return 1;
}
}