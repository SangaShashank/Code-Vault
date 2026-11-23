/*Question 4: Hall Booking
Topic: Greedy · Hidden bugs: 2
A college has one seminar hall and several event requests, 
each with a start time and an end time. Two events cannot overlap,
 but an event may start at the exact time the previous one ends (back-to-back is allowed). 
 The organiser wants to host as many events as possible in one day. 
 The program should print the maximum number of events.*/
import java.util.*;
public class HallBooking {
    static int maxEvents(int[][] ev) {
        Arrays.sort(ev, (a, b) -> a[1] - b[1]);
        int count = 1, lastEnd = ev[0][1];
        for (int i = 1; i < ev.length; i++) {
            if (ev[i][0] >= lastEnd) { //overlap annadu kada 
                count++;
                lastEnd = ev[i][1];
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] day1 = {{1, 10}, {2, 3}, {3, 5}, {5, 8}};
        System.out.println("Day 1: " + maxEvents(day1));

        int[][] day2 = {{1, 2}, {2, 3}, {3, 4}};
        System.out.println("Day 2: " + maxEvents(day2));
    }
}
/*Expected output
Day 1: 3
Day 2: 3
Actual output
Day 1: 1
Day 2: 2
Task: find and fix the bugs. */