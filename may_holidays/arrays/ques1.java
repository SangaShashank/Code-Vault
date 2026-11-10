/*INTERVIEW QUESTION:

You are given an integer array of size n.
Find both the maximum and minimum elements in the array.

CONSTRAINTS:
- Solve it in a single traversal
- Do NOT use sorting
- Array can contain negative numbers
- n >= 1

EXAMPLE:
Input:  [3, 5, 1, 8, 2]
Output: min = 1, max = 8

FOLLOW-UP QUESTIONS:
1. Can you reduce the number of comparisons?
2. What is the minimum number of comparisons required?
3. Can you solve it using pair-wise comparison optimization?

YOUR TASK:
1. Explain your approach
2. Give time complexity
3. Write Java code*/
//my approach 

/*import java.util.Scanner;

public class ques1 {
    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        String [] s1 = s.nextLine().split(" ");
        Integer k [] = new Integer[s1.length];
        for (int i=0;i<s1.length;i++){
            k[i] = Integer.parseInt(s1[i]);         
        }
        int max = k[0];
        int min = k[0];
                //single traversal lo cheayli kabbatti :
        for(int i=0;i<k.length;i++){
            max = Math.max(max,k[i]);
            min = Math.min(min,k[i]);
        }
        System.out.printf("max is %d", max);
        System.out.printf("min is %d", min);

    }
}*/
// ai approach 
import java.util.*;

public class ques1 {
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        String[] input = s.nextLine().split(" ");

        int[] arr = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        int min, max;
        int i;

        // Step 1: Initialize
        if (arr.length % 2 == 0) {
            // if even
            if (arr[0] < arr[1]) {
                min = arr[0];
                max = arr[1];
            } else {
                min = arr[1];
                max = arr[0];
            }
            i = 2;
        } else {
            // if odd
            min = max = arr[0];
            i = 1;
        }

        // Step 2: Process in pairs
        while (i < arr.length - 1) {
            int localMin, localMax;

            if (arr[i] < arr[i + 1]) {
                localMin = arr[i];
                localMax = arr[i + 1];
            } else {
                localMin = arr[i + 1];
                localMax = arr[i];
            }

            if (localMin < min) {
                min = localMin;
            }

            if (localMax > max) {
                max = localMax;
            }
            

            i += 2;
        }

        System.out.println("min = " + min + ", max = " + max);
    }
}
