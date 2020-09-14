
/**
 * Part 4: Finding Web Links
 * 
 * @author (EPS)
 * @version (2020-09-13)
 */

import edu.duke.*;

public class Part4 {
    //a program that reads the lines from a file at this URL
    //http://www.dukelearntoprogram.com/course2/data/manylinks.html
    //use URLResource to read the file word by word
    //For each word, check if youtube.com is in it, 
    public void printUrls(String url) {
        URLResource myurl = new URLResource(url);
        for (String s: myurl.lines()) {
            System.out.println(s);
            //if there is a string match
            if (s.toLowerCase().indexOf("youtube.com") != -1) 
            {
                int firstQuoteIndex = s.indexOf("\"");
                int lastQuoteIndex = s.indexOf("\"",firstQuoteIndex+1);
                System.out.println(s.substring(firstQuoteIndex,lastQuoteIndex));
            }
            else {
                System.out.println("Phrase not found in URL.");
            }
        }
    }
    
    public void testing() {
        printUrls("http://www.dukelearntoprogram.com/course2/data/manylinks.html");
    }
    
    public static void main() {
        Part4 url = new Part4();
        url.testing();
    }
}
