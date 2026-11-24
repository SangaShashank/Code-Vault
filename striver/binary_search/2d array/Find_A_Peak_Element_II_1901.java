/* peak element in a 2D grid is an element that is strictly greater than all of its adjacent neighbors to the left, right, top, and bottom.

Given a 0-indexed m x n matrix mat where no two adjacent cells are equal, find any peak element mat[i][j] and return the length 2 array [i,j].

You may assume that the entire matrix is surrounded by an outer perimeter with the value -1 in each cell.

You must write an algorithm that runs in O(m log(n)) or O(n log(m)) time.*/

import java.util.*;

public class Find_A_Peak_Element_II_1901 {

    // Brute: check every cell against 4 neighbors
    static int[] brute(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int up = i > 0 ? mat[i - 1][j] : -1;
                int down = i < m - 1 ? mat[i + 1][j] : -1;
                int left = j > 0 ? mat[i][j - 1] : -1;
                int right = j < n - 1 ? mat[i][j + 1] : -1;
                if (mat[i][j] > up && mat[i][j] > down
                        && mat[i][j] > left && mat[i][j] > right) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1};
    }

    // Better: global maximum is always a peak
    static int[] better(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int maxVal = -1, r = -1, c = -1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] > maxVal) {
                    maxVal = mat[i][j];
                    r = i;
                    c = j;
                }
            }
        }
        return new int[]{r, c};
    }

    // Helper: row index of max element in a column
    static int maxRowInCol(int[][] mat, int col) {
        int row = 0;
        for (int i = 1; i < mat.length; i++) {
            if (mat[i][col] > mat[row][col]) row = i;
        }
        return row;
    }

    // Optimal: binary search on columns
    static int[] optimal(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int lo = 0, hi = n - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int row = maxRowInCol(mat, mid);
            int cur = mat[row][mid];
            //security guards 
            int left = mid - 1 >= 0 ? mat[row][mid - 1] : -1;
            int right = mid + 1 < n ? mat[row][mid + 1] : -1;

            if (cur > left && cur > right) return new int[]{row, mid};
            else if (left > cur) hi = mid - 1; //binary search - heart of the problem 
            else lo = mid + 1;
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] mat = new int[m][n];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                mat[i][j] = sc.nextInt();

        System.out.println("Brute   : " + Arrays.toString(brute(mat)));
        System.out.println("Better  : " + Arrays.toString(better(mat)));
        System.out.println("Optimal : " + Arrays.toString(optimal(mat)));
        sc.close();
    }
}