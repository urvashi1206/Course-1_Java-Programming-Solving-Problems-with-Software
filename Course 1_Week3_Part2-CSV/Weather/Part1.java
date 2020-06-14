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
    public CSVRecord coldestHourInFile(CSVParser parser)
    {
        CSVRecord coldestSoFar=null;
        for(CSVRecord current : parser)
        {
            if(coldestSoFar==null)
            {
                coldestSoFar=current;
            }
            else
            {
                double coldestTemp=Double.parseDouble(coldestSoFar.get("TemperatureF"));
                double currentTemp=Double.parseDouble(current.get("TemperatureF"));
                if(currentTemp != -9999 && coldestTemp>currentTemp)
                {
                    coldestSoFar=current;
                }
            }
        }
        return coldestSoFar;
    }
    public String fileWithColdestTemperature()
    {
        String coldestFileName=null;
        CSVRecord largestSoFar = null;
        DirectoryResource dr= new DirectoryResource();
        for(File f:dr.selectedFiles()){
            FileResource fr= new FileResource(f);
            CSVRecord current=coldestHourInFile(fr.getCSVParser());
            if(largestSoFar==null)
            {
                largestSoFar=current;
            }
            else{
                double coldestTemp=Double.parseDouble(largestSoFar.get("TemperatureF"));
                double currentTemp=Double.parseDouble(current.get("TemperatureF"));
                if(currentTemp != -9999 && coldestTemp>currentTemp)
                {
                    largestSoFar=current;
                    coldestFileName=f.getPath();
                }
            }
        }
        return coldestFileName;
    }
    
    public void testFileWithColdestTemperature()
    {
        String coldestFileName=fileWithColdestTemperature();
        System.out.println("Coldest day was in the file: "+coldestFileName);
        FileResource f = new FileResource(coldestFileName);
        CSVRecord record = coldestHourInFile(f.getCSVParser());
        System.out.println("Coldest Temperature was "+record.get("TemperatureF"));
        System.out.println("All the temperatures on the coldest day were: ");
        for(CSVRecord coldest: f.getCSVParser())
        {
            System.out.print(coldest.get("DateUTC"));
            System.out.print(" ");
            System.out.println(coldest.get("TemperatureF"));
        }
    }
    public CSVRecord lowestHumidityInFile(CSVParser parser)
    {
        CSVRecord leastHumid=null;
        for(CSVRecord current : parser)
        {
            if(leastHumid==null)
            {
                leastHumid=current;
            }
            else
            {
                if(current.get("Humidity").length() != 3) { 
                    double leastHumidTemp=Double.parseDouble(leastHumid.get("Humidity"));
                    double currentHumid=Double.parseDouble(current.get("Humidity"));
                    if(currentHumid<leastHumidTemp && currentHumid!=-9999)
                    {
                        leastHumid=current;
                    }
                }
            }
        }
        return leastHumid;
    }
    public CSVRecord lowestHumidityInManyFiles()
    {
        CSVRecord lowestHumid = null;
        DirectoryResource dr= new DirectoryResource();
        for(File f:dr.selectedFiles()){
            FileResource fr= new FileResource(f);
            CSVRecord current=lowestHumidityInFile(fr.getCSVParser());
            if(lowestHumid==null)
            {
                lowestHumid=current;
            }
            else{
                if(current.get("Humidity").length() != 3) { 
                    double leastHumidTemp=Double.parseDouble(lowestHumid.get("Humidity"));
                    double currentHumid=Double.parseDouble(current.get("Humidity"));
                    if(currentHumid<leastHumidTemp && currentHumid!=-9999)
                    {
                        lowestHumid=current;
                    }
                }
            }
        }
        return lowestHumid;
    }
    public void testLowestHumidityInManyFiles()
    {
        CSVRecord leastHumid=lowestHumidityInManyFiles();
        System.out.println("Lowest Humidity was "+leastHumid.get("Humidity")+" at "+leastHumid.get("DateUTC"));
    }
    public double averageTemperatureInFile(CSVParser parser)
    {
        double avgTemp=0.0;
        int len=0;
        double sum=0.0;
        for(CSVRecord csv:parser)
        {
            double currentTemp= Double.parseDouble(csv.get("TemperatureF"));
            sum+=currentTemp;
            len++;
        }
        avgTemp=sum/len;
        return avgTemp;
    }
    public void testAverageTemperatureInFile() 
    {
        FileResource f = new FileResource();
        CSVParser parser = f.getCSVParser();
        double avgTemp= averageTemperatureInFile(parser);
        System.out.print("Average temperature in file is "+avgTemp);
    }
    public void testLowestHumidityInFile()
    {
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        CSVRecord csv = lowestHumidityInFile(parser);
        System.out.print("Lowest Humidity was ");
        System.out.print(csv.get("Humidity"));
        System.out.println(" at "+csv.get("DateUTC"));
    }
    public double averageTemperatureWithHighHumidityInFile(CSVParser parser,int value)
    {
        double avgTemp=0.0;
        int len=1;
        double sum=0.0;
        for(CSVRecord csv:parser)
        {
            double currentTemp= Double.parseDouble(csv.get("TemperatureF"));
            double currentHumid= Double.parseDouble(csv.get("Humidity"));
            if(currentHumid>=value)
            {
                sum+=currentTemp;
                avgTemp=sum/len;
                len++;
            }   
        }
        return avgTemp;
    }
    public void testAverageTemperatureWithHighHumidityInFile()
    {
        FileResource fr= new FileResource();
        CSVParser parser = fr.getCSVParser();
        double avg =averageTemperatureWithHighHumidityInFile(parser,80);
        if(avg==0)
        {
            System.out.println("\nNo temperatures with that humidity");
        }
        else 
        {
            System.out.println("Average Temp when high Humidity is "+avg);
        }
    }
    public void testColdestHourInFile()
    {
        FileResource fr= new FileResource();
        CSVRecord coldestSoFar=coldestHourInFile(fr.getCSVParser());
        System.out.println("Coldest Temperature was "+coldestSoFar.get("TemperatureF")+" at "+coldestSoFar.get("DateUTC"));
        
    }
}
