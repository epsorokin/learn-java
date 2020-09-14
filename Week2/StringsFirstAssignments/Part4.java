
/**
 * Part 4: Finding Web Links
 * 
 * @EPS
 * @2020-09-13
 */
public class Part4 {
    //a program that reads the lines from a file at this URL
    //http://www.dukelearntoprogram.com/course2/data/manylinks.html
    //use URLResource to read the file word by word
    //For each word, check if youtube.com is in it, 
    public String lastPart(String a, String b) {
        //find the first occurrence of string a in string b
        //return the part of string b that follows string a
        int firstOccurrence = b.indexOf(a);
        if (firstOccurrence == -1)
        { 
            return b;
        }
        else {
            return b.substring(firstOccurrence+a.length());
        }
    }
    public void testing() {
        String a1 = "a";
        String b1 = "banana";
        System.out.println("String a: " + a1);
        System.out.println("String b: " + b1);
        boolean result = twoOccurrences(a1,b1);
        System.out.println("Fnx twoOccurrences Returned: " + result);
        
        String a2 = "a";
        String b2 = "aster";
        System.out.println("String a: " + a2);
        System.out.println("String b: " + b2);
        boolean result2 = twoOccurrences(a2,b2);
        System.out.println("Fxn twoOccurrences Returned: " + result2);

        String a3 = "an";
        String b3 = "banana";
        System.out.println("String a: " + a3);
        System.out.println("String b: " + b3);
        String result3 = lastPart(a3,b3);
        System.out.println("The part of the string after " + a3 + " in " + b3 + " is " + result3);
        
        String a4 = "zoo";
        String b4 = "forest";
        String result4 = lastPart(a4,b4);
        System.out.println("The part of the string after " + a4 + " in " + b4 + " is " + result4);
    }
}
