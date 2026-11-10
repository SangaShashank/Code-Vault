import java.util.*;
public class ques10 {
    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        int m = s.nextInt();
        int n = s.nextInt();
        int arr[][] = new int [m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                arr[i][j]= s.nextInt();
            }
        }
        app2(arr,m,n);
        Set <Integer> r = new HashSet<>();
        Set <Integer > c = new HashSet<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(arr[i][j]==0){
                    r.add(i);
                    c.add(j);
                }
            }
        }
       //System.out.println(r);
       for(int x:r){
        for(int i=0;i<n;i++){
            arr[x][i]=0;
        }
       }
       for(int x:c){
        for(int i=0;i<m;i++){
            arr[i][x]=0;
        }
       }
       // print
       for(int i=0;i<m;i++){
        for(int j=0;j<n;j++){
            System.out.print(arr[i][j]);
        }
        System.out.print("\n");
       }
}
public static void app2(int arr[][],int m,int n){
    boolean row0is0 = false;
    boolean col0is0 = false;
    for(int i=0;i<n;i++){
        if(arr[0][i]==0){
            row0is0 = true;
            break;
        }
    }
    for(int i=0;i<m;i++){
        if(arr[i][0]==0){
            col0is0 = true;
            break;
        }
    }
    for(int i=1;i<n;i++){
        for(int j=0;j<n;j++){
            if(arr[i][j]==0){
                arr[0][j] = 0;
                arr[i][0] = 0;
            }
        }
    }
    for(int i=0;i<m;i++){
        if(arr[i][0]==0){
            for(int j=1;j<n;j++){
                arr[i][j]=0;  // zero down 
            }
        }
    }
    for(int i=0;i<n;i++){
        if(arr[0][i]==0){
            for(int j=1;j<n;j++){
                arr[j][i]=0;  // zero down 
            }
        }
    }
    for(int i=0;i<m;i++){
        for(int j=0;j<n;j++){
            System.out.print(arr[i][j]);

        }
        System.out.print("\n");
    }
}
}
