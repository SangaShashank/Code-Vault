/*Given an array, return the k most frequent elements.
Input:
nums = [1,1,1,2,2,3]  
k = 2
Output:
[1,2]

sample test case 1:
input=1 1 1 2 2 3
2
output=1 2

sample test case 1:
input=2 1 1 2 2 3 3 4
3
output=2 3 1*/
//my approch : 
/*import java.util.*;
class fds24{
    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        String s1 [] = s.nextLine().split(",");
        Integer l [] = new Integer[s1.length];
        for (int i = 0;i<s1.length;i++){
            l[i] = Integer.parseInt(s1[i]);
        }
        int j = s.nextInt();
        
        HashMap<Integer,Integer> m = new HashMap<>();
        for (int k : l){
            m.put(k,m.getOrDefault(k,0)+1);
        }
        //System.out.print((m.values()).getClass().getName());
        List <Integer> l2 = new ArrayList<>(m.values());
        l2.sort(Collections.reverseOrder());
        List <Integer> l3 = l2.subList(0,j);
        List <Integer > res = new ArrayList<>();// top k values kada 
        for (int v : l3){
           // System.out.print(v);
           for(int k : m.keySet()){
               if(m.get(k)==v) {res.add(k);}
           }      
        }
        System.out.print(res);
    }
}*/
// ai one:
import java.util.*;
class fds24{
    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        String s1 [] = s.nextLine().split(" ");
        Integer l [] = new Integer[s1.length];
        for (int i = 0;i<s1.length;i++){
            l[i] = Integer.parseInt(s1[i]);
        }
        int j = s.nextInt();
        
        HashMap<Integer,Integer> m = new HashMap<>();
        for (int k : l){
            m.put(k,m.getOrDefault(k,0)+1);
        }
        PriorityQueue <Integer> pq = new PriorityQueue<>(
            (a,b) -> m.get(a) - m.get(b) // see in book 
            );
        for (int i: m.keySet())    {
            pq.add(i); // automatic ga ascending order of lo pothadi 
            if(pq.size()>j){
                pq.poll();     // top k kada , so pool chestunnam 
            }
        }
        List <Integer> res = new ArrayList<>();
        while(!pq.isEmpty()){
            //System.out.print(pq.poll() + " ");
            res.add(pq.poll());
            
        }
        Collections.reverse(res);
        for (int i : res) System.out.print(i + " ");

    }
}