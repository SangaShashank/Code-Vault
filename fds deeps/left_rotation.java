/* left rotation by k steps */
// m - 1 : 
import java.util.*;
class left_rotation{
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
        int k = 5;
        int n = a.length; // PAKKA length ee undali not n-1
        if(k>n) k = k%n;
        // s1 : revere complete 
        reverse(a,0,n-1);
        System.out.print(Arrays.toString(a));
        int  h = n-k;
        reverse(a,0,h-1);
        System.out.print(Arrays.toString(a));
        //s3 : reverse remanining elements :
        reverse(a,h,n-1);
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
            result[i] = arr[(i+k)%n];
        }

        System.out.println(Arrays.toString(result));
    }
}
 */
//https://claude.ai/share/809403b9-17aa-4c58-b41e-a79c02f6579a