//package greedy.secduling and intervaling;
/*A software engineer is tasked with using the shortest job first (SJF) policy to calculate the average waiting time for each process. The shortest job first also known as shortest job next (SJN) scheduling policy selects the waiting process with the least execution time to run next.

You are given an array of integers bt of size n representing the burst times (execution times) of n processes.

Your task is to calculate the average waiting time for all processes when scheduled using the SJF policy. The waiting time of a process is the total time a process has to wait before its execution starts, which is the sum of burst times of all previously executed processes.

Return the floor of the average waiting time, i.e., the largest whole number less than or equal to the actual average.

Example 1:
Input : bt = [4, 1, 3, 7, 2]

Output : 4

Explanation : The total waiting time is 20.

So the average waiting time will be 20/5 => 4.

Example 2:
Input : bt = [1, 2, 3, 4]

Output : 2

Explanation : The total waiting time is 10.

So the average waiting time will be 10/4 => 2. */
import java.util.*;
public class Shortest_Job_First {
    public static void main(String args[]){
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();
        int arr [] = new int[n];
        for (int i=0;i<n;i++) arr[i] = s.nextInt();
        System.out.print(app1(arr));
    }
    public static long app1(int[] bt) {
        //your code goes here
        Arrays.sort(bt);
        double sum = 0;
        double wt = 0;
        for(int x : bt){
            wt += sum;
            sum += x;
            System.out.print(x + " "+ sum+ " ");
            System.out.println(x + " "+ wt);
        }
        return (long) Math.floor(wt/bt.length);
    }

}
//https://claude.ai/share/9ae557f1-65dd-4183-9324-75573cd706aa