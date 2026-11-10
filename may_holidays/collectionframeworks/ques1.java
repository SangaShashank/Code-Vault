/*Given a list of strings, find all duplicates and return them sorted alphabetically using 
Java Collections Framework.
Input:  ["apple","banana","apple","cherry","banana","apple"]
Output: ["apple", "banana"]
Constraints: Use only Collections Framework APIs.
Hint
Hide follow-up
Mark solved
Explain solution ↗
Follow-up: What is the time complexity? How would you do this with Java Streams in one pipeline? */
import java.util.*;

class ques1{
    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        String arr [] = s.nextLine().split(" ");
        approach_1(arr);
        appraoch_2(arr);
        app_3(arr);

    }
    public static void approach_1(String arr[]){
        ArrayList <String> going = new ArrayList<>();
        TreeSet<String> res = new TreeSet<>();
        for(String x:arr){
            if(going.contains(x)){
                res.add(x);
            }
            going.add(x);
        }
        System.out.print(res);

    }
    public static void appraoch_2(String arr[]){
        HashSet <String> chustuuna = new HashSet<>();
        TreeSet <String > res = new TreeSet<>();
        for(String x: arr){
            if(!(chustuuna.add(x))){
                res.add(x);
            }
            chustuuna.add(x);

        }
        System.out.println(res);
    }
    public static void app_3(String arr[]){
        HashMap <String, Integer> m  = new HashMap<>();
        TreeSet <String> res = new TreeSet<>();
        for (String x : arr){
            m.put(x,m.getOrDefault(x,0) +1);
        }
        //System.out.println(m);
        for(String x : m.keySet()){
            if(m.get(x)>1) res.add(x);
        }
        System.out.println(res);
    }
}