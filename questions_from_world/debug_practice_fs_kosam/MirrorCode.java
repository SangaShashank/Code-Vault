/*A security firm's door panel accepts a phrase typed by staff. The phrase may contain letters and spaces, and
spaces count as ordinary characters. The firm's rule engine looks for the longest mirror inside the phrase: a
stretch of consecutive characters that reads the same forwards and backwards. If two mirrors have the same
length, the one that starts earlier is reported. The program uses the expand-around-centre method: every
position is tried as the centre of an odd-length mirror, and every gap between two neighbouring positions is
tried as the centre of an even-length mirror. It prints the mirror length, a space, and the mirror itself.
Input format: one line containing the whole phrase.*/
import java.util.*;
public class MirrorCode {
    static int expand(String s, int l, int r) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        return r - l;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int best = 0, start = 0;
        for (int i = 0; i < s.length()-1; i++) {
            int len1 = expand(s, i, i);
            int len2 = expand(s, i, i+1);
            int len = Math.max(len1, len2);
            if (len > best) { // earler kavali kada 
                best = len;
                start = (i - len) / 2;
            }
        }
        System.out.println(best + " " + s.substring(start, start + best));
    }
}
/*Sample test cases
Input
Test 1
babad
Expected output
3 bab
Test 2
ab cdc ba
Task: find and fix all the bugs.
9 ab cdc ba */