/*Given an undirected graph with V vertices. Two vertices u and v belong to a single province if there is a path from u to v or v to u. Find the number of provinces. The graph is given as an n x n matrix adj where adj[i][j] = 1 if the ith city and the jth city are directly connected, and adj[i][j] = 0 otherwise.

A province is a group of directly or indirectly connected cities and no other cities outside of the group.

Example 1:


Input: adj=[ [1, 0, 0, 1], [0, 1, 1, 0], [0, 1, 1, 0], [1, 0, 0, 1] ]

Output: 2

Explanation:In this graph, there are two provinces: [1, 4] and [2, 3]. City 1 and city 4 have a path between them, and city 2 and city 3 also have a path between them. There is no path between any city in province 1 and any city in province 2.

Example 2:
Input: adj= [ [1, 0, 1], [0, 1, 0], [1, 0, 1] ]

Output: 2

Explanation: The graph clearly has 2 Provinces [1,3] and [2]. As city 1 and city 3 has a path between them they belong to a single province. City 2 has no path to city 1 or city 3 hence it belongs to another province.

Example 3:
Input: adj= [ [1, 1], [1, 1] ]

Output:
1
Still unsure what the problem is asking ?

Let’s go through a few more examples, step by step, to make it clearer.

Constraints:
  1 <= V <= 300
  V == adj.length
  V == adj[i].length
  adj[i][j] is 1 or 0.
  adj[i][i] == 1
  a[i][j] == adj[j][i]*/
  import java.util.*;
  public class Number_Of_Provinces_547{
    public static void main(String args[]){
      Scanner s = new Scanner(System.in);
      int n = s.nextInt();
      int arr [][]= new int[n][n];
      for (int i=0;i<n;i++){
        for(int j=0;j<n;j++) arr[i][j] = s.nextInt();
      }    
      System.out.println(app1(arr,n));
    }
    public static int app1(int graph [][],int n){
      int count = 0;
      boolean visited [] = new boolean[n];
      //System.out.print(visited[2]);
      for(int i=0;i<n;i++){
        if(visited[i]!=true){ // visited false unntey ney call cheyali 
          bfs(visited,graph,n,i); // void enduku anntey manam visited okkati manuplate cheste chalu kada 
          count ++;
        }
      }
      return count;
    }
    public static void bfs(boolean [] visited,int graph[][],int n,int source){
      Queue<Integer> q = new LinkedList<>();
      q.add(source);
      visited[source] = true; // enque chesi viisted mark cheyali
      while(!q.isEmpty()){
        int u = q.poll();
      // visited[u] = true; // dequeue appudu vaddu le 
        for(int v=0;v<n;v++){
          if(visited[v]!=true && graph[u][v]!=0){
            q.add(v);
            visited[v] = true;// enque appudu mark cheayli 
          }
        }
      }


    }
  }
  //https://claude.ai/share/d219621e-076f-4d87-a871-4654472775c5
  