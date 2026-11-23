/*Question 2: Signal Tower
Topic: Strings · Hidden bugs: 1
A signal tower receives a stream of letters. 
A "clean burst" is a run of consecutive letters where no letter repeats.
 The engineer needs the length of the longest clean burst in each stream. 
The program uses a sliding window with a map that remembers the last position of each letter.*/
import java.util.*;

public class SignalBurst {
    static int longestBurst(String s) {
        Map<Character, Integer> last = new HashMap<>();
        int left = 0, best = 0;
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            System.out.println(c);
            if (last.containsKey(c)) {
                left = Math.max(left, last.get(c) + 1);
                System.out.println(left);
            }
            last.put(c, right);
            best = Math.max(best, right - left+1);
            System.out.println(best);
        }
        return best;
    }

    public static void main(String[] args) {
        String[] signals = {"abcabcbb", "bbbbb", "pwwkew", "abba"};
        for (String s : signals) {
            System.out.println(s + " -> " + longestBurst(s));
        }
    }
}
/*Expected output
abcabcbb -> 3
bbbbb -> 1
pwwkew -> 3
abba -> 2
Actual output
abcabcbb -> 2
bbbbb -> 0
pwwkew -> 2
abba -> 1*/