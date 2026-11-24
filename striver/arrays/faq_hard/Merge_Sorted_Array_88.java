/*88. Merge Sorted Array
Easy
Topics
premium lock icon
Companies
Hint
You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n, representing the number of elements in nums1 and nums2 respectively.

Merge nums1 and nums2 into a single array sorted in non-decreasing order.

The final sorted array should not be returned by the function, but instead be stored inside the array nums1. To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged, and the last n elements are set to 0 and should be ignored. nums2 has a length of n.

 

Example 1:

Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
Output: [1,2,2,3,5,6]
Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.
Example 2:

Input: nums1 = [1], m = 1, nums2 = [], n = 0
Output: [1]
Explanation: The arrays we are merging are [1] and [].
The result of the merge is [1].
Example 3:

Input: nums1 = [0], m = 0, nums2 = [1], n = 1
Output: [1]
Explanation: The arrays we are merging are [] and [1].
The result of the merge is [1].
Note that because m = 0, there are no elements in nums1. The 0 is only there to ensure the merge result can fit in nums1.
 

Constraints:

nums1.length == m + n
nums2.length == n
0 <= m, n <= 200
1 <= m + n <= 200
-109 <= nums1[i], nums2[j] <= 109
 

Follow up: Can you come up with an algorithm that runs in O(m + n) time? */
import java.util.*;
public class Merge_Sorted_Array_88{
    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        int k = s.nextInt();
        int arr1[] = new int [k];
        for (int i=0;i<k;i++) arr1[i] = s.nextInt();
        int n = s.nextInt();
        int arr2[] = new int [n];
        for (int i=0;i<n;i++) arr2[i] = s.nextInt();
        // actual arr1 elements :
        int m = k -n;
        System.out.print(Arrays.toString(app1(arr1,arr2,m,n)));
    }
    public static int[] app1(int arr1[], int arr2[], int m,int n){
        int i=m-1, j= n-1,k= m+n-1;
        while(i>= 0 && j >= 0){
            if (arr1[i]>arr2[j]) {
                arr1[k] = arr1[i];// max pettali kada 
                i--; k--;
            }
            else if (arr1[i]<arr2[j]){
                arr1[k] = arr2[j];
                k--; j--;
            }
            else { // anntey same element (duplicates kavali annta )
                arr1[k] = arr2[j];
                k--;
                arr1[k] = arr1[i];
                k--; i--; j--;
            }
        }
        // left overs fill cheyali :
        while(i>=0) {
            arr1[k] = arr1[i]; i--; k--;
        }
        while(j>=0) {
            arr1[k] = arr2[j]; j--; k--;
        }
        return arr1;
    }
}
/*import java.util.*;

public class Merge_Sorted_Array_88 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();                 // length of nums1 (m + n)
        int[] nums1 = new int[len];
        for (int i = 0; i < len; i++) nums1[i] = sc.nextInt();
        int n = sc.nextInt();
        int[] nums2 = new int[n];
        for (int i = 0; i < n; i++) nums2[i] = sc.nextInt();
        int m = len - n;

        // clone so each approach gets a fresh copy of the input
        int[] a = nums1.clone();
        brute(a, m, nums2, n);
        System.out.println("Brute   : " + Arrays.toString(a));

        int[] b = nums1.clone();
        better(b, m, nums2, n);
        System.out.println("Better  : " + Arrays.toString(b));

        int[] c = nums1.clone();
        optimal(c, m, nums2, n);
        System.out.println("Optimal : " + Arrays.toString(c));
    }

    // BRUTE: copy nums2 into the tail of nums1, then sort everything
    // Time: O((m+n) log(m+n))  Space: O(1) (ignoring sort's internal stack)
    static void brute(int[] nums1, int m, int[] nums2, int n) {
        for (int j = 0; j < n; j++) nums1[m + j] = nums2[j];
        Arrays.sort(nums1);
    }

    // BETTER: classic forward merge into a temp array, copy back
    // Time: O(m+n)  Space: O(m+n)
    static void better(int[] nums1, int m, int[] nums2, int n) {
        int[] res = new int[m + n];
        int i = 0, j = 0, k = 0;
        while (i < m && j < n) {
            if (nums1[i] <= nums2[j]) res[k++] = nums1[i++];
            else res[k++] = nums2[j++];
        }
        while (i < m) res[k++] = nums1[i++];
        while (j < n) res[k++] = nums2[j++];
        for (int x = 0; x < m + n; x++) nums1[x] = res[x];
    }

    // OPTIMAL: fill nums1 from the back with the larger of the two tails
    // Time: O(m+n)  Space: O(1)
    // idhey nenu try chesina paina ,ofc vedi antha baga rale 
    static void optimal(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n - 1, k = m + n - 1;
        while (j >= 0) {   // only nums2 leftovers need copying;
                           // nums1 leftovers are already in place
            if (i >= 0 && nums1[i] > nums2[j]) nums1[k--] = nums1[i--];
            else nums1[k--] = nums2[j--];
        }
    }
} */
//https://claude.ai/share/9a7ed4c2-4944-40b8-80fa-080be823cad7
