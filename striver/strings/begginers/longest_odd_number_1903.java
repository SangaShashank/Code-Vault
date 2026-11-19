/*Given a string s, representing a large integer, the task is to return the largest-valued odd integer (as a string) that is a substring of the given string s.

The number returned should not have leading zero's. But the given input string may have leading zero. (If no odd number is found, then return empty string.)

Example 1:
Input : s = "5347"

Output : "5347"

Explanation :

The odd numbers formed by given strings are --> 5, 3, 53, 347, 5347.

So the largest among all the possible odd numbers for given string is 5347.

Example 2:
Input : s = "0214638"

Output : "21463"

Explanation :

The different odd numbers that can be formed by the given string are --> 1, 3, 21, 63, 463, 1463, 21463.

We cannot include 021463 as the number contains leading zero.

So largest odd number in given string is 21463.*/
import java.util.*;
public class longest_odd_number_1903{
    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        String k = s.nextLine();
        int i = 0, j = k.length()-1;
        while(i<k.length() && k.charAt(i) == '0') i++;
        while(j>=0){
            int a = k.charAt(j) - '0';
            if(a%2!=0) break;
            j--;
        }
        if(j<i){ System.out.print(""); return ; }// imp edges case 
        System.out.print(k.substring(i,j+1)); // inclusive kadu kada 
    }
}
//https://claude.ai/share/af57b2ea-3aa4-4d65-99f9-e697dd8dde96