
/**
 * Write a description of Part1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part1 {
    public int findStopCodon(String dna, int startIndex, String stopCodon)
    {
        int currIndex=dna.indexOf(stopCodon,startIndex+3);
        while(currIndex!=-1){
            if((currIndex-startIndex)%3==0)
            {
                return currIndex;
            }
            else
            {
                currIndex=dna.indexOf(stopCodon,currIndex+1);
            }
        }
        return dna.length();
    }
    
    public void testFindStopCodon()
    {
        String dna="xxxyyyzzzTAAxxxyyyyzzzTAAxx";
        int dex=findStopCodon(dna,0,"TAA");
        if(dex!=9){
            System.out.println("Error on 9");
        }
        dex=findStopCodon(dna,9,"TAA");
        if(dex!=21){
            System.out.println("Error on 21");
        }
        dex=findStopCodon(dna,1,"TAA");
        if(dex!=26){
            System.out.println("Error on 26");
        }
        dex=findStopCodon(dna,0,"TAG");
        if(dex!=26){
            System.out.println("Error on 26");
        }
        System.out.println("tests finished");
    }
    
    public String findGene(String dna, int where)
    {
        int startIndex=dna.indexOf("ATG");
        if(startIndex==-1)
        {
            return "";
        }
        int taaIndex=findStopCodon(dna,startIndex,"TAA");
        int tagIndex=findStopCodon(dna,startIndex,"TAG");
        int tgaIndex=findStopCodon(dna,startIndex,"TGA");
        int Index=Math.min(tagIndex,taaIndex);
        int minIndex=Math.min(Index,tgaIndex);
        if(minIndex==dna.length())
        {
            return "";
        }
        return dna.substring(startIndex,minIndex+3);
    }
    
    public void printAllGenes(String dna)
    {
        int startIndex=0;
        while(true)
        {
            String currGene=findGene(dna,startIndex);
            if(currGene.isEmpty())
            {
                break;
            }
            System.out.println(currGene);
        }
    }
}
