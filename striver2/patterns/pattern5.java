/*Given an integer n. You need to recreate the pattern given below for any value of N. Let's say for N = 5, the pattern should look like as below:



*****

****

***

**

*



Print the pattern in the function given to you. */
public class pattern5{
    public static void main(String args[]){
        int n = 5;
        for(int i=n;i>0;i--){
            for(int j=i;j>0;j--){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}