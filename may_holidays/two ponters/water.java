/*Problem: Container With Most Water (Two Pointer Technique)
Problem Statement:
You are given an integer array height of length n.
Each element represents the height of a vertical line drawn at that index.
Find two lines that, together with the x-axis, form a container such that the
container holds the maximum amount of water.
Note:
You may not tilt the container.
Input:
An integer array height of size n.
Output:
Return an integer representing the maximum amount of water that can be stored.
Examples:
Example 1:
Input:
height = [1,8,6,2,5,4,8,3,7]
Output:
49

Explanation:
The maximum area is obtained by choosing lines at index 1 and 8.
Width = 8 - 1 = 7
Height = min(8, 7) = 7
Area = 7 * 7 = 49

Example 2:
Input:
height = [1,1]

Output:
1

Constraints:
2 ≤ n ≤ 10^5
0 ≤ height[i] ≤ 10^4

Expected Time Complexity:
O(n)

Expected Space Complexity:
O(1)

Approach Hint:
- Use two pointers: one at the start and one at the end
- Calculate ar
 */
public class water {
    
}
