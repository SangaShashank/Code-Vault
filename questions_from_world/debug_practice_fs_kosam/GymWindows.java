/*A gym app stores a member's daily calorie balance 
(calories eaten minus calories burned, so a day
 can be negative). The trainer wants to know how many groups of 
 consecutive days add up to exactly 
 the member's target k. Different groups that happen to give the same total are all counted.
The program keeps a running total and a map of the totals seen so far.*/
import java.util.*;
public class GymWindows {
    static int countWindows(int[] mins, int k) {
        Map<Integer, Integer> seen = new HashMap<>();
        int sum = 0, count = 0;
        for (int x : mins) {
            sum += x;
            if (seen.containsKey(sum -k)) {
                count++;
            }
            seen.put(sum, 1);
        }
        return count;
    }

    public static void main(String[] args) {
        int[] a = {1, 1, 1};
        System.out.println("Member A: " + countWindows(a, 2));

        int[] b = {3, 4, 7, 2, -3, 1, 4, 2};
        System.out.println("Member B: " + countWindows(b, 7));
    }
}
/*Expected output
Member A: 2
Member B: 4
Actual output
Member A: 1
Member B: 3*/
//fixed 
static int countWindows(int[] mins, int k) {
    Map<Integer, Integer> seen = new HashMap<>();
    seen.put(0, 1); //fix one
    int sum = 0, count = 0;
    for (int x : mins) {
        sum += x;
        if (seen.containsKey(sum - k)) {
            count += seen.get(sum - k);
        }
        seen.put(sum, seen.getOrDefault(sum, 0) + 1); // fix two 
    }
    return count;
}