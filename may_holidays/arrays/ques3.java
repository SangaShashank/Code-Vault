/*t.Given an array of integers, return the indices of the two numbers that add up to a target.
Input:  nums = [2, 7, 11, 15], target = 9
Output: [0, 1]  // because nums[0]+nums[1] = 9
Constraints: Exactly one solution exists. Cannot use same element twice.
Follow-up: What if you need all pairs, not just indices? What if the array is sorted? */
import java.util.*;

public class ques3{
    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int arr [] = new int[n];
        for(int i =0;i<n;i++){
            arr[i] = s.nextInt();

        }
        System.out.println("target: ");
        int k = s.nextInt();
        appraoch_1(arr,k); // brute force
        approach_2(arr,k); // two pointer
        approach_3(arr, k);
    }
    public static void appraoch_1(int arr[],int k){
        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                if(arr[i] + arr[j] == k){
                    System.out.println(i+","+j);
                    return ;
                }
            }
        }
    }
    public static void approach_2(int arr[], int k){
       
        int left = 0 , right = arr.length-1;
        while (left < right){
            if (arr[left] + arr[right] == k){
                System.out.print(left+","+right);
                return;
            }
            else if((arr[left] + arr[right]>k)){
                right--;
            }
            else{
                left++;
            }
        }
    }
    public static void approach_3(int arr[], int k){
        Map<Integer,Integer> m = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            if(m.containsKey(k-arr[i])){
                System.out.print(m.get(k-arr[i]) + " ," + i);
                return ;
                
            }
            else {
                m.put(arr[i],i);
            }
            System.out.println(i + " :" + m);
        }


    }
}
