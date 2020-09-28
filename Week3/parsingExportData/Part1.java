package parsingExportData;


/**
 * Programming Exercise: Parsing Export Data. Finding lowest temp in many days
 * @author (EPS) 
 * @version (2020-09-27)
 */

import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;

public class Part1 {
    public CSVRecord coldestHourInFile(CSVParser parser) {
        //Return the CSV record with coldest temperature in the file 
        
        CSVRecord lowestSoFar = null;
        
        //Still have to iterate over the file 
        for (CSVRecord currentRow : parser) {
            lowestSoFar = getLowestOfTwo(currentRow, lowestSoFar, "Temperature.F");
        }
        return lowestSoFar;     
    }

    public CSVRecord getLowestOfTwo(CSVParser currentRow, CSVParser lowestSoFar, String variable) {
        //Initialize lowest so far as a CSV record
        CSVRecord lowestSoFar = null;
        //For each row (currentRow) in the CSV file
        for (CSVRecord currentRow : parser) {
            
            //If lowest so far is nothing
            if (lowestSoFar == null) {
                
                //if it is, assume current temp is lowest so far
                lowestSoFar = currentRow;
            }
            // Otherwise if not null
            else {
                //check if currentRow has lower temp than lowest #Temperature.F
                double currentTemp = Double.parseDouble(currentRow.get(variable));
                double lowestTemp = Double.parseDouble(lowestSoFar.get(variable));
                //if so update
                if (currentTemp < lowestTemp) {
                    lowestTemp = currentTemp; 
                }
            }
        }
    }
    public CSVRecord fileWithColdestTemperature() {
        //Return a string that is name of file from selected files that has lowest temp
        CSVRecord lowestSoFar = null;
        DirectoryResource dr = new DirectoryResource();
        
        //iterate over files in dir
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
        
            //use method to gest lowest in that file
            CSVRecord currentRow = coldestHourInFile(fr.getCSVParser());
            //compare the two records
            lowestSoFar = getLowestOfTwo(currentRow, lowestSoFar,"Temperature.F");
        }
        return lowestSoFar;
    }
    public CSVRecord lowestHumidityInFile(CSVParser parser) {
        //Return CSV Record with lowest Humidity
        CSVRecord lowest = null; 
        for (CSVRecord currentRow : parser) {
            lowest = getLowestOfTwo(currentRow, lowestSoFar, "Humidity");
        }
        return lowest; 
    }
    public void testColdestHourInFile(){
        System.out.println("Testing coldestHourInFile...");
        FileResource fr = new FileResource();
        CSVRecord lowest = coldestHourInFile(fr.getCSVParser());
        System.out.println("Lowest temperature was " + lowest.get("TemperatureF") +
                   " at " + lowest.get("TimeEST"));
    }
    public void testFileWithColdestTemperature() {
        System.out.println("Testing coldestHourInFile...");
        CSVRecord lowest = fileWithColdestTemperature();
    }
    public void testLowestHumidityInFile() {
        System.out.println("Testing lowestHumidityInFile...");
        CSVRecord lowest = lowestHumidityInFile();
    }
}


