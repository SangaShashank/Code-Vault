/*Given an n x m grid, where each cell has the following values : 

2 - represents a rotten orange

1 - represents a Fresh orange

0 - represents an Empty Cell

Every minute, if a fresh orange is adjacent to a rotten orange in 4-direction ( upward, downwards, right, and left ) it becomes rotten. 

Return the minimum number of minutes required such that none of the cells has a Fresh Orange. If it's not possible, return -1.

Example 1:
Input: grid = [ [2, 1, 1] , [0, 1, 1] , [1, 0, 1] ]

Output: -1

Explanation: Orange at (3,0) cannot be rotten.



Example 2:
Input: grid = [ [2,1,1] , [1,1,0] , [0,1,1] ] 

Output: 4

Explanation:



Now Your Turn!
Pick the correct output for the given input
Input: grid = [[0,1,2],[0,1,2],[2,1,1]]


0

2

1

3
Still unsure what the problem is asking ?

Let’s go through a few more examples, step by step, to make it clearer.

Constraints:
  1 <= n, m <= 500
  grid[i][j] == 0 or 1 or 2
Advertisements

 */
import java.util.*;
public class rotten_oranges{
  public static void main(String args[]){
    Scanner s = new Scanner(System.in);
    int m = s.nextInt();
    int n = s.nextInt();
    int arr [][] = new int[m][n];
    for (int i=0;i<m;i++){
      for(int j=0;j<n;j++){
        arr[i][j] = s.nextInt();

      }
    }
    System.out.print(app1(arr,m,n));
  }
  public static int app1(int arr[][], int m ,int n ){
    Queue <int []> q = new LinkedList<>();
    int fresh = 0;
    // all the intial 2's and fresh oranges count cheddam , rotten queue loki add cheddam 
    for (int i=0;i<m;i++){
      for(int j=0;j<n;j++){
        if(arr[i][j] == 2) q.add(new int[]{i,j});
        if(arr[i][j] == 1 ) fresh++;
      }
    }
    int minutes = 0;
    while(!q.isEmpty() && fresh >0){ // fresh condition marchipoyinam 
      int size = q.size();
      for (int i=0;i<size;i++){
        int rot_pos [] = q.poll();
        fresh =  rot_the_oranges(arr,rot_pos,fresh,q);
        System.out.print("fresh now :" + fresh);
      }
      minutes++;
    }
    // ippudu while end ayidi anntey rot process complete ayindi 
    if(fresh!= 0) return -1; // question mention chesadu kada andukey ila 
    return minutes;
     
  }
  public static int rot_the_oranges(int arr[][],int [] rot_pos, int fresh, Queue<int []> q ){
    int neigh [][] = {{0,-1},{0,1},{-1,0},{1,0}} ;
    for (int []k :neigh){
      int x = rot_pos[0] + k[0];
      int y = rot_pos [1] + k[1];
      if(x>=0 && y>=0 && x<arr.length && y<arr[0].length && arr[x][y] == 1){
        arr[x][y] = 2; //  rot chestuunnam 
        q.add(new int []{x,y}); // next round kosam 
        fresh --; // ade mana counter 
      }
    }
  return  fresh;
}
}
//https://claude.ai/share/ec64423a-0aba-4f16-9046-53260ee16547