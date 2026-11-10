/*mplement binary search recursively. Return the index if the element is found, else return -1.
Input:  arr = [1, 3, 5, 7, 9, 11], target = 7
Output: 3
Constraints: Array is sorted. O(log n) time.
Hint
Hide follow-up
Mark solved
Explain solution ↗
Follow-up: How does recursion depth compare to iterative approach? Which is preferred in production? */
import java.util.*;
class ques1{
    public static void main(String args[])   {
        Scanner s = new Scanner(System.in);
        String s1 [] = s.nextLine().split(" ");
        int arr [] = new int [s1.length];
        for(int i=0;i<s1.length;i++){
            arr[i] = Integer.parseInt(s1[i]);
        }
        int k = s.nextInt();
    int low = 0 , high = s1.length - 1;
    int res = binary(arr,k,low, high);
    System.out.print(res);
    }
    public static int binary(int arr[], int k,int low, int high){
        int mid = (low + high)/2;
        if(low > high) return -1;
        if(arr[mid] == k) return mid;
        
        else if (arr[mid] < k){
            return binary(arr,k,mid +1,high);
        }
        else {
           return  binary(arr,k,low,mid-1);
        }
    }
}
