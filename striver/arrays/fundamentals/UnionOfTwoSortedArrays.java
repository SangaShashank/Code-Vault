/*713. Union of two sorted arrays
Given two sorted arrays nums1 and nums2, return an array that contains the union of these two arrays. The elements in the union must be in ascending order.

The union of two arrays is an array where all values are distinct and are present in either the first array, the second array, or both.

Example 1:
Input: nums1 = [1, 2, 3, 4, 5], nums2 = [1, 2, 7]

Output: [1, 2, 3, 4, 5, 7]

Explanation:

The elements 1, 2 are common to both, 3, 4, 5 are from nums1 and 7 is from nums2

Example 2:
Input: nums1 = [3, 4, 6, 7, 9, 9], nums2 = [1, 5, 7, 8, 8]

Output: [1, 3, 4, 5, 6, 7, 8, 9]

Explanation:

The element 7 is common to both, 3, 4, 6, 9 are from nums1 and 1, 5, 8 is from nums2 */
import java.util.*;
public class UnionOfTwoSortedArrays{
    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        int m = s.nextInt();
        int arr1[] = new int[m];
        for (int i=0;i<m;i++) arr1[i] = s.nextInt();
        int n= s.nextInt();
        int arr2[] = new int[n];
        for (int i=0;i<n;i++) arr2[i] = s.nextInt();
        System.out.print(app1(arr1, arr2,n,m)); // dentlo bokka endi anntey dupicates ni hashmap handle chestunndi 
        // kani ofc manam telivi vadi cheyali adhi 
        System.out.print(app2(arr1, arr2,n,m));
    }

    // Brute: ignores that arrays are sorted
    public static int[] bruteTreeSet(int[] a, int[] b) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int x : a) set.add(x);
        for (int x : b) set.add(x);
        int[] res = new int[set.size()];
        int k = 0;
        for (int x : set) res[k++] = x;
        return res;
    }
    public static LinkedHashSet<Integer>  app1(int arr1[], int arr2[], int n ,int m){
        LinkedHashSet<Integer> res = new LinkedHashSet<>();
        int i=0; int j = 0;
        while(i<m &&  j < n){
            if(arr1[i]>arr2[j]) { res.add(arr2[j]); j++;}
            else if(arr1[i]< arr2[j])  { res.add(arr1[i]); i++;}
            else { res.add(arr1[i]); i++; j++;}
    }
    while(i<m){ // remaining elements 
        res.add(arr1[i]); i++;
    }
    while(j<n){ // remaining elements 
        res.add(arr2[j]); j++;
    }
    return res;
    
}
    public static ArrayList<Integer>   app2(int arr1[], int arr2[], int n ,int m){
        ArrayList<Integer> res = new ArrayList<>();
        int i=0; int j = 0;
        while(i<m &&  j < n){
            if(arr1[i]>arr2[j]) { 
                if(res.isEmpty() || res.get(res.size()-1) != arr2[j]) res.add(arr2[j]);
                 j++;}
            else if(arr1[i]< arr2[j])  {
                if(res.isEmpty() || res.get(res.size()-1) != arr1[i]) res.add(arr1[i]);
                 i++;}
            else { 
                if(res.isEmpty() || res.get(res.size()-1) != arr1[i]) res.add(arr1[i]);
                 i++; j++;}
    }
    while(i<m){ // remaining elements 
        if(res.isEmpty() || res.get(res.size()-1) != arr1[i]) res.add(arr1[i]);
         i++;
    }
    while(j<n){ // remaining elements 
        if(res.isEmpty() || res.get(res.size()-1) != arr2[j]) res.add(arr2[j]);
        j++;
    }
    return res;
    
}}