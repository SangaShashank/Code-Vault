/*
An e-commerce warehouse stores product batch codes as lowercase strings.

Due to supplier variations, some product codes are written in different character orders but actually
 represent the same product type (they contain exactly the same letters with the same frequency).

Your task is to group all product codes that represent the same product type together.

You may return the groups in any order.


Input Format
A list of strings, strs, representing product codes, separated by spaces

Output Format
A list of lists of strings, each sublist containing codes that are anagrams of each other.
Each group is printed in square brackets and codes separated by commas.
The order of groups and the order of codes within a group does not matter.

Each inner list contains product codes that represent the same product type.

 Constraints

1 <= strs.length <= 10^4

0 <= strs[i].length <= 100

Sample Test Cases

Sample Test Case 1

Input:
strs = eat tea tan ate nat bat

Output:
[[bat],[nat,tan],[ate,eat,tea]]

Sample Test Case 2

Input:
strs = 

Output:
[[]]

Sample Test Case 3

Input:
strs = a

Output:
[[a]]
*/
/*import java.util.*;
class fds23{
    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        String s1 = s.nextLine();
        String sp [] = s1.split(" ");
        Set <List <String>> l1 = new HashSet<>(); //set of lists --> outer one 

        for (int i = 0; i<sp.length;i++){
             Set <String > l2 = new HashSet<>();// clear on every pass so that i can reuse 
             l2.add(sp[i]);
            for (int j = 0; j<sp.length;j++){
                if(sp[i].length()== sp[j].length()){
                    int res = checkana(sp[i],sp[j]);
                    if(res == 1){
                        l2.add(sp[j]);
                    }
                }
            }
            l1.add(new ArrayList<>(l2));
        }
        //System.out.print(l1);
        System.out.print(new ArrayList<>(l1));
    }
    public static int checkana(String s1,String s2){
        s1 = s1.toLowerCase();
        s2 = s2.toLowerCase();
        HashMap <Character , Integer>  m = new HashMap<>();
        for (char c: s1.toCharArray()){
            m.put(c,m.getOrDefault(c,0)+1);
        }
        for(char c : s2.toCharArray()){
            if(!m.containsKey(c)) return 0;
            m.put(c,m.get(c) -1);
        }
        for (int v : m.values()){
            if(v!=0) return 0;
        }
        return 1;
    }
   
}*/
// logic : all anagrams will have same sorted order 
import java.util.*;
public class Group_Anagrams_49{
    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        String s1 [] = s.nextLine().split(" ");
        HashMap <String ,List<String >> m = new HashMap<>(); // to map string and list of strings
        for (int i = 0;i<s1.length;i++){
            char [] k = s1[i].toCharArray();
            Arrays.sort(k); // sorting using arrays -> see 18 
            String sor = new String(k); 
            if(m.containsKey(sor)){
                m.get(sor).add(s1[i]);
                m.put(sor,m.get(sor)); // this line is useless 
            }
            else{
                List <String> l = new ArrayList<>();
                l.add(s1[i]);
                m.put(sor,l);
            }
        }
        System.out.print(m);
    }}
        
// naa idea  ni chatgpt code chesindi 
/* import java.util.*;

class Group_Anagrams {

    public static void main(String args[]) {

        Scanner s = new Scanner(System.in);

        String strs[] = s.nextLine().trim().split("\\s+");

        int n = strs.length;

        boolean visited[] = new boolean[n];

        List<List<String>> res = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            if (visited[i]) continue;

            List<String> l = new ArrayList<>();

            l.add(strs[i]);
            visited[i] = true;

            for (int j = i + 1; j < n; j++) {

                if (!visited[j] && anaCheck(strs[i], strs[j])) {

                    l.add(strs[j]);
                    visited[j] = true;
                }
            }

            res.add(l);
        }

        System.out.print(res);
    }

    public static boolean anaCheck(String s1, String s2) {

        if (s1.length() != s2.length()) return false;

        HashMap<Character, Integer> m = new HashMap<>();

        for (char c : s1.toCharArray()) {
            m.put(c, m.getOrDefault(c, 0) + 1);
        }

        for (char c : s2.toCharArray()) {

            if (!m.containsKey(c)) return false;

            m.put(c, m.get(c) - 1);

            if (m.get(c) < 0) return false;
        }

        return true;
    }
}*/