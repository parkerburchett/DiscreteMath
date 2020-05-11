import java.util.ArrayList;
public class binaryDistance
{
   public static void main(String[] args)
   {
   ArrayList<Vector> ar =  new ArrayList<Vector>(64);
   for (int a =0; a<2; a++)
      for (int b =0; b<2; b++)
         for (int c =0; c<2; c++)
            for (int d =0; d<2; d++)
               for (int e =0; e<2; e++)
                  for (int f =0; f<2; f++)
                  {
                     Vector v =  new Vector(a,b,c,d,e,f);
                     ar.add(v);
                  }
   Vector[] master =  new Vector[64];
   Vector[] side =  new Vector[64];
   
   for (int i=0; i<64; i++)
   {
      master[i] = ar.get(i);
      side[i] = ar.get(i);
   }
   // at this point side and master are correct;
   
   int [][] done = new int[64][64];
   
   for(int i= 0; i<64; i++)
   {
      for(int j= 0; j<64; j++)
      {
         int distance =0;
         for(int k =0; k<6; k++)
         {
            if(master[i].ar[k] != side[j].ar[k])
               distance++;
         }
         done[i][j] = distance;
      }
   }
   for(int i= 0; i<64; i++)
   {
      for(int j= 0; j<64; j++)
      {
         System.out.print(done[i][j]+ " ");
      }
      System.out.println();
   }
   
      System.out.println("end"); 
   }

}