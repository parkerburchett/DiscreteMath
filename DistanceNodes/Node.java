// By Parker Burchett on 3.7.2020
// parkerburchett@gmail.com

public class Node
{
   public Node next;
   public int key;
   public int id;
   public String name;
   
   public Node(int id, String name)
   {
      this.next = null;
      this.key = hash(id);
      this.id = id; // Need to add Number format ####
      this.name = name;
   }
   
   public int hash(int id)
   {
      return ((7*id)+29) % 5;
   }   
}