import edu.duke.*;
import java.io.*;
/**
 * Write a description of Part2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part2 {
    public ImageResource makeInversion(ImageResource inImage)
    {
        ImageResource outImage= new ImageResource(inImage.getWidth(),inImage.getHeight());
        for(Pixel p : outImage.pixels())
        {
           Pixel inPixel= inImage.getPixel(p.getX(),p.getY());
           p.setRed(255-inPixel.getRed());
           p.setBlue(255-inPixel.getBlue());
           p.setGreen(255-inPixel.getGreen());
        }
        return outImage;
    }
    public void testInversionandSave()
    {
        DirectoryResource dr = new DirectoryResource();
        for(File f: dr.selectedFiles())
        {
            ImageResource ir= new ImageResource(f);
            String fname = ir.getFileName();
            String newName= "inverted-"+fname;
            ImageResource gray= makeInversion(ir);
            gray.setFileName(newName);
            gray.draw();
            gray.save();
        }
    }
}
