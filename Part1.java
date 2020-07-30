
/**
 * Write a description of Part1 here.
 * countryInfo-> This function returns the all the information about the input country.
 * listExportersTwoProducts-> This function prns those country which are having both the input products.
 * numberOfExporters-> This function return the number of exporters of given product from file.
 * bigExporters-> This function print the big exporters countries and their value(dollar).
 * @author (Yashi Saxena) 
 * @version (3/07/2020)
 */

import edu.duke.*;
import org.apache.commons.csv.*;
public class Part1 {
 
 public String countryInfo(CSVParser parser, String country)
 {
    for(CSVRecord record : parser)
    { 
        String Con = record.get("Country");
        if(Con.contains(country))
        { 
           String export= record.get("Exports");
           String value= record.get("Value (dollars)");
           return Con +" : " +export +" : " +value;
        }
    }
    return "NOT FOUND";
    }
 public void listExportersTwoProducts(CSVParser parser, String exportItem1,String exportItem2)
 {
     for(CSVRecord record:parser)
     {
        String one= record.get("Exports");
        if(one.contains(exportItem1)&&one.contains(exportItem2))
        {
           System.out.println(record.get("Country"));
        }
    }
    }
    public int numberOfExporters(CSVParser parser, String exportItem1)
  {
       int count =0;
     for(CSVRecord record: parser)
     {
       
        String one= record.get("Exports");
        if(one.contains(exportItem1))
        {
            count++;
        }
     }
     return count;
    }
   public void bigExporters(CSVParser parser,String dollar)
   {
      
       for(CSVRecord record: parser)
       {
         String value = record.get("Value (dollars)");
         if(value.length()>dollar.length())
          {
              System.out.println(record.get("Country") +"  " +record.get("Value (dollars)"));  
           }
       }
   }
 public void tester()
 {
     FileResource fr = new FileResource();
     
     CSVParser parser = fr.getCSVParser();
    // String coninfo = countryInfo(parser, "Nauru");
    // System.out.println(coninfo);
     
    // parser = fr.getCSVParser();
    listExportersTwoProducts(parser,"fish","nuts");
     
     //parser = fr.getCSVParser(); 
    //int numexp= numberOfExporters(parser,"gold");
    //System.out.println("The no. of country exports " +numexp);
     
     //parser = fr.getCSVParser(); 
    //bigExporters(parser,"$999,999,999,999");
    }
}
