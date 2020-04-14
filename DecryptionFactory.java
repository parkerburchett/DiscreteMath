import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;

public class DecryptionFactory
{
   private Code code;
   
   public DecryptionFactory(Code code) // note you can push this up the dependece heirachy since it is the same constructor as and in the encryption factory
   {
      this.code = code;
   }
   
   public File convertToLetters(File numbers) throws Exception
   {
      Scanner numberScanner = new Scanner(numbers);
      File toLetters = new File("toLetters.txt");  
      try 
      {
         FileWriter toLettersWriter = new FileWriter("toLetters.txt");
         if (toLetters.exists())
         {
            toLetters.delete();
            try 
            {
		         toLetters.createNewFile();
	         } 
            catch (IOException e) 
            {
		         e.printStackTrace();
	         }
         }
         
         while(numberScanner.hasNextLine()) 
         {
            String curLine = numberScanner.nextLine();
            toLettersWriter.write(convertEntireLine(curLine)+"\n");
         }
         toLettersWriter.close();
      } 
      catch (IOException e) 
      {
      System.out.println("An error occurred.");
      e.printStackTrace();
      }
      return toLetters;
   }

   public String convertEntireLine(String curLine)// this breaks with non number pairs eg "," will break this. You need to make a generic factory since it will work with all that stuff
   {
      String[] curLineAsAr = curLine.split("");
      String[] condensedCurLine = new String[curLineAsAr.length /2];
      for(int n =0,  i =0; n<curLineAsAr.length-1; n=n+2, i++) // this is needed to make all the ar contain[08] rather [0] [8]. Is needed to decode
      {
         condensedCurLine[i] = curLineAsAr[n] + curLineAsAr[n+1]; 
      }
      String converted ="";  
      for(int n =0; n<condensedCurLine.length; n++)
         converted+= code.getLetter(condensedCurLine[n]);
      converted += "\n";
      return converted;
   }
 
   public File completeToletters(File inputFile ,File toLetters, File toNumbers, Code code, EncryptionFactory Efact, DecryptionFactory Dfact) throws Exception //only works with single line file
   {
      File endFile = new File("endFile.txt");
      try 
      {
         FileWriter endFileWriter = new FileWriter("endFile.txt");
         if (endFile.exists())
         {
            endFile.delete();
            try 
            {
		         endFile.createNewFile();
	         } 
            catch (IOException e) 
            {
		         e.printStackTrace();
	         }
         }
         
      for(int n =0; n<26; n++)
      {
         String currentNumbers = getTopLine(toNumbers);
         String currentLetters = Dfact.convertEntireLine(currentNumbers);
         endFileWriter.write("Using a shift of " + Integer.toString(n)+ " places" +"\n");

         endFileWriter.write(currentLetters+"\n");
         code.shiftRight();
      }  
      endFileWriter.close();
      } 
      catch (IOException e) 
      {
         System.out.println("An error occurred.");
         e.printStackTrace();
      }
      return endFile;

   }
   
   public String getTopLine(File f) throws Exception
   {
      Scanner fn = new Scanner(f);
      return fn.nextLine().trim();
   }
   
}