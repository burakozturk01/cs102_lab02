/**
 * Specialized reader to HTML based on MySimpleURLReader
 */
public class HTMLFilteredReader extends MySimpleURLReader
{
   // properties

   // constructors
   public HTMLFilteredReader( String url)
   {
      super( url);
   }
   
   // methods
   public String getPageContents()
   {
      String s, tmp;
      s = super.getPageContents();
      int start, end, count;
      
      count = 0;
      
      for (int i = 0; i < s.length(); i++)
      {
         if (s.charAt(i) == '<')
            count++;
      }
      
      for ( int i = 1; i <= count - 1; i++)
      {
         start = s.indexOf( "<");
         end = s.indexOf( ">");
         
         if ( end - start <= 0)
            return s;
         
         tmp = s.substring( start, end + 1);
         
         s = s.replace( tmp, "");
         s.trim();
      }
      
      return s;
   }
   
   public String getUnfilteredPageContents()
   {
      return super.getPageContents();
   }

}