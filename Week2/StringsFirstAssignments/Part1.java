
/**
 * Part 1: Finding a Gene - Using the Simplified Algorithm
 * 
 * @author (EPS)
 * @version (2020-09-13)
 */
public class Part1 {
    //findSimpleGene has one String parameter, DNA
    public String findSimpleGene(String dna) {
        String result = "";
        //start codon ATG
        int startIndex = dna.indexOf("ATG");
        if (startIndex == -1) //not found
        {
            return "";
        }
        //stop codon TAA; start looking past start codon
        int stopIndex = dna.indexOf("TAA",startIndex+3);
        if (stopIndex == -1) //not found
        {
            return "";
        }
        //get the open reading frame
        result = dna.substring(startIndex,stopIndex+3);
        if (result.length() % 3 != 0 ) 
        {
            return "";
        }
        return result;
    }
        public void testSimpleGene() {
        String dna = "ATGGCGTAATGGT";
        System.out.println("DNA Strand is:" + dna);
        String gene = findSimpleGene(dna);
        System.out.println("Gene is : " + gene);
                
        String dna2 = "GTAATGGT";
        System.out.println("DNA Strand is:" + dna2);
        String gene2 = findSimpleGene(dna2);
        System.out.println("Gene is : " + gene2);
        
        String dna3 = "ATGCTAATGGT";
        System.out.println("DNA Strand is:" + dna3);
        String gene3 = findSimpleGene(dna3);
        System.out.println("Gene is : " + gene3);
        
        String dna4 = "ATGCTGGT";
        System.out.println("DNA Strand is:" + dna4);
        String gene4 = findSimpleGene(dna4);
        System.out.println("Gene is : " + gene4);
    }
}
