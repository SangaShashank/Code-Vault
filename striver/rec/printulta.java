/*Given an integer n, write a function to print all numbers from n to 1 (inclusive) using recursion.

You must not use any loops such as for, while, or do-while.
The function should print each number on a separate line, in decreasing order from n to 1

Example 1

Input: 5

Output:

5

4

3

2

1

Example 2

Input: 1

Output:

1

Constraints

1 <= n <= 100*/
public class printulta{
    public static void main(String args[]){
        do_print(5);
    }
    public static void do_print(int n){
        if(n == 0){
            return;

        }
        System.out.println(n);
        do_print(n-1);
        System.out.println("shashi"); // just to make u understand how recusrrion works 
    }
}