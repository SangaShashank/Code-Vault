/*Problem:
Reverse characters in each word but maintain word order.
Examples:
Input: "Let's take LeetCode contest"
Output: "s'teL ekat edoCteeL tsetnoc"

Input: "Hello World"
Output: "olleH dlroW"*/
import java.util.*;
class fds4{
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