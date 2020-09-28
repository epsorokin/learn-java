package HottestTemp;

/**
 * Find the highest temperature in a CSV file of weather data.
 * 
 * @author EPS 
 */
import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;

public class CSVMax {
    public CSVRecord hottestHourInFile(CSVParser parser) {
        //initialize largestSoFar to be null  
        CSVRecord largestSoFar = null; 
        //For each row (currentRow) in the CSV File
        for (CSVRecord currentRow : parser ) {
            //If largestSoFar is nothing
            if (largestSoFar == null) {
                //if it is, assume current temp is the hottest one
                largestSoFar = currentRow; 
            }
            //Otherwise
            else {
                //Check if currentRow’s temperature > largestSoFar’s
                double currentTemp = Double.parseDouble(currentRow.get("TemperatureF"));
                double largestTemp = Double.parseDouble(
                largestSoFar.get("TemperatureF"));
                //If so update largestSoFar to currentRow
                if (currentTemp > largestTemp) {
                    largestSoFar = currentRow;
                }
            }
        }
        //The largestSoFar is the answer
        return largestSoFar; 
    }

    public void testHottestInDay () {
        FileResource fr = new FileResource("/Users/elenasorokin/src/learn-java/Week3/HottestTemp/data/2015/weather-2015-01-02.csv");
        CSVRecord largest = hottestHourInFile(fr.getCSVParser());
        System.out.println("hottest temperature was " + largest.get("TemperatureF") +
        " at " + largest.get("TimeEST"));
    }
}
