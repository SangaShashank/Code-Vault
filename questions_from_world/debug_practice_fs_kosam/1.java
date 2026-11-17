/*Question 1: Fresh Mart Profit
Topic: Arrays · Hidden bugs: 2
Fresh Mart records its profit for each day of a week (a negative number is a loss). 
The owner wants the best run of consecutive days, meaning the stretch with the highest total profit, 
and the day numbers where it starts and ends. Days are numbered from 1. The owner must pick at least one day, 
even if every day was a loss.
public class BestStretch {
    static int[] bestStretch(int[] profit) {
        int best = 0, cur = 0;
        int start = 0, bestStart = 0, bestEnd = 0;
        for (int i = 0; i < profit.length; i++) {
            cur += profit[i];
            if (cur > best) {
                best = cur;
                bestStart = start;
                bestEnd = i;
            }
            if (cur < 0) {
                cur = 0;
                start = i;
            }
        }
        return new int[]{best, bestStart, bestEnd};
    }

    public static void main(String[] args) {
        int[] week1 = {2, -5, 4, 3, -1, 6, -8};
        int[] r1 = bestStretch(week1);
        System.out.println("Week 1 -> Best profit: " + r1[0] + " from Day " + (r1[1] + 1) + " to Day " + (r1[2] + 1));

        int[] week2 = {-3, -1, -6};
        int[] r2 = bestStretch(week2);
        System.out.println("Week 2 -> Best profit: " + r2[0] + " from Day " + (r2[1] + 1) + " to Day " + (r2[2] + 1));
    }
}
Expected output
Week 1 -> Best profit: 12 from Day 3 to Day 6
Week 2 -> Best profit: -1 from Day 2 to Day 2
Actual output
Week 1 -> Best profit: 12 from Day 2 to Day 6
Week 2 -> Best profit: 0 from Day 1 to Day 1
Task: find and fix the bugs. */
