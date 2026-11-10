/*Given an array of characters chars, compress it using the following algorithm:

Begin with an empty string s. For each group of consecutive repeating characters in chars:

If the group's length is 1, append the character to s.
Otherwise, append the character followed by the group's length.
The compressed string s should not be returned separately,
 but instead, be stored in the input character array chars.
  Note that group lengths that are 10 or longer will be split into multiple characters in chars.

After you are done modifying the input array, return the new length of the array.

You must write an algorithm that uses only constant extra space.

Note: The characters in the array beyond the returned length do not matter and should be ignored.

 

Example 1:

Input: chars = ["a","a","b","b","c","c","c"]
Output: 6
Explanation: The groups are "aa", "bb", and "ccc". This compresses to "a2b2c3".
Example 2:

Input: chars = ["a"]
Output: 1
Explanation: The only group is "a", which remains uncompressed since it's a single character.
Example 3:

Input: chars = ["a","b","b","b","b","b","b","b","b","b","b","b","b"]
Output: 4
Explanation: The groups are "a" and "bbbbbbbbbbbb". This compresses to "ab12".*/
/* idhi code cheyatam koncham agam agam chesinga 
import java.util.*;
public class ques5 {
    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        String s1 = s.nextLine();
        char arr [] = s1.toCharArray();
        int i=0,j=1,w=0;
        while(i<arr.length){
            if(j<arr.length && arr[i]==arr[j]) j++;
            else{
                if((j-i)>1){
                    arr[w]=arr[i];
                    String count = String.valueOf((j-i));
                    for(char c: count.toCharArray()){
                            w++;
                            arr[w]=c;
                    }
                    i = j;
                    j++;
                }
                else{
                    w++;
                    arr[w] = arr[i];
                    i++; j++; 
                }
            }
        }
        System.out.print(new String(arr));
    }
}
*/
/*ai 
int i = 0, w = 0;
int n = arr.length;

while(i < n) {
    char current = arr[i];
    int j = i;

    // scan the group
    while(j < n && arr[j] == current) {
        j++;
    }

    int count = j - i;

    // write character
    arr[w++] = current;

    // write count if more than 1
    if(count > 1){
        for(char c: String.valueOf(count).toCharArray()){
            arr[w++] = c;
        }
    }

    // move i to next group
    i = j;
}*/