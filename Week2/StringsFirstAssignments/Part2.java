
/**
 * Part 2: Finding a Gene - Using the Simplified Algorithm Reorganized
 * 
 * @EPS
 * @2020-09-13
 */
public class Part2 {
    //findSimpleGene has one String parameter, DNA
    public String findSimpleGene(String dna, String startCodon, String stopCodon) {
        //Determine case
        boolean hasUppercase = dna.equals(dna.toUpperCase());
        dna = dna.toUpperCase();
        String result = "";
        //start codon ATG
        int startIndex = dna.indexOf(startCodon);
        if (startIndex == -1) //not found
        {
            return "";
        }
        //stop codon TAA; start looking past start codon
        int stopIndex = dna.indexOf(stopCodon,startIndex+3);
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
        if (!hasUppercase) //if lower case original string
        {
            result = result.toLowerCase();
        }
        return result;
    }
        public void testSimpleGene() {
        String dna = "ATGGCGTAATGGT";
        System.out.println("DNA Strand is:" + dna);
        String gene = findSimpleGene(dna, "ATG","TAA");
        System.out.println("Gene is : " + gene);
                
        String dna2 = "atggcgtaatggt";
        System.out.println("DNA Strand is:" + dna2);
        String gene2 = findSimpleGene(dna2, "ATG","TAA");
        System.out.println("Gene is : " + gene2);
        
        String dna3 = "ATGCTAATGGT";
        System.out.println("DNA Strand is:" + dna3);
        String gene3 = findSimpleGene(dna3, "ATG","TAA");
        System.out.println("Gene is : " + gene3);
        
        String dna4 = "ATGCTGGT";
        System.out.println("DNA Strand is:" + dna4);
        String gene4 = findSimpleGene(dna4, "ATG","TAA");
        System.out.println("Gene is : " + gene4);
    }
}
