
/**
 * Write a description of Part3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part3 {
    public boolean twoOccurrences(String a, String b)
    {
         int count=0;
         int occ = b.indexOf(a);
         if(occ==-1)
         {
             return false;
         }
         count+=1;
         for(int i=occ;i<b.length();i++){
             String s=b.substring(occ+a.length());
             occ=s.indexOf(a);
             if(occ==-1)
             {
                 return false;
                }
             count+=1;
         }
         if(count>=2)
         {
             return true;
            }
         else 
         {
             return false;
            }
    }
    
    public void testing()
    {
        String a="atg";
        String b="ctgtatgta";
        boolean result=twoOccurrences(a, b);
        System.out.println("Result : " + result);
        
        a="a";
        b="banana";
        result=twoOccurrences(a, b);
        System.out.println("Result : " + result);
                       
        a="by";
        b="A story by Abby Long";
        result=twoOccurrences(a, b);
        System.out.println("Result : " + result);
        
        a="an";
        b="banana";
        String answer=lastPart(a, b);
        System.out.println("The part of the string after " +a+" in "+b+" is "+answer);
        
        a="zoo";
        b="forest";
        answer=lastPart(a, b);
        System.out.println("The part of the string after " +a+" in "+b+" is "+answer);
        
        a="by";
        b="A story by Abby Long";
        answer=lastPart(a, b);
        System.out.println("The part of the string after " +a+" in "+b+" is "+answer);
    }
    public String lastPart(String a, String b)
    {
         int occ = b.indexOf(a);
         if(occ==-1)
         {
             return b;
         }
         String s=b.substring(occ+a.length());
         return s;
    }
}

