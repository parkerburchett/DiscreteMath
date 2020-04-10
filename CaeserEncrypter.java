import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;

public class CaeserEncrypter
{
   public static void main(String[] args) throws Exception
   {
      File alphabet = new File("numberedAlphabet.txt");

      Encoder[] standardAlphabet = codeMaker(alphabet);     
      Code standardCode = new Code(standardAlphabet);
      
      File copiedRaw = new File("Invictus");
      rawToNumbers(copiedRaw, standardCode);
   }
   public static Encoder[] codeMaker(File file) throws Exception // works
   {
      Encoder[] standardAlphabet = new Encoder[26];
      Scanner f = new Scanner(file);
      for(int n =0; n<26; n++)
      {
         String[] curAr = f.nextLine().split(",");
         standardAlphabet[n] = new Encoder(curAr[0].trim(), curAr[1].trim(), curAr[2].trim());
      }
      return standardAlphabet;
   }
   
   public static Encoder[] shiftRight(Encoder[] code) // works
   {
      String firstNum = code[0].number; 
      for(int n = 0; n< 26 ; n++)
         code[n].number = code[(n+1)%26].number;
      code[25].number = firstNum;
      return code;
   }
   
   public static void rawToNumbers(File rawFile, Code code) throws Exception
   {
      File toNumbers = new File("toNumbers.txt");  
      try // this is copy pasted from https://www.w3schools.com/java/showjava.asp?filename=demo_files_create
      {  
      if (toNumbers.createNewFile()) 
        System.out.println("File created: " + toNumbers.getName());  
      else  
        System.out.println("File already exists.");  
      } 
      catch (IOException e) 
      {
        System.out.println("An error occurred.");
        e.printStackTrace(); 
      }
     
      Scanner rawScanner = new Scanner(rawFile);
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
         while(rawScanner.hasNextLine())
         {
            String curLine = rawScanner.nextLine();
            String[] curLineAsAr = curLine.split("");
            
            for(int n =0; n<curLineAsAr.length; n++)
            {
               toNumbersWriter.write(code.getNumber(curLineAsAr[n]));
            }
            toNumbersWriter.write("\n");
         }
         
         toNumbersWriter.close();
      } 
      catch (IOException e) 
      {
      System.out.println("An error occurred.");
      e.printStackTrace();
      }
      
      
   }
}


























/* simple Ceaser Cipher. 
This program reads in a text file and creates a new text file that is that text file ecrypted

each of the normal letters with an other moved a set number down the alphebet.

This ignores case and puncation. All things are converted into capitals.


method:

1. read in file. 
2. create a new text file and replace every character with its associted number eg( a or A = 00 .. z or Z = 25). This is the intermedite file
3. For each number add x (where x is the code chosen) and create a new file where all of the numbers are +5 %26. This is the almost encoded file
4. take encoded file and crate a new file where each of the numbers are replacted with an assocated letter. eg This is the fully encorded file


5. You need an array of all the Encoder objects of all the letters
*/

