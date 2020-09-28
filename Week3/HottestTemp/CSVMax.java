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
        for (Class currentRow : parser ) {
            //If largestSoFar is nothing
            if (largestSoFar == null) {
             //do something 
            }
            //Otherwise
            else {
            //Check if currentRow’s temperature > largestSoFar’s

            //If so update largestSoFar to currentRow
            largestSoFar = currentRow.getTemperature()
            }
        }
        //The largestSoFar is the answer
        return largestSoFar; 
    }

    public void testHottestInDay () {
        FileResource fr = new FileResource("data/2015/weather-2015-01-02.csv");
        CSVRecord largest = hottestHourInFile(fr.getCSVParser());
        System.out.println("hottest temperature was " + largest.get("TemperatureF") +
        " at " + largest.get("TimeEST"));
    }
}
