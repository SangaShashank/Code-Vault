/*A monkey is given n piles of bananas, where the 'ith' pile has nums[i] bananas. An integer h represents the total time in hours to eat all the bananas.
Each hour, the monkey chooses a non-empty pile of bananas and eats k bananas. 
If the pile contains fewer than k bananas, the monkey eats all the bananas in that 
pile and does not consume any more bananas in that hour. // chala imp line idhi enduku anntey high value ni determine chesidi idhey 

Determine the minimum number of bananas the monkey must eat per hour to finish all the bananas within h hours.

Example 1:
Input: n = 4, nums = [7, 15, 6, 3], h = 8

Output: 5

Explanation: If Koko eats 5 bananas/hr, he will take 2, 3, 2, and 1 hour to eat the piles accordingly. So, he will take 8 hours to complete all the piles.  

Example 2:
Input: n = 5, nums = [25, 12, 8, 14, 19], h = 5

Output: 25

Explanation: If Koko eats 25 bananas/hr, he will take 1, 1, 1, 1, and 1 hour to eat the piles accordingly. So, he will take 5 hours to complete all the piles.

Example 3:
Input: n = 4, nums = [3, 7, 6, 11], h = 8

Output:
4*/
import java.util.*;
public class Koko_Eating_Bananas {
public static void main(String args[])    {
    Scanner s = new Scanner(System.in);
    int n = s.nextInt();
    int arr [] = new int[n];
    for(int i=0;i<n;i++) arr[i] = s.nextInt();
    int hours = s.nextInt();
    System.out.println(app1(arr,n,hours));
}
public static int app1(int arr[], int n,int hours){
    int low = 1;
    int high = Integer.MIN_VALUE;
    for(int x : arr) high = Math.max(high,x);
    int res = -1;
    while(low<= high){
        int mid = low + (high - low)/2;
        int req_hours = calc_hours(arr,n,mid);
        System.out.println(req_hours + " " + mid);
        if(req_hours<= hours) {
            res = mid;
            high = mid -1;
        } 
        else{
            low = mid +1;
        }
    }
    return res;
}
public static int calc_hours(int arr[], int n,double speed){ // divison kosam
    int req_hours = 0;
    for(int i=0;i<n;i++){
        req_hours += Math.ceil(arr[i]/speed);
        System.out.println(req_hours);
    }
    return req_hours;
}
}
// already motu somasa chesinam kada 
