/*Given an M * N matrix, print the elements in a clockwise spiral manner.

Return an array with the elements in the order of their appearance when printed in a spiral manner.

Example 1:
Input: matrix = [[1, 2, 3], [4 ,5 ,6], [7, 8, 9]]

Output: [1, 2, 3, 6, 9, 8, 7, 4, 5]

Explanation:

The elements in the spiral order are 1, 2, 3 -> 6, 9 -> 8, 7 -> 4, 5

Example 2:
Input: matrix = [[1, 2, 3, 4], [5, 6, 7, 8]]

Output: [1, 2, 3, 4, 8, 7, 6, 5]

Explanation:

The elements in the spiral order are 1, 2, 3, 4 -> 8, 7, 6, 5*/
import java.util.*;
class spiral_matrix {
    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        int m = s.nextInt();
        int n = s.nextInt();
        int arr [][] = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++) arr[i][j] = s.nextInt();
        }
        System.out.print(spiralOrder(arr));
    }
    public static List<Integer> spiralOrder(int[][] arr) {
        List<Integer> res = new ArrayList<>();
        int i=0,j=0; int r = arr.length; int c = arr[0].length;
            int r2=0, c2 = 0;
            int total = arr.length*(arr[0].length);
        while(res.size() <total){
            while(j<c){ // go left 
                res.add(arr[i][j]); j++;
                System.out.println("res now : "+res);
            }
           j--; i++;
            //return res;
           while(i<r){ // go down 
                res.add(arr[i][j]); i++;
                System.out.println("res now : "+res);
            }
            i--; j--;
            //return res;
           while(j>=c2 &&  res.size() < total){ // go left 
                res.add(arr[i][j]); j--;
                System.out.println("res now : "+res);
            }
            j++; i--;
            //return res;
            while(i>r2 &&  res.size() < total){ // go right 
                res.add(arr[i][j]); i--;
                System.out.println("res now : "+res);
            }
            i++; j++;
            //return res;
            c--; r--; c2++; r2++;
        }
        return res;
    }}
    // nen miss ayindi while lopala res.size rayadam , dani valla problem ayithadi ani nak teludu 
