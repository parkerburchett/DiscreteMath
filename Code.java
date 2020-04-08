public class Code
{
   private final Encoder[] code;
   
   public Code(Encoder[] code)
   {
      this.code = code;
   }
   
   public String getNumber(String letter) // untested. Should return the assocated number or the character or the character. eg "A" becomes "00" and "," becomes ","
   {
      if (letter.length() != 1)
         throw new IllegalArgumentException("you are passing in a letter that is more than one character. That String is" + letter);
      else
      {
         for(int n =0; n<26 ; n++)
            if (letter.equals(code[n].upperCase)|| letter.equals(code[n].lowerCase))
               return code[n].number;
         return letter;
      }
   }
}