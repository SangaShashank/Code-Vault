/*Problem:
Reverse characters in each word but maintain word order.
Examples:
Input: "Let's take LeetCode contest"
Output: "s'teL ekat edoCteeL tsetnoc"

Input: "Hello World"
Output: "olleH dlroW"*/
import java.util.*;
public class Reverse_Words_in_a_String_III_557{
    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        String a = s.nextLine();
        String [] a2 = a.split(" ");
        StringBuilder res  = new StringBuilder();
        for(String x : a2){
            char [] x2 = x.toCharArray();
            int i=0,j=x.length() - 1;
            while(i<j){
                char temp = x2[i];
                x2[i] = x2[j];
                x2[j] = temp;
                i++; j--;
                
            }
            // System.out.println(x2);
            res.append(x2);
            res.append(" ");
        }
        System.out.print((res));
    }
}
// chatgpt code form my idea 

class Solution {

    public String reverseWords(String s) {

        char[] arr = s.toCharArray();

        int i = 0;

        while (i < arr.length) {

            // Skip spaces
            while (i < arr.length && arr[i] == ' ') {
                i++;
            }

            int j = i;

            // Find the end of the word
            while (j < arr.length && arr[j] != ' ') {
                j++;
            }

            // Reverse the current word
            reverse(arr, i, j - 1);

            // Move to the next word
            i = j + 1;
        }

        return new String(arr);
    }

    public void reverse(char[] arr, int i, int j) {

        while (i < j) {

            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;

            i++;
            j--;
        }
    }
}
