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
public class Next_Smaller_Element{
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
/*import java.util.*;

public class Next_Smaller_Element{

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

        System.out.println("Brute   : " + Arrays.toString(brute(arr, n)));
        System.out.println("Better  : " + Arrays.toString(better(arr, n)));
        System.out.println("Optimal : " + Arrays.toString(optimal(arr, n)));
        sc.close();
    }

    // Brute: for each i, scan right until a smaller element is found
    // Time: O(n^2) | Space: O(1) extra (output array excluded)
    public static int[] brute(int[] arr, int n) {
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = -1;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[i]) {
                    res[i] = arr[j];
                    break;
                }
            }
        }
        return res;
    }

    // Better: stack-free, jump using already-computed NSE indices
    // For i, start at j = i+1. While arr[j] >= arr[i], jump to nseIdx[j]
    // (everything between j and nseIdx[j] is >= arr[j] >= arr[i], so skip it).
    // Time: O(n) amortized | Space: O(n)
    public static int[] better(int[] arr, int n) {
        int[] nseIdx = new int[n];
        int[] res = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            int j = i + 1;
            while (j < n && arr[j] >= arr[i]) j = nseIdx[j];
            nseIdx[i] = j;                 // n means "none"
            res[i] = (j < n) ? arr[j] : -1;
        }
        return res;
    }

    // Optimal: monotonic stack, right to left, input not modified
    // Time: O(n) (each element pushed and popped at most once) | Space: O(n)
    public static int[] optimal(int[] arr, int n) {
        int[] res = new int[n];
        Deque<Integer> st = new ArrayDeque<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && st.peek() >= arr[i]) st.pop();
            res[i] = st.isEmpty() ? -1 : st.peek();
            st.push(arr[i]);
        }
        return res;
    }
} */