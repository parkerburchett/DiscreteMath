import java.util.Scanner;
import java.io.File;


public class CaeserEncrypter
{
   public static void main(String[] args) throws Exception
   {
      File file = new File("numberedAlphabet.txt");

      Encoder[] standardAlphabet = codeMaker(file);
      for(Encoder e : standardAlphabet)
      {
         System.out.println(e);
      }
   }
   public static Encoder[] codeMaker(File file) throws Exception // works
   {
      Encoder[] standardAlphabet = new Encoder[26];
      Scanner f = new Scanner(file);
      for(int n =0; n<26; n++)
      {
         String[] curAr = f.nextLine().split(",");
      }
      return standardAlphabet;
   }
   
   public static Encoder[] shiftRight(Encoder[] code) // works
   {
      String firstNum = code[0].number; 
      for(int n = 0; n< 26 ; n++)
      {
         code[n].number = code[(n+1)%26].number;
         //System.out.println(code[n]);
      }
      code[25].number = firstNum;
      return code;
   }
   
   public void rawToNumbers(File rawFile, Code code) throws Exception
   {
   // create new blank file called toNumbers
   
   // walk thorugh every character in rawFile
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

