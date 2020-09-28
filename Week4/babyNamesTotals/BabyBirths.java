/**
 * totalBirths : Print out total number of babies born, as well as for each gender, in a given CSV file of baby name data.
 * Modify the method totalBirths to also print the number of girls names , 
 * the number of boys names and the total names in the file.
 * 
 * getRank : get the rank of the name in the file for a given gender
 * 
 * getName : get the name in a file for the name in this rank for a given gender 
 * 
 */
import edu.duke.*;
import org.apache.commons.csv.*;
import java.util.*; 

public class BabyBirths {
	public void printNames () {
		FileResource fr = new FileResource();
		for (CSVRecord rec : fr.getCSVParser(false)) {
			int numBorn = Integer.parseInt(rec.get(2));
			if (numBorn <= 100) {
				System.out.println("Name " + rec.get(0) +
						   " Gender " + rec.get(1) +
						   " Num Born " + rec.get(2));
			}
		}
	}

	public void totalBirths (FileResource fr) {
		int totalBirths = 0;
		int totalBoys = 0;
		int totalGirls = 0;
		Set girlNames = null;
		Set boyNames = null; 
		
		for (CSVRecord rec : fr.getCSVParser(false)) {
		        //get gender
			int numBorn = Integer.parseInt(rec.get(2));
			//add to total births
			totalBirths += numBorn;
			//get the current name 
			String currName = rec.get(0);
			//add to gender specific totals
			if (rec.get(1).equals("M")) {
				totalBoys += numBorn;
				
				if ((boyNames.contains(currName))==false) {
				    boyNames.add(currName);
				}
			}
			else {
				totalGirls += numBorn;
				if ((girlNames.contains(currName))==false) {
				    girlNames.add(currName);
				}
			}
			
		}
		System.out.println("total births = " + totalBirths);
		System.out.println("female girls = " + totalGirls);
		System.out.println("male boys = " + totalBoys);
		System.out.println("male names = " + boyNames.size());
		System.out.println("female names = " + girlNames.size());
		
	}

	public void testTotalBirths () {
		//FileResource fr = new FileResource();
		FileResource fr = new FileResource("data/yob2014.csv");
		totalBirths(fr);
	}
}
