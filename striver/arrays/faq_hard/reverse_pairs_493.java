/*152. Reverse Pairs
Given an integer array nums. Return the number of reverse pairs in the array.

An index pair (i, j) is called a reverse pair if:

0 <= i < j < nums.length
nums[i] > 2 * nums[j]
Example 1:
Input: nums = [6, 4, 1, 2, 7]

Output: 3

Explanation:

The reverse pairs are:

(0, 2) : nums[0] = 6, nums[2] = 1, 6 > 2 * 1

(0, 3) : nums[0] = 6, nums[3] = 2, 6 > 2 * 2

(1, 2) : nums[1] = 4, nums[2] = 1, 4 > 2 * 1

Example 2:
Input: nums = [5, 4, 4, 3, 3]

Output: 0

Explanation:

No pairs satisfy both the conditons.

Now Your Turn!
Pick the correct output for the given input
Input: nums = [6, 4, 4, 2, 2]


0

2

3

7
Still unsure what the problem is asking ?

Let’s go through a few more examples, step by step, to make it clearer.

Constraints:
1 <= nums.length <= 5 * 104
-231 <= nums[i] <= 231 - 1 */
import java.util.*;

public class reverse_pairs_493{
    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        long arr[] = new long [n]; // ade aa overflow kosam 
        for (int i=0;i<n;i++) arr[i]=  s.nextInt();
        System.out.print(app1(arr,n));
    }
    public static int app1(long arr[], int n){
        int count = 0;
        for (int i=0;i<n-1;i++){
            for(int j = i+1;j<n;j++){ // i must be less than j question lo annadu 
                if(arr[i]>2*arr[j]) count ++;
            }
        }
        return count;
    }


}