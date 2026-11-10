import java.util.*;

public class Fractional_Knapsack {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        int n = s.nextInt();

        int val[] = new int[n];
        int wt[] = new int[n];

        for(int i = 0; i < n; i++) {
            val[i] = s.nextInt();
        }

        for(int i = 0; i < n; i++) {
            wt[i] = s.nextInt();
        }

        long cap = s.nextLong();

        System.out.println(app1(val, wt, n, cap));
    }

    // Approach 1: Sorting using value/weight ratio
    public static double app1(int val[], int wt[], int n, long cap) {

        double ratio[] = new double[n];

        for(int i = 0; i < n; i++) {
            ratio[i] = val[i] / (double)wt[i];
        }

        // Sort in descending order
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n - 1; j++) {

                if(ratio[j] < ratio[j+1]) {

                    double temp = ratio[j];
                    ratio[j] = ratio[j+1];
                    ratio[j+1] = temp;

                    int temp2 = val[j];
                    val[j] = val[j+1];
                    val[j+1] = temp2;

                    int temp3 = wt[j];
                    wt[j] = wt[j+1];
                    wt[j+1] = temp3;
                }
            }
        }

        double res = 0;

        for(int i = 0; i < n; i++) {

            if(cap >= wt[i]) {
                cap -= wt[i];
                res += val[i];
            }
            else {
                res += ratio[i] * cap;
                return res;
            }
        }

        return res;
    }
}