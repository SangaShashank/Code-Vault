/*901. Online Stock Span
Medium
Topics
premium lock icon
Companies
Design an algorithm that collects daily price quotes for some stock and returns the span of that stock's price for the current day.

The span of the stock's price in one day is the maximum number of consecutive days (starting from that day and going backward) for which the stock price was less than or equal to the price of that day.

For example, if the prices of the stock in the last four days are [7,2,1,2] and the price of the stock today is 2, then the span of today is 4 because starting from today, the price of the stock was less than or equal to 2 for 4 consecutive days.
Also, if the prices of the stock in the last four days is [7,34,1,2] and the price of the stock today is 8, then the span of today is 3 because starting from today, the price of the stock was less than or equal 8 for 3 consecutive days.
Implement the StockSpanner class:

StockSpanner() Initializes the object of the class.
int next(int price) Returns the span of the stock's price given that today's price is price.
 

Example 1:

Input
["StockSpanner", "next", "next", "next", "next", "next", "next", "next"]
[[], [100], [80], [60], [70], [60], [75], [85]]
Output
[null, 1, 1, 1, 2, 1, 4, 6]

Explanation
StockSpanner stockSpanner = new StockSpanner();
stockSpanner.next(100); // return 1
stockSpanner.next(80);  // return 1
stockSpanner.next(60);  // return 1
stockSpanner.next(70);  // return 2
stockSpanner.next(60);  // return 1
stockSpanner.next(75);  // return 4, because the last 4 prices (including today's price of 75) were less than or equal to today's price.
stockSpanner.next(85);  // return 6
 

Constraints:

1 <= price <= 105
At most 104 calls will be made to next. */


//ofc brute nek telsu 

import java.util.*;
public class  Online_Stock_Span_901  {
    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int arr [] = new int[n];
        for (int i=0;i<n;i++) arr[i] = s.nextInt();
        System.out.print(Arrays.toString(app1(arr,n)));
    }
    public static int [] app1(int arr [], int n ){
        Deque<int []> st = new ArrayDeque<>();
        int res [] = new int [n];
        for (int i=0;i<n;i++){
            while(!st.isEmpty() && st.peek()[0]<= arr[i]){
                st.pop();
            }
        int pge_index = -1; // default even if stack is empty 
        if (!st.isEmpty()) pge_index = st.peek()[1]; // pge index kosam 
        res[i] = i - pge_index;
        st.push(new int []{arr[i],i});

        }

        return res;
    }
}