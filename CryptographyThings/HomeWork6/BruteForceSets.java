public class BruteForceSets
{
   public static void main(String[] args)
   {
      int counter =0;
      for (int a=0; a<=10; a++)
         for (int b=0; b<=10; b++)
            for (int c=0; c<=10; c++)
               for (int d=0; d<=10; d++)
               {
                  if (a+b+c+d ==10 && a>1&& b>1 && c>1 && d>1)// checks proper amount of books
                  {
                     counter++;
                     int[] ar  = new int[]{a,b,c,d};
                     String str = "";
                     for(int x = 0; x<4; x++)
                        {
                           str += Integer.toString(ar[x])+" ";
                        }
                     System.out.println(str+ " number of possibilties within form: "+ Integer.toString(PossibilityWithForm(ar)));
                  }
               }

      System.out.println("Number of ways to put 10 books on to 4 shelves");
      System.out.println(counter);
    }
    
    public static int PossibilityWithForm(int[] form)
    {
        int remainingBooks =10;
        int a = form[0];
        int b = form[1];
        int c = form[2];
        int d = form[3];
        int workingSum = 1;
        workingSum *= choose(remainingBooks, a) * factorial(a);
        remainingBooks -= a;
        workingSum *= choose(remainingBooks, b)* factorial(b);
        remainingBooks -= b;
        workingSum *= choose(remainingBooks, c)* factorial(c);
        remainingBooks -= c;
        workingSum *= choose(remainingBooks, d)* factorial(d);
        remainingBooks -= d;
        if(remainingBooks != 0)
        {
         throw new IllegalArgumentException("there is something wrong with the amounts of books here: "+ Integer.toString(remainingBooks));
        }
        return workingSum ;
    }
    
    public static int choose(int n, int k)
    {
      return factorial(n) / ((factorial(k)* factorial(n-k)));
    }
    
   public static int factorial(int a) // untested
   {
      if (a==0 || a==1)
         return 1;
      else
      {
         int fact = 1; 
         for(int x=1; x<=a; x++)
         {
            fact = fact*x;
         }
         return fact;
      } 
   }
}      