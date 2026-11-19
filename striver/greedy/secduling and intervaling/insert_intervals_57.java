/*Given a 2D array Intervals, where Intervals[i] = [start[i], end[i]] represents the start and end of the ith interval, the array represents non-overlapping intervals sorted in ascending order by start[i]. 

Given another array newInterval, where newInterval = [start, end] represents the start and end of another interval, merge newInterval into Intervals such that Intervals remain non-overlapping and sorted in ascending order by start[i].

Return Intervals after the insertion of newInterval.

Example 1:
Input : Intervals = [ [1, 3] , [6, 9] ] , newInterval = [2, 5]

Output : [ [1, 5] , [6, 9] ]

Explanation : After inserting the newInterval the Intervals array becomes [ [1, 3] , [2, 5] , [6, 9] ].

So to make them non overlapping we can merge the intervals [1, 3] and [2, 5].

So the Intervals array is [ [1, 5] , [6, 9] ].

Example 2:
Input : Intervals = [ [1, 2] , [3, 5] , [6, 7] , [8,10] ] , newInterval = [4, 8]

Output : [ [1, 2] , [3, 10] ]

Explanation : The Intervals array after inserting newInterval is [ [1, 2] , [3, 5] , [4, 8] , [6, 7] , [8, 10] ].

We merge the required intervals to make it non overlapping.

So final array is [ [1, 2] , [3, 10] ].

Now Your Turn!
Pick the correct output for the given input
Input : Intervals = [ [1, 2] , [3, 5] , [6, 7] , [8,10] ] , newInterval = [1, 8]


[ [1, 10] ]

[ [1, 7], [8, 10] ]

[ [1, 2] , [1, 8], [3, 5] , [6, 7] , [8,10] ]

[ [1, 8] , [8,10] ]
Still unsure what the problem is asking ?

Let’s go through a few more examples, step by step, to make it clearer.

Constraints:
0 <= Intervals.length <= 105
0 <= start[i] < end[i] <= 107
0 <= start < end <= 107
Intervals[i].length = 2
newInterval.length = 2 */
//cosmetic changes unnai 
import java.util.*;
public class insert_intervals_57{
    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int arr[][] = new int[n][2];
        for (int i = 0;i<n;i++){
            for (int j = 0;j<2;j++) arr[i][j] = s.nextInt();
        }
        int new_interval [] = new int []{s.nextInt(),s.nextInt()};
        // idhi cute unndi 
     List<int[]> res = new ArrayList<>();
     res = (app1(arr,new_interval));
     for (int x []: res){
        System.out.print(Arrays.toString(x));
     }
    }
    public static List<int []> app1(int [][] interval, int [] new_interval){
        int i=0;
        List<int []> res = new ArrayList<>();
        while(i<interval.length && interval[i][1]<new_interval[0] ){ // before concepts 
            res.add(interval[i]); 
            i++;
        }
        while(i<interval.length && interval[i][0]<=new_interval[1]){
            new_interval[0] = Math.min(new_interval[0],interval[i][0]); //min of start 
            new_interval[1] = Math.max(new_interval[1], interval[i][1]); // max of end 
            i++;
        }
        res.add(new_interval); // merged interval add chesinam 
        while(i<interval.length){ // rest over intervals 
            res.add(interval[i]);
            i++;
        }
        return res;
    }
}