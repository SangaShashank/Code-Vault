/*A freelancer works alone and every task takes exactly one day. Each task has a deadline day (day 1 is
tomorrow, and a task must be finished on or before its deadline day) and a payment. Only one task can be
done per day, and a task that misses its deadline earns nothing. The freelancer wants the highest total
payment, so each chosen task should be placed on the latest free day on or before its deadline. The program
must print how many tasks get done and the total payment.
Input format: the first line is n. Each of the next n lines has the deadline followed by the payment.*/
import java.util.*;
public class TaskDesk {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] deadline = new int[n];
        int[] profit = new int[n];
        int maxD = 0;
        for (int i = 0; i < n; i++) {
            deadline[i] = sc.nextInt();
            profit [i] = sc.nextInt();
            maxD = Math.max(maxD, deadline[i]);
        }
        Integer[] idx = new Integer[n];
        for (int i = 0; i < n; i++) idx[i] = i;
        Arrays.sort(idx, (b,a) -> profit[a] - profit[b]);
        System.out.print(Arrays.toString(idx));
        boolean[] used = new boolean[maxD + 1];
        int total = 0, done = 0;
        for (int t : idx) {
            for (int d = deadline[t]; d > 0; d--) {
                if (!used[d]) {
                    used[d] = true;
                    total += profit[t];
                    done++;
                    break; // idhey nen marchipoyina 
                }
            }
        }
        System.out.println("Tasks done: " + done);
        System.out.println("Total profit: " + total);
    }
}
/*Sample test cases
Input
Test 1
Test 2
5
2 100
1 19
2 27
1 25
3 15
4
4 20
1 10
1 40
1 30
Expected output
Tasks done: 3
Total profit: 142
Tasks done: 2
Total profit: 60*/