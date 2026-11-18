//epoch 1:
//ofc konni tappulu unnai 
/*import java.util.*;
public class Longest_Palindromic_Substring_5 {
    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        String st = s.nextLine();
        char c [] = st.toCharArray();
        System.out.println(app1(c));
    }    
    public static String app1(char c []){
        String res = "";
        int res_length = -1;
        for (int i=0;i<c.length;i++){
            for(int j= i;j<c.length;j++){
                if(check_palindrome(c,i,j) && res_length> j-i){
                    res_length = j-i;
                    res = c.toString().substring(i,j);
                }
            }
        }
        return res;
    }
    public static boolean check_palindrome(char c [], int i,int j){
        while(i<j){
            if(c[i]!= c[j]) return false;
            i++; j--;
        }
        return true;
    }
}*/
//claude ichina code 
import java.util.*;
public class Longest_Palindromic_Substring_5 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String st = s.nextLine();
        char[] c = st.toCharArray();
        System.out.println(app1(c));
    }

    public static String app1(char[] c) {
        String res = "";
        int resLen = 0;
        for (int i = 0; i < c.length; i++) {
            for (int j = i; j < c.length; j++) {
                int len = j - i + 1;
                if (len > resLen && check_palindrome(c, i, j)) {
                    resLen = len;
                    res = new String(c, i, len);
                }
            }
        }
        return res;
    }

    public static boolean check_palindrome(char[] c, int i, int j) {
        while (i < j) {
            if (c[i] != c[j]) return false;
            i++;
            j--;
        }
        return true;
    }
}