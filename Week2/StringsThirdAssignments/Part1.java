
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


    public StorageResource getAllGenes(String dna) {
        //create an empty Storage Resource call it geneList
        StorageResource geneList = new StorageResource();
        int startIndex = 0;
        String currentGene = findGene(dna, startIndex);
        
        while (true) {
            String currGene = findGene(dna, startIndex);
            //if no gene
            if (currGene.isEmpty()) {
                break;
            }
            //Print that gene out 
            geneList.add(currentGene);
            startIndex = dna.indexOf(currentGene, startIndex + currentGene.length());
        }
        return geneList;
    
    }
    public void testOn(String dna) {
        System.out.println("...Testing all genes in: " + dna);
        StorageResource geneList = getAllGenes("ATGCAGCGGTCTTAGATGCAGCGGTCTTAG");
        for (String g: geneList.data()) {
            System.out.println(g);
        }
        System.out.println("...Done.");
    }

}

