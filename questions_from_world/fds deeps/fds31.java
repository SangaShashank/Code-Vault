/*
Given two strings s and t, determine if they are isomorphic.
Two strings are isomorphic if characters in s can be replaced to get t, with a one-to-one mapping.
Input:
s = egg  
t = add
Output:
true
Sample Test case1
input=egg
add
output=true

Sample Test case2
input=foo
bar
output=false

*/
//i assumed it was only way mapping but kadu annta 
/*import java.util.*;
class fds31{
    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        String s1 = s.nextLine();
        String s2 = s.nextLine();
        int i = 0; // to track elements of 2nd array 
        // ig only one mapping ee anukunnta so only one map use cheedam 
        HashMap <Character,Character> h = new HashMap<>();
        for (char c : s1.toCharArray()){
            if(h.containsKey(c)){ // anntey already eppudo map ayyindi  
                if(!(h.get(c).equals(s2.charAt(i)))) {
                    System.out.print("False");
                    return;
                }
            }
            else{
                h.put(c,s2.charAt(i));
                i++;
            }
        }
    System.out.print("Ture"); // last ki vachesam kada
    }
}*/
/*import java.util.*;
class fds31{
    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        String s1 = s.nextLine();
        String s2 = s.nextLine();
        if(s1.length() != s2.length()){
            System.out.print("False");
            return ; 
        }
        int i = 0; // to track elements of 2nd array 
        // ig only one mapping ee anukunnta so only one map use cheedam 
        HashMap <Character,Character> h = new HashMap<>();
        for (char c : s1.toCharArray()){
            if(h.containsKey(c)){ // anntey already eppudo map ayyindi  
                if(!(h.get(c).equals(s2.charAt(i)))) {
                    System.out.print("False");
                    return;
                }
            }
            else{
                h.put(c,s2.charAt(i));
               // i++; logic : ikkada increment cheste tappu , see ai 
            }
            i++;
        }
    System.out.print("True"); // last ki vachesam kada
    }
}*/
// this is code for 2 way mapping , denni inka optimise chesa in fds 18
/*import java.util.*;
class fds31

{


    public static void main(String args[])

{


        Scanner s = new Scanner(System.in);
        String s1 = s.nextLine();
        String s2 = s.nextLine();
        if(s1.length() != s2.length())

{


            System.out.print("False");
            return;
        

}
        int i = 0;
        // bijection kada so two maps vadali 
        HashMap <Character , Character> m1 = new HashMap<>();
        HashMap <Character , Character> m2 = new HashMap<>();
        for (char c : s1.toCharArray())

{


            if(m1.containsKey(c))

{


                if(!(m1.get(c).equals(s2.charAt(i))))

{


                    System.out.print("False");
                    return;
                

}
            

}
            else

{


                m1.put(c,s2.charAt(i));
            

}
            i++;
        

}
        i = 0;
        for (char c : s2.toCharArray())

{


            if(m2.containsKey(c))

{


                if(!(m2.get(c).equals(s1.charAt(i))))

{


                    System.out.print("False");
                    return;
                

}
            

}
            else

{


                m2.put(c,s1.charAt(i));
            

}
            i++;
        

}
        System.out.print("True");
    

}

}*/