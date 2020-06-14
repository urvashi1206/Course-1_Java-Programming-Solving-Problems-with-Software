
/**
 * Write a description of Part2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part2 {
    public String findSimpleGene(String dna, int startCodon, int stopCodon)
    {
        String result="";
        String test="";        
        if(startCodon==-1)
        {
            return "";
        }        
        if(stopCodon==-1)
        {
            return "";
        }
        test=dna.substring(startCodon,stopCodon+3);
        if(test.length()%3==0)
        {
            result=test;
        }
        else 
        {
            return "";
        }
        return result;
    }
    
    public void  testSimpleGene()
    {
        String dna="";
             
        dna="ATTAGSATGAGATGGATTAA";
        int startCodon=dna.indexOf("ATG");
        int stopCodon=dna.indexOf("TAA",startCodon+3);
        System.out.println("DNA Strand is : " + dna);
        String gene = findSimpleGene(dna,startCodon,stopCodon);
        System.out.println("Gene is : " + gene);
        
        dna="TAGTAGAGTAA";
        startCodon=dna.indexOf("ATG");
        stopCodon=dna.indexOf("TAA",startCodon+3);
        dna.toLowerCase();
        System.out.println("DNA Strand is : " + dna);
        gene = findSimpleGene(dna,startCodon,stopCodon);
        System.out.println("Gene is : " + gene);
        
        dna="ATTATGTTATAT";
        startCodon=dna.indexOf("ATG");
        stopCodon=dna.indexOf("TAA",startCodon+3);
        System.out.println("DNA Strand is : " + dna);
        gene = findSimpleGene(dna,startCodon,stopCodon);
        System.out.println("Gene is : " + gene);
        
        dna="tatatatat";
        startCodon=dna.indexOf("ATG");
        stopCodon=dna.indexOf("TAA",startCodon+3);
        dna=dna.toUpperCase();
        System.out.println("DNA Strand is : " + dna);
        gene = findSimpleGene(dna,startCodon,stopCodon);
        System.out.println("Gene is : " + gene);
        
        dna="ATTAGSATGAGATGGATTTAAAG";
        startCodon=dna.indexOf("ATG");
        stopCodon=dna.indexOf("TAA",startCodon+3);
        System.out.println("DNA Strand is : " + dna);
        gene = findSimpleGene(dna,startCodon,stopCodon);
        System.out.println("Gene is : " + gene);        
    }
}
