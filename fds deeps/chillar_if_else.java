// ==================================================================
// Continuing our journey in mastering conditional statements & our interest with cricket.
// Let's help the Indian cricket's governing body (BCCI) to automate its plan of allotting pensions to former players.

// Rules:
// •	If a player has played more than 10 test matches AND more than 100 ODIs → Rs. 50,000
// •	If a player has played more than 10 test matches → Rs. 25,000
// •	If a player has played more than 100 ODIs → Rs. 15,000
// •	If a player has played for India → Rs. 10,000
// •	Amount is incremented by 1/4th for every 'Man of the Match' award
// •	If not played for India but played IPL → Rs. 8,000
// •	If not played for India nor IPL → Rs. 7,000

// Sample Input and Output 1:
// Has the player represented for India[y or n]?
// y
// Enter the number of Test matches he has played
// 15
// Enter the number of ODI matches he has played
// 101
// Number of man of the matches he has won
// 2
// Amount received as pension: Rs.75000.0

// Sample Input and Output 2:
// Has the player represented for India[y or n]? n
// Has he played IPL[y or n]? y
// Amount received as pension: Rs.8000.0

// Concept: Conditional Logic (nested if-elif-else) with arithmetic
import java.util.*;
public class chillar_if_Else{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.println("Has the player represented for India[y or n]?");
        char india = sc.next().charAt(0);

        double pension = 0;

        if (india == 'y'){

            System.out.println("Enter the number of Test matches he has played");
            int tests = sc.nextInt();

            System.out.println("Enter the number of ODI matches he has played");
            int odis = sc.nextInt();

            System.out.println("Number of man of the matches he has won");
            int mom = sc.nextInt();

            if (tests > 10 && odis > 100) {
                pension = 50000;
         } else if (tests > 10){
                pension = 25000;
}       else if (odis > 100){
                pension = 15000;
} else{
                pension = 10000;
}
            pension += pension * 0.25 * mom;

}        else{
            System.out.println("Has he played IPL[y or n]?");
            char ipl = sc.next().charAt(0);
            if (ipl == 'y' || ipl == 'Y') {
                pension = 8000;
}           else {
                pension = 7000; 
}
        
}
      System.out.println("Amount received as pension: Rs." + pension);
        sc.close();
    

}
