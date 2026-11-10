/*You have a long flowerbed in which some of the plots are planted, and some are not. However, flowers cannot be planted in adjacent plots.
Given an integer array flowerbed containing 0's and 1's, where 0 means empty and 1 means not empty, and an integer n, return true if n new flowers can be planted in the flowerbed without violating the no-adjacent-flowers rule and false otherwise.
Example 1:
Input: flowerbed = [1,0,0,0,1], n = 1
Output: true
Example 2:
Input: flowerbed = [1,0,0,0,1], n = 2
Output: false
Constraints:
1 <= flowerbed.length <= 2 * 104
flowerbed[i] is 0 or 1.
There are no two adjacent flowers in flowerbed.
0 <= n <= flowerbed.length*/
import java.util.*;
public class ques7 {
    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        String s1 [] = s.nextLine().split(",");
        int arr [] = new int [s1.length];
        for(int i=0;i<s1.length;i++){
            arr[i]= Integer.parseInt(s1[i]);
        }
        int i=0;
        int n = s.nextInt();
        while(i<arr.length){
            if(n==0){
                System.out.println("True");
                return ;
            }
            if(arr[i]==0){ // can place 
                if(i==0 && arr[i+1]!=1){ // starting 
                    arr[i] = 1; n--; i = i+ 2;  // flower place chesi next elago avsaram ledu kabbati moving 2 steps ahead
                }
                else if(i==arr.length-1 && arr[i-1]!=1){ // end 
                    arr[i] = 1; n--; i = i+2;
                }
                else{ // anntey midlle 
                    if(arr[i+1]!=1 && arr[i-1]!=1){
                        arr[i] = 1; n--; i = i+2;
                    }
                }
            }
            else{
                i++;
            }
        }
        System.out.println(Arrays.toString(arr));

    }
    
}
