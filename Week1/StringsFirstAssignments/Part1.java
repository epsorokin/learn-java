
/**
 * Write a description of Part1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part1 {
    public String findSimpleGene(String dna) {
        
        String result = "";
        
        //start codon is ATG
        int startIndex = dna.indexOf("ATG");
        if (startIndex == -1) //no ATG
        {
            return "";
        }
        int stopIndex = dna.indexOf("TAA", startIndex+3);
        result = dna.substring(startIndex, stopIndex+3);
        
        return result;
    }
    public void testSimpleGene() {
        String dna = "ATGCAGTCATAA";
        System.out.println("DNA strand is: " + dna);
        String gene = findSimpleGene(dna); 
        System.out.println("Gene is: " + gene); 
    }
}

