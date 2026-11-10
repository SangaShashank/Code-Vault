/*You are given a sorted array of integers arr and an integer target. Your task is to determine how many times target appears in arr.

Return the count of occurrences of target in the array.

Example 1:
Input: arr = [0, 0, 1, 1, 1, 2, 3], target = 1

Output: 3

Explanation: The number 1 appears 3 times in the array.

Example 2:
Input: arr = [5, 5, 5, 5, 5, 5], target = 5

Output: 6

Explanation: All elements in the array are 5, so the target appears 6 times. */
import java.util.*;
public class Count_Occurrences_in_a_Sorted_Array{
    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int arr [] = new int[n];
        for(int i=0;i<n;i++) arr[i] = s.nextInt();
        int target = s.nextInt();
        System.out.print(app1(arr, target));
    }
    public static int app1(int arr[], int target){
        int low = 0, high = arr.length - 1;
        while(low <= high ){
            int mid = low + (high - low )/2;
            if()
        }
    }
}