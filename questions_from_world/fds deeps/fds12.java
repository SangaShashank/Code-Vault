//streams : it is a like pipe line which have 3 func -> source(stream()) , intermidiate(filter,map,find any,match any),stopping (collector,count,for each)
import java.util.*;
import java.util.function.Predicate; //predicates kosam
class fds12{
    public static void main(String args[] ){
        List<Integer> l = new ArrayList<>(Arrays.asList(10,20,30,40,50));
        List<String> l2 = new ArrayList<>(Arrays.asList("anil","sarath","zoe","mandira","akshara","anand"));
        List<Integer> scores = Arrays.asList(45, 82, 61, 38, 75, 90, 55, 48, 70, 33);
        //System.out.print(l);
        Predicate <Integer> p = (n) -> n>40;
        Predicate <Integer> p2 = (n) -> n%3==0;
        Predicate <Integer> k = (n) -> n>60;
        Predicate <Integer> k2 = (n) -> n%2==0;
        Predicate <Integer> k3 = (n) -> n>50;
        Predicate <Integer> k4 = (n) -> n<50;
        Predicate <Integer> ks = (n) -> n>70;
        Predicate <String> s = (n) ->n.startsWith("a");
        Predicate <String> s2 = (n) ->n.length()<=5;
        l.stream().filter(p.or(p2)).forEach(n-> System.out.println(n));
        l2.stream().filter(s).forEach(n-> System.out.print(n+" "));
        l2.stream().filter(s2).forEach(n-> System.out.println(n));
        l2.stream().map((n) ->n.toUpperCase()).forEach(n-> System.out.print(n+ " "));
        scores.stream().filter(k).forEach(n-> System.out.print(n + " "));
        System.out.println();
        scores.stream().filter(k2.and(k3)).forEach(n-> System.out.print(n + " "));
        
        System.out.println();
        scores.stream().filter(k4).forEach(n-> System.out.print(n + " "));
        
        System.out.println();
        
        
    }
} 