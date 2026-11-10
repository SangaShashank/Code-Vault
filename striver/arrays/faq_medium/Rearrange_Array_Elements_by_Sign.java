/*Given an integer array nums of even length consisting of an equal number of positive and negative integers.Return the answer array in such a way that the given conditions are met:

Every consecutive pair of integers have opposite signs.
For all integers with the same sign, the order in which they were present in nums is preserved.
The rearranged array begins with a positive integer.
Example 1:
Input : nums = [2, 4, 5, -1, -3, -4]

Output : [2, -1, 4, -3, 5, -4]

Explanation:

The positive number 2, 4, 5 maintain their relative positions and -1, -3, -4 maintain their relative positions

Example 2:
Input : nums = [1, -1, -3, -4, 2, 3]

Output : [1, -1, 2, -3, 3, -4]

Explanation:

The positive number 1, 2, 3 maintain their relative positions and -1, -3, -4 maintain their relative positions */

import java.util.Arrays;
import java.util.Scanner;
public class Rearrange_Array_Elements_by_Sign{
    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++) arr[i] = s.nextInt();
        System.out.print(Arrays.toString(app1(arr))); //brute
        System.out.print(Arrays.toString(app2(arr))); //better
        System.out.print(Arrays.toString(app3(arr))); //optimal

    }

    public static int[] app1(int arr[]) {

        int n = arr.length;

        int pos[] = new int[n / 2];
        int neg[] = new int[n / 2];

        int a = 0, b = 0;

        // Separate positive and negative numbers
        for(int x : arr) {

            if(x > 0) {
                pos[a++] = x;
            }
            else {
                neg[b++] = x;
            }
        }

        int res[] = new int[n];

        int p = 0, q = 0, k = 0;

        // Alternate positive and negative
        while(p < pos.length && q < neg.length) {

            res[k++] = pos[p++];
            res[k++] = neg[q++];
        }

        return res;
    }

public static int[] app2(int[] arr) {
    int[] res = new int[arr.length];

    int i = 0;
    for (int x : arr) {              // pass 1: positives at 0, 2, 4...
        if (x > 0) { res[i] = x; i += 2; }
    }

    int j = 1;
    for (int x : arr) {              // pass 2: negatives at 1, 3, 5...
        if (x < 0) { res[j] = x; j += 2; }
    }
    return res;
}
    public static int [] app3(int arr[]){
        int i = 0;int j=1;
        int res [] = new int[arr.length];
        for(int x:arr){
            if(x>0) {
                res[i] = x; 
                i = i+2;
        }
        else{
            res[j] = x;
            j = j+2;
        }
    }
    return res;
}
}
