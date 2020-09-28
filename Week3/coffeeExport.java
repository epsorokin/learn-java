
/**
 * Write a description of coffeeExport here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import edu.duke.*;
import org.apache.commons.csv.*;

public class coffeeExport {
    public String countryInfo (CSVParser parser, String country) {
        //Return string of info about country or 
        //return NOT FOUND if no info about country
        
        String export = parser.get("Exports");
        String value = parser.get("Value");
        String result = country + ":" + export + ":" + value;
        return result;
    }

    public void listExportersTwoProducts (CSVParser parser, String exportOfInterest1, 
    String exportOfInterest2) {
        
        for (CSVRecord record : parser) {
            //Look for exports column
            String export = record.get("Exports");
            
            //check if contains exportOfInterest
            if (export.contains(exportOfInterest1) && export.contains(exportOfInterest2)) {
                
                //If so write down the country from that row
                String country = record.get("Country");
                System.out.println("Contains " + exportOfInterest1 + " and " + exportOfInterest2 +
                ": " + country); 
            }
        }

    }
    public int numberOfExporters (CSVParser parser, String exportOfInterest){
        int numExporters = 0;
        //Return num of countries that export that item
        for (CSVRecord line : parser) {
            String export = line.get("Exports");
            if (export.contains(exportOfInterest)) {
                numExporters = numExporters + 1; 
            }
        
        }
    return numExporters;
    }
    public void bigExporters (CSVParser parser, String amount) {
        //names of countries and their Value amount for all countries 
        //whose Value (dollars) string is longer than the amount string
        for (CSVRecord line : parser) {
            String value = line.get("Value");
            String country = line.get("Country");
            
            System.out.println(country + "  " + value);
        }
    }
    //not returning anything so must be void    
    public void whoExportsCoffee() {
        //Which countrie export coffee from data resource? 
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        listExportersTwoProducts(parser, "coffee");
    }
    
    public void testNumExporters() {
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        numberOfExportersTwoProducts(parser, "coffee", "vanilla");
    }
}
