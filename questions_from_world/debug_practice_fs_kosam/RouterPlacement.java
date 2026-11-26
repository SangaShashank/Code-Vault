/*Question 3: RouterPlacement
Topic: Binary Search  |  Time: 15 minutes  |  Hidden bugs: 5 (1 mark each)  |  Input: Scanner
A long corridor has n wall sockets at different positions (in metres, given in any order). An engineer must
install k Wi-Fi routers in distinct sockets. Routers placed too close interfere with each other, so the engineer
wants to maximise the smallest distance between any two routers. The program binary searches on the
distance. For a trial distance, it places the first router at the leftmost socket and then greedily places the next
router at the first socket that is at least that far from the previous one. It prints the largest possible minimum
distance.
Input format: the first line has n and k. The second line has the n socket positions.*/
import java.util.*;
public class RouterPlacement {
    static boolean canPlace(int[] pos, int k, int gap) {
        int count = 0, last = pos[0];
        for (int i = 1; i < pos.length; i++) {
            if (pos[i] - last > gap) {
                count++;
            }
        }
        return count >= k;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] pos = new int[n];
        for (int i = 0; i < n; i++) pos[i] = sc.nextInt();
        int low = 1, high = pos[n - 1] - pos[0], ans = 0;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (canPlace(pos, k, mid)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        System.out.println("Largest minimum gap: " + ans);
    }
}
/*Sample test cases
Input
Test 1
Test 2
5 3
1 2 8 4 9
Expected output
Largest minimum gap: 3
7 3
5 17 100 11 20 2 50
Task: find and fix all the bugs.
Largest minimum gap: 4 */