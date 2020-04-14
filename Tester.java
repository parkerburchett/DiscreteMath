import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;

public class Tester
{
   public static void main(String[] args) throws Exception
   {
      File alphabet = new File("numberedAlphabet.txt");
      File inputFile= new File("problem2.txt");
      
      Code code = new Code(alphabet);
      EncryptionFactory Efact = new EncryptionFactory(code);
      DecryptionFactory Dfact = new DecryptionFactory(code);
      File toNumbers = Efact.convertToNumbers(inputFile);  
      File toLetters = Dfact.convertToLetters(toNumbers);
      File endFile = Dfact.completeToletters(inputFile, toLetters, toNumbers, code, Efact, Dfact);
      
      
      System.out.println("end");
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

