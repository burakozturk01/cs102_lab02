import java.util.ArrayList;

/**
 * WordSearch class
 */
public class WordSearch extends HTMLFilteredReader
{
   // properties
   
   // constructors
   public WordSearch( String url)
   {
      super( url);
   }
   
   // methods
   public String wordSearch( ArrayList<String> words)
   {
      String html = getPageContents();
      String result = "";
      int index = 0;
      
      for (String x : words)
      {
         index = html.indexOf( x, index);
         result += x + " | Indexes: " + index;
         while (index != -1)
         {
            index = html.indexOf( x, index + 1);
            result += ", " + index;
         }
         result += "\n";
         index = 0;
      }
      
      return result;
   }
   
}