import java.util.Scanner;
import java.io.File;

public class SubSolver
{
   public static void main(String[] args) throws Exception
   {
      File f = new File("Q4.txt");
      Scanner s = new Scanner(f);
      String line = "";
      String choice= "y";
      while(s.hasNextLine())
      {
         line +=s.nextLine();
      }
      String[] ar = line.split("");
      while(choice.equals("y"))
      {
         swap(ar);
         print(ar);
         Scanner kb =new Scanner(System.in);
         System.out.println("\n y to continue");   
         choice = kb.nextLine().trim(); 
      }
   }
   
   public static void swap(String[] entire)
   {
      Scanner kb =new Scanner(System.in);
      System.out.println("Find: ");
      String find = kb.nextLine().trim();
      System.out.println("Replace: ");
      String replace = kb.nextLine().trim();
      
      for(int n =0; n<entire.length; n++)
      {
         if(entire[n].equals(find))
            entire[n] = replace;
         else if(entire[n].equals(replace))
            entire[n] = find;
      }
   }
   
   public static void print(String[] entire)
   {
      for(int n =0; n<entire.length; n++)
      {
         System.out.print(entire[n]);
         if(n%80 ==0)
            System.out.print("\n");
      }

   }
   
}