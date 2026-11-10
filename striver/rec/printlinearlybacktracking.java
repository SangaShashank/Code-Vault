public class printlinearlybacktracking{
    public static void main(String args[]){
        int i=3,n = 3;
        do_print(i,n);
    }
    public static void do_print(int i,int n){
        if(i<=0){
            return;
        }
        do_print(i-1,n); // 1st recurrsive call and then the statement 
        System.out.println(i); 
    }
}