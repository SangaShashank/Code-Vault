public class printulta2{
    public static void main(String args[]){
        int i=0;int n = 3;
        do_print(i,3);
    }
    public static void do_print(int i,int n){
        if(i>=n){
            return;
        }
        do_print(i+1,n);
        System.out.println(i+1);
    }
}