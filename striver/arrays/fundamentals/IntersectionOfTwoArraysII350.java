/*706. Intersection of two sorted arrays
Given two sorted arrays, nums1 and nums2, return an array containing the intersection of these two arrays. Each element in the result must appear as many times as it appears in both arrays; that is, if an element appears x times in nums1 and y times in nums2, it should appear min(x, y) times in the result.

The intersection of two arrays is an array where all values are present in both arrays. Since both input arrays are sorted, the resulting intersection array should also be in sorted order.

Example 1:
Input: nums1 = [1, 2, 2, 3, 5], nums2 = [1, 2, 7]

Output: [1, 2]

Explanation:

The elements 1, 2 are the only elements present in both nums1 and nums2

Example 2:
Input: nums1 = [1, 2, 2, 3, 3, 3], nums2 = [2, 3, 3, 4, 5, 7]

Output: [2, 3, 3]

Explanation:

The element 2 appears in both arrays only one time.

The element 3 appears in both arrays two times so we add element 3 equal to its number of occurrences. */
import java.util.*;
public class  IntersectionOfTwoArraysII350{
    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        int m = s.nextInt();
        int arr1[] = new int[m];
        for(int i=0;i<m;i++) arr1[i] = s.nextInt();
        int n = s.nextInt();
        int arr2[] = new int[n];
        for(int i=0;i<n;i++) arr2[i] = s.nextInt();
        System.out.print(app1(arr1, arr2, m,n));
    }
    public static ArrayList<Integer>  app1(int arr1[], int arr2[], int m, int n){
        ArrayList<Integer> res = new ArrayList<>();
        int i=0, j=0;
        while(i<m && j<n){
            if(arr1[i]== arr2[j]){
                res.add(arr1[i]); i++; j++;
            }
            else if(arr1[i]>arr2[j]){
               j++;
            }
            else { i++;}
        }
        return res;
    }
}
//https://claude.ai/share/5ecba1d2-84ea-416a-8cde-afe2edc95a6d