//annty koncham cute unndi andukey paste cheisna 
public class palindrome_Check{   
    public static boolean palindromeCheck(String s) {
        //your code goes here
        int i=0,j = s.length()-1;
        while(i<j){
            if(s.charAt(i) != s.charAt(j)) return false;
            i++; j--;
        }
        return true;
    }

}