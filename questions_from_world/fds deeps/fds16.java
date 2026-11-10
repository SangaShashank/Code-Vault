/*
Imagine you are building a University Exam Registration System.
Each student is assigned a unique registration ID stored in an integer array nums.
Due to a system glitch, some IDs might be recorded more than once.
Your task is to check whether any registration ID appears more than once.
If any duplicate exists → print true
If all IDs are unique → print false

Problem Statement
Given an integer array nums, return:
true if any value appears at least twice
false if every element is distinct

Input Format
nums = [element1,element2,element3,...]

Input is given in single line
Elements are comma-separated
Values may be positive or negative

Output Format
true

or
false

Constraints
1 <= nums.length <= 10^5
-10^9 <= nums[i] <= 10^9

 Large input size possible
 Negative numbers allowed
 Large integer values allowed

Sample Test Cases
Test Case1
input=[-5,-4,-3,-2,-1,0,1,2,3,4]
output=false
Test Case2
input=nums = [0,0,1,2]
output=true

*/
// brinda approach 

/*import java.util.*;
class fds16
{
    public static void main(String args[])
    {
       Scanner s=new Scanner(System.in);
        
        String a=s.nextLine();
        a=a.replace("[","").replace("]","");
        String b[]=a.split(",");
        int c=0;
        for(int i=0;i<b.length;i++)
        

{


           
            for(int j=i+1;j<b.length;j++)
            

{


                if(Integer.parseInt(b[i])==Integer.parseInt(b[j]))
                

{


                    c++;
                

}
            

}
            
        

}
        
        if(c>=1)
        

{


                System.out.println(true);
        

}
        else
        

{


                System.out.println(false);
        

}

}

}*/
 // my appraoch 
 import java.util.*;
class fds16{
    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        String s1 [] = s.nextLine().split(",");
        Integer l [] = new Integer[s1.length];
        for(int i=0;i<s1.length;i++){
            l[i]= Integer.parseInt(s1[i]);
        }
        HashMap <Integer, Integer> m = new HashMap<>();
        for (int i : l){
            m.put(i,m.getOrDefault(i,0)+1);
        }
        for (int i : m.values()){
            if (i > 1) {
                System.out.println("true");
                return ; 
            }
        }
        System.out.print("false"); // em lekapthey idi varaku vastasdi kada 
        
    }
}
// Ai appraoch :
/*import java.util.*;
class fds16 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String[] input = s.nextLine().split(",");
        
        Set<Integer> seen = new HashSet<>();
        for(String numStr : input){
            int num = Integer.parseInt(numStr.trim());
            if(seen.contains(num)){
                System.out.println("true"); // duplicate found
                return;
            }
            seen.add(num);
        }
        System.out.println("false"); // no duplicates
    }
} */