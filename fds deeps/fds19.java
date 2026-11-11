import java.util.*;

class fds19{
    public static void main(String[] args) {
        String s = "goodmorning";
        String [] k = s.split("");
        //System.out.print(k[5]);
        int l=0,r=0;
        Set <String> s1 = new HashSet<>();
        while(r<k.length && l<k.length){
            if(s1.contains(k[r])){
                l++;
            }
            else{
                s1.add(k[r]);
                r++;
            }
        }
        System.out.print(r);
    }
}