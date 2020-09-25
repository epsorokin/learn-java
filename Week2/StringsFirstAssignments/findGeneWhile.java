
/**
 * Week 2: Indefinite loops and storing intermediate results
 * ...And short-circuited boolean evaluation
 * @author EPS
 * @version 2020-09-13
 */

import edu.duke.StorageResource;

public class findGeneWhile {
    public String findGene(String dna, int where) {
        //Find first occurrence of "ATG" and call its index startIndex
        int startIndex = dna.indexOf("ATG", where);
        if (startIndex == -1) {
            return "";
        }
        
        //Find the "TAA", "TAG","TGA" starting from (startIndex+3), call this result currIndex
        
        int taaIndex = findStopCodon(dna, startIndex, "TAA");
        int tagIndex = findStopCodon(dna, startIndex, "TAG");
        int tgaIndex = findStopCodon(dna, startIndex, "TGA");
        
        //Use the Math.min function to find the shortest string
        //Pick the smallest one that isn't -1
        
        //int temp = Math.min(taaIndex, tagIndex);
        //int minIndex = Math.min(temp, tgaIndex);
        
        //int minIndex = Math.min(taaIndex, Math.min(tagIndex, tgaIndex));
        //initialize minIndex 
        int minIndex = 0; 
        if (taaIndex == -1  || 
            (tgaIndex != -1 && tgaIndex < taaIndex)){
                minIndex = tgaIndex;
            }
        else {
                minIndex = taaIndex;
            }
        if (minIndex == -1 ||
            (tagIndex != -1 && tagIndex < minIndex)){
                minIndex = tagIndex;//FIXME
            }
            else {
                minIndex = minIndex; //FIXME
            }
                
        if (minIndex == dna.length()) {
            return "";
        }
        return dna.substring(startIndex, minIndex + 3);
    }
    //method to print all genes 
    public void printAllGenes(String dna) {
        //Set startIndex to 0 
        int startIndex = 0; 
        //Repeat the following steps
        while (true) {
            //Find the next gene after StartIndex
            //Refer to the currGene as explicit obj
            String currentGene = findGene(dna, startIndex);
            //If no gene found: leave loop
            //if (currentGene.length() == 0 ) 
            if (currentGene.isEmpty()) {
                break;
            }
            
            //Print that gene out 
            System.out.println(currentGene);
            //Set startIndex to just past the end of the gene
            startIndex = dna.indexOf(currentGene, startIndex) + currentGene.length();
        }
    }
    public void testOn(String dna ) {
        //ATG TAA ATG TGA 
        testOn("ATGATCTAATTTATGCTGCAACGGTGAAGA");
        testOn("");
        // ATG.... ATGTAA 
        testOn("ATGATCATAAGAAGAATAATAAGAGGGGCCCCATGTAA");
    }
    public String findStopCodon (String dna, int startIndex, String stopCodon) {
        //Find "TAA" or other stop codn starting from (startIndex + 3), call this result currIndex
        int currIndex = dna.indexOf(stopCodon, startIndex + 3);
        while (currIndex != -1) {
            //If (currIndex - startIndex) is mulitple of 3
            int diff = currIndex - startIndex;
            if ((diff % 3) == 0) {
                //If so: Answer 
                return dna.indexOf(currIndex);
            } 
            else {
                //If not: Update currIndex
                currIndex = dna.indexOf(stopCodon, currIndex + 1); 
            }
             
        }
        return -1; 
    }
    public void testFindGeneWhile() {
        String dna = "ATGGCGTAATGGT";
        System.out.println("DNA Strand is:" + dna);
        String gene = findGene(dna);
        System.out.println("Gene is : " + gene);
                
        String dna2 = "GTAATGGT";
        System.out.println("DNA Strand is:" + dna2);
        String gene2 = findGene(dna2);
        System.out.println("Gene is : " + gene2);
        
        String dna3 = "ATGCTAATGGT";
        System.out.println("DNA Strand is:" + dna3);
        String gene3 = findGene(dna3);
        System.out.println("Gene is : " + gene3);
        
        String dna4 = "ATGCTGGT";
        System.out.println("DNA Strand is:" + dna4);
        String gene4 = findGene(dna4);
        System.out.println("Gene is : " + gene4);
    }
}
