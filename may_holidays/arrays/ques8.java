/*iven an integer array nums, return true if there exists a triple of indices (i, j, k)
 such that i < j < k and nums[i] < nums[j] < nums[k]. If no such indices exists, return false.
Example 1:

Input: nums = [1,2,3,4,5]
Output: true
Explanation: Any triplet where i < j < k is valid.
Example 2:

Input: nums = [5,4,3,2,1]
Output: false
Explanation: No triplet exists.
Example 3:

Input: nums = [2,1,5,0,4,6]
Output: true
Explanation: One of the valid triplet is (1, 4, 5), because nums[1] == 1 < nums[4] == 4 < nums[5] == 6.
 

Constraints:

1 <= nums.length <= 5 * 105
-231 <= nums[i] <= 231 - 1*/import java.util.*;
/*idhi moddalo logic annta public class ques8 {
    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        String s1  = s.nextLine();
        int arr [] = new int[s1.length()];
        int l=0;
        for(char c: s1.toCharArray()){ // idhi baguundi , koncham kothaga chesina 
            arr[l] = c - '0';
            l++;
        }
        //System.out.println(Arrays.toString(arr));
        int i=0,j=1,k=2;
        while(k<arr.length) {
            if(arr[i]<arr[j] && arr[i]<arr[k] && arr[j]<arr[k] ){
                System.out.print("valid");
                return;
            }
            if(arr[i] > arr[j]){
                i++; j++; k++;
            }
            if(arr[j]>arr[k]){
                k++;
            }
        }
        System.out.println("not valid");

    }
    
}
*/
/* ai code int first = Integer.MAX_VALUE;
int second = Integer.MAX_VALUE;

for(int num: arr){
    if(num <= first) first = num;
    else if(num <= second) second = num;
    else {
        System.out.println("valid");
        return;
    }
}

System.out.println("not valid");*/

