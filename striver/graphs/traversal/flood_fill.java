/*An image is represented by a 2-D array of integers, each integer representing the pixel value of the image. Given a coordinate (sr, sc) representing the starting pixel (row and column) of the flood fill, and a pixel value newColor, "flood fill" the image.

To perform a flood fill, consider the starting pixel, plus any pixels connected 4-directionally to the starting pixel of the same colour as the starting pixel, plus any pixels connected 4-directionally to those pixels (also with the same colour as the starting pixel), and so on. Replace the colour of all of the aforementioned pixels with the newColor.

Example 1:


Input: image = [ [1, 1, 1], [1, 1, 0], [1, 0, 1] ], sr = 1, sc = 1, newColor = 2

Output: [ [2, 2, 2], [2, 2, 0], [2, 0, 1] ]

Explanation: From the center of the image with position (sr, sc) = (1, 1) (i.e., the red pixel), all pixels connected by a path of the same color as the starting pixel (i.e., the blue pixels) are colored with the new color.

Note the bottom corner is not colored 2, because it is not 4-directionally connected to the starting pixel.

Example 2:
Input: image = [ [0, 1, 0], [1, 1, 0], [0, 0, 1] ], sr = 2, sc = 2, newColor = 3

Output: [ [0, 1, 0], [1, 1, 0], [0, 0, 3] ]

Explanation: Starting from the pixel at position (2, 2) (i.e., the blue pixel), we flood fill all adjacent pixels that have the same color as the starting pixel. In this case, only the pixel at position (2, 2) itself is of the same color. So, only that pixel gets colored with the new color, resulting in the updated image.

Now Your Turn!
Pick the correct output for the given input
Input: image = [ [1, 1, 1], [1, 1, 0], [1, 0, 1] ], sr = 1, sc = 1, newColor = 0


[ [0, 0, 0], [0, 0, 0], [0, 0, 0] ]

[ [0, 0, 0], [0, 0, 0], [1, 0, 1] ]

[ [0, 0, 0], [0, 0, 0], [1, 0, 0] ]

[ [0, 0, 0], [0, 0, 0], [0, 0, 1] ]
Still unsure what the problem is asking ?

Let’s go through a few more examples, step by step, to make it clearer.

Constraints:
·  n == image.length

·  m == image[i].length

·  1 <= m, n <= 50

·  0 <= image[i][j], color < 216

·  0 <= sr < n

·  0 <= sc < m

Advertisements


Hints
Hint 1
Hint 2
Frequently Occurring Doubts
How do we prevent infinite loops when filling?
What happens if newColor is the same as the original color?
Interview Follow-up Questions
How would you modify this if pixels had multiple properties (e.g., color and texture)?
Can flood fill be used for maze-solving or pathfinding?
Fun Facts
Fun Fact 1
Fun Fact 2 */
import java.util.*;
public class flood_fill{
    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int arr[][]= new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++) arr[i][j] =s.nextInt();
        }
        int sr = s.nextInt();
        int sc = s.nextInt();
        int new_pixel = s.nextInt();
        app1(arr,n,sr,sc,new_pixel);
        System.out.println(Arrays.deepToString(arr)); //2d arrays kosam annta 
    }
    public static int[][] app1(int grid[][],int n,int sr,int sc , int new_pixel){
        Queue<int []> q = new LinkedList<>();  
        int old_pixel = grid[sr][sc]; // comparision tarvata kavali kada 
        q.add(new int[]{sr,sc});
        grid[sr][sc] = new_pixel; // enque tarvata visited
        int neighbours [][] = {{0,-1},{-1,0},{1,0},{0,1}};
        while(!q.isEmpty()){
            int current [] = q.poll();
            for(int x[]:neighbours){
                int i = current[0]+x[0];
                int j = current[1]+x[1];
                if(i>=0 && j>=0 && i<grid.length &&  j<grid[0].length && grid[i][j]==old_pixel){
                    q.add(new int[]{i,j});
                    grid[i][j] = new_pixel; // same enque tarvata visited 
                }
            }
        }
        return grid;
    }
}