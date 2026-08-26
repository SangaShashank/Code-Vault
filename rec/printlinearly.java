public class printlinearly{
    public static void main(String args[]){
        do_linear(0);
    }
    public static void do_linear(int i){
        if(i == 4){
            return ;
        }
        System.out.println(i);
        do_linear(i+1);
    }
}