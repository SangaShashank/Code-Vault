/*Given an integer N, return the sum of first N natural numbers. Try to solve this using recursion.


Example 1

Input : N = 4

Output : 10

Explanation : first four natural numbers are 1, 2, 3, 4.

Sum is 1 + 2 + 3 + 4 => 10.

Example 2

Input : N = 2

Output : 3

Explanation : first two natural numbers are 1, 2.

Sum is 1 + 2 => 3. */
public class sum_of_nterms{
    public static void main(String args[]){
        int n = 4; // if u want take input later
        int i=0,sum = 0;
        do_sum(n,i,sum);
        System.out.println(do_sum2(n));
        System.out.println(do_sum3(n));
        

    }
    static int sum2 = 0;
    public static void do_sum(int n,int i, int sum){
        if(i==n){
            System.out.println(sum);
            return;
        }
        i++;
        sum = sum + i;
        do_sum(n,i,sum);
    }
    
    public static int do_sum2(int n){
        if(n<=0){
            return sum2;
        }
        sum2 += n;
        return do_sum2(n - 1);
    }
    public static int do_sum3(int n){
        if(n==0){
            return 0;
        }
        return n + do_sum3(n-1);
    }

}