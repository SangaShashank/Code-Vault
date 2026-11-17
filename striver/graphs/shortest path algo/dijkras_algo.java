/*Given a weighted, undirected graph of V vertices, numbered from 0 to V-1, and an 2D vector/array which represents the edges:

Each entry in edges[i] is of the form [u, v, weight], where:

u, v → represents the vertex having undirected edge between them
weight → the weight of the edge between u and v
Given a source node S. Find the shortest distance of all the vertex from the source vertex S. Return a list of integers denoting shortest distance between each node and source vertex S. If a vertex is not reachable from source then its distance will be 109.

Example 1:


Input: V = 2, edges = [[0,1,9]] , S=0

Output: [0, 9]

Explanation:

The shortest distance from node 0(source) to node 0 is 0 and the shortest distance from node 0 to node 1 is 9.

Example 2:


Input: V = 3, edges = [[0, 1, 1], [0, 2, 6], [1, 2, 3]] , S=2

Output: [4, 3, 0]

Explanation: 

For node 0, the shortest path is 2->1->0 (distance=4)

For node 1, the shortest path is 2->1 (distance=3)

Now Your Turn!
Pick the correct output for the given input
Input: V=4, edges = [[0,1,1],[0,3,2],[1,2,4],[2,3,3]] , S=0


[1, 5, 2, 0]

[0, 5, 1, 2]

[0, 1, 5, 2]

[0, 1, 1, 5]
Still unsure what the problem is asking ?

Let’s go through a few more examples, step by step, to make it clearer.

Constraints:
1 ≤ V ≤ 10000
0 ≤ edges[i][j] ≤ 10000
1 ≤ edges.size() ≤ [ (V*(V - 1)) / 2 ]
0 ≤ S < V*/
import java.util.*;
public class dijkras_algo{
    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int arr[][] = new int[n][n];
        for (int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                arr[i][j] = arr[j][i] = s.nextInt();
            }
        }
        int source = s.nextInt();
        System.out.print(Arrays.toString(app1(arr,source)));

    }
    public static int [] app1(int arr[][], int source){
        boolean visited [] = new boolean[arr.length];
        int min_dist[] = new int[arr.length];
        //prerequistes anukoo iga 
        for (int i=0;i<arr.length;i++) min_dist[i] = Integer.MAX_VALUE;
        min_dist[source] = 0;
        for(int i=0;i<arr.length;i++){
            //pick the unvisited smallest index 
            int u = min_dist_vertex(arr,min_dist,visited);
            if(u==-1){
                return min_dist; // process ayipoyindi 
            }
            visited[u] = true;
            for(int v=0;v<arr.length;v++){
                if(visited[v] == false && arr[u][v] !=0 && min_dist[v]>min_dist[u]+arr[u][v]){
                    min_dist[v]=min_dist[u]+arr[u][v];
                }
            }
        }
        return min_dist;
    }
    public static int min_dist_vertex(int arr[][], int min_dist[],boolean visited[]){
        int mindist = Integer.MAX_VALUE;
        int best_vertex = -1;
        for(int i=0;i<arr.length;i++){
            if(visited[i]!=true && mindist>min_dist[i]){
                mindist = min_dist[i];
                best_vertex = i;
            }
        }
        return best_vertex;
    }
}