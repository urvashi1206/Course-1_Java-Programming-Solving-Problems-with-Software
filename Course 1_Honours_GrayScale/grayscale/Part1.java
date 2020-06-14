import edu.duke.*;
import java.io.*;
/**
 * Write a description of Part1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part1 {
    public ImageResource makeGray(ImageResource inImage)
    {
        ImageResource outImage= new ImageResource(inImage.getWidth(),inImage.getHeight());
        for(Pixel p : outImage.pixels())
        {
           Pixel inPixel= inImage.getPixel(p.getX(),p.getY());
           int avg= (inPixel.getRed()+inPixel.getBlue()+inPixel.getGreen())/3;
           p.setRed(avg);
           p.setBlue(avg);
           p.setGreen(avg);
        }
        return outImage;
    }
    public void testGrayandSave()
    {
        DirectoryResource dr = new DirectoryResource();
        for(File f: dr.selectedFiles())
        {
            ImageResource ir= new ImageResource(f);
            String fname = ir.getFileName();
            String newName= "gary-"+fname;
            ImageResource gray= makeGray(ir);
            gray.setFileName(newName);
            gray.draw();
            gray.save();
        }
    }
}
