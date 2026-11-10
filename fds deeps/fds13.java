/*
/*
A company uses a badge coding system to assign employee access roles.

A string pattern represents the badge role sequence (each character = role type).

A string s represents actual employee names assigned in sequence (space-separated).

Your task is to determine whether the badge assignment follows a strict one-to-one mapping rule:

Rules

Each role character in pattern must map to exactly one unique employee name.

Each employee name must map to exactly one role character.

No two different roles can map to the same employee.

No two different employees can map to the same role.

Return true if the assignment is valid. Otherwise, return false.

Input Format
pattern = ""<pattern_string>""
s = ""<space_separated_employee_names>""
Output Format
true or false
Constraints

1 <= pattern.length <= 300

pattern contains only lowercase English letters

1 <= s.length <= 3000

s contains lowercase English letters and single spaces

No leading or trailing spaces

Words are separated by exactly one space

Sample Test Cases

Test Case 1
input=pattern = abba
s = dog cat cat dog

output=true

Explanation:
Mapping:
a → dog
b → cat

Test Case 2

input=pattern = abba
s = dog cat cat fish

output=false

Explanation:
'b' cannot map to both 'cat' and 'fish'

*/
import java.util.*;
class fds13{
    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        String s1 = s.nextLine();
        String sk = s.nextLine();
        //int res = twomaps_approach(s1,sk);
        int res = oneset_onemap_apporach(s1,sk);
        System.out.print(res == 1); // boolean lo vastadi 
    } 
    public static int twomaps_approach(String s1,String sk){
        String s2 [] = sk.split(" ");
        int i = 0;
        Map <Character,String > m1 = new HashMap<>();
        Map <String , Character> m2 = new HashMap<>();
        for (char ch : s1.toCharArray()){
            String word = s2[i];
            if(!(m1.containsKey(ch)) && !(m2.containsKey(word))){ // both were not mapped eariler kada 
            m1.put(ch,word); m2.put(word,ch);
            }
            else if(!m1.containsKey(ch) || !m2.containsKey(word)){ // very imp case see book
                return 0;
            }       
            else { // annthey both contain 
                if(!m1.get(ch).equals(word) || !m2.get(word).equals(ch)) // best use of or gate --> see book
                return 0;
            }
            i++;
        }
        return 1; //ikkadi varaku vaccham anntey no problem ani artham 
    }
    public static int oneset_onemap_apporach(String s1,String sk){
        String s2 [] = sk.split(" ");
        if (s1.length()!=s2.length) return 0; // enduko see in book
        Map <Character , String > m = new HashMap<>();
        Set <String > mapped = new HashSet<>(); // to keep a track of who are mapped till now 
        int i = 0;
        for (char c : s1.toCharArray()){
            String word = s2[i];
            if(m.containsKey(c)){
                if(!(m.get(c).equals(word))){
                    return 0;
                }
            }
            else { // enters if key is not present 
                //case 1 emo word is not already used 
                if(mapped.contains(word)){
                    return 0;
                }
                else { // idi emo both are not present then simply add
                    m.put(c,word); mapped.add(word); 
                }
            }
            i++;
        }
        return 1;
    }
}