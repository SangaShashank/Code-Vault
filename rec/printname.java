public class printname{
    public static void main(String args[]){
        do_print("shashi"); // static vadatam anta manchidi kadu annta 
        do_print2("shashi",0,3); // idhi chala manchidi annta 
        
    }
    static int c=0;
    public static void do_print(String name){
         if(c == 3){
            return;
        }
        c++;
        System.out.println(name);
        do_print(name);
    }
    public static void do_print2(String name,int i,int n){
        if(i==n){
            return ;
        }
        i++;
        System.out.println(name);
        do_print2(name,i,n);
    }
}