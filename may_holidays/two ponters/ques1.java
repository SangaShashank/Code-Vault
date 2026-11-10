/*Given an integer array, sort it containing 0s, 1s, and 2s in-place without using any sort function.
Input:  [2, 0, 2, 1, 1, 0]
Output: [0, 0, 1, 1, 2, 2]
Constraints: One-pass, O(1) extra space. (Dutch National Flag problem)
Hint
Hide follow-up
Mark solved
Explain solution ↗
Follow-up: Can you do this in a single pass? What is the loop invariant? */
import java.util.*;
public class ques1{
    public static void main(String args[]){
        int arr []= {2,0,2,1,1,0};
        int i=0, j = arr.length -1;
        while(i<j){
            if(arr[i]>arr[j]){
                if(arr[i] == 2 && arr[j] == 0){
                    int temp = 
                }
            }
        }
    }
}