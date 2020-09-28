
/**
 * Write a description of Part2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class Part2 {
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
}
