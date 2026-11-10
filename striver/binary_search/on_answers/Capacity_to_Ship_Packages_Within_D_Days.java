/*You are given an array weights where weights[i] represents the weight of the i-th package on a conveyor belt. All the packages must be shipped in the order given from one port to another within days days.

Each day, the ship can carry a contiguous sequence of packages, as long as the total weight does not exceed its maximum capacity.

Your task is to find the minimum possible capacity of the ship so that all packages can be shipped within the given number of days.

Example 1:
Input: weights = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10], days = 5

Output: 15

Explanation:

Minimum ship capacity = 15. One way to ship in 5 days:

Day 1: 1 + 2 + 3 + 4 + 5 = 15
Day 2: 6 + 7 = 13
Day 3: 8
Day 4: 9
Day 5: 10
No day exceeds capacity 15 and all packages are shipped in order in 5 days.

Example 2:
Input: weights = [3, 2, 2, 4, 1, 4], days = 3

Output: 6

Explanation:

One possible division with capacity 6:

Day 1: 3 + 2 = 5
Day 2: 2 + 4 = 6
Day 3: 1 + 4 = 5
All packages shipped in order within 3 days.
Constraints:
1 <= days <= weights.length <= 5 * 10⁴
1 <= weights[i] <= 500*/
import java.util.*;
public class Capacity_to_Ship_Packages_Within_D_Days {
public static void main(String args[]) {
    Scanner s = new Scanner (System.in);
    int n = s.nextInt();
    int arr [] = new int [n];
    for(int i=0;i<n;i++) arr[i]= s.nextInt();
    int days = s.nextInt();
    System.out.println(app1(arr,days));
}
public static int app1(int arr [], int days){
    int low = Integer.MIN_VALUE,high = 0;
    for(int x :arr) {
        low = Math.max(low,x); // heart of the problem 
        high += x;
    }
    int res = -1;
    while(low <= high ){
        int mid = low + (high - low)/2;
        if(calc_days(arr,mid)<= days) { //  with in days kada 
            res = mid; high = mid - 1;
        }
        else { low = mid +1;}
    }
    return res;
}
public static int calc_days(int arr[], int capacity){
    int current_capacity = capacity;
    int days = 1; // day one nuuchi start avvali enduku anntey aadhi ofc kabatti 
    for (int i=0;i<arr.length;i++){
        if(arr[i]<= current_capacity){
            current_capacity-= arr[i];
        }
        else{
            current_capacity = capacity; // refuel cheyali kada ofc 
            days ++; // oka day ayipoindi 
            current_capacity -= arr[i]; // refuel chesam bane unndi kani, current arr[i] pasitit endi , adhi kotha day capacity lo add kavali kada , andukey add chestunnam ikkada 
            // idey nen marchipoyina (sad)
        }
    }
    return days;
}
}
//https://claude.ai/share/cde1a74c-274d-48f3-ba5d-579fd1cdd5bd
