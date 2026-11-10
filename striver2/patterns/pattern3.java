/*Given an integer n. You need to recreate the pattern given below for any value of N. Let's say for N = 5, the pattern should look like as below:



1

12

123

1234

12345



Print the pattern in the function given to you. */
public class pattern3{
    public static void main(String args[]){
        int n = 5;
        for(int i=1;i<=n;i++){ // zero pedthe oka extra blank vastadi
            for(int j=0;j<i;j++){
                System.out.print(j+1);
            }
            System.out.println();
        }
    }
}