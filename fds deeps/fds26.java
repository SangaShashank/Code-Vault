/*Given a list of dates, sort them in ascending (chronological) order.

Date Format:
Each date is in the form:  dd mmm yyyy
•	dd  : 01 to 31
•	mmm : Jan, Feb, Mar, Apr, May, Jun, Jul, Aug, Sep, Oct, Nov, Dec
•	yyyy: four digit year

Input:
20 Oct 2052
06 Jun 1933
26 May 1960
20 Sep 1958
16 Mar 2068
25 May 1912
16 Dec 2018
26 Dec 2061
04 Nov 2030
28 Jul 1963

Output:
25 May 1912
06 Jun 1933
20 Sep 1958
26 May 1960
28 Jul 1963
16 Dec 2018
04 Nov 2030
20 Oct 2052
26 Dec 2061
16 Mar 2068

Concept: Custom Sort with key mapping (month name → month number)
*/
//shrewwwni approach : 
import java.util.*;
class fds26
{
    public static void main(String args[])
    {
        Scanner s= new Scanner(System.in);
        int a=s.nextInt();
        s.nextLine(); // fix

        String q[]=new String[a];

        Map<String,Integer> mnth=new HashMap<>();
        mnth.put("Jan",1); mnth.put("Feb",2); mnth.put("Mar",3);
        mnth.put("Apr",4); mnth.put("May",5); mnth.put("Jun",6);
        mnth.put("Jul",7); mnth.put("Aug",8); mnth.put("Sep",9);
        mnth.put("Oct",10); mnth.put("Nov",11); mnth.put("Dec",12);

        for(int i=0;i<a;i++)
        {
            q[i]=s.nextLine();
        }

        for(int i=0;i<a-1;i++)
        {
            for(int j=0;j<a-i-1;j++)
            {
                String p[]=q[j].split(" ");
                String b[]=q[j+1].split(" ");

                int y1=Integer.parseInt(p[2]);
                int y2=Integer.parseInt(b[2]);

                if(y1 > y2 ||
                  (y1 == y2 && mnth.get(p[1]) > mnth.get(b[1])) ||
                  (y1 == y2 && mnth.get(p[1]).equals(mnth.get(b[1])) &&
                   Integer.parseInt(p[0]) > Integer.parseInt(b[0])))
                {
                    String temp=q[j];
                    q[j]=q[j+1];
                    q[j+1]=temp;
                }
            }
        }

        for(int i=0;i<a;i++)
        {
            System.out.println(q[i]);
        }
    }
}
