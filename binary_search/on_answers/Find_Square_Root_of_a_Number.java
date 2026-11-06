/*Given a positive integer n. Find and return its square root. If n is not a perfect square, then return the floor value of sqrt(n).

Example 1:
Input: n = 36

Output: 6

Explanation: 6 is the square root of 36.

Example 2:
Input: n = 28

Output: 5

Explanation: The square root of 28 is approximately 5.292. So, the floor value will be 5. */
import java.util.*;
public class Find_Square_Root_of_a_Number{
    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        System.out.print(app1(n)); // ofc bakwas
        System.out.println(app2(n)); // ofc optimal
        System.out.println(app3(n));
    }
    public static int  app1(int n ){
        return (int ) Math.floor(Math.sqrt(n)); // answer double lo vastadi 
    }
    public static int app2(int n){
        int low = 0 , high = n;  // high machiga chuskoo
        int res = -1;
        while(low<=high){
        int mid = low + (high-low)/2;
        if((long)mid*mid<= n){
            res = mid;
           low = mid+1;
        }
        else{
            high = mid -1;
        }
        }
        return res;
    }
    public static int app3(int n){ // intha chinna visyam rayaniki chala time pattindi (sad)
        int i= 0;
        while((long)i*i<=n) i++;
        return i -1; 
    }

}
// long anede endukoo see in clude 
//https://claude.ai/share/4c2deaa2-0923-4d90-820b-b4954890f107