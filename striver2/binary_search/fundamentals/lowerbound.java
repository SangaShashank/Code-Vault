/*Given a sorted array of nums and an integer x, write a program to find the lower bound of x.

The lower bound algorithm finds the first and smallest index in a sorted array where the value at that index is greater than or equal to a given key i.e. x.

If no such index is found, return the size of the array.

Example 1:
Input : nums= [1,2,2,3], x = 2

Output:1

Explanation:

Index 1 is the smallest index such that arr[1] >= x.

Example 2:
Input : nums= [3,5,8,15,19], x = 9

Output: 3

Explanation:

Index 3 is the smallest index such that arr[3] >= x*/
import java.util.*;
public class lowerbound{
    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int arr [] = new int[n];
        for(int i=0;i<n;i++) arr[i] = s.nextInt();
        int target = s.nextInt();
        System.out.println(app1(arr,n,target));
    }
    public static int app1(int arr[],int n,int target){
        int low = 0, high = n-1;
        int res = n; 
        while(low<=high){
            int mid = low + (high-low)/2;
            if(arr[mid]>= target){ // as it is question anntey 
                res = mid;
                high = mid -1; // heart of problem , as we need smallest index so it will search for that min possible index and once it fails it returns the smallest index
            }
            else{
                low = mid +1;
            }
            // bs laga 3 cases avasram ledu ee design lo 


        }
        return res;
        
    }
}
//https://claude.ai/share/13f524a4-7818-466d-9363-04f62daec3b7