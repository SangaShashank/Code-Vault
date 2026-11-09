/*Given an 2D array Jobs of size Nx3, where Jobs[i][0] represents JobID , Jobs[i][1] represents Deadline , Jobs[i][2] represents Profit associated with that job. Each Job takes 1 unit of time to complete and only one job can be scheduled at a time.

The profit associated with a job is earned only if it is completed by its deadline. Find the number of jobs and maximum profit.

Example 1:
Input : Jobs = [ [1, 4, 20] , [2, 1, 10] , [3, 1, 40] , [4, 1, 30] ]

Output : 2 60

Explanation : Job with JobID 3 can be performed at time t=1 giving a profit of 40.

Job with JobID 1 can be performed at time t=2 giving a profit of 20.

No more jobs can be scheduled, So total Profit = 40 + 20 => 60.

Total number of jobs completed are two, JobID 1, JobID 3.

So answer is 2 60.

Example 2:
Input : Jobs = [ [1, 2, 100] , [2, 1, 19] , [3, 2, 27] , [4, 1, 25] , [5, 1, 15] ]

Output : 2 127

Explanation : Job with JobID 1 can be performed at time time t=1 giving a profit of 100.

Job with JobID 3 can be performed at time t=2 giving a profit of 27.

No more jobs can be scheduled, So total Profit = 100 + 27 => 127.

Total number of jobs completed are two, JobID 1, JobID 3.

So answer is 2 127. */
import java.util.*;
public class Job_Sequencing_Problem{
    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int arr [][] = new int [n][3];
        for(int i=0;i<n;i++){
            for(int j=0;j<3;j++) arr[i][j] = s.nextInt();
        }
        System.out.print(app1(arr));
       // System.out.print(app2(arr));
    }
   /* my attempts :
    public static int app1(int arr[][]){
        int time = 1, val = 0;
        boolean not_found_job = false;
        while(!not_found_job){
            int val_max = 0;
            not_found_job = true; // defalt 
        for (int i = 0;i<arr.length;i++){
            if(arr[i][1]>= time){
                not_found_job = false;
                val_max= Math.max(arr[i][2],val_max);
                //System.out.println(val_max);
            }
        }
        if(!not_found_job) {
            val+= val_max;
            System.out.println(val_max + " " + val);
            time+= 1;
        }
        else{
            break;
        }
    }

    return val;
}
public static int app2(int arr[][]){
    for (int i=0;i<arr.length;i++){
        for(int j=0;j<arr.length-1;j++){
            if(arr[j][1]>arr[j+1][1]){ // greater deadline
                int temp = arr[j][0];
                arr[j][0] = arr[j+1][0];
                arr[j+1][0] = temp;
                int temp2 = arr[j][1];
                arr[j][1] = arr[j+1][1];
                arr[j+1][1] = temp2;
                int temp3 = arr[j][2];
                arr[j][2] = arr[j+1][2];
                arr[j+1][2] = temp3;
            }
            else if(arr[j][1] == arr[j+1][1] && arr[j][2] < arr[j+1][2]){
                 // same deadline then check for value  
                int temp = arr[j][0];
                arr[j][0] = arr[j+1][0];
                arr[j+1][0] = temp;
                int temp2 = arr[j][1];
                arr[j][1] = arr[j+1][1];
                arr[j+1][1] = temp2;
                int temp3 = arr[j][2];
                arr[j][2] = arr[j+1][2];
                arr[j+1][2] = temp3;
        }
    }
}
// sort ayindi 
int time = 1, val = 0;
for (int x []:arr){
    System.out.print(Arrays.toString(x)); 
    if(x[1]>= time) {
        time += 1;
        val += x[2];
    }
}
return val;
}
}*/
// striver solution :
    // Approach 1: Greedy + Sorting
    // Time: O(n log n + n * maxDeadline)
    // Space: O(maxDeadline)
    public static int[] app1(int arr[][]) {

        int n = arr.length;

        // Sort jobs according to profit (descending)
        Arrays.sort(arr, (a, b) -> b[2] - a[2]); // idhi alavatu chesukovali 

        int totProfit = 0;
        int cnt = 0;
        int maxDeadline = -1;

        // Find maximum deadline
        for(int i = 0; i < n; i++) {
            maxDeadline = Math.max(maxDeadline, arr[i][1]); // max no of days kosam kavali
        }

        // -1 means slot is free
        int hash[] = new int[maxDeadline + 1]; // plus one enduku anntey to manage zero based index , array 0 nunchi start ayina , we conisider days form 1 enduku anntey day 0 unndadu kabatti 

        Arrays.fill(hash, -1); // kali slots

        // Schedule jobs
        for(int i = 0; i < n; i++) {
            // Find latest available slot
            for(int j = arr[i][1]; j >= 1; j--) { //start ee deadline unna riju nunchi chesaru 
                if(hash[j] == -1) {
                    cnt++;
                    hash[j] = arr[i][0];
                    totProfit += arr[i][2];
                    break;
                }
            }
        }
        return new int[]{cnt, totProfit};
    }
}
