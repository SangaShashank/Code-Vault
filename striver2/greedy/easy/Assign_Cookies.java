//package PLACEMENTS.striver.greedy.easy;
/*Consider a scenario where a teacher wants to distribute cookies to students, with each student receiving at most one cookie.

Given two arrays, student and cookie, the ith value in the Student array describes the minimum size of cookie that the ith student can be assigned. The jth value in the Cookie array represents the size of the jth cookie. If Cookie[j] >= Student[i], the jth cookie can be assigned to the ith student.

Maximize the number of students assigned with cookies and output the maximum number.

Example 1:
Input : student = [1, 2, 3] , cookie = [1, 1]

Output :1

Explanation : You have 3 students and 2 cookies.

The minimum size of cookies required for students are 1 , 2 ,3.

You have 2 cookies both of size 1, So you can assign the cookie only to student having minimum cookie size 1.

So your answer is 1.

Example 2:
Input : student = [1, 2] , cookie = [1, 2, 3]

Output : 2

Explanation : You have 2 students and 3 cookies.

The minimum size of cookies required for students are 1 , 2.

You have 3 cookies and their sizes are big enough to assign cookies to all students.

So your answer is 2.

Example 3:
Input : student = [4, 5, 1] , cookie = [6, 4, 2]

Output:
3 */
//chatgpt code like me tho generatate chesina 
import java.util.*;

public class Assign_Cookies {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();
        int student[] = new int[n];
        for (int i = 0; i < n; i++) student[i] = s.nextInt();

        int m = s.nextInt();
        int cookie[] = new int[m];
        for (int i = 0; i < m; i++) cookie[i] = s.nextInt();

        System.out.println(app1(student, cookie, n, m));
    }

    // Approach 1: Sorting + Two Pointers
    // Time: O(n log n + m log m), Space: O(1) auxiliary
    public static int app1(int student[], int cookie[], int n, int m) {
        Arrays.sort(student);
        Arrays.sort(cookie);

        int i = 0, j = 0;

        while (i < n && j < m) {
            if (cookie[j] >= student[i]) {
                i++;
            }
            j++;
        }

        return i;
    }
}
