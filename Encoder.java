public class Encoder
{
   public String lowerCase;
   public String upperCase;
   public String number; // [00,25] always 2 digits
   
   public Encoder(String lower, String upper, String num)
   {
      this.lowerCase = lower;
      this.upperCase = upper;
      this.number = num;
   }
   @Override
   public String toString()
   {
      return lowerCase + " " + upperCase + " " + number;
   }
   
}