/*A support centre logs one letter per message, and each letter is the code of the agent who replied. Codes are
not case-sensitive, so a and A are the same agent. A manager wants the longest stretch of consecutive
messages handled by at most k different agents. If two stretches have the same length, report the one that
starts earlier. The program prints the stretch length and the stretch itself, exactly as it appears in the log
(original upper/lower case).*/
import java.util.*;
public class ChatLog {
    static String longestStretch(String s, int k) {
        String t = s.toLowerCase();
        Map<Character, Integer> cnt = new HashMap<>();
        int left = 0, bestLen = 0, bestStart = 0;
        for (int right = 0; right < s.length(); right++) {
            char c = t.charAt(right);
            cnt.put(c, cnt.getOrDefault(c, 0) + 1);
            System.out.println(cnt);
            while (cnt.size() > k) {
                System.out.print("whlie entered at :" + right);
                char l = t.charAt(left);
                cnt.put(l, cnt.get(l) - 1);
                if (cnt.get(l) == 0) cnt.remove(l);
                left++;
            }
            if (right - left +1>bestLen) {
                bestLen = right - left +1;
                bestStart = left;
            }
        }
        return bestLen + " " + s.substring(bestStart, bestStart + bestLen);
    }
    public static void main(String[] args) {
        System.out.println("Log 1: " + longestStretch("eceba", 2));
        System.out.println("Log 2: " + longestStretch("aAbbCc", 2));
    }
}
/*Sample test cases
Call
Test 1
longestStretch("eceba", 2)
Expected output
Log 1: 3 ece
Test 2
longestStretch("aAbbCc", 2)
Task: find and fix all the bugs.
Log 2: 4 aAb */