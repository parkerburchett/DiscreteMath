public class KnownAffineSolver
{
// this works since there are only 26^2 possible answers. I think maybe
   public static void main(String[] args)
   {
      // This finds A and B when SV converst into IN
      
       int s =1;
       int i =4;
       
       int v =12;
       int n= 7;
      
      int TrueA = 0;
      int TrueB = 0;
      for(int a =0; a<26; a++)
      {
         for(int b = 0; b<26; b++)
         {
            if((a*s + b) %26 == i &&(a*v + b) %26 == n)
            {
               // Calculates  the proper a and b values for the given letter pairs 
               TrueA =a;
               TrueB =b;
               System.out.println(TrueA);
               System.out.println(TrueB);
            }
         }
      }
      
   }
}