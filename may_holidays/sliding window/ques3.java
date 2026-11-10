/*Given an array of daily temperatures and an integer k=3, return the maximum 
average temperature over any k consecutive days*/
import java.util.*;
public class ques3 {
    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int arr [] = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = s.nextInt();
        }
        int k = s.nextInt();
        int sum = 0;
        for(int i=0;i<k;i++){
            sum = sum + arr[i];
        }
        int m = sum;
        for(int i=k;i<arr.length;i++){
            sum += arr[i];
            sum -= arr[i-k];
            m = Math.max(sum,m);
        }
        System.out.println(m/k);
    }
    
}
