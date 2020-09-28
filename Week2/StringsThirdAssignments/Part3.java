
/**
 * Write the void method processGenes that has one parameter sr,
 * which is a StorageResource of strings. This method processes
 * all the strings in sr to find out information about them
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.StorageResource;
import edu.duke.FileResource;

public class Part3 {
    public float cgRatio (String dna) {
        
        //returns the ratio of C’s and G’s in dna as a 
        //fraction of the entire strand of DNA
        
        //find C
        int currentIndex = 0;
        int c_count = 0;
        
        while (true) {
            currentIndex = dna.indexOf("C", currentIndex);
            if (currentIndex == -1) {
                break;
            }
            c_count = c_count + 1;
            currentIndex = dna.indexOf("C", currentIndex + 1);
        }
        //find G
        int currentIndexG = 0;
        int g_count = 0;
        
        while (true) {
            currentIndexG = dna.indexOf("G", currentIndexG);
            if (currentIndex == -1) {
                break;
            }
            g_count = g_count + 1;
            currentIndexG = dna.indexOf("G", currentIndexG + 1);
            
        }
        int cg_count = c_count + g_count;
        return (float) cg_count / dna.length();
    }
    
    public int countCTG (String dna ) {
        // returns the number of times the codon CTG appears in string
        int count = 0;
        int index = 0;
        while (true) {
            index = dna.indexOf("CTG", index);
            if (index == -1) {
                break;
            }
            count = count + 1;
            index = dna.indexOf("CTG", index + 3);
        }   
        return index;
    }
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
    public void processGenes(StorageResource sr) {
        int cg_count = 0;
        int longestLength = -1; 
        for (String gene : sr.data()){
            //If longer than 9 char
            if (gene.length() > 60) {
                System.out.println(gene);
                int currLength = gene.length() - 60; 
                System.out.println("Number of chars beyond 60: " + currLength);
                
            }
            float cg_ratio = cgRatio (gene);
            
            if (cg_ratio > 0.35) {
                System.out.println(gene);
                cg_count = cg_count + 1;
            }
            if (gene.length() > longestLength) {
                longestLength = gene.length(); 
       
            }
        }
        
        
        System.out.println("The number of strings whose C-G ratio >0.35 is: "+ cg_count);
        System.out.println("The longest gene is: " + longestLength); 
    }
    public void testProcessGenes() {
        String dna =  "ATGCGCATTTAAACTCAGATGCCCGGGTAGATGCGCATTATGCGCATTATGCGCATTTAA";
        System.out.println("...Testing all genes in: " + dna);
        StorageResource geneList = getAllGenes(dna);
        for (String g: geneList.data()) {
            System.out.println(g);
        }
        System.out.println("...Done.");
        
        FileResource fr = new FileResource("brca1line.fa");
        String dna2 = fr.asString();
        System.out.println("...Testing all genes in: " + dna2);
        StorageResource geneList = getAllGenes(dna2);
        for (String g: geneList.data2()) {
            System.out.println(g);
        }
        System.out.println("...Done.");

    }
        
}
