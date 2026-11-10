/*Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value. If the target is not found in the array, return [-1, -1].

Example 1:
Input: nums = [5, 7, 7, 8, 8, 10], target = 8

Output: [3, 4]

Explanation:The target is 8, and it appears in the array at indices 3 and 4, so the output is [3,4]

Example 2:
Input: nums = [5, 7, 7, 8, 8, 10], target = 6

Output: [-1, -1]

Expalantion: The target is 6, which is not present in the array. Therefore, the output is [-1, -1].

Now Your Turn!
Pick the correct output for the given input
Input: nums = [5, 7, 7, 8, 8, 10], target = 5 */
import java.util.*;
public class First_and_last_occurrence{
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int arr [] = new int[n];
        for(int i=0;i<n;i++) arr[i] =s.nextInt();
        int target = s.nextInt();
        System.out.print(Arrays.toString(app1(arr,n,target)));
        System.out.print(Arrays.toString(app2(arr,n,target)));
    }
    public static int [] app1(int arr[],int n,int target){
        int res[] = new int [2];
        int i=0, j=n-1;
        while(i<=j){
        if(arr[i] < target && arr[j]>target){
            i++; j--;
        }
        if(arr[i]== target && arr[j] == target) {
            res[0] = i; res[1] = j;
            return res;
        }
        if((arr[i] > target || arr[j]<target)){
            res[0] = -1;res[1] = -1;
            return res;
        }
        //only i increases
        if(arr[i]<target) i++;
        if(arr[j]>target) j--;
    }
    return new int[]{-1, -1};
    }
    // Approach 2: two binary searches. Time O(log n), space O(1)
    public static int[] app2(int arr[], int n, int target) {
        return new int[]{first(arr, n, target), last(arr, n, target)};
    }

    // Binary search 1: first occurrence, or -1 if not present
    static int first(int arr[], int n, int target) {
        int low = 0, high = n - 1;
        int result = -1;                      // stays -1 if target is missing

        while (low <= high) {
            int mid = low + (high - low) / 2; // avoids overflow

            if (arr[mid] == target) {
                result = mid;                 // save as possible answer
                high = mid - 1;               // keep looking on the left
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return result;
    }

    // Binary search 2: last occurrence, or -1 if not present
    static int last(int arr[], int n, int target) {
        int low = 0, high = n - 1;
        int result = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == target) {
                result = mid;                 // save as possible answer
                low = mid + 1;                // keep looking on the right
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return result;
    }
}
