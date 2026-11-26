/*A town has n blocks in a row, and the array gives the height of each block. After heavy rain, water collects over
a block when there is a taller (or equal) block somewhere on its left and also on its right. The water above
block i is the smaller of "the tallest block from the left end up to i" and "the tallest block from i to the right end",
minus the height of block i. The program builds two helper arrays for this: L[i] (tallest height from the left end up
to i) and R[i] (tallest height from i to the right end). It prints the total water collected and the block number
(counting from 1) where the water is deepest. If two blocks are equally deep, report the earliest. If no water
collects anywhere, the block number printed is 0.*/
public class RainTank {
    static int[] collect(int[] h) {
        int n = h.length;
        int[] L = new int[n], R = new int[n];
        L[0] = h[0];
        for (int i = 1; i < n; i++) L[i] = Math.max(L[i - 1], h[i]);
        R[n - 1] = h[0];
        for (int i = n - 2; i >= 0; i--) R[i] = Math.max(R[i + 1], h[i]);
        int total = 0, bestDepth = 0, bestIdx = -1;
        for (int i = 0; i < n; i++) {
            int w = Math.min(L[i], R[i]) - h[i];
            total += w;
            if (w > bestDepth) {
                bestDepth = w;
                bestIdx = i;
            }
        }
        return new int[]{total, bestIdx+1};
    }
    public static void main(String[] args) {
        int[] t1 = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int[] a = collect(t1);
        System.out.println("Town 1: water " + a[0] + ", deepest at block " + a[1]);
        int[] t2 = {3, 0, 2, 0, 4};
        int[] b = collect(t2);
        System.out.println("Town 2: water " + b[0] + ", deepest at block " + b[1]);
    }
}
/*Sample test cases
Array
Test 1
Expected output
{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1} Town 1: water 6, deepest at block 6
Test 2
{3, 0, 2, 0, 4}
Task: find and fix all the bugs.
Town 2: water 7, deepest at block 2 */