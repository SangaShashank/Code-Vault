/*Given a string s, reverse only all the vowels in the string and return it.

The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both lower and upper cases, more than once.

 

Example 1:

Input: s = "IceCreAm"

Output: "AceCreIm"

Explanation:

The vowels in s are ['I', 'e', 'e', 'A']. On reversing the vowels, s becomes "AceCreIm".

Example 2:

Input: s = "leetcode"

Output: "leotcede"

 

Constraints:

1 <= s.length <= 3 * 105
s consist of printable ASCII characters.*/import java.util.*;
public class Reverse_Vowels_Of_A_String_345  {
    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
       String s1 = s.nextLine();
       char arr [] = s1.toCharArray();
       int i=0,j=arr.length - 1;
       while(i<j){
        boolean k = (arr[i]=='a' || arr[i] == 'e' || arr[i] == 'i' || arr[i] == 'o' || arr[i] == 'u' || arr[i]== 'A' || arr[i] == 'E' ||arr[i] == 'O' ||arr[i] == 'I' || arr[i] == 'U');
        boolean l = (arr[j]=='a' || arr[j]=='e' || arr[j]=='i' || arr[j]=='o' || arr[j]=='u' 
          || arr[j]=='A' || arr[j]=='E' || arr[j]=='I' || arr[j]=='O' || arr[j]=='U');
            if(!k)
                i++;
            else if(!l) j--;
            else if(!k && !l){ i++; j--;}
            else{
                char temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp ;
                i++; j--;
            }
       }
       System.out.println(new String (arr));
    }
    
}
/*import java.util.*;

public class Reverse_Vowels_Of_A_String_345 {

    static boolean isVowel(char c) {
        return "aeiouAEIOU".indexOf(c) != -1; // chala cute unndi 
    }

    // Brute: collect vowels, reverse the list, rewrite them in order
    static String bruteForce(String s) {
        List<Character> vowels = new ArrayList<>();
        for (char c : s.toCharArray())
            if (isVowel(c)) vowels.add(c);
        Collections.reverse(vowels);

        StringBuilder sb = new StringBuilder();
        int idx = 0;
        for (char c : s.toCharArray()) {
            if (isVowel(c)) sb.append(vowels.get(idx++));
            else sb.append(c);
        }
        return sb.toString();
    }

    // Better: stack gives the reversal for free (no explicit reverse step)
    static String better(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray())
            if (isVowel(c)) stack.push(c);

        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (isVowel(c)) sb.append(stack.pop());
            else sb.append(c);
        }
        return sb.toString();
    }

    // Optimal: two pointers, swap vowels in place
    static String optimal(String s) {
    // paina dey koncham optmize cheddam le , adey bagaunndi 
        char[] arr = s.toCharArray();
        int i = 0, j = arr.length - 1;
        while (i < j) {
            while (i < j && !isVowel(arr[i])) i++;
            while (i < j && !isVowel(arr[j])) j--;
            if (i < j) {
                char temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }
        return new String(arr);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        System.out.println("Brute   : " + bruteForce(s));
        System.out.println("Better  : " + better(s));
        System.out.println("Optimal : " + optimal(s));
    }
} */