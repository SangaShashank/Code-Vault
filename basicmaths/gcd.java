/*You are given two integers n1 and n2. You need find the Greatest Common Divisor (GCD) of the two given numbers. Return the GCD of the two numbers.



The Greatest Common Divisor (GCD) of two integers is the largest positive integer that divides both of the integers.


Example 1

Input: n1 = 4, n2 = 6

Output: 2

Explanation: Divisors of n1 = 1, 2, 4, Divisors of n2 = 1, 2, 3, 6

Greatest Common divisor = 2.

Example 2

Input: n1 = 9, n2 = 8

Output: 1

Explanation: Divisors of n1 = 1, 3, 9 Divisors of n2 = 1, 2, 4, 8.

Greatest Common divisor = 1. */
import java.util.*;
class gcd{
    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        int n1= s.nextInt();
        int n2 = s.nextInt();
        approch_2(n1,n2);
        approch_3(n1,n2);
        int ans = 1;
        for(int i=2;i<=Math.min(n1,n2);i++){
            if((n1%i==0) && (n2%i==0)){
                ans = i;
            }
            //System.out.println(i);
        }
        System.out.println(ans);

    }
public static void approch_2(int n1,int n2){
    for(int i=Math.min(n1,n2);i>=1;i--){
        if(n1%i == 0 && n2%i == 0){
            System.out.println(i);
            break;
        }
    }
}
public static void approch_3(int a,int b){
    while (a>=0 && b >=0){
        if (a==0){
            System.out.println(b);
            break;
        }
        else if(b==0){
        System.out.println(a);
        break;}
        else if(a>b){
            a = a%b;
        }
        else if(b>a){
            b = b%a ;
        }
    }
}
}