/*Given an array of integers nums and an integer limit as the threshold value, find the smallest positive integer divisor such that upon dividing all the elements of the array by this divisor, the sum of the division results is less than or equal to the threshold value.

After dividing each element by the chosen divisor, take the ceiling of the result (i.e., round up to the next whole number).

Example 1:
Input: nums = [1, 2, 3, 4, 5], limit = 8

Output: 3

Explanation: We can get a sum of 15(1 + 2 + 3 + 4 + 5) if we choose 1 as a divisor. 

The sum is 9(1 + 1 + 2 + 2 + 3) if we choose 2 as a divisor. Upon dividing all the elements of the array by 3, we get 1,1,1,2,2 respectively. Now, their sum is equal to 7 <= 8 i.e. the threshold value. So, 3 is the minimum possible answer.

Example 2:
Input: nums = [8,4,2,3], limit = 10

Output: 2

Explanation: If we choose 1, we get 17 as the sum. If we choose 2, we get 9 (4+2+1+2) <= 10 as the answer. So, 2 is the answer.*/
import java.util.*;
public class Find_the_Smallest_Divisor {
    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        int n  = s.nextInt();
        int arr [] = new int [n];
        for(int i=0;i<n;i++) arr[i] = s.nextInt();
        int limit = s.nextInt();
        System.out.println(app1(arr,limit));
        System.out.println(app2(arr,limit));
    }
    public static int app1(int arr[], int limit){
        double x = 1; // inorder to statify the divide condition exactly we need double not int 
        while(true){
            if(check_divide(arr,x,limit)){
                return (int)x;
            }
            x++;
        }

    }
    public static boolean check_divide(int arr[], double x ,int limit){ // double kavali
        int sum = 0;
        for(int i=0;i<arr.length;i++){
            sum += Math.ceil(arr[i]/x);
            if(sum>limit) return false;

        }
        return true;
    }
    public static int app2(int arr[],int limit){
        int low = 1; // smallest divisor one ee kada
        int high = Integer.MIN_VALUE; 
        for(int x : arr) high = Math.max(high,x);
        int res = -1;
        while(low <= high){
            int mid = low + (high-low)/2;
            if(check_divide(arr, mid, limit)){
                res = mid;
                high = mid - 1;
            }
            else{
                low = mid +1;
            }
        }
        return res;
    }
}
//claude code :
/*import java.util.*;
public class Find_the_Smallest_Divisor {
    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        int n  = s.nextInt();
        int arr [] = new int [n];
        for(int i=0;i<n;i++) arr[i] = s.nextInt();
        int limit = s.nextInt();
        System.out.println(app1(arr,limit));
        System.out.println(app2(arr,limit)); // ADDED: call the optimal approach too
    }

    // ---------- Approach 1: Brute force ----------
    public static int app1(int arr[], int limit){
        if (limit < arr.length) return -1;   // ADDED: sum is always >= n, so no divisor can work
        // ee pattern nen notice cheyale
        int max = Integer.MIN_VALUE;         
        for (int v : arr) max = Math.max(max, v);

        // CHANGED: double x -> int x, and while(true) -> bounded loop (1..max).
        // At d = max the sum is exactly n <= limit, so an answer always exists by then.
        for (int x = 1; x <= max; x++) {
            if (check_divide(arr, x, limit)) {
                return x;                    // CHANGED: no (int) cast needed now
            }
        }
        return -1;                           // ADDED: safety return, never reached after the guard
    }

    // ---------- Approach 2: Binary search on the answer ----------
    public static int app2(int arr[], int limit){
        if (limit < arr.length) return -1;   // ADDED: impossible case, as you reasoned

        int low = 1;                         // smallest divisor is 1
        int high = Integer.MIN_VALUE;
        for(int x : arr) high = Math.max(high,x); // high = max(nums): sum is n here, can't improve beyond
        int res = -1;
        while(low <= high){
            int mid = low + (high-low)/2;
            if(check_divide(arr, mid, limit)){
                res = mid;                   // mid works, but a smaller divisor might also work
                high = mid - 1;
            }
            else{
                low = mid + 1;               // mid fails, so we need a bigger divisor
            }
        }
        return res;
    }

    // ---------- Check function ----------
    // CHANGED: parameter double x -> int x
    public static boolean check_divide(int arr[], int x, int limit){
        long sum = 0;                        // CHANGED: int -> long to avoid overflow at small divisors
        for(int i=0;i<arr.length;i++){
            // CHANGED: Math.ceil(arr[i] / x) -> integer ceiling formula (a + d - 1) / d.
            // The (long) cast keeps a + d - 1 from overflowing int.
            sum += ((long) arr[i] + x - 1) / x; // ade formula rasina chudu paina
            if(sum > limit) return false;    // early exit, kept from your version
        }
        return true;
    }
} */
//https://claude.ai/share/a7553df5-77bf-4250-9e8e-f372246cf787
