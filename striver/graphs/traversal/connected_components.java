/*Given a undirected Graph consisting of V vertices numbered from 0 to V-1 and E edges. The ith edge is represented by [ai,bi], denoting a edge between vertex ai and bi. We say two vertices u and v belong to a same component if there is a path from u to v or v to u. Find the number of connected components in the graph.

A connected component is a subgraph of a graph in which there exists a path between any two vertices, and no vertex of the subgraph shares an edge with a vertex outside of the subgraph.

Example 1:


Input: V=4, edges=[[0,1],[1,2]]

Output: 2

Explanation: Vertices {0,1,2} forms the first component and vertex 3 forms the second component.

Example 2:
Input: V = 7, edges = [[0, 1], [1, 2], [2, 3], [4, 5]]

Output: 3

Explanation:

The edges [0, 1], [1, 2], [2, 3] form a connected component with vertices {0, 1, 2, 3}.

The edge [4, 5] forms another connected component with vertices {4, 5}.

Therefore, the graph has 3 connected components: {0, 1, 2, 3}, {4, 5}, and the isolated vertices {6} (vertices 6 and any other unconnected vertices).

Example 3:
Input: V = 5, edges = [[0, 1], [1, 2], [3, 4]]

Output:
2
Still unsure what the problem is asking ?

Let’s go through a few more examples, step by step, to make it clearer.

Constraints:
1 ≤ V, edges.length ≤ 104
0 <= edges[i][0], edges[i][1] <= V-1
All edges are unique */
import java.util.*;
public class connected_components{
    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int e = s.nextInt();
        //input koncham marchina anthey 
        int arr[][] = new int[n][n];
        for (int i=0;i<e;i++){
            int u = s.nextInt();
            int v = s.nextInt();
            arr[u][v] = arr[v][u]= 1;
        }
        System.out.print(app1(arr,n));
    }
    public static int app1(int arr[][],int n){
        int count = 0;
        boolean visited [] = new boolean[n];
        for (int i=0;i<n;i++){
            if(visited[i]== false){
              bfs(visited,n,arr,i); // visited ni pratisari change chestadi 
                count++;
            }
        }
return count; 
    }
    public static void bfs(boolean visited[],int n , int arr[][],int source ){
        Queue<Integer> q = new LinkedList<>();
        visited[source] = true;
        q.add(source);
        while(!q.isEmpty()){
            int u = q.poll();
            for (int i=0;i<n;i++){
                if(visited[i]==false && arr[u][i] == 1){
                    visited[i]= true;
                    q.add(i);
                }
            }
        }
    }
}
// ippudu nen input marchina kada onlu adjaceny list tho :
/*import java.util.*;

public class connected_components {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int e = s.nextInt();

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>()); 
        // anni number of lists mundey chetunnam aa tarvata a list ki add chestunnam antey 

        for (int i = 0; i < e; i++) {
            int u = s.nextInt();
            int v = s.nextInt();
            adj.get(u).add(v);
            adj.get(v).add(u);   // undirected: add both ways
        }
        System.out.print(countComponents(adj, n));
    }

    static int countComponents(List<List<Integer>> adj, int n) {
        boolean[] visited = new boolean[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                bfs(adj, visited, i);
                count++;
            }
        }
        return count;
    }

    static void bfs(List<List<Integer>> adj, boolean[] visited, int source) {
        Queue<Integer> q = new ArrayDeque<>();
        visited[source] = true;
        q.add(source);
        while (!q.isEmpty()) {
            int u = q.poll();
            for (int nb : adj.get(u)) {       // only real neighbours
                if (!visited[nb]) {
                    visited[nb] = true;       // mark on push
                    q.add(nb);
                }
            }
        }
    }
} */
/*idhi emo dfs: 
static void dfs(List<List<Integer>> adj, boolean[] visited, int u) {
    visited[u] = true;
    for (int nb : adj.get(u))
        if (!visited[nb]) dfs(adj, visited, nb);
} */
//https://claude.ai/share/7f1266af-671e-49ee-b234-5cce1194cf92
