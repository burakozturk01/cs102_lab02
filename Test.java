import java.util.Scanner;
import java.util.ArrayList;

import cs1.SimpleURLReader;

/**
 * Test program for URLScanner
 * @author Burak Ozturk
 * @version 15.10.2020
 */ 
public class Test
{
   public static void main( String[] args)
   {
      Scanner scan = new Scanner( System.in);

      // constants

      // variables
      String url;
      SimpleURLReader read;
      MySimpleURLReader read2;
      HTMLFilteredReader read3;
      WordSearch read4;
      ArrayList<String> words = new ArrayList<>();

      // program code
      System.out.println( "Start...");
      
      //1. Taking URL
      System.out.println( "Enter the URL.");
      url = scan.nextLine();
      
      //2. Scan URL
      read = new SimpleURLReader( url);
      read2 = new MySimpleURLReader( url);
      read3 = new HTMLFilteredReader( url);
      read4 = new WordSearch( url);
      
      //3. Print lines
      System.out.println( "There are " + read.getLineCount() + " line(s) on that webpage.");
      
      //4. Print URL and page name
      System.out.println( "URL: " + read2.getURL() );
      System.out.println( "Page Name: " + read2.getName() );
      
      //5. Count .css
      System.out.println( "Number of .css things: " + read2.getNumberOfCSSLinks());
      
      //6. Filtered HTML
      //System.out.println( "Filtered HTML page: " + read3.getPageContents());
      
      //7. Word Search
      words.add("Turkey");
      words.add("Sudan");
      words.add("Capital");
      System.out.println( "Search result: " + read4.wordSearch(words));

      System.out.println( "End.");
   }

}