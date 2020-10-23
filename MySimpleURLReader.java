import cs1.SimpleURLReader;

/**
 * MySimpleURLReader class
 * Child class of cs1.SimpleURLReader class
 */
public class MySimpleURLReader extends SimpleURLReader
{
   // properties
   String urlH;

   // constructors
   public MySimpleURLReader( String theurl)
   {
      super( theurl);
      urlH = theurl;
   }
   
   // methods
   public String getURL()
   {
      return urlH;
   }
   
   public String getName()
   {
      String name = "";
      int count = 0;
      
      StringBuffer urlB = new StringBuffer( urlH);
      
      for ( int i = 0; i < urlB.length(); i++)
      {
         if ( urlB.charAt(i) == '/')
            count = 0;
         else
            count++;
      }
      
      name = urlB.substring( urlB.length() - count, urlB.length());
      
      return name;
   }
   
   public int getNumberOfCSSLinks()
   {
      String html = getPageContents();
      CharSequence subURL;
      String r = "replaced";
      
      int ind1, ind2;
      int count = 0;
      
      boolean done = false;
      
      while ( !done)
      {
         ind1 = html.indexOf("<");
         ind2 = html.indexOf(">");
         
         if (ind1 == -1)
            done = true;
         else
         {
            subURL = html.subSequence(ind1, ind2 + 1);
            
            if (subURL.toString().contains(".css"))
            {
               html = html.replace(subURL, r);
               count++;
            }
            else
               html = html.replace(subURL, r);
         }
      }
      return count;
   }
}