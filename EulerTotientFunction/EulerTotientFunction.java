public class EulerTotientFunction
{

   public static void main(String[] args)
   {
      for(int i = 0; i< 1000; i++)
      {
         System.out.println(Integer.toString(i) + "," +Integer.toString(phi(i)));
      }
   }
   
   public static int phi(int x)
   {
      int counter =0;
      for(int n = 0; n<=x; n++)
      {
         if(gcd(n, x) ==1)
            counter++;
      }
      return counter;
   }
   
   public static int gcd(int a, int b) // from https://www.programiz.com/java-programming/examples/hcf-gcd
   {
      int counter =0;

        for(int i = 1; i <= a && i <= b; i++)
        {
            // Checks if i is factor of both integers
            if(a % i==0 && b % i==0)
                counter = i;
        }
      return counter;
   }
}


/* fun little function to calculate the toitent function of an integer

E(x) = try for every int n where gcd(n, x) == 1 and n is a real integer between greater than 0 and less than n. Simple for loop here

*/