class fds32{
    public static void main(String args[]){
        m1(1);
        System.out.println();
        m2(1);
        System.out.println();
        System.out.println(m3(3));
        System.out.println(m4(3));
        System.out.println(m5(1456)); // sum of digits 
        m6(126);
        System.out.println(m7(15476,0));
       // System.out.println(m6(1456)); // rev of digits 
    }
    public static void m1(int c){
        if(c == 5){
            return;
        }
        System.out.print(c + " ");
        m1(c+1);
    }
    public static void m2(int c){
        if(c == 5){
            return;
        }
        System.out.print(10 + " ");
        m2(c+1);
    }
    public static int m3(int c){
        if(c==1) return 1000;
        return (m3(c-1)+1000);
    }
    public static int m4(int c){
        if(c==0) return c;
        return (m4(c-1)+c);
    }
    public static int m5(int c){
        if(c==0) return c;
        return (m5(c/10)+c%10);

    }
    public static void m6(int c){ // cheating
        if(c==0) return;
        System.out.print(c%10);
        m6(c/10);
    
    }
    public static int m7(int c,int y){
        if (c==0) return y;
        int x = y*10 + (c%10);
        return m7(c/10,x);
    }

}