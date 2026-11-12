/*/*
Question:

Given an integer array nums and query values,
find the maximum length of a subsequence whose sum
is less than or equal to each query.

Input Format:
First line contains n.
Second line contains n array elements.
Third line contains q.
Fourth line contains q query values.

Output Format:
Print the maximum subsequence length for each query.

Sample Input:
4
4 5 2 1
3
3 10 21

Sample Output:
2 3 4
*/
import java.util.*;
public class Answer_Queries_with_Sum_of_Elements_2389{
    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int nums [] = new int [n];
        for(int i=0;i<n;i++) nums[i] = s.nextInt();
        int q = s.nextInt();
        int query [] = new int [q];
        for(int i=0;i<q;i++) query[i] = s.nextInt();
        int res [] = new int [q];
        int i=0;
        for(int x:query){
            res[i] = calc_max_sequence(nums,x);
            i++; 
        }
        System.out.print(Arrays.toString(res));

    }
    public static int calc_max_sequence(int nums[],int target){
        int left = 0, right = nums.length-1;
        int sum =0;
        int res =0 ;
        for(right = 0;right<nums.length;right++){
            sum += nums[right];
            while(sum>target && left <nums.length){
                sum-= nums[left];
                left++;
            }
            res = Math.max(res,right-left+1);

                }
                return res;

    }
}