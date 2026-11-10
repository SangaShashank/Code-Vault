/*Given one meeting room and N meetings represented by two arrays, start and end, where start[i] represents the start time of the ith meeting and end[i] represents the end time of the ith meeting, determine the maximum number of meetings that can be accommodated in the meeting room if only one meeting can be held at a time. A meeting starting at the same time another meeting ends is considered overlapping.

Example 1:
Input : Start = [1, 3, 0, 5, 8, 5] , End = [2, 4, 6, 7, 9, 9]

Output : 4

Explanation : The meetings that can be accommodated in meeting room are (1,2) , (3,4) , (5,7) , (8,9).

Example 2:
Input : Start = [10, 12, 20] , End = [20, 25, 30]

Output : 1

Explanation : Given the start and end time, only one meeting can be held in meeting room.

Now Your Turn!
Pick the correct output for the given input
Input : Start = [1, 4, 6, 9] , End = [2, 5, 7, 12]


2

4

1

3
Still unsure what the problem is asking ?

Let’s go through a few more examples, step by step, to make it clearer.

Constraints:
1 <= N <= 105
0 <= start[i] < end[i] <= 105*/
import java.util.*;

public class N_Meetings {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        int n = s.nextInt();

        int start[] = new int[n];
        int end[] = new int[n];

        for(int i = 0; i < n; i++) {
            start[i] = s.nextInt();
        }

        for(int i = 0; i < n; i++) {
            end[i] = s.nextInt();
        }

        System.out.println(app1(start, end, n));
    }

    // Approach 1: Bubble Sort + Greedy
    // Time: O(n²), Space: O(1)
    public static int app1(int start[], int end[], int n) {

        // Sort according to ending time
        for(int i = 0; i < n - 1; i++) {

            boolean swapped = false;

            for(int j = 0; j < n - 1 - i; j++) {

                if(end[j] > end[j + 1]) {

                    int temp = end[j];
                    end[j] = end[j + 1];
                    end[j + 1] = temp;

                    temp = start[j];
                    start[j] = start[j + 1];
                    start[j + 1] = temp;

                    swapped = true;
                }
            }

            if(!swapped) break;
        }

        int count = 0;
        int lastEnd = -1;

        // Select maximum non-overlapping meetings
        for(int i = 0; i < n; i++) {

            if(start[i] > lastEnd) {

                count++;
                lastEnd = end[i];
            }
        }

        return count;
    }
}