/*Given an integer n, return the first n (1-Indexed) rows of Pascal's triangle.

In Pascal's triangle:

The first row has one element with a value of 1.
Each row has one more element in it than its previous row.
The value of each element is equal to the sum of the elements directly above it when arranged in a triangle format.
Example 1:
Input: n = 4

Output: [[1], [1, 1], [1, 2, 1], [1, 3, 3, 1]]

Explanation: The Pascal's Triangle is as follows:

1

1 1

1 2 1

1 3 3 1

1st Row has its value set to 1.

All other cells take their value as the sum of the values directly above them

Example 2:
Input: n = 5

Output: [[1], [1, 1], [1, 2, 1], [1, 3, 3, 1], [1, 4, 6, 4, 1]]

Explanation: The Pascal's Triangle is as follows:

1

1 1

1 2 1

1 3 3 1

1 4 6 4 1

1st Row has its value set to 1.

All other cells take their value as the sum of the values directly above them*/
import java.util.*;
public class Pascals_Triangle_3 {
    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        int r = s.nextInt();
        ArrayList<ArrayList<Integer>> pascal = build_pascal(r); // ofc no of rows ee kavali kada
        System.out.print(pascal);
        //System.out.print(pascal.get(r-1).get(c-1));
    }
    public static ArrayList<ArrayList<Integer>> build_pascal(int n){
         ArrayList<ArrayList<Integer>> res = new ArrayList<>();
         for(int i=0;i<n;i++){
            ArrayList<Integer> current = new ArrayList<>();
            current.add(1); // start index 

            for(int j=1;j<=i-1;j++){
                 ArrayList<Integer> prev = res.get(i-1); // pathadi pattuchi vadali kada 
                 current.add(prev.get(j)+prev.get(j-1));
            }
            if(i>0) current.add(1);
            res.add(current);
         }
         return res;
    }
}
//https://claude.ai/share/c275341e-7ec4-46f8-80a3-830fa71c620f