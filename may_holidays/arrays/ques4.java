/*Given a sorted array, remove duplicates in-place such that each unique element
 appears only once. Return the new length.
Input:  [1, 1, 2, 3, 3, 4]
Output: 4  // array is now [1, 2, 3, 4, ...]
Constraints: O(1) extra space. Modify array in-place.
Hint
Hide follow-up
Mark solved
Explain solution ↗
Follow-up: What if each element is allowed to appear at most twice? */
import java.util.*;
public class ques4{
    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        String s1 [] = s.nextLine().split(",")        ;
        int arr [] = new int [s1.length];
        for (int i=0;i<s1.length;i++){
            arr[i] = Integer.parseInt(s1[i]);
        }
        int i=0, j = 1;
        while(j<s1.length){
            if(arr[i]== arr[j]){
                j++;
            }
            else{
                arr[i+1] = arr[j];
                i++; j++;
                System.out.println("Arrat now :"+ Arrays.toString(arr));

            }
        }
        System.out.println("Array length: "+ i+1);

    }
}