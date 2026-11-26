/*Question 8: ShelfLookup Library
Topic: Binary Search  |  Time: 15 minutes  |  Hidden bugs: 8 (1 mark each)  |  Input: Scanner
A library storage room keeps n distinct book IDs on one long shelf. The IDs were originally in ascending order,
but the shelf was rotated: some books from the front were moved to the back (for example 0 1 2 4 5 6 7
became 4 5 6 7 0 1 2). Slots are numbered from 1. The program must do two things using binary search only,
with no linear scan. First, print the rotation slot, which is the slot holding the smallest ID. Second, for each
query ID, print the slot where it sits, or 0 if the ID is not on the shelf.
Input format: n, then the n IDs, then q (number of queries), then the q query IDs.*/
import java.util.*;
public class ShelfLookup {
    static int findMin(int[] a) {
        int lo = 0, hi = a.length - 1;
        int mini= Integer.MAX_VALUE;
       for(int x : a) mini =  Math.min(x, mini);
       return mini;
    }
    static int search(int[] a, int x) {
        int lo = 0, hi = a.length - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (a[mid] == x) return mid;
            if (a[lo] < a[mid]) {
                if (x >=a[lo] && x <=a[mid]) hi = mid - 1;
                else lo = mid + 1;
            } else {
                if (x >= a[mid] && x <= a[hi]) lo = mid + 1;
                else hi = mid - 1;
            }
        }
        return 0;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = sc.nextInt();
        System.out.println("Rotation slot: " + findMin(a));
        int q = sc.nextInt();
        for (int t = 0; t < q; t++) {
            int x = sc.nextInt();
            System.out.println(x + " -> slot " + search(a, x));
        }
    }
}
/*Sample test cases
Input
Test 1
Test 2
7
4 5 6 7 0 1 2
3
0 3 7
5
30 40 50 10 20
2
20 30
Expected output
Rotation slot: 5
0 -> slot 5
3 -> slot 0
7 -> slot 4
Rotation slot: 4
20 -> slot 5
30 -> slot 1
Task: find and fix all the bugs */