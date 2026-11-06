/*Given an array nums sorted in non-decreasing order. Every number in the array except one appears twice. Find the single number in the array.

Example 1:
Input :nums = [1, 1, 2, 2, 3, 3, 4, 5, 5, 6, 6]

Output:4

Explanation: Only the number 4 appears once in the array.

Example 2:
Input : nums = [1, 1, 3, 5, 5]

Output:3

Explanation: Only the number 3 appears once in the array. */
import java.util.*;
public class Single_Element_in_Sorted_Array{
    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int arr [] = new int[n];
        for (int i=0;i<n;i++) arr[i] = s.nextInt();
        System.out.println(app1(arr)); // idhi nen rasina 
        // migtavi given claude to check other alternatives
    }
    public static int app1(int arr[]){
        int low = 0, high = arr.length-1;
        while(low <= high ){
            int mid = low + (high - low )/2;
            if(low == high ) // or high - low = 0
            { return arr[low]; // high or mid kuda return cheayvachu
            }
            else if(arr[mid] == arr[mid-1]){ // paired with left side 
                int left_length = (mid -1) - low ; // zero based indexing kada
                if(left_length % 2 ==0) {
                    low = mid +1; // heart of the problem 
                }
                else{
                    high = mid -2;
                }
            }
            else if (arr[mid] == arr[mid+1]){ // paired with right half 
                int left_length = mid -low;
                if(left_length%2 == 0) {
                    low = mid +2;
                }
                else{
                    high = mid -1;
                }
            }
            else {return arr[mid];}
        }
        return -1 ; // never excutess 
    }
    public static int linearScan(int[] arr) {
    int n = arr.length;
    if (n == 1) return arr[0]; // to stop array out of bounds
    if (arr[0] != arr[1]) return arr[0]; // 1st element special check
    if (arr[n - 1] != arr[n - 2]) return arr[n - 1]; // last element special check
    for (int i = 1; i < n - 1; i++)
        if (arr[i] != arr[i - 1] && arr[i] != arr[i + 1]) return arr[i]; // other checks 
    return -1;
}
public static int evenJump(int[] arr) { // idhi naa idea 
    int n = arr.length;
    for (int i = 0; i < n - 1; i += 2) // n-1 varake povali
        if (arr[i] != arr[i + 1]) return arr[i];  
    return arr[n - 1]; // last element ee answer iga                            
}
public static int bruteMap(int[] arr) { // ofc idhi manam ila cheyam , just to remind you the approch of hashmap
    HashMap<Integer, Integer> map = new HashMap<>();
    for (int x : arr) map.put(x, map.getOrDefault(x, 0) + 1);
    for (Map.Entry<Integer, Integer> e : map.entrySet())
        if (e.getValue() == 1) return e.getKey();
    return -1;
}
}
//https://claude.ai/share/d0b9c1d1-28fa-4fca-abab-2459d1e7b26b