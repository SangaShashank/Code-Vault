/*You are given a string s. Return the array of unique characters, sorted by highest to lowest occurring characters.

If two or more characters have same frequency then arrange them in alphabetic order.

Example 1:
Input : s = "tree"

Output : ['e', 'r', 't' ]

Explanation :

The occurrences of each character are as shown below :

e --> 2

r --> 1

t --> 1.

The r and t have same occurrences , so we arrange them by alphabetic order.

Example 2:
Input : s = "raaaajj"

Output : ['a' , 'j', 'r' ]

Explanation :

The occurrences of each character are as shown below :

a --> 4

j --> 2

r --> 1

Now Your Turn!
Pick the correct output for the given input
Input : s = "bbccddaaa"


['c', 'a', 'b', 'd']

['c', 'a', 'd', 'b']

['a', 'b', 'c', 'd']

['a', 'b', 'd', 'c']
Still unsure what the problem is asking ?

Let’s go through a few more examples, step by step, to make it clearer.

Constraints:
1 <= s.length <= 105
s consist of only lowercase English characters.*/
import java.util.*;
public class Sort_Characters_By_Frequency_451 {
    public List<Character> frequencySort(String s) {

        HashMap<Character, Integer> m = new HashMap<>();

        // Step 1: Count frequency
        for (char x : s.toCharArray()) {
            m.put(x, m.getOrDefault(x, 0) + 1);
        }

        // Step 2: Store unique characters
        ArrayList<Character> l = new ArrayList<>(m.keySet());

        // Step 3: Sort by frequency, then alphabetically
        l.sort((a, b) -> {
            if (m.get(a) != m.get(b)) { // equal kakapothey sort by freq 
                return m.get(b) - m.get(a);
            }
            return a - b; // equal ayithey then alaphabetical order kosam 
        });

        return l;
    }
}