/*Implement a phone number letter combination generator. Given a digit string, return all possible letter combinations (like a T9 keyboard).
Input:  "23"
Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
Constraints: Digits 2-9 only. Use a Map for digit-to-letters mapping.
Hint
Hide follow-up
Mark solved
Explain solution ↗
Follow-up: How many combinations are possible for a 10-digit number? Is recursion or iteration better here?*/
import java.util.*;
public class ques6 {
    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        String s1 = s.nextLine();
        HashMap <Character,String > map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
    char arr [] = s1.toCharArray();
    for(int i=0;i<arr.length;i++){
        for(int j=i+1;j<arr.length;j++){
            mixing()
        }
    }
    }
}
