/*You are given an integer n. You need to check if the number is prime or not. Return true if it is a prime number, otherwise return false.



A prime number is a number which has no divisors except 1 and itself.


Example 1

Input: n = 5

Output: true

Explanation: The only divisors of 5 are 1 and 5 , So the number 5 is prime.

Example 2

Input: n = 8

Output: false

Explanation: The divisors of 8 are 1, 2, 4, 8, thus it is not a prime number. */
import java.util.*;
public class primeno{
    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        boolean res = false;
        for(int i=2;i<n;i++){
            // i * i <= n best 
            if(n%i ==0){
                //System.out.println("%d is not a prime number",n);
                //ln rayaddu annta 
                System.out.printf("%d is not a prime number",n);
                res = true; 
                break;
            }
        }
        if(res == false)
        System.out.printf("%d is a prime number",n);
    }
}
// time complexity --> O(n)
//space complexity --> O(1)
//when changed to root n 
// time ---> O(root(n)) and space --> O(1)
// edge cases : n = 1, 