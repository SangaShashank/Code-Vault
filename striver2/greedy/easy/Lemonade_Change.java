/*Each lemonade at a booth sells for $5. Consumers are lining up to place individual orders, following the billing order. Every consumer will purchase a single lemonade and may pay with a $5, $10, or $20 bill. Each customer must receive the appropriate change so that the net transaction is $5. Initially, there is no change available.

Determine if it is possible to provide the correct change to every customer. Return true if the correct change can be given to every customer, and false otherwise.

Given an integer array bills, where bills[i] is the bill the ith customer pays, return true if the correct change can be given to every customer, and false otherwise.

Example 1:
Input : bills = [5, 5, 10, 5, 20]

Output : true

Explanation : Initially we have $0 available for change.

From first two customers, we will collect two $5 bills in order. After the first two customers we have two $5 bills available with us for change.

From the third customer , we collect bill of $10 and give back $5. After third customer we have one $5 and one $10 bill available with us for change.

From fourth customer , we collect $5 bill. After fourth customer we have two $5 and one $10 bills available with us for change if required.

From fifth customer , we collect bill of $20 and give back $15 (one $10 + one $5 bill).

Since all the customers did receive the change correctly , so we return true.

Example 2:
Input : bills = [5, 5, 10, 10, 20]

Output : false

Explanation : From first two customers, we will collect two $5 bills in order. After the first two customers we have two $5 bills available with us for change.

From third customer , we collect $10 and give back $5. After the third customer we have one $5 and one $10 bill available with us for change.

From fourth customer , we collect $10 and give back $5. After the fourth customer we have two $10 bill available with us for change.

From fifth customer , we collect $20 , we cannot give the $15 change as we have two $10 bills.

Since all the customers did not receive the change correctly , the we return false. */
import java.util.*;
public class Lemonade_Change {
    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int arr [] = new int[n];
        for(int i=0;i<n;i++) arr[i] = s.nextInt();
        System.out.print(lemonadeChange(arr));
        System.out.print(lemonadeChange2(arr));
    }
    public static boolean lemonadeChange(int[] bills) {
        //your code goes here
        HashMap<Integer, Integer> m = new HashMap<>();
        m.put(5,0); m.put(10,0); m.put(20,0);
        System.out.print(m);
        for(int x : bills){
            if(x == 5) m.put(5,m.get(5)+1);
            else if(x == 10) {
                m.put(10,m.get(10)+1);
                if(m.get(5)>=1) m.put(5,m.get(5)-1);// giving back 5 rupeees
                else return false;
            }
            else {
                 m.put(20,m.get(20)+1);
                if(m.get(5)>=1 && m.get(10)>=1) {
                    m.put(5,m.get(5)-1); m.put(10,m.get(10)-1); // this should be first
                }
                else if(m.get(5)>=3) m.put(5,m.get(5)-3); // 3 5 rupees coins
                else return false;
            }
             System.out.println(m + " for" + x);
        }
        return true;
    }
    public static boolean lemonadeChange2(int[] bills) {
    int five = 0, ten = 0;
    for (int b : bills) {
        if (b == 5) five++;
        else if (b == 10) {
            if (five == 0) return false;
            five--; ten++;
        } else {
            if (five > 0 && ten > 0) { five--; ten--; }
            else if (five >= 3) five -= 3;
            else return false;
        }
    }
    return true;
}
}