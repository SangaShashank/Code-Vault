/*Given an array of N intervals in the form of (start[i], end[i]), where start[i] is the starting point of the interval and end[i] is the ending point of the interval, return the minimum number of intervals that need to be removed to make the remaining intervals non-overlapping.

Note:

Intervals which only touch at a point are also considered as non-overlapping. For example, [1, 3] and [3, 4] are non-overlapping.

Example 1:
Input : Intervals = [ [1, 2] , [2, 3] , [3, 4] ,[1, 3] ]

Output : 1

Explanation : You can remove the interval [1, 3] to make the remaining interval non overlapping.

Example 2:
Input : Intervals = [ [1, 3] , [1, 4] , [3, 5] , [3, 4] , [4, 5] ]

Output : 2

Explanation : You can remove the intervals [1, 4] and [3, 5] and the remaining intervals becomes non overlapping.

Now Your Turn1 <= Intervals.length <= 105
0 <= start[i] < end[i] <= 105
Intervals[i].length = 2
*/
//package greedy.secduling and intervaling;
import java.util.*;
public class Non_Overlapping_Intervals {
    public static void main(String args[]){
    Scanner s = new Scanner(System.in);
    int n = s.nextInt();
    //input oorikey koncham variety ga tesukunna 
    /*ArrayList<int[]> interval = new ArrayList<>();
    for(int i=0;i<n;i++){
        interval.add(new int[]{s.nextInt(),s.nextInt()});
    }
    for (int[] k : interval) {
    System.out.println(Arrays.toString(k));*/
    int interval [][] = new int[n][2]; // pratidaniki 2 kada 
    for (int i=0;i<n;i++){
        for(int j = 0;j<2;j++){
            interval[i][j] = s.nextInt();
        }
        }
    for (int[] k : interval) {
    System.out.println(Arrays.toString(k));
    }
    System.out.print(app1(interval));
}
public static int app1(int [][] interval){
    int count = 1; // imp :already 1st interval ni consider chesam kada , chala imp 
    Arrays.sort(interval, (a,b) -> Integer.compare(a[1], b[1])); //comparator vadinam on end time 
    int lastendtime = interval[0][1]; // akkada emo -1 kada 
    for (int i=1;i<interval.length;i++){
        if(interval[i][0]>=lastendtime){ // start is greater than lastendtime, = ni question accept chesindi 
            lastendtime = interval[i][1];
            count ++;
        }
    }
    return interval.length- count;
}

}
//https://claude.ai/share/8eba1e99-e0be-4789-9a83-3602de605fd7