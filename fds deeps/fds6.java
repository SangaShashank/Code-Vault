/* right rotation by k steps */
// m - 1 : 
import java.util.*;
class fds6{
    public static void reverse(int a[],int s,int e){
        while(s<e){
            int temp = a[s];
            a[s] =a[e];
            a[e] = temp;
            s++ ; e--;
        }
    }
    public static void main(String args[]){
        int a [] = {1,2,3,4,5,6};
        int k = 4;
        // super imp : if k > n then use k = k % n 
        int n = a.length; // PAKKA length ee undali not n-1
        // s1 : revere complete 
        reverse(a,0,n-1);
        System.out.print(Arrays.toString(a));
        //s2: reverse upto size%k 
        // System.out.print(6%4);
        int h = n % k ;
        reverse(a,0,h);
        System.out.print(Arrays.toString(a));
        //s3 : reverse remanining elements :
        reverse(a,h+1,n);
        System.out.print(Arrays.toString(a));
    }
}
// m - 2 : new array :
/*import java.util.*;

class RotateArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int k = 2;

        int n = arr.length;
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            result[(i + k) % n] = arr[i];
        }

        System.out.println(Arrays.toString(result));
    }
}
 */