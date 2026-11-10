/*Given a list of integers, use Java Streams to find the count, sum, average, min, and max in a single pipeline.
Input:  [3, 1, 4, 1, 5, 9, 2, 6]
Output: count=8, sum=31, avg=3.875, min=1, max=9
Constraints: Single stream pass using IntSummaryStatistics.
Hint
Hide follow-up
Mark solved
Explain solution ↗
Follow-up: Why can you not reuse a Stream after a terminal operation? */
import java.util.*;
public class ques1{
    public static void main(String args[]){
        ArrayList <Integer> l = new ArrayList<>((Arrays.asList(3, 1, 4, 1, 5, 9, 2, 6)));
        System.out.print(l.stream().count());
       l.stream().foreach(n -> sum + n);
    }
}