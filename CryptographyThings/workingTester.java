import java.util.Scanner;
import java.io.File;

public class workingTester
{
   public static void main(String[] args) throws Exception
   {
      Encoder[] standardAlphabet = new Encoder[26];
      
      File file = new File("numberedAlphabet.txt");
      
      Scanner f = new Scanner(file);
      int n =0;
      while(f.hasNextLine())
      {
         String curLine = f.nextLine();
         String[] curAr = curLine.split(",");
         standardAlphabet[n] = new Encoder(curAr[0].trim(), curAr[1].trim(), curAr[2].trim());
         n++;  
      }
      System.out.println("end");    
   }
}