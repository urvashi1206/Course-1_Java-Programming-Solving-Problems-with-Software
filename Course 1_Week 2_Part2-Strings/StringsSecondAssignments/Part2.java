
/**
 * Write a description of Part2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part2 {
    public int howMany(String a, String b)
    {
        int currIndex=b.indexOf(a);
        int count=0;
        while(currIndex!=-1)
        {
           count+=1;
           currIndex=b.indexOf(a,currIndex+a.length());
        }
        return count;
    }
    
    public void testHowMany()
    {
        String a="GAA";
        String b="ATGAACGAATTGAATC";
        int count=howMany(a,b);
        System.out.println(count);
        
        String x="AA";
        String y="ATAAAA";
        count=howMany(x,y);
        System.out.println(count);
    }
}
