import edu.duke.FileResource;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
/**
 * Write a description of Part1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part1 {
    public String countryInfo(CSVParser parser, String country)
    {
        for(CSVRecord csvRecord : parser)
        {
            String newCountry= csvRecord.get("Country");
            String countryInfo="";
            if(newCountry.contains(country))
            {
                countryInfo = String.format("%s: %s: %s",country , csvRecord.get("Exports"), csvRecord.get("Value (dollars)"));
                return countryInfo;
            }
        }
        return "NOT FOUND";
    }
    public void listExportersTwoProducts(CSVParser parser, String exportItem1, String exportItem2)
    {
        for(CSVRecord csvRecord : parser)
        {
           String exportItems= csvRecord.get("Exports");
           if(exportItems.contains(exportItem1) && exportItems.contains(exportItem2))
           {
               System.out.print("\n"+csvRecord.get("Country"));
           }
        }
    }
    public int numberOfExporters(CSVParser parser, String exportItem)
    {
        int count=0;
        for(CSVRecord csvRecord : parser)
        {
           String exportItems= csvRecord.get("Exports");
           if(exportItems.contains(exportItem))
           {
               count++;
           }
        }
        return count;
    }
    public void  bigExporters(CSVParser parser, String amount)
    {
       for(CSVRecord csvRecord : parser)
        {
           String values= csvRecord.get("Value (dollars)");
           if(values.length()>amount.length())
           {
               System.out.print("\n"+csvRecord.get("Country")+" ");
               System.out.println(values);
           }
        } 
    }
    public void tester()
    {
        FileResource fr= new FileResource();
        CSVParser parser = fr.getCSVParser();
        //String country=countryInfo(parser, "Nauru");
        //System.out.print(country);
        //parser = fr.getCSVParser();
        //listExportersTwoProducts(parser, "cotton", "flowers");
        //parser = fr.getCSVParser();
        //int count=numberOfExporters(parser, "cocoa");
        //System.out.print("\n"+count);
        //parser = fr.getCSVParser();
        bigExporters(parser, "$999,999,999,999");
    }
}
