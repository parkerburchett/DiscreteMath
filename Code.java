import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;

public class Code
{
   private  Encoder[] converter;
   
   public Code(File LettersAndNumbers) throws Exception // works
   {
      converter = new Encoder[26];
      Scanner f = new Scanner(LettersAndNumbers);
      for(int n =0; n<26; n++)
      {
         String[] curAr = f.nextLine().split(",");
         converter[n] = new Encoder(curAr[0].trim(), curAr[1].trim(), curAr[2].trim());
      }
   }
   
   public String getNumber(String letter) // untested. Should return the assocated number or the character or the character. eg "A" becomes "00" and "," becomes ","
   {
      if (letter.length() != 1)
         return letter;
      else
      {
         for(int n =0; n<26 ; n++)
            if (letter.equals(converter[n].upperCase)|| letter.equals(converter[n].lowerCase))
               return converter[n].number;
         return letter;
      }
   }
   
   public void shiftRight()
   {
      String firstNum = converter[0].number; 
      for(int n = 0; n< 26 ; n++)
         converter[n].number = converter[(n+1)%26].number;
      converter[25].number = firstNum;
   }
}