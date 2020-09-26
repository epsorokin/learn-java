
/**
 * Week 2: Find a gene with any of three stop codons
 * @author EPS
 * @version 2020-09-25
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
                //If not: Update currIndex to be next index of a stop codon 
                currIndex = dna.indexOf(stopCodon, currIndex + 1); 
            }
             
        }
        // If there is no such stopCodon, this method returns the length of the dna strand.
        //return dna.length(); 
        return -1; 
    }

    public String findGene (String dna, int where) {
        //Find the index of the first occurrence of the start codon "ATG" or return empty string
        int startIndex = dna.indexOf("ATG", where);
        if (startIndex == -1) {
            return "";
        }
        int tagIndex = findStopCodon(dna, startIndex + 3, "TAG");
        if (tagIndex == -1) {
            return "";
        } 
        return dna.substring(startIndex, tagIndex + 3); 
        
    }
    public void printAllGenes(String dna) {
        //Find genes until there are no more 
        //Initialize start index
        int startIndex = 0;
        while (true) {
            String currGene = findGene(dna, startIndex);
            //if no gene
            if (currGene.isEmpty()) {
                break;
            }
            //Print that gene out 
            System.out.println(currGene);
            //Set startIndex to just past the end of the gene
            startIndex = dna.indexOf(currGene, startIndex) + currGene.length();
        }
    }
    public void testFindStopCodon() {
        //4. Call the method with several examples 
        System.out.println("");
        System.out.println("testFindStopCodon...");
        //Example with TAA stop codon
        String dna1 = "ATGCCACGCTAA";
        System.out.println("The DNA Strand is:   " + dna1);
        int stopIndex1 = findStopCodon(dna1, 0, "TAA"); 
        System.out.println("The stop index is :   " + stopIndex1);
        //Example with no stop codon
        String dna2 = "ATGGCTCTTAGGATGG";
        System.out.println("The DNA Strand is:   " + dna2);
        
        int stopIndex2 = findStopCodon(dna2, 0, "TAG");
        System.out.println("The stop index is :   " + stopIndex2);
    }
    public void testFindGene() {
        //no ATG
        System.out.println("");
        System.out.println("Test findGene...");
        String dna1 = "CGCTAACTAGCT";
        String gene1 = findGene(dna1,0);
        System.out.println("The DNA Strand is: " + dna1);
        System.out.println("The gene is: " + gene1);
        //ATG and one valid stop codon
        String dna2 = "ATGCAGCGGTCTTAG";
        String gene2 = findGene(dna2,0);
        System.out.println("The DNA Strand is: " + dna2);
        System.out.println("The gene is: " + gene2);
        //ATG and multiple valid stop codons
        String dna3 = "TAGATGCGTGACTAGCGTTAG";
        String gene3 = findGene(dna3,0);
        System.out.println("The DNA Strand is: " + dna3);
        System.out.println("The gene is: " + gene3);
        //ATG with no valid stop codons
        String dna4 = "GGATGCGATTCGATATTA";
        System.out.println("The DNA Strand is: " + dna4);
        String gene4 = findGene(dna4,0);
        System.out.println("The gene is: " + gene4);
        
    }
    public void testOn() {
        System.out.println("");
        System.out.println("Test testFindAllGenes...");
        String dna1 = "AATGCGCTAGCTAGCTATGCGACTAATCATGTAGAAA";
        findAllGenes(dna1);
        
    }
}
