
/**
 * Write a description of Part2 here.
 * 
 * @author (EPS) 
 * @version (2020-09-26)
 */
public class Part2 {
    //HowMany method takes two string paramters
    public int howMany(String a, String b) {
        //Return integer indicating how many times stirng a appears in stringb where each occurrence must not overlap
        int currIndex = 0;
        int count = 0;
        //if stringa is longer than stringb
        if (a.length() > b.length()){
            return count;
        }
        //while the current index is less than 
        while (currIndex < b.length() - 1) {
            int currSubstringIndex = b.indexOf(a, currIndex);
            if (currSubstringIndex == -1) {
                break;
            }
            else {
                String currSubstring = b.substring(currSubstringIndex, currSubstringIndex + a.length());
                System.out.println(currSubstring);
                count = count + 1;
                currIndex = currSubstringIndex + a.length();
            }
        
        }
        return count;
    }
    public void testHowMany() {
        System.out.println("testHowMany...");
        //Example with many results
        String b1 = "bananananana";
        String a1 = "a";
        int result1 = howMany(a1, b1); 
        System.out.println("Result 1: " + result1);
        //Example with no results
        String b2 = "bananananana";
        String a2 = "f";
        int result2 = howMany(a2, b2); 
        System.out.println("Result 2: " + result2);
        System.out.println("");
    }
}
