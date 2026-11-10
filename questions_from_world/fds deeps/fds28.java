// Programming includes many braces like '{..}', '[..]', '(..)'. Let's check for the correct nestedness of braces!

// NOTE: There are no spaces between the braces in the actual input. Spaces in examples are shown for ease of understanding.

// Test Cases:
// Input  = {[()]}
// Output = TRUE

// Input  = {[(])}
// Output = FALSE

// Input  = {()[]}
// Output = TRUE

// Input  = {[()]}
// Output = TRUE

// Concept: Stack-based bracket matching

// import java.util.*;
//brinda
/*class fds28
{
    public static void main(String args[])
    {
        Scanner s = new Scanner(System.in);
        String str = s.nextLine();

        Stack<Character> stack = new Stack<>();

        for(char c : str.toCharArray())
        {
            // opening brackets
            if(c == '(' || c == '{' || c == '[')
            {
                stack.push(c);
            }
            else
            {
                

                char top = stack.pop();
                if((c == ')' && top != '(') ||
                   (c == '}' && top != '{') ||
                   (c == ']' && top != '['))
                {
                    System.out.println("FALSE");
                    return;
                }
            }
        }

        
        if(stack.isEmpty())
            System.out.println("TRUE");
        else
            System.out.println("FALSE");
    }
}*/
//chatgpt

import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

class fds28{
    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        String s1 = s.nextLine();
        HashMap <Character> h = new HashMap<>();
        h.put('(',')');
        h.put('[',']');
        h.put('{','}');
        Stack <Character> stackuu  = new Stack<>();
        for(char c : s1.toCharArray()){
            if(h.containsKey(c)){ // anntey opening vi 
                stackuu.push(c);
            }
            else if(h.containsValue(c)){ 
                char top = stackuu.pop();           // anntey closing 
                if(h.get(top) != c){ // comparing using map 
                    System.out.println("False");
                    return;
                }
            }
        }
        if(stackuu.isEmpty()){
            System.out.println("True");
            return;
        }
        else {
                System.out.println("False");
        }
    }
}