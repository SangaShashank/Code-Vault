/*244. Celebrity Problem
A celebrity is a person who is known by everyone else at the party but does not know anyone in return. Given a square matrix M of size N x N where M[i][j] is 1 if person i knows person j, and 0 otherwise, determine if there is a celebrity at the party. Return the index of the celebrity or -1 if no such person exists.

Note that M[i][i] is always 0.

Example 1:
Input: M = [ [0, 1, 1, 0], [0, 0, 0, 0], [1, 1, 0, 0], [0, 1, 1, 0] ]

Output: 1

Explanation: Person 1 does not know anyone and is known by persons 0, 2, and 3. Therefore, person 1 is the celebrity.

Example 2:
Input: M = [ [0, 1], [1, 0] ]

Output: -1

Explanation: Both persons know each other, so there is no celebrity.

Now Your Turn!
Pick the correct output for the given input
Input: M = [ [0, 1, 0], [0, 0, 0], [0, 1, 0] ]*/
// naa approch 
import java.util.Scanner;

public class Find_The_Celebrity_277 {

    // true if person i knows nobody (row i all 0s, ignoring diagonal)
    static boolean rowAllZero(int[][] M, int n, int i) {
        for (int j = 0; j < n; j++) {
            if (j == i) continue;
            if (M[i][j] == 1) return false;
        }
        return true;
    }

    // true if everybody knows person i (column i all 1s, ignoring diagonal)
    static boolean colAllOne(int[][] M, int n, int i) {
        for (int j = 0; j < n; j++) {
            if (j == i) continue;
            if (M[j][i] == 0) return false;
        }
        return true;
    }

    static int celebrity(int[][] M, int n) {
        for (int i = 0; i < n; i++) {
            if (rowAllZero(M, n, i) && colAllOne(M, n, i)) return i;
        }
        return -1; // only after checking every person
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] M = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                M[i][j] = sc.nextInt();

        System.out.println("Celebrity: " + celebrity(M, n));
        sc.close();
    }
}
//striver appproches 
class Find_The_Celebrity__277 {

    // ---------- Striver Brute: knowMe[] and Iknow[] arrays ----------
    static int celebrityBrute(int[][] M, int n) {
        int[] knowMe = new int[n];   // how many people know i
        int[] Iknow = new int[n];    // how many people i knows

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (M[i][j] == 1) {
                    knowMe[j]++;
                    Iknow[i]++;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (knowMe[i] == n - 1 && Iknow[i] == 0) return i;
        }
        return -1;
    }

    // ---------- Striver Optimal: two pointers ----------
    static int celebrityOptimal(int[][] M, int n) {
        int top = 0, down = n - 1;

        while (top < down) {
            if (M[top][down] == 1) top++;          // top knows down -> top is out
            else if (M[down][top] == 1) down--;    // down knows top -> down is out
            else { top++; down--; }                // neither knows the other -> both out
        }

        if (top > down) return -1;                 // both got eliminated, no candidate

        // verify the single candidate
        for (int i = 0; i < n; i++) {
            if (i == top) continue;
            if (M[top][i] == 1 || M[i][top] == 0) return -1;
        }
        return top;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] M = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                M[i][j] = sc.nextInt();

        System.out.println("Striver brute   : " + celebrityBrute(M, n));
        System.out.println("Striver optimal : " + celebrityOptimal(M, n));
        sc.close();
    }
}
//https://claude.ai/share/70ebaf38-41f5-49d7-ab93-6ca89d6516d9