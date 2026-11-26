/*A railway station logs the arrival times and departure times of all trains in one day. Times are in 24-hour hhmm
form (930 means 09:30, 1415 means 14:15). The two lists are given as they were logged and are not sorted.
Every train needs its own platform while it is in the station. A train that arrives at the exact minute another
train departs still needs its own platform, because the departing train has not yet cleared. The station master
wants the minimum number of platforms so that no train has to wait, and the earliest time at which that
peak number of platforms is first reached. The program sorts the times and sweeps through them. It prints the
number of platforms and the peak time in hh:mm format (two digits each).*/
import java.util.*;
public class Platforms {
    static String plan(int[] arr, int[] dep) {
        Arrays.sort(arr);
        Arrays.sort(dep);
        int i = 0, j = 0, cur = 0, max = 0, peak = 0;
        while (i < arr.length) {
            if (arr[i] <= dep[j]) {
                cur++;
                if (cur > max) {
                    max = cur;
                    peak = arr[i];
                }
                i++;
            } else {
                cur--;
                j++;
            }
        }
        return max + " platforms, peak at " + (peak / 100) + ":" + (peak % 100);
    }
    public static void main(String[] args) {
        int[] a1 = {900, 940, 950, 1100, 1500, 1800};
        int[] d1 = {910, 1200, 1120, 1130, 1900, 2000};
        System.out.println("Station A: " + plan(a1, d1));
        int[] a2 = {800, 830, 900};
        int[] d2 = {830, 900, 930};
        System.out.println("Station B: " + plan(a2, d2));
    }
}
/*Sample test cases
Arrays
Test 1
Test 2
arr = {900, 940, 950, 1100, 1500,
1800}
dep = {910, 1200, 1120, 1130, 1900,
2000}
Expected output
Station A: 3 platforms, peak at 11:00
arr = {800, 830, 900}
dep = {830, 900, 930}
Task: find and fix all the bugs.
Station B: 2 platforms, peak at 08:3 */