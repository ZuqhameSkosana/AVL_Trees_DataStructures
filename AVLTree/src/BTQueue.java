// Hussein's Binary Tree
// 26 March 2017
// Hussein Suleman
/**@author Hussein Suleman
 * class makes use of other classes BTQueueNode
 * it is used to add data in a Queue manner.
 *
 * 
 * */
public class BTQueue<dataType>
{   
   BTQueueNode<dataType> head;
   BTQueueNode<dataType> tail;
      
   public BTQueue ()
   {
      head = null;
      tail = null;
   }
   
   /**data used to get the next data item in the data structure
    *@return this method return the node 
    */
   public BinaryTreeNode<dataType> getNext ()
   {
      if (head == null)
         return null;
      BTQueueNode<dataType> qnode = head;
      head = head.next;
      if ( head == null )
         tail = null;
      return qnode.node;
   }
   /**void method which does some checking if tail is null or not if tail is null, it sets head to be equals to tail after re initializing tail
    * else if tail is not null, you get the next item etc
    */
   public void enQueue ( BinaryTreeNode<dataType> node )
   {
      if (tail == null)
      {   
         tail = new BTQueueNode<dataType> (node, null);
         head = tail;
      }   
      else
      {
         tail.next = new BTQueueNode<dataType> (node, null);
         tail = tail.next;
      }   
   }   
}
