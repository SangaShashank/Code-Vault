/*Given an integer array nums of size n, sorted in ascending order with distinct values. 
The array has been right rotated an unknown number of times, between 0 and n-1 (including). 
Determine the number of rotations performed on the array.

Example 1:
Input : nums = [4, 5, 6, 7, 0, 1, 2, 3]

Output: 4

Explanation: The original array should be [0, 1, 2, 3, 4, 5, 6, 7]. So, we can notice that the array has been rotated 4 times.

Example 2:
Input: nums = [3, 4, 5, 1, 2]

Output: 3

Explanation: The original array should be [1, 2, 3, 4, 5]. So, we can notice that the array has been rotated 3 times.*/
import java.util.*;
public class Find_Number_of_Times_Array_is_Rotated{
    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int arr [] = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = s.nextInt();
        }
        System.out.println(app1(arr,n));
        
    }
    public static int app1(int arr[],int n){
        int low = 0, high = n-1;
        int min_value= Integer.MAX_VALUE;
        int min_index = -1;
        while(low<=high){
            int mid = low + (high -low)/2;
            if(arr[mid]>=arr[low]){ // left sorted
                if(min_value> arr[low]){ // ofc min element is low 
                    min_value = arr[low];
                    min_index = low;
                }
                low = mid +1;
            }
            else{
              if(min_value >arr[mid]){
                    min_value = arr[mid];
                    min_index = mid;
                }
                high = mid -1;
            }
        }
        return min_index;
    }
}
//https://claude.ai/share/cd137ef9-db32-4f1f-b074-5d1dc24d7288