
/**
 * Write a description of Part1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part1 {
    public String findSimpleGene(String dna)
    {
        String result="";
        String test="";
        int startIndex=dna.indexOf("ATG");
        if(startIndex==-1)
        {
            return "";
        }
        int stopIndex=dna.indexOf("TAA",startIndex+3);
        if(stopIndex==-1)
        {
            return "";
        }
        test=dna.substring(startIndex,stopIndex+3);
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
        System.out.println("DNA Strand is : " + dna);
        String gene = findSimpleGene(dna);
        System.out.println("Gene is : " + gene);
        
        dna="TAGTAGAGTAA";
        System.out.println("DNA Strand is : " + dna);
        gene = findSimpleGene(dna);
        System.out.println("Gene is : " + gene);
        
        dna="ATTATGTTATAT";
        System.out.println("DNA Strand is : " + dna);
        gene = findSimpleGene(dna);
        System.out.println("Gene is : " + gene);
        
        dna="TATATATAT";
        System.out.println("DNA Strand is : " + dna);
        gene = findSimpleGene(dna);
        System.out.println("Gene is : " + gene);
        
        dna="ATTAGSATGAGATGGATTTAAAG";
        System.out.println("DNA Strand is : " + dna);
        gene = findSimpleGene(dna);
        System.out.println("Gene is : " + gene);        
    }
}
