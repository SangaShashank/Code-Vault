/*You are given an integer n. Return the value of n! or n factorial.



Factorial of a number is the product of all positive integers less than or equal to that number.


Example 1

Input: n = 2

Output: 2

Explanation: 2! = 1 * 2 = 2.

Example 2

Input: n = 0

Output: 1

Explanation: 0! is defined as 1.*/
import java.util.*;
public class factorial {
    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        if(n<0){
            return;
        }
        System.out.println(fact(n));
    }
    public static long fact(int n ){
        if(n == 0 || n == 1){
            return 1;

        }
        return  n *fact(n-1);
    }
}
// 16- 9- 26 : https://claude.ai/share/cf1ccf75-ebd1-47b4-8842-a43c3d9ea05d