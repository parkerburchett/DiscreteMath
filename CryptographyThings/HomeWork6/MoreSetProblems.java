public class MoreSetProblems
{
   public static void main(String[] args)
   {
       int three =0;
       int four =0;
       int twelve =0;
       int counter =0;
      
      for (int x =1; x<=1000; x++)
      {
         if (x%3 ==0)
            three++;
         if(x%4 ==0)
            four++;
         if(x%12 == 0)
            twelve++;
         if((x%3 ==0 || x%4 ==0) && (false == (x%3 ==0 && x%4 ==0)))
            counter++;
         
      }
      System.out.println(three);
      System.out.println(four);
      System.out.println(twelve);
      System.out.println(counter);
   }
}