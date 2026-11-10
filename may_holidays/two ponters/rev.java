
import java.util.Arrays;

/*Problem: Reverse an Array / String (Two Pointer Technique)
Problem Statement:
You are given an array of integers or a string.
Your task is to reverse it in-place using the two pointer technique.
You are not allowed to use any extra array or built-in reverse functions.
Input:
1. An integer array arr of size n
   OR
2. A string s
Output:
Return the reversed array or string.
Examples:
Example 1:
Input:
arr = [1, 2, 3, 4, 5]
Output:
[5, 4, 3, 2, 1]
Example 2:
Input:
s = "shivaya"
Output:
"ayavihs"
Constraints:
1 ≤ n ≤ 10^5
-10^9 ≤ arr[i] ≤ 10^9
Expected Time Complexity:
O(n)
Expected Space Complexity:
O(1)
Approach Hint:
Use two pointers:
- One pointer starts from the beginning
- One pointer starts from the end
Swap the elements and move the pointers towards each other.
*/
public class rev {
    public static void main(String[] args) {
        int [] a= {4,5,6,7,8};
        int i = 0,j=a.length-1;
        while(i<j){
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;
            i++;
            j--;
        }
       System.out.println(Arrays.toString(a));

    }
}


public class ReverseArray { 
    public static void main(String[] args) {
        char[] bestTeacher = {'S','h','a','s','h','a','n','k'};

        // Print Original
        System.out.print("Original: ");
        for (int x = 0; x < bestTeacher.length; x++) {
            System.out.print(bestTeacher[x]);
        }
        System.out.println();
        int i = 0;
        int j = bestTeacher.length - 1;
        // Reverse using two pointers
        while (i < j) {
            char temp = bestTeacher[i];
            bestTeacher[i] = bestTeacher[j];
            bestTeacher[j] = temp;

            i++;
            j--;
        }
        // Print Reversed
        System.out.print("Reversed: ");
        for (int x = 0; x < bestTeacher.length; x++) {
            System.out.print(bestTeacher[x]);
        }
    }
}

