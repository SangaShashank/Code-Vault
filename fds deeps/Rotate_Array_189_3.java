/*Problem Statement:
You're building a playlist shuffle feature for a music app. The app has a "rotate playlist" button that shifts all songs by k positions to give users a different listening order without full randomization.
Given an array of songs and a number k, rotate the array to the right by k steps.

Example Scenarios:

Input: songs = ["Pop", "Rock", "Jazz", "Blues", "Country"], k = 2
Output: ["Blues", "Country", "Pop", "Rock", "Jazz"]

Explanation: 
After 1st rotation: ["Country", "Pop", "Rock", "Jazz", "Blues"]
After 2nd rotation: ["Blues", "Country", "Pop", "Rock", "Jazz"]

Input: songs = ["Song1", "Song2", "Song3"], k = 1
Output: ["Song3", "Song1", "Song2"]

Explanation: Move the last song to the front

Input: nums = [1, 2, 3, 4, 5], k = 5
Output: [1, 2, 3, 4, 5]

Explanation: Rotating by array length brings it back to original


*/
import java.util.*;

public class Rotate_Array_189_3 {
    public static void main(String[] args) {

        String[] songs = {"Pop", "Rock", "Jazz", "Blues", "Country"};
        int k = 2;

        int n = songs.length;
        k = k % n;   // handle large k

        String[] result = new String[n];

        for (int i = 0; i < n; i++) {
            result[(i + k) % n] = songs[i];
        }

        System.out.println(Arrays.toString(result));
    }
}

