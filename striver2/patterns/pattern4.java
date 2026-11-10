//13-08-2026
/*Given an integer n. You need to recreate the pattern given below for any value of N. Let's say for N = 5, the pattern should look like as below:



1

22

333

4444

55555 */
import java.util.*;
public class pattern4{
    public static void main(String ars[]){
        int n =5;
        app_2(n);
        for(int i=1;i<=n;i++){
            for(int j =0;j<i;j++){
                System.out.print(i);
            }
            System.out.println();
        } 
        
    }
    //deni time :  O(n^2) and space O(1)
    public static void app_2(int n){
        for(int i=0;i<n;i++){
            StringBuilder sb = new StringBuilder();
            for(int j=0;j<=i;j++){
                sb.append(i+1);
            }
            System.out.println(sb);
        }
    }
    //deni time kuda O(n^2) ee kani only one print statement tho ney aypiothadi 
}
//other best approches ai lo unnai 