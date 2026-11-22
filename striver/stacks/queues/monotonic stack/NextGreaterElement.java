/*102. Next Greater Element
Given an array arr of size n containing elements, find the next greater element for each element in the array in the order of their appearance.

The next greater element of an element in the array is the nearest element on the right that is greater than the current element.

If there does not exist a next greater element for the current element, then the next greater element for that element is -1.

Example 1:
Input: arr = [1, 3, 2, 4]

Output: [3, 4, 4, -1]

Explanation: In the array, the next larger element to 1 is 3, 3 is 4, 2 is 4 and for 4 is -1, since it does not exist.

Example 2:
Input: arr = [6, 8, 0, 1, 3]

Output: [8, -1, 1, 3, -1]

Explanation: In the array, the next larger element to 6 is 8, for 8 there is no larger elements hence it is -1, for 0 it is 1 , for 1 it is 3 and then for 3 there is no larger element on the right and hence -1.*/
import java.util.*;

public class NextGreaterElement {

    // Approach 1: Brute force. Time O(n^2), Space O(1) extra
    static int[] bruteForce(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = -1;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] > arr[i]) {      // strict >, equal is not greater
                    ans[i] = arr[j];
                    break;                  // nearest one found
                }
            }
        }
        return ans;
    }

    // Approach 2: Monotonic stack, right to left (your approach). Time O(n), Space O(n)
    static int[] stackRightToLeft(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        Deque<Integer> st = new ArrayDeque<>();
        for (int i = n - 1; i >= 0; i--) {
            int element = arr[i];
            while (!st.isEmpty() && st.peek() <= element) {
                st.pop();                   // useless candidates
            }
            ans[i] = st.isEmpty() ? -1 : st.peek();
            st.push(element);
        }
        return ans;
    }

    // Approach 3: Monotonic stack of indices, left to right. Time O(n), Space O(n)
    static int[] stackLeftToRight(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);               // leftovers keep -1
        Deque<Integer> st = new ArrayDeque<>();   // indices still waiting for an answer
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] < arr[i]) {
                ans[st.pop()] = arr[i];     // arr[i] is the nearest greater for popped index
            }
            st.push(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter " + n + " elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println("Brute force (O(n^2))        : " + Arrays.toString(bruteForce(arr)));
        System.out.println("Stack right to left (O(n))  : " + Arrays.toString(stackRightToLeft(arr)));
        System.out.println("Stack left to right (O(n))  : " + Arrays.toString(stackLeftToRight(arr)));

        sc.close();
    }
}
