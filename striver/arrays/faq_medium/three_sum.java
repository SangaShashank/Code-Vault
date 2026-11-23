/*Given an integer array nums. Return all triplets such that:

i != j, i != k, and j != k
nums[i] + nums[j] + nums[k] == 0.
Notice that the solution set must not contain duplicate triplets. One element can be a part of multiple triplets. The output and the triplets can be returned in any order.

Example 1:
Input: nums = [2, -2, 0, 3, -3, 5]

Output: [[-2, 0, 2], [-3, -2, 5], [-3, 0, 3]]

Explanation:

nums[1] + nums[2] + nums[0] = 0

nums[4] + nums[1] + nums[5] = 0

nums[4] + nums[2] + nums[3] = 0

Example 2:
Input: nums = [2, -1, -1, 3, -1]

Output: [[-1, -1, 2]]

Explanation:

nums[1] + nums[2] + nums[0] = 0

Note that we have used two -1s as they are separate elements with different indexes

But we have not used the -1 at index 4 as that would create a duplicate triplet */
import java.util.*;
public class three_sum{
    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int arr [] = new int[n];
        for (int i=0;i<n;i++) arr[i] = s.nextInt();
        System.out.print(app1(arr,n));
        System.out.print(app1(arr,n));
    }
    public static HashSet<List<Integer>> app1(int arr[], int n){
         HashSet<List<Integer>> res = new HashSet<>();
         for (int i=0;i<n;i++){
            for (int j = i+1;j<n;j++){
                for (int k =j+1; k<n;k++){
                    if(arr[i] + arr[j] + arr[k] == 0) {
                        List<Integer> temp = new ArrayList<>();
                        temp.add(arr[i]); temp.add(arr[j]); temp.add(arr[k]);
                        Collections.sort(temp); // dupplicates kosam 
                        res.add(temp);                    }
                }
            }
         }
         return res; 
    }
}
class Three_Sum_15 {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = s.nextInt();

        System.out.println("Brute   : " + app1(arr.clone(), n));
        System.out.println("Better  : " + app2(arr.clone(), n));
        System.out.println("Optimal : " + app3(arr.clone(), n));
    }

    // Brute: all triplets, sort each one, HashSet removes duplicates
    // Time: O(n^3)   Space: O(number of triplets)
    public static List<List<Integer>> app1(int[] arr, int n) {
        Set<List<Integer>> res = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (arr[i] + arr[j] + arr[k] == 0) {
                        List<Integer> temp = Arrays.asList(arr[i], arr[j], arr[k]);
                        Collections.sort(temp); // same values => same list
                        res.add(temp);
                    }
                }
            }
        }
        return new ArrayList<>(res);
    }

    // Better: fix i, move j, look up the third value in a HashSet of seen values
    // Time: O(n^2)   Space: O(n) for seen + O(triplets) for dedupe set
    public static List<List<Integer>> app2(int[] arr, int n) {
        Set<List<Integer>> res = new HashSet<>();
        for (int i = 0; i < n; i++) {
            Set<Integer> seen = new HashSet<>(); // values between i and j
            for (int j = i + 1; j < n; j++) {
                int third = -(arr[i] + arr[j]);
                if (seen.contains(third)) {
                    List<Integer> temp = Arrays.asList(arr[i], arr[j], third);
                    Collections.sort(temp);
                    res.add(temp);
                }
                seen.add(arr[j]);
            }
        }
        return new ArrayList<>(res);
    }

    // Optimal: sort + fix i + two pointers, duplicates skipped (no HashSet)
    // Time: O(n log n) sort + O(n^2) loops = O(n^2)
    // Space: O(1) extra (ignoring output and sort internals)
    public static List<List<Integer>> app3(int[] arr, int n) {
        Arrays.sort(arr);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < n - 2; i++) { // n - 2 varake 
            if (i > 0 && arr[i] == arr[i - 1]) continue; // skip repeated first value
            int low = i + 1, high = n - 1;
            while (low < high) {   // equal to unndadu enduku anntey j!= k kada 
                int sum = arr[i] + arr[low] + arr[high];
                if (sum > 0) high--;  // sum ekkava unndi kada
                else if (sum < 0) low++; // sum takkava unndi kada 
                else {
                    res.add(Arrays.asList(arr[i], arr[low], arr[high])); 
                    low++;
                    high--; 
                    // duplicate removal processs 
                    // heart of the problem 
                    while (low < high && arr[low] == arr[low - 1]) low++;
                    while (low < high && arr[high] == arr[high + 1]) high--;
                }
            }
        }
        return res;
    }
}