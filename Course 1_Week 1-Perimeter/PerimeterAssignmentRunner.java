import edu.duke.*;
import java.io.File;

public class PerimeterAssignmentRunner {
    public double getPerimeter (Shape s) {
        // Start with totalPerim = 0
        double totalPerim = 0.0;
        // Start wth prevPt = the last point 
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
            totalPerim = totalPerim + currDist;
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        // totalPerim is the answer
        return totalPerim;
    }

    public int getNumPoints (Shape s) {
        // Put code here
        int count=0;
        for(Point p : s.getPoints()){
            count+=1;
        }
        return count;
    }

    public double getAverageLength(Shape s) {
        // Put code here
        double length=getPerimeter(s);
        double sides=getNumPoints(s);
        double avgLength=length/sides;
        return avgLength;
    }

    public double getLargestSide(Shape s) {
        // Put code here
        double largestSide=0.0;
        Point lastPoint=s.getLastPoint();
        for(Point p:s.getPoints())
        {
            double dist=lastPoint.distance(p);
            if(dist>largestSide){
                largestSide=dist;
            }
            lastPoint=p;
        }
        return largestSide;
    }

    public double getLargestX(Shape s) {
        // Put code here
        double largestX=0.0;
        for(Point p: s.getPoints()){
            double x=p.getX();
            if(x>largestX){
                largestX=x;
            }
        }
        return largestX;
    }

    public double getLargestPerimeterMultipleFiles() {
        // Put code here
        DirectoryResource dr = new DirectoryResource();
        double largestPerim=0.0;
        FileResource largestFile=null;
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            Shape s = new Shape(fr);
            double perimeter=getPerimeter(s);
            if(perimeter>largestPerim)
            {
                largestPerim=perimeter;
            }
        }
        return largestPerim;
    }

    public String getFileWithLargestPerimeter() {
        // Put code here
        DirectoryResource dr = new DirectoryResource();
        double largestPerim=0.0;
        File largestFile=null;
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            Shape s = new Shape(fr);
            double perimeter=getPerimeter(s);
            if(perimeter>largestPerim);
            {
                largestPerim=perimeter;
                largestFile=f;
            }
        }
        return largestFile.getName();
    }

    public void testPerimeter () {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double length = getPerimeter(s);
        int numPoints=getNumPoints(s);
        double avgLength=getAverageLength(s);
        double largestSide=getLargestSide(s);
        double largestX=getLargestX(s);
        System.out.println("perimeter = " + length);
        System.out.println("Number of Points : " + numPoints);
        System.out.println("Average Length : " + avgLength);
        System.out.println("Largest Side : " + largestSide);
        System.out.println("Largest X value : " + largestX);
    }
    
    public void testPerimeterMultipleFiles() {
        double largestPerim=getLargestPerimeterMultipleFiles();
        System.out.println("Largest Perimeter : " + largestPerim);
        // Put code here
    }

    public void testFileWithLargestPerimeter() {
        String largestFile=getFileWithLargestPerimeter();
        System.out.println("File with largest Perimeter : " + largestFile);
        // Put code here
    }

    // This method creates a triangle that you can use to test your other methods
    public void triangle(){
        Shape triangle = new Shape();
        triangle.addPoint(new Point(0,0));
        triangle.addPoint(new Point(6,0));
        triangle.addPoint(new Point(3,6));
        for (Point p : triangle.getPoints()){
            System.out.println(p);
        }
        double peri = getPerimeter(triangle);
        System.out.println("perimeter = "+peri);
    }

    // This method prints names of all files in a chosen folder that you can use to test your other methods
    public void printFileNames() {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            System.out.println(f);
        }
    }

    public static void main (String[] args) {
        PerimeterAssignmentRunner pr = new PerimeterAssignmentRunner();
        pr.testPerimeter();
    }
}
