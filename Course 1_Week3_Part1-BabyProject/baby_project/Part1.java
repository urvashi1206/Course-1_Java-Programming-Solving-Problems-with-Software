import org.apache.commons.csv.*;
import edu.duke.*;
import java.io.*;
/**
 * Write a description of Part1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part1 {
    public void totalBirths(FileResource fr)
    {
        int noOfGirls=0;
        int noOfBoys=0;
        int totalBirths=0;
        for(CSVRecord csv: fr.getCSVParser(false))
        {
            int numBorn = Integer.parseInt(csv.get(2));
            totalBirths+=numBorn;
            if(csv.get(1).equals("F"))
            {
                noOfGirls+=numBorn;
            }
            else if(csv.get(1).equals("M"))
            {
                noOfBoys+=numBorn;
            }
        }
        System.out.println("Total Births "+totalBirths);
        System.out.println("Total Girls "+noOfGirls);
        System.out.println("Total Boys "+noOfBoys);
    }
    public void testBirths()
    {
       FileResource f= new FileResource();
       totalBirths(f);
    }
    public int getRank(int year, String name, String gender)
    {
        String fname="yob"+year+".csv";
        FileResource fr = new FileResource(fname);
        int rank=0;
        for(CSVRecord csv: fr.getCSVParser(false))
        {
            if(csv.get(1).equals(gender)){
                rank++;
                if(csv.get(0).equals(name))
                {
                    return rank;
                }
            }
        }
        return -1;
    }
    public void testRank()
    {
        int rank=getRank(1971, "Frank", "M");
        System.out.println("Rank: "+rank);
    }
    public String getName(int year, int rank, String gender)
    {
        String name="";
        String fname="yob"+year+".csv";
        FileResource fr = new FileResource(fname);
        int checkRank=0;
        for(CSVRecord csv:fr.getCSVParser(false))
        {
            if(csv.get(1).equals(gender))
            {
                checkRank++;
                if(checkRank==rank)
                {
                    return csv.get(0);
                }
            }
        }
        return "NO NAME";
    }
    public void testName()
    {
        String name = getName(1982,450,"M");
        System.out.println("Name: "+name);
    }
    public void whatIsNameInYear(String name, int year, int newYear, String gender)
    {
        String nameyear="yob"+year+".csv";
        FileResource fr = new FileResource(nameyear);
        CSVParser csvOld = fr.getCSVParser(false);
        
        String newnameyear="yob"+newYear+".csv";
        FileResource fr1 = new FileResource(newnameyear);
        CSVParser csvNew = fr1.getCSVParser(false);
        
        int rank=0;
        int flag=0;
        for(CSVRecord csv: csvOld)
        {
            if(csv.get(1).equals(gender))
            {
                rank++;
                if(csv.get(0).equals(name)) {
                     flag=1;
                     break;
                }
            }
        }
        int newrank=0;
        int newflag=0;
        if(flag==0)
        {
            System.out.println("NO NAME!") ;
        }
        for(CSVRecord csv: csvNew)
        {
            if(csv.get(1).equals(gender))
            {
                newrank++;
                if(newrank==rank) {
                     newflag=1;
                     System.out.println(name + " born in " + year + " would be " + csv.get(0) + " if she/he was born in "+ newYear);
                }
            }
        }
        if(newflag==0)
        {
            System.out.println("No such rank in year "+newYear);
        }
    }
    public void testNameInYear()
    {
        whatIsNameInYear("Owen", 1974, 2014, "M");
    }
    public int yearOfHighestRank(String name, String gender)
    {
        DirectoryResource dr = new DirectoryResource();
        int rank=0;
        int year=0;
        for(File f: dr.selectedFiles())
        {
            int currYear=Integer.parseInt(f.getName().substring(3,7));
            int currRank=getRank(currYear, name, gender);
            if(currRank!=-1)
            {
                if(rank==0 || currRank<rank)
                {
                    rank=currRank;
                    year=currYear;
                }
            }
        }
        if(year==0)
        {
            return -1;
        }
        return year;
    }
    public void testyearOfHighestRank() {
        int year = yearOfHighestRank("Mich", "M");
        System.out.println("Highest rank is in the year: "+year);
    }
    public double getAverageRank(String name, String gender)
    {
        DirectoryResource dr = new DirectoryResource();
        double avgRank=0.0;
        int len=0;
        double rank=0.0;
        for(File f: dr.selectedFiles())
        {
            String fname=f.getName();
            FileResource fr= new FileResource(fname);
            for(CSVRecord csv:fr.getCSVParser(false))
            {
                int currentYear = Integer.parseInt(f.getName().substring(3,7));
                int currentRank = getRank(currentYear, name, gender);
                rank+=currentRank;
                len++;
            }
        }
        if (rank==0)
        {
            return -1;
        }
        avgRank=rank/len;
        return avgRank;
    }
    public void testAvgRank()
    {
       double avg= getAverageRank("Robert", "M");
       System.out.println("Average Rank: "+avg);
    }
    public int  getTotalBirthsRankedHigher(int year, String name, String gender)
    {
        String nameyear = "yob" + year + ".csv";
        FileResource fr = new FileResource(nameyear);
        CSVParser parser = fr.getCSVParser(false);
        int totalBirths=0;
        int flag=0;
        for(CSVRecord record: parser)
        {
            if(record.get(1).equals(gender))
            {
                if(record.get(0).equals(name))
                {
                    flag=1;
                    break;
                }
                totalBirths+=Integer.parseInt(record.get(2));
            }
        }
        if(flag==0)
        {
            return -1;
        }
        return totalBirths;
    }
    public void testgetTotalBirthsRankedHigher() {
        int sum = getTotalBirthsRankedHigher(1990, "Drew", "M");
        System.out.println("The total births higher is "+sum);
    }
}
