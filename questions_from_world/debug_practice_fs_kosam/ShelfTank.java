/*Question 4: ShelfTank
Topic: Arrays  |  Time: 15 minutes  |  Hidden bugs: 5 (1 mark each)  |  Input: in main
A warehouse floor has shelves in a straight line, numbered from 1. Shelf i has height h[i]. A water tank is built
by choosing two shelves and using them as the left and right walls. The tank's width is the distance between
the two shelf numbers, and its height is limited by the shorter of the two shelves, so its area is width x height.
The manager wants the largest possible tank area and the two shelf numbers that give it. The program uses
two pointers, one at each end.*/

public class ShelfTank {
    static int[] bestTank(int[] h) {
        int l = 0, r = h.length - 1;
        int best = 0, bl = 0, br = 0;
        while (l < r) {
            int area = (r - l +1) * Math.min(h[l], h[r]);
            if (area > best) {
                best = area;
                bl = l;
                br = r;
            }
            if (h[l] < h[r]) {
                l++;
            } else {
                r--;
            }
        }
        return new int[]{best, bl, br};
    }
    public static void main(String[] args) {
        int[] s1 = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int[] a = bestTank(s1);
        System.out.println("Floor 1: area " + a[0] + ", shelves " + a[1] + " and " + a[2]);
        int[] s2 = {4, 3, 2, 1, 4};
        int[] b = bestTank(s2);
        System.out.println("Floor 2: area " + b[0] + ", shelves " + b[1] + " and " + b[2]);
    }
}
/*Sample test cases
Array
Test 1
{1, 8, 6, 2, 5, 4, 8, 3, 7}
Expected output
Floor 1: area 49, shelves 2 and 9
Test 2
{4, 3, 2, 1, 4}
Task: find and fix all the bugs.
Floor 2: area 16, shelves 1 and */