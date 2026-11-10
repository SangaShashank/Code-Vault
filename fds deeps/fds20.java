//longest substring 

import java.util.HashSet;
class fds20{
   public static void main(String[] args) {
        String k = "baca";
        HashSet <Character> h = new HashSet<>();
        int i = 0;
        int l = 0,r = 0,maxlen = 0;
        while (r<k.length()){ //r munduku potunndi ga 
            while(h.contains(k.charAt(r))){  // to remove all dublicates while
                h.remove(k.charAt(l));
                l++;
                

}
            if(!h.contains(k.charAt(r))){;
                h.add(k.charAt(r));
                if(r-l+1>maxlen){
                    maxlen = r - l + 1;
                    i = l;
                }
                r++;
}

                

}
String k1 = k.substring(i,i+maxlen);
System.out.println(k1);
}}
        