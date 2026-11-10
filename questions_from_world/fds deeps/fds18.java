/*/*
A data migration system is transferring records from Server S to Server T.

Each record in Server S is encoded using certain symbols.
During migration:

Every symbol from Server S must consistently translate to exactly one symbol in Server T.

No two different symbols from Server S can translate to the same symbol in Server T.

A symbol may translate to itself.

The order of symbols must remain unchanged.

Your task is to determine whether the encoding transformation from Server S to Server T is valid.

Return true if the migration rule is valid, otherwise return false.

 Input Format
s
t

s → Original encoded string from Server S

t → Transformed string from Server T

Output Format
true / false

Constraints

1 <= s.length <= 5 * 10^4

t.length == s.length

s and t consist of any valid ASCII characters

Order must be preserved

Mapping must be one-to-one (bijection)

Sample Test Cases
Test case 1
input =
egg
add

output =
true

Test case 2
input =
f11
b23

output =
false

*/
//ali bhai apprach 
import java.util.*;

public class fds18{
    public static boolean A(String s, String t) {
        if (s.length() != t.length()) return false;

        HashMap<Character, Character> mapST = new HashMap<>();
        HashMap<Character, Character> mapTS = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char cs = s.charAt(i);
            char ct = t.charAt(i);
            if (mapST.containsKey(cs)){
                if (mapST.get(cs) != ct){
                    return false;
}
            
} 
    else{
                mapST.put(cs, ct);
}

            if (mapTS.containsKey(ct)){
                if (mapTS.get(ct) != cs){
                    return false;
}
            
} 
          else{
                mapTS.put(ct, cs);
          }
        
}

        return true;
}
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String t = sc.nextLine();
        boolean r = A(s, t);
        if (r) {
            System.out.println("True");
} 
        else{
            System.out.println("False");
         }
}

}
