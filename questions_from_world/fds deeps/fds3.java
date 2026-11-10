/*Problem:
// same question with out split is there in strings ques 1 of interviews
Reverse the order of words in a string. Words are separated by spaces.
Examples:
Input: "the sky is blue"
Output: "blue is sky the"

Input: "  hello world  "
Output: "world hello"
(Note: Remove extra spaces)

Input: "a good   example"
Output: "example good a"
(Note: Reduce multiple spaces to single space)
Constraints:

Remove leading/trailing spaces
Reduce multiple spaces between words to single space*/
public class fds3 {
        public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        String a = s.nextLine();
        String [] a2 = a.split("\\s+");
        int i=0, j = a2.length- 1;
        // two pointers vadudam : 
        while(i<j){
            String temp = a2[i];
            a2[i] = a2[j];
            a2[j] = temp;
            i++;
            j--;
        }
        System.out.print(Arrays.toString(a2));
    }
}

