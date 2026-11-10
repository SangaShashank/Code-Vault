/*Given n roses and an array nums where nums[i] denotes that the 'ith' rose will bloom on the nums[i]th day, only adjacent bloomed roses can be picked to make a bouquet. Exactly k adjacent bloomed roses are required to make a single bouquet. Find the minimum number of days required to make at least m bouquets, each containing k roses. Return -1 if it is not possible.

Example 1:
Input: n = 8, nums = [7, 7, 7, 7, 13, 11, 12, 7], m = 2, k = 3

Output: 12

Explanation: On the 12th the first 4 flowers and the last 3 flowers would have already bloomed. So, we can easily make 2 bouquets, one with the first 3 and another with the last 3 flowers.

Example 2:
Input: n = 5, nums = [1, 10, 3, 10, 2], m = 3, k = 2

Output: -1

Explanation: If we want to make 3 bouquets of 2 flowers each, we need at least 6 flowers. But we are given only 5 flowers, so, we cannot make the bouquets.

Now Your Turn!
Pick the correct output for the given input
Input: n = 5, nums = [1, 10, 3, 10, 2], m = 3, k = 1


10

1

2

3
Still unsure what the problem is asking ?

Let’s go through a few more examples, step by step, to make it clearer.

Constraints:
 1 <= n <= 105
 1 <= nums[i] <= 109
 1 <= m <= 106
 1 <= k <= n
Advertisements


Hints
Hint 1
Hint 2
Frequently Occurring Doubts
How is bouquet feasibility checked efficiently?
Why use binary search to find the minimum days?
Interview Follow-up Questions
How would you handle non-adjacent bouquets?
What if the roses bloom asynchronously, with delays or dependencies?*/
import java.util.*;
public class Minimum_Days_to_Make_M_Bouquets {
    public static void main(String args[])    {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int arr [] = new int[n];
        for(int i=0;i<n;i++) arr[i] = s.nextInt();
        int m = s.nextInt();
        int k = s.nextInt();
        if ((long) m * k > n) {System.out.println(-1); return;}// ee line ne pettale , claude pettindi but antha imp emm kadu ,
        // ee line lekapoyina vastadi output just waste of computations anthey 
        System.out.println(app1(arr,n,m,k));
    }
    public static int app1(int arr[], int n,int m,int k){
        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;
        for(int x:arr) {
            low = Math.min(low,x);
            high = Math.max(high,x);
        }
        //System.out.println(low + " " + high);
        int res = -1;
        while(low<= high){
            int mid = low + (high-low)/2;
            //System.out.print(mid);
            if(calc_bouques(arr,n, k,mid)>= m){ // atleast kada
                res = mid;
                //System.out.print(res + " " + calc_bouques(arr,n, k,mid));
                high = mid -1;
            }
            else{
                low = mid +1;
            }
        }
        return res;
    }
    public static int calc_bouques(int arr[],int n,int k,int day){ // mid anntey aa day ni artham
        int i=0;
        int bouque_count = 0;
        while(i<n){
            if(arr[i]<= day) { // bloomed
                 int bouque = 0;
                /*while(i<n && i< i +k && arr[i]<= day ){ // mistake see in notes 
                    bouque ++; i++;
                }*/
               for(int j=0;j<k;j++){ // excatly k times run avali anntey best option for loop ee kada
                 if(i<n && arr[i]<= day) {
                    bouque ++; i++; 
                 }
               }
                if(bouque == k) bouque_count++;
            }
            else {
                i++;
            }
        }
        return bouque_count;
    }
}
//claude ichindi : 
/*static int count(int[] a, int k, int day) {
    int run = 0, bouquets = 0;
    for (int x : a) {
        if (x <= day) {
            run++;
            if (run == k) { bouquets++; run = 0; }
        } else run = 0;
    }
    return bouquets;
} */
//https://claude.ai/share/3b34564c-81b7-4ebd-b17d-5fd30e1510fe