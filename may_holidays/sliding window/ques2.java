/*Find the longest subarray with sum equal to k.
Input:  arr = [10, 5, 2, 7, 1, 9], k = 15
Output: 4  // subarray [5, 2, 7, 1]
Constraints: Array can have positive integers. O(n) time. */
import java.util.*;
public class ques2{
    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        String s1 = s.nextLine();
        s1 = s1.replace("[","");
        s1 = s1.replace("]","");
        System.out.print(s1);
        String s2 [] = s1.split(",");
        int arr [] = new int[s2.length];
        for(int i=0;i<s2.length;i++){
            arr[i] = Integer.parseInt(s2[i]);
        }
        int k = s.nextInt();
        int sum = 0; int l= 1; int j = 0; int i=0;
        int maxl = Integer.MIN_VALUE;
        while(i<arr.length){
            if(sum == k){
                maxl = Math.max(maxl , l);
                sum = sum + arr[i]; l++; i++;
            }
            else if(sum < k){
                sum = sum + arr[i]; l++; i++;
            }
            else {
                sum = sum - arr[j];
                j++; l--;
            }

        }
        System.out.println(maxl);
    }
}
