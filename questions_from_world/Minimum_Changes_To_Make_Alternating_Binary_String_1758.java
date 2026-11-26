import java.util.*;

public class Minimum_Changes_To_Make_Alternating_Binary_String_1758 {

    public static int app1(String s) {
        int count1 = 0, count2 = 0;

        for (int i = 0; i < s.length(); i++) {
            //pattern 1 
            if (i % 2 == 0 && s.charAt(i) != '0') count1++;
            else if (i % 2 != 0 && s.charAt(i) != '1') count1++;
            //pattern 2 
            if (i % 2 == 0 && s.charAt(i) != '1') count2++;
            else if (i % 2 != 0 && s.charAt(i) != '0') count2++;
        }

        return Math.min(count1, count2);
    }

    public static int app2(String s) {
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            char expected = (i % 2 == 0) ? '0' : '1';

            if (s.charAt(i) != expected) {
                count++;
            }
        }

        return Math.min(count, s.length() - count);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.next();

        System.out.println("Approach 1: " + app1(s));
        System.out.println("Approach 2: " + app2(s));

        sc.close();
    }
}