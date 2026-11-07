/*Given a sorted array of unique positive integers arr, your task is to return the kᵗʰ missing positive number that is not present in arr.

The array is guaranteed to be strictly increasing, and the missing numbers are those positive integers that do not appear in arr but would appear in a full sequence starting from 1.

Example 1:
Input: arr = [3, 5, 7, 10], k = 6

Output: 9

Explanation:

The missing numbers are [1, 2, 4, 6, 8, 9, 11, ...]. The 6ᵗʰ missing number is 9.

Example 2:
Input: arr = [1, 4, 6, 8, 9], k = 3

Output: 5

Explanation:

The missing numbers are [2, 3, 5, 7, 10, ...]. The 3ʳᵈ missing number is 5.
Constraints:
1 <= arr.length <= 1000
1 <= arr[i] <= 1000
1 <= k <= 1000
arr[i] < arr[j] for all 1 <= i < j <= arr.length*/
import java.util.*;
public class Kth_Missing_Positive_Number {
    public static void main(String args[])    {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int arr [] = new int [n];
        for(int i=0;i<n;i++) arr[i] = s.nextInt();
        int k = s.nextInt();
        System.out.println(app1(arr,k));
    }
    public static int app1(int arr[],int k){
        int x = 1; int count = 0;
        while(true){
            if(!is_present(arr,x)){
                count++;
            }
            if(count == k){
                return x;
            }
            x++;
            }
    }
    public static boolean is_present(int arr[],int x){
        int low = 0, high = arr.length-1;
        while(low <= high ){
            int mid = low + (high -low)/2;
            if(arr[mid] == x) return true;
            else if(arr[mid]>x) high = mid -1;
            else low = mid +1;
        }
        return false;
    }
}
