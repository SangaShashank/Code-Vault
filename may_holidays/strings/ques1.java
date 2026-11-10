/* Write a function to reverse the words in a sentence without reversing characters inside each word.
Example:
Input:  "the sky is blue"
Output: "blue is sky the"
Constraints:
Do not use split()
Handle multiple spaces, leading/trailing spaces
Optimize for time and space */
//approach 1:
import java.util.*;
public class ques1{
    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        String s1 = s.nextLine();
        approach_1(s1);
        approach_2(s1);
        appraoch_3(s1);
        appraoch_4(s1);
    }
        public static void approach_1(String s1){
        List <String> l = new ArrayList<>();
        s1 = s1.trim();
        String s2 = "";
        for(int i=0;i<s1.length();i++){
            if(s1.charAt(i)!=' '){
                s2 = s2+s1.charAt(i);
            }
            else{
                if(!s2.equals("")){ // very imp line
                s2 = s2.trim();
                l.add(s2);
                s2 = "";
                }
            }
        }
        if(!s2.equals("")){ //for last word 
            s2 = s2.trim();
            l.add(s2);
        }

        String arr [] = l.toArray(new String[0]);
        String res = "";
        for(int i=arr.length-1;i>=0;i--){
            res = res + arr[i];
            res = res + " ";
        }
        System.out.println(res);

    }
    public static void approach_2(String s1){
       
       String res = rev(s1);
        //System.out.print(res);
    // now reverse each word 
    String s2 = "";
    String res3 = "";
    for(int k=0;k<res.length();k++){
        if(res.charAt(k) != ' '){
            s2 = s2 + res.charAt(k);
        }
        else{
            if(!s2.equals("")){
                String res2 = rev(s2);
                s2 = "";
                res3 = res3 + res2;
                res3 = res3 + " ";
            }
        }

        
    }
    if(!s2.equals("")){
        String res2 = rev(s2);
        s2 = "";
        res3 = res3 + res2;
    }
        System.out.print(res3);
        
    }
    public static String rev(String s2){
        int i=0; int j = s2.length() -1 ;
        char [] arr2 = s2.toCharArray();
        while(i<j){
            char temp = arr2[i];
            arr2[i] = arr2[j];
            arr2[j] = temp;
            i++ ; j-- ;
        }
        String res = new String(arr2);
        return res;
    } 
public static void appraoch_3(String s1){
    StringBuilder sha = new StringBuilder();
    int i=0 , n = s1.length();
    while(i<n  && s1.charAt(i)== ' '){
        i++ ;                                 // starting spaces 
    }
    while(i<n){
        while(i<n && s1.charAt(i)!= ' '){
            sha.append(s1.charAt(i)); // only taking wanted 
            i++;
        }
        while(i<n && s1.charAt(i) == ' '){
            i++;            
        }
        if(i<n){ // anntey there are more words 
            sha.append(' '); // we are adding one space after every word 
        }
        
    }
    System.out.print(sha);
    // now lets play :
    String clean = sha.toString();
    String res = rev(clean);
    char [] arr = res.toCharArray();
    int left = 0, l = 0, right = 0;
    while(l<arr.length){
        while(l<arr.length && arr[l]!= ' '){
            l++;
        }
        right = l - 1;
        rev_in_place(arr,left,right);
        left = l + 1 ;
        l++;
    }
    System.out.print(new String(arr));
    
}
public static void rev_in_place(char arr[], int left, int right){
    while(left < right){
        char temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
        left++; right--;
    }
}

public static void appraoch_4(String s1){
    Stack <String> st = new Stack<>();
    // lets clean it 
    StringBuilder sb = new StringBuilder();
    int i=0; int n = s1.length();
    while (i<n && s1.charAt(i)==' '){
        i++; // starting spaces 

    }
    while(i<n){
        while(i<n && s1.charAt(i)!=' '){
            sb.append(s1.charAt(i));
            i++;
        }
        while(i<n && s1.charAt(i) == ' '){
            i++;
        }
        if(i<n){
            sb.append(' '); // space after each word
            //System.out.println("buffer now : "+sb);
           
        }
    }
    //System.out.println("buffer now:"+sb);
    StringBuilder sb2 = new StringBuilder();
    for(int k=0;k<sb.length();k++ ){
        while ( k<sb.length()&& sb.charAt(k) != ' '){
            sb2.append(sb.charAt(k));
            k++;
        }
        st.push(sb2.toString());
        sb2.setLength(0);

    }
StringBuilder res = new StringBuilder();
System.out.println("stack : "+st);
while(!(st.empty())){
    res.append(st.pop());
    res.append(' ');
}
System.out.println(res);

}
}
