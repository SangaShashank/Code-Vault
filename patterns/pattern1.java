/*Given an integer n. You need to recreate the pattern given below for any value of N. Let's say for N = 5, the pattern should look like as below:
*****
*****
*****
*****
*****
*/ 
public class pattern1{
    public static void main(String args[]){
        int n=5;
        app_2(n);
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
    public static app_2(int n){
        int i = 0;
        while(i<=n){
            if(i!= 0 && i!=1 &&  n%i== 0){
                System.out.println();
            }
            System.out.print("*");

        }
    }
}
