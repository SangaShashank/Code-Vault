/*
INTERVIEW QUESTION:

You are given an integer array of size n.
Find the SECOND LARGEST element in the array.

CONSTRAINTS:
- Solve it in a single traversal
- Do NOT use sorting
- Handle duplicates properly
- If second largest does not exist, return -1

EXAMPLES:
Input:  [3, 5, 1, 8, 2]
Output: 5

Input:  [10, 10, 10]
Output: -1

Input:  [7]
Output: -1

FOLLOW-UP QUESTIONS:
1. What if the array contains negative numbers?
2. Can you do it in one pass?
3. What edge cases should you handle?

YOUR TASK:
1. Explain your approach
2. Give time complexity
3. Write Java code
*/ 
//epoch 1
/*import java.util.*;
public class ques2{
    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        String [] s1 = s.nextLine().split(",");
        int k [] = new int[s1.length];
        for(int i=0;i<s1.length;i++){
            k[i] = Integer.parseInt(s1[i]);
        }
        int max_1 = k[0];
        int max_2 = k[0];
        for(int i=0;i<k.length;i++){
            max_2 = max_1;
            max_1 = Math.max(k[i],max_1);
        }
        System.out.print(max_2);
        

    }
}*/
/*//epoch 2
import java.util.*;
public class ques2{
    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        String [] s1 = s.nextLine().split(",");
        int k [] = new int[s1.length];
        for(int i=0;i<s1.length;i++){
            k[i] = Integer.parseInt(s1[i]);
        }
        int max_1 = k[0];
        int max_2 = k[0];
        for (int i=0;i<k.length;i++){
            if (k[i]>max_1){
                max_2 = max_1;
                max_1 = k[i];
            }
            else if(k[i]>max_2){
                max_2 = k[i];
            }

        }
        System.out.println(max_2);
    }}*/
//epoch 3
import java.util.*;
public class ques2{
    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        String [] s1 = s.nextLine().split(",");
        int k [] = new int[s1.length];
        for(int i=0;i<s1.length;i++){
            k[i] = Integer.parseInt(s1[i]);
        }
        int max_1 = Integer.MIN_VALUE;
        int max_2= Integer.MIN_VALUE;
        for (int i=0;i<k.length;i++){
            if (k[i]>max_1){
                max_2 = max_1;
                max_1 = k[i];
            }
            else if(k[i]>max_2 && k[i]!=max_1){
                max_2 = k[i];
            }

        }
        if(max_2==Integer.MIN_VALUE){
            System.out.print("-1");
            return;
        }
        System.out.println(max_2);
    }}