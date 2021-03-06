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
        // return integer that is number of points in s
        int numPoints = 0;
        for (Point p: s.getPoints()) {
            numPoints += 1; 
        }
        return numPoints; 
    }

    public double getAverageLength(Shape s) {
        // Return a number of type double that is the average of all lengths
        double totalPerim = getPerimeter(s);
        double numSides = (double) getNumPoints(s);
        double averageLength = totalPerim / numSides;
        return averageLength;
    }

    public double getLargestSide(Shape s) {
        double largestDist = 0.0;
        Point prevPt = s.getLastPoint(); 
        for (Point currPt: s.getPoints()) {
            double currDist = prevPt.distance(currPt);
            if (currDist > largestDist) {
                largestDist = currDist;
                
            }
            prevPt = currPt;
        }
        return largestDist;
    }


    public double getLargestX(Shape s) {
        int largestX = 0;        
        for (Point p: s.getPoints()) {
            int currX = p.getX();
            if (currX > largestX ) {
                largestX = currX; 
            }
        }    
        return largestX;
}

    public double getLargestPerimeterMultipleFiles() {
        // Create a DirectoryResource then iterate over these files 
        DirectoryResource dr = new DirectoryResource();
        double largestPerim = 0.0;
        for (File f :  dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            Shape s = new Shape(fr);
            double currPerim = getPerimeter(s);
            if (currPerim > largestPerim) {
                currPerim = largestPerim;
            }        
    }
    return largestPerim;
}


    public String getFileWithLargestPerimeter() {
        DirectoryResource dr = new DirectoryResource();
        double largestPerim = 0.0; 
        File temp = null;    
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            Shape s = new Shape(fr);
            double currPerim = getPerimeter(s);
            if (currPerim > largestPerim) {
                temp = f;
            }
        }           
        return temp.getName();
    }

    public void testPerimeter () {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double length = getPerimeter(s);
        int numPoints = getNumPoints(s);
        double averageLength = getAverageLength(s);
        double largestSide = getLargestSide(s);
        double largestX = getLargestX(s);
        System.out.println("perimeter = " + length);
        System.out.println("Number of points = " + numPoints);
        System.out.println("Average length = " + averageLength);
        System.out.println("Largest side = " + largestSide);
        System.out.println("Largest X = " + largestX);
    }
    
    public void testPerimeterMultipleFiles() {
        double largestPerim = getLargestPerimeterMultipleFiles();
        System.out.println("Largest perim multiple files = " + largestPerim);
    }

    public void testFileWithLargestPerimeter() {
        String file = getFileWithLargestPerimeter();
        System.out.println("File with largest perimeter = " + file);
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
