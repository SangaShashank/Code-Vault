/*Given two numbers N and M, find the Nth root of M. The Nth root of a number M is defined as a number X such that when X is raised to the power of N, it equals M. If the Nth root is not an integer, return -1.

Example 1:
Input: N = 3, M = 27

Output: 3

Explanation: The cube root of 27 is equal to 3.

Example 2:
Input: N = 4, M = 69

Output:-1

Explanation: The 4th root of 69 does not exist. So, the answer is -1.

Example 3:
Input: N = 4, M = 81

Output:
3 */
import java.util.*;
public class Find_Nth_Root_of_a_Number{
    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int m = s.nextInt();
        System.out.println(app1(n,m));
        System.out.println(app2(n,m));
        System.out.println(app3(n,m));
    }
    public static int app1(double n,double m){
        double pow = Math.pow(m,1/n);
        System.out.print(pow );
        if((pow - Math.ceil(pow))==0){ // integer aa kada ani check chestunnam
            return (int)pow;
        }
        return -1;
    } // understand y it is failing 
    public static int app2(int n,int m){
        int x = 0;
        while(true){
            if(Math.pow(x,n) == m) return x;
            else if(Math.pow(x,n)<m) x++;
            else return -1;
        }
    }
    public static int app3(int n,int m){
        int low = 0, high = m; // aa number ee high pedtam 
        while(low<= high){
            int mid = low + (high - low)/2;
            if(Math.pow(mid,n) == m) return mid;
            else if(Math.pow(mid,n)<m) low = mid +1;
            else high = mid -1;
        }
        return -1;
    }
}
//claude : 
/*import java.util.*;

public class Find_Nth_Root_of_a_Number {

    // 0 -> mid^n < m,  1 -> mid^n == m,  2 -> mid^n > m
    static int compare(int mid, int n, int m) {
        long ans = 1;
        for (int i = 0; i < n; i++) {
            ans *= mid;
            if (ans > m) return 2;   // early exit, so no overflow
        }
        return ans == m ? 1 : 0;
    }

    // Method 1: Brute force (linear search on the answer)
    static int bruteForce(int n, int m) {
        for (int x = 1; x <= m; x++) {
            int c = compare(x, n, m);
            if (c == 1) return x;    // exact root found
            if (c == 2) return -1;   // went past m, so no integer root
        }
        return -1;
    }

    // Method 2: Binary search on the answer (optimal, interview answer)
    static int binarySearch(int n, int m) {
        int low = 1, high = m;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int c = compare(mid, n, m);
            if (c == 1) return mid;
            else if (c == 0) low = mid + 1;   // mid^n too small, go right
            else high = mid - 1;              // mid^n too big, go left
        }
        return -1;
    }

    // Method 3: Round and verify (math shortcut)
    static int roundAndVerify(int n, int m) {
        int r = (int) Math.round(Math.pow(m, 1.0 / n));  // candidate only
        return compare(r, n, m) == 1 ? r : -1;           // exact check
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int m = s.nextInt();
        System.out.println(bruteForce(n, m));
        System.out.println(binarySearch(n, m));
        System.out.println(roundAndVerify(n, m));
    }
} */