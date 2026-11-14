import java.util.*;

public class Minimum_Window_Substring_76 {

    public static void main(String args[]) {

        Scanner s = new Scanner(System.in);

        String str = s.nextLine();

        System.out.println("Approach 1: Brute Force");
        System.out.println(minWindowBrute(str));

        System.out.println("Approach 2: Sliding Window");
        System.out.println(minWindow(str));
    }

    // Approach 1: Brute Force
    static int minWindowBrute(String s) {
        int n = s.length(), best = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            boolean a = false, t = false, g = false, c = false;
            for (int j = i; j < n; j++) {
                char ch = s.charAt(j);
                if (ch == 'A') a = true;
                else if (ch == 'T') t = true;
                else if (ch == 'G') g = true;
                else if (ch == 'C') c = true;
                if (a && t && g && c) {
                    best = Math.min(best, j - i + 1);
                    break;                      // longer j can't beat this start
                }
            }
        }
        return best == Integer.MAX_VALUE ? -1 : best;
    }

    // Approach 2: Sliding Window
    static boolean correctWindow(Map<Character, Integer> map) {
        for (int count : map.values()) {
            if (count < 1) return false;   // some letter missing
        }
        return true;
    }

    static int minWindow(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('A', 0); map.put('T', 0); map.put('G', 0); map.put('C', 0);

        int result = Integer.MAX_VALUE;
        int l = 0;

        for (int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            if (map.containsKey(c)) map.put(c, map.get(c) + 1);   // expand
            while (correctWindow(map)) {                           // shrink while valid
                result = Math.min(result, r - l + 1);
                char left = s.charAt(l);
                if (map.containsKey(left)) map.put(left, map.get(left) - 1);
                l++;
            }
        }
        return result;
    }
}