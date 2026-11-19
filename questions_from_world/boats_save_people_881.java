/*ou are given an array people where people[i] is the weight of the ith person, and an infinite number of boats where each boat can carry a maximum weight of limit. Each boat carries at most two people at the same time, provided the sum of the weight of those people is at most limit.

Return the minimum number of boats to carry every given person.

 

Example 1:

Input: people = [1,2], limit = 3
Output: 1
Explanation: 1 boat (1, 2)
Example 2:

Input: people = [3,2,2,1], limit = 3
Output: 3
Explanation: 3 boats (1, 2), (2) and (3)
Example 3:

Input: people = [3,5,3,4], limit = 5
Output: 4
Explanation: 4 boats (3), (3), (4), (5)
 

Constraints:

1 <= people.length <= 5 * 104
1 <= people[i] <= limit <= 3 * 104 */
import java.util.*;
public class boats_save_people_881{
    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int arr [] = new int [n];
        for (int i=0;i<n;i++) arr[i] = s.nextInt();
        int limit = s.nextInt();
        System.out.print(app1(arr,limit));

    }
    public static int app1(int arr[], int limit ){
      //Arrays.sort(arr,Collections.reverseOrder()); // reverse order on int [] pani cheaydu annta 
      // so andukey ila 
      Arrays.sort(arr);
      int i = 0, j = arr.length-1;
      while(i<j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp; i++; j--;
      }
      int boats = 0;
      int heavy = 0, light = arr.length -1;
      while(heavy<=light){
        if((arr[heavy] + arr[light])<= limit ) {heavy++; light --; boats++;}
        else if(arr[heavy]<=limit) {heavy++; boats++;}
      }
      return boats;
      
    }
}
// inka manchiga cheyali anntey 
/*Arrays.sort(arr);
int lo = 0, hi = arr.length - 1, boats = 0;
while (lo <= hi) {
    if (arr[lo] + arr[hi] <= limit) lo++;
    hi--;
    boats++;
} */
