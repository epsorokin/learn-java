
/**
 * Week 2: Find a gene with any of three stop codons
 * @author EPS
 * @version 2020-09-13
 */

import edu.duke.StorageResource;

public class Part1 {
    public int findStopCodon (String dna, int startIndex, String stopCodon) {
        //Find "TAA" or other stop codn starting from (startIndex + 3), call this result currIndex
        //startIndex = dna.indexOf("ATG");
        int currIndex = dna.indexOf(stopCodon, startIndex + 3);
        while (currIndex != -1) {
            //If (currIndex - startIndex) is mulitple of 3
            int diff = currIndex - startIndex;
            if ((diff % 3) == 0) {
                //If so: Answer 
                return currIndex;
            } 
            else {
                //If not: Update currIndex
                currIndex = dna.indexOf(stopCodon, currIndex + 1); 
            }
             
        }
        // If there is no such stopCodon, this method returns the length of the dna strand.
        return dna.length(); 
    }
    //method to test findStopCodon()
    public void testFindStopCodon() {
        String dna1 = "ATGTGGCGCCAATAATCT";
        System.out.println("DNA Strand is ;" + dna1);
        int startIndex = 0;
        String stopCodon = "TAA";
        String stopIndex = findStopCodon(dna1, startIndex, stopCodon);
        //System.out.println("Stop index is : ", (char) stopIndex); 
    }
    
    public String findGene(String dna) {
        //Find first occurrence of "ATG" and call its index startIndex
        int startIndex = dna.indexOf("ATG");
        if (startIndex == -1) {
            return "";
        }
        
        //Find the "TAA", "TAG","TGA" starting from (startIndex+3), call this result currIndex
        int taaIndex = findStopCodon(dna, startIndex, "TAA");
        int tagIndex = findStopCodon(dna, startIndex, "TAG");
        int tgaIndex = findStopCodon(dna, startIndex, "TGA");
        
        //Initialize minIndex
        int minIndex = 0; 
        //Logic to update minIndex 
        if (taaIndex == -1  || 
            (tgaIndex != -1 && tgaIndex < taaIndex)){
                minIndex = tgaIndex;
            }
        else {
                minIndex = taaIndex;
            }
        if (minIndex == -1 ||
            (tagIndex != -1 && tagIndex < minIndex)){
                minIndex = tagIndex;
            }
        
        if (minIndex == -1 ) {
            return ""; 
            }
                
        if (minIndex == dna.length()) {
            return "";
        }
        return dna.substring(startIndex, minIndex + 3);
    }

   
        public void testOn(String dna ) {
        //ATG TAA ATG TGA 
        testOn("ATGATCTAATTTATGCTGCAACGGTGAAGA");
        testOn("");
        // ATG.... ATGTAA 
        testOn("ATGATCATAAGAAGAATAATAAGAGGGGCCCCATGTAA");
    }
}
