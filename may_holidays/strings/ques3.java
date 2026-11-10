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
public class ques3 {
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
