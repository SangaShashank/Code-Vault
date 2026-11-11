/*Given two integers r and c, return the value at the rth row and cth column (1-indexed) in a Pascal's Triangle.

In Pascal's triangle:

The first row contains a single element 1.
Each row has one more element than the previous row.
Every row starts and ends with 1.
For all interior elements (i.e., not at the ends), the value at position (r, c) is computed as the sum of the two elements directly above it from the previous row:
Pascal[r][c]=Pascal[r−1][c−1]+Pascal[r−1][c]
where indexing is 1-based
Example 1:
Input: r = 4, c = 2

Output: 3

Explanation:

The Pascal's Triangle is as follows:

1

1 1

1 2 1

1 3 3 1

....

Thus, value at row 4 and column 2 = 3

Example 2:
Input: r = 5, c = 3

Output: 6

Explanation:

The Pascal's Triangle is as follows:

1

1 1

1 2 1

1 3 3 1

1 4 6 4 1

....

Thus, value at row 5 and column 3 = 6*/
import java.util.*;
public class Pascals_Triangle_I {
    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        int r = s.nextInt();
        int c = s.nextInt();
        ArrayList<ArrayList<Integer>> pascal = build_pascal(r); // ofc no of rows ee kavali kada
        //System.out.print(pascal);
        System.out.print(pascal.get(r-1).get(c-1));
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
