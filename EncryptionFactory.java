import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;

// This is the class that does the encryption work. It either modifies passed in files, or creates new file.

public class EncryptionFactory
{
   private Code code;
   
   public EncryptionFactory(Code code){ this.code =code; }
   
   public File convertToNumbers(File rawFile, Code code) throws Exception
   {
      Scanner rawScanner = new Scanner(rawFile);
      File toNumbers = new File("toNumbers.txt");  
      try 
      {
         FileWriter toNumbersWriter = new FileWriter("toNumbers.txt");
         if (toNumbers.exists())
         {
            toNumbers.delete();
            try 
            {
		         toNumbers.createNewFile();
	         } 
            catch (IOException e) 
            {
		         e.printStackTrace();
	         }
         }
         
         while(rawScanner.hasNextLine()) // walk through everyline and convert it
         {
            String curLine = rawScanner.nextLine();
            toNumbersWriter.write(convertEntireLine(curLine)+"\n");
         }
         toNumbersWriter.close();
      } 
      catch (IOException e) 
      {
      System.out.println("An error occurred.");
      e.printStackTrace();
      }
      return toNumbers;
   }
   
   public String convertEntireLine(String curLine)
   {
      String converted ="";  
      String[] curLineAsAr = curLine.split("");
      for(int n =0; n<curLineAsAr.length; n++)
         converted+= code.getNumber(curLineAsAr[n]);
      converted += "\n";
      return converted;
   }
}