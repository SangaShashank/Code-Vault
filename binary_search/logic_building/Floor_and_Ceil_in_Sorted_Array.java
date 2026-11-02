/*Given a sorted array nums and an integer x. Find the floor and ceil of x in nums. The floor of x is the largest element in the array which is smaller than or equal to x. The ceiling of x is the smallest element in the array greater than or equal to x. If no floor or ceil exists, output -1.

Example 1:
Input : nums =[3, 4, 4, 7, 8, 10], x= 5

Output: 4 7

Explanation: The floor of 5 in the array is 4, and the ceiling of 5 in the array is 7.

Example 2:
Input : nums =[3, 4, 4, 7, 8, 10], x= 8

Output: 8 8

Explanation: The floor of 8 in the array is 8, and the ceiling of 8 in the array is also 8.

Example 3:
Input : nums = [2, 4, 6, 8, 10, 12, 14], x= 1

Output:
[-1, 2]
Still unsure what the problem is asking ?

Let’s go through a few more examples, step by step, to make it clearer.

Constraints:
  1 <= nums.length <= 105 
  0 < nums[i], x < 105 
  nums is sorted in ascending order. */
import java.util.*;
public class  Floor_and_Ceil_in_Sorted_Array{
  public static void main(String args[]){
    Scanner s = new Scanner(System.in);
    int n = s.nextInt();
    int arr [] = new int[n];
    for (int i=0;i<n;i++) arr[i] = s.nextInt();
    int target = s.nextInt();
    System.out.print(Arrays.toString((bs(arr,n,target))));
  }
  public static int [] bs(int arr[], int n, int target){
    int res [] = new int[2];
    int low = 0, high = arr.length-1;
    while(low<= high){
    int mid = low + (high - low )/2;
    if(arr[mid] == target){
      res[0] = target; res[1] = target;
      return res;
    }
    else if(arr[mid]>target){
      high = mid -1;
    }
    else {
      low = mid +1;
    }
  }
    // security guards 
    if(high <0){ // see carefully high emo 0 vaipu vastunndi and low emo n vaipu vastunndi 
      res[0] = -1;
    }
    else{
      res[0] = arr[high];
    }
    // low kosam kuda 
    if(low > n-1){
      res[1] = -1;
    }
    else{
      res[1] = arr[low];
    }
  return res;

}
}
//https://claude.ai/share/0e375aca-e610-4a8e-83bf-c5eb9f4ef8bb 
//dsa 11
