import java.util.*;

public class Candy {

    static int r[], c[], n;

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        int n = s.nextInt();

        int ratings[] = new int[n];

        for(int i = 0; i < n; i++) {
            ratings[i] = s.nextInt();
        }

        System.out.println("Approach 1: " + app1(ratings, n));
        System.out.println("Approach 2: " + app2(ratings));
        System.out.println("Approach 3: " + app3(ratings));
    }

    // Approach 1: Repeated checking
    // Time: O(n²) or more in worst-case analysis
    // Space: O(n)

    public static int app1(int ratings[], int n) {

        int candy[] = new int[n];

        Arrays.fill(candy, 1);

        boolean changed = true;

        while(changed) {

            changed = false;

            for(int i = 0; i < n; i++) {

                if(i > 0 && ratings[i] > ratings[i - 1]
                        && candy[i] <= candy[i - 1]) {

                    candy[i] = candy[i - 1] + 1;
                    changed = true;
                }

                if(i < n - 1 && ratings[i] > ratings[i + 1]
                        && candy[i] <= candy[i + 1]) {

                    candy[i] = candy[i + 1] + 1;
                    changed = true;
                }
            }
        }

        int sum = 0;

        for(int i = 0; i < n; i++) {
            sum += candy[i];
        }

        return sum;
    }

    // Approach 2: Recursion

    public static int app2(int ratings[]) {

        r = ratings;
        n = ratings.length;

        c = new int[n];

        Arrays.fill(c, 1);

        for(int i = 0; i < n; i++) {
            checkLeft(i);
            checkRight(i);
        }

        int sum = 0;

        for(int x : c) {
            sum += x;
        }

        return sum;
    }

    static void checkLeft(int i) {

        if(i > 0 && i < n && r[i] > r[i - 1]
                && c[i] <= c[i - 1]) {

            c[i] = c[i - 1] + 1;

            checkLeft(i + 1);
        }
    }

    static void checkRight(int i) {

        if(i >= 0 && i < n - 1 && r[i] > r[i + 1]
                && c[i] <= c[i + 1]) {

            c[i] = c[i + 1] + 1;

            checkRight(i - 1);
        }
    }

    // Approach 3: Two Arrays (Left + Right)
    // Time: O(n)
    // Space: O(n)

    public static int app3(int ratings[]) {

        int n = ratings.length;

        int left[] = new int[n];
        int right[] = new int[n];

        left[0] = 1;

        // Left to Right
        for(int i = 1; i < n; i++) {

            if(ratings[i] > ratings[i - 1]) {
                left[i] = left[i - 1] + 1;
            }
            else {
                left[i] = 1;
            }
        }

        right[n - 1] = 1;

        // Right to Left
        for(int i = n - 2; i >= 0; i--) {

            if(ratings[i] > ratings[i + 1]) {
                right[i] = right[i + 1] + 1;
            }
            else {
                right[i] = 1;
            }
        }

        int sum = 0;

        for(int i = 0; i < n; i++) {
            sum += Math.max(left[i], right[i]);
        }

        return sum;
    }
}