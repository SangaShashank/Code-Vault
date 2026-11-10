// [2, 4, 5, -1, -3, -4]
// [2, -1, 4, -3, 5, -4]
import java.util.Arrays;
import java.util.Scanner;
public class x {
    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++) arr[i] = s.nextInt();
        System.out.print(Arrays.toString(app1(arr)));

    }
    public static int [] app1(int arr[]){
        int i = 0;int j=1;
        int res [] = new int[arr.length];
        for(int x:arr){
            if(x>0) {
                res[i] = x; 
                i = i+2;
        }
        else{
            res[j] = x;
            j = j+2;
        }
    }
    return res;
}
}
