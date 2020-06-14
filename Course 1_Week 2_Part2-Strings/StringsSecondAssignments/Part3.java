import edu.duke.StorageResource;
import edu.duke.FileResource;
/**
 * Write a description of Part3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part3 {
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
    
    public String findGene(String dna, int startIndex)
    {
        if(startIndex==-1)
        {
            return "";
        }
        int taaIndex=findStopCodon(dna,startIndex,"TAA");
        System.out.println("TAA index:"+taaIndex);
        int tagIndex=findStopCodon(dna,startIndex,"TAG");
        System.out.println("TAG index:"+tagIndex);
        int tgaIndex=findStopCodon(dna,startIndex,"TGA");
        System.out.println("TGA index:"+tgaIndex);
        int minIndex=0;
        if(taaIndex==-1||(tgaIndex!=-1 && tgaIndex<taaIndex)){
            minIndex=tgaIndex;
        }
        else {
            minIndex=taaIndex;
        }
        if(minIndex==-1 || (tagIndex!=-1 && tagIndex<minIndex)){
            minIndex=tagIndex;
        }
        if(minIndex==-1)
        {
            return "";
        }
        System.out.println("min index:"+minIndex);
        System.out.println(dna.substring(startIndex,minIndex+3));
        return dna.substring(startIndex,minIndex+3);
    }
    
    public StorageResource printAllGenes(String dna)
    {
        StorageResource res= new StorageResource();
        int startIndex=dna.indexOf("ATG");
        
        while(true)
        {
            String currGene=findGene(dna,startIndex);
            if(currGene.isEmpty())
            {
                break;
            }
            res.add(currGene);
            startIndex=dna.indexOf("ATG", startIndex+currGene.length());        
        }
        //System.out.println("Start Index is :"+startIndex);
        return res;
    }
    
    public void test(String dna){
        System.out.println("Testing on:"+dna);
        StorageResource gene=printAllGenes(dna);
        for(String s: gene.data()){
            System.out.println(s);
        }
        //countGenes("ATGATCTAATTTATGCTGCAAACGGTGAAGA");
        //countGenes("ATGATCATAAGAAGATAATAGAGGGCCATGTAA");
        //countGenes("ATGHHPTGA");
    }
    
    public void testOn()
    {
        test("ATGTAAMKLATGHHPTAA");
    }
}
