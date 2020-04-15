public class Prog3Solver
{
// this works since there are only 26^2 possible answers. I think maybe
   public static void main(String[] args)
   {
      int i =8;
      int n= 13;
      int v =21;
      int s =18;
      int TrueA =0;
      int TrueB=0;
      for(int a =0; a<26; a++)
      {
         for(int b = 0; b<26; b++)
         {
            if((a*s + b) %26 == i &&(a*v + b) %26 == n)
            {
               // Calculates  the proper a and b values for the given letter pairs 
               TrueA =a;
               TrueB =b;
            }
         }
      }
      int h = 7;
      int g = 6;
      int k = 10;
      int a = 0;
      
      int[] ar =  {s,v,h,g,k,a};
      
      for(int x: ar)
      {
         int ans =(TrueA*x + TrueB)%26;
         System.out.println(ans);
      }
   }
}