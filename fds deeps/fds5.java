/* remove dulpicatses from sorted array 
*/
import java.util.*;
class fds5{
    public static void main(String args[]){
        int [] a = {1,2,2,3,3,4,5,6};
        Set <Integer> l = new LinkedHashSet<>(); // follows the input order
        for(int x : a){
            l.add(x);
        }
        System.out.print(l);
        
    }
}