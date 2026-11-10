/*Check whether a given string is a valid palindrome considering only alphanumeric
 characters and ignoring case.
Input:  "A man, a plan, a canal: Panama"
Output: true

Input:  "race a car"
Output: false
Constraints: O(n) time, O(1) space. Do not use extra string or StringBuilder. */
import java.util.*;
class ques2{
    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        String s1 = s.nextLine();
        int i=0, j =s1.length()-1;
        while(i<j){
            char ci = Character.toLowerCase(s1.charAt(i));
            char cj = Character.toLowerCase(s1.charAt(j));
            if(!(Character.isLetterOrDigit(ci))){
                i++;
                continue; // ivi chala imp 
            }
            if(!(Character.isLetterOrDigit(cj))){
                j--;
                continue;
            }
            if(ci != cj){
                System.out.println(ci); System.out.println(i);
                System.out.print(cj); System.out.println(j);
                System.out.println("not palindriome");
                return;
            }
            i++; j--;
        }
        System.out.println("palimdrome");
    }
}