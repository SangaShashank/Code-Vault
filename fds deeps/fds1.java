/*Problem:
Reverse every group of k elements in an array. If remaining elements are less than k, reverse all of them.
Examples:
Input: arr = [1, 2, 3, 4, 5, 6, 7, 8], k = 3
Output: [3, 2, 1, 6, 5, 4, 8, 7]
Explanation: First 3 reversed, next 3 reversed, last 2 reversed

Input: arr = [1, 2, 3, 4, 5], k = 2
Output: [2, 1, 4, 3, 5]
What will happen for 
k = 1
k >= array length 
k = 0 
*/
//my apporach : 
/*import java.util.*;
class fds1{
    public static void main(String args[]){
        /*Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int k = s.nextInt();
        int a[] = new int[n];
        for(int i = 0;i<n;i++){
            a[i] = s.nextInt();
        }*/
    //    int a [] = {4,5,6,7,8,9,10,11};
    //    int k = 3;
       /*int l = 0;
        for(int i=0;i<a.length - 1;i=i+k-1){
            //System.out.println(i);
            int x = i;
            int j=i+k-1;
            l=j+1;
            //System.out.println(j);
            while(x<j){
                int temp = a[x];
                a[x] = a[j];
                a[j] = temp;
                x--;
                i++;

            }
            
        }
        //for last elements:
        int y = a.length - 1;
        while(l<y){
            int temp = a[l];
                a[l] = a[y];
                a[y] = temp;
                y--;
                l++;
        }
        
        for(int i = 0;i<a.length;i++){
            System.out.print(" "+a[i]);
        }
    }
}
*/
import java.util.*;

class Reverse_Array_In_Groups {
    public static void main(String args[]) {

        int[] a = {4, 5, 6, 7, 8, 9, 10, 11};
        int k = 3;
        int n = a.length;

        if (k <= 0) {
            System.out.println("Invalid k");
            return;
        }

        for (int i = 0; i < n; i += k) {

            int left = i;
            int right = Math.min(i + k - 1, n - 1);

            while (left < right) {
                int temp = a[left];
                a[left] = a[right];
                a[right] = temp;
                left++;
                right--;
            }
        }

        System.out.println(Arrays.toString(a));
    }
}
/* shreni :
public static void m1(int a1[],int a[],int k,int n){
        a1[0]=a[k];
        int i=k + 1;
        int j=1;
        while(i!=k){
            a1[j]=a[i];
            i=(i + 1)%n;
            j++;
        }
        System.out.print(Arrays.toString(a1));
    }*/