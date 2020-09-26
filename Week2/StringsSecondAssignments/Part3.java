
/**
 * Part 3: How Many Genes?
 * 
 * @author (EPS) 
 * @version (2020 09 25)
 */
public class Part3 {
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
    public int countGenes (String dna) {
        
        //Return the number of genes found in the dna 
        int startIndex = 0;
        int geneCount = 0;
        
        while (true) {
            
            String currGene = findGene(dna, startIndex);
            if (currGene.isEmpty()) {
                break;
            }
            
            geneCount = geneCount + 1;
            startIndex = dna.indexOf(currGene,startIndex) + currGene.length();
        }
        
        return geneCount;
    
    }
    public void testCountGenes() {
        //Initial example for testing
        System.out.println("");
        System.out.println("Test testCountGenes...");
        String dna1 = "AATGCGCTAGCTAGCTATGCGACTAATCATGTAGAAA";
        System.out.println("DNA Strand is: " + dna1);
        int geneCount1 = countGenes(dna1);
        System.out.println("Gene count is : " + geneCount1);
        
    }
}
