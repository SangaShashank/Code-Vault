/*Given an integer array nums, return a list of all the leaders in the array.

A leader in an array is an element whose value is strictly greater than all elements to its right in the given array. 
The rightmost element is always a leader. The elements in the leader array must appear in the order they appear in the nums array.

Example 1:
Input: nums = [1, 2, 5, 3, 1, 2]

Output: [5, 3, 2]

Explanation:

2 is the rightmost element, 3 is the largest element in the index range [3, 5], 5 is the largest element in the index range [2, 5]

Example 2:
Input: nums = [-3, 4, 5, 1, -4, -5]

Output: [5, 1, -4, -5]

Explanation:

-5 is the rightmost element, -4 is the largest element in the index range [4, 5], 1 is the largest element in the index range [3, 5] and 5 is the largest element in the range [2, 5]

Now Your Turn!
Pick the correct output for the given input
Input: nums = [-3, 4, 5, 1, -30, -10]


[-3, 4, 5]

[5, 1, -30]

[5, 1, -10]

[5, -10, 1]
Still unsure what the problem is asking ?

Let’s go through a few more examples, step by step, to make it clearer.

Constraints:
1 <= nums.length <= 105
-104 <= nums[i] <= 104*/
import java.util.*;
public class leaders_in_a_array {
    public static void main(String args[]){
        Scanner s= new Scanner(System.in);
        int n = s.nextInt();
        int arr [] = new int [n];
        for (int i=0;i<n;i++) arr[i] = s.nextInt();
        System.out.println(app1(arr));
        System.out.println(brinda(arr));

    }
    public static ArrayList<Integer> app1(int arr[]){
        ArrayList<Integer> res = new ArrayList<>();
        for(int i=0;i<arr.length;i++){ // last varaku check cheayali 
            if(can_leader(arr,i)){
                //System.out.println(res + " " +i);
                res.add(arr[i]);
            }
        }
        return res;
    }
    public static boolean can_leader(int arr[],int i){
        for (int j = i+1;j<arr.length;j++){
            if(arr[j]>=arr[i]) return false;
        }
        return true;
    }
    public static ArrayList<Integer> brinda(int arr[]){
        ArrayList<Integer> res = new ArrayList<>();
        int max = arr[arr.length-1];
        res.add(max);
        for(int j=arr.length-2;j>=0;j--){
            if(arr[j]>max){
                max = arr[j];
                res.add(max);
            }
        }
        Collections.reverse(res);
        return res;
}
}
//https://claude.ai/share/cf1e05b5-824c-4c74-b27d-8e1c4797ec62