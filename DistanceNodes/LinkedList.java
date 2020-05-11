// By Parker Burchett on 3.7.2020
// parkerburchett@gmail.com

public class LinkedList
{
   private int size;
   public Node head;
   
   public LinkedList()
   {
      this.size = 0 ;
      this.head = null;
   }
   
   public LinkedList(Node n)
   {
      this.size = 1;
      this.head = n;
   }
   
   public int size() {return this.size();}
   
   public void add(Node n)
   {
      if (n == null)
         throw new IllegalArgumentException("You cannot add a node that is null");     
      n.next = head;
      this.head = n;
      size++;
   }
   
   public Node get(int id) // Key and ID are different: 0 < key < 4 id: is 4 digits
   {
      if (head == null) // solves for edge cases
         return null;
      
      else
      {
         Node cur =  head;
         while (cur != null)
         {
            if (cur.id == id)
            {
               this.size--;
               return cur;
            }
            cur = cur.next;    
         }
         return null;
      }
   }
   
   public Node removeNode(int id)
   {
      if (head == null)
         return null;
      
      else if (size ==1)
      {
         if (head.id == id)
         {
            Node temp = head;
            head = null;
            size--;
            return temp;
         }
         else
         {
            return null;
         }
      }
      else // size >1
      {
         Node cur = head.next;
         Node prev = head;
         
         if(head.id == id)
         {
            Node temp = head;
            size--;
            head = head.next;
            return temp;
         }
         
         while(cur != null)
         {
            if (cur.id == id)
            {
               Node temp = cur;
               size--;
               prev.next = cur.next;
               return temp;
            }
            prev =  prev.next;
            cur= cur.next;
         }       
         return null;
      }
   }
   
   @Override
   public String toString()
   {
      String str ="";
      
      for(Node cur = head; cur!= null; cur = cur.next)
      {
         String leadingZeros = String.format ("%04d", cur.id);
         str = str + "(" + leadingZeros+ "," + cur.name + ") ";
      }
      return str;
   }
}