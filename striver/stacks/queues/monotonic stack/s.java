/*194. Next Smaller Element
Given an array of integers arr, your task is to find the Next Smaller Element (NSE) for every element in the array.

The Next Smaller Element for an element x is defined as the first element to the right of x that is smaller than x.

If there is no smaller element to the right, then the NSE is -1.

Example 1:
Input: arr = [4, 8, 5, 2, 25]

Output: [2, 5, 2, -1, -1]

Explanation:

- For 4, the next smaller element is 2.

- For 8, the next smaller element is 5.

- For 5, the next smaller element is 2.

- For 2, there is no smaller element to its right → -1.

- For 25, no smaller element exists → -1.

Example 2:
Input: arr = [10, 9, 8, 7]

Output: [9, 8, 7, -1]

Explanation:

Each element’s next right neighbor is smaller. */
import java.util.*;
public class s {
    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int arr [] = new int [n];
        for (int i=0;i<n;i++) arr[i] = s.nextInt();
        System.out.print(Arrays.toString(app1(arr,n)));
    }
    public static int [] app1(int arr[], int n){
        Deque<Integer> st = new ArrayDeque<>();
        for (int i = n-1;i>= 0;i--){
            int curr = arr[i]; // pakka store cheayli 
           while (!st.isEmpty() && st.peek()>= arr[i]){
            st.pop();
           }
           if(st.isEmpty()) arr[i] = -1;
           else arr[i] = st.peek();
           st.push(curr);
        }
        return arr;
    }
}