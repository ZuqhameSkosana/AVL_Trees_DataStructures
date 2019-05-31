// Hussein's Binary Tree
// 26 March 2017
// Hussein Suleman
/**@author Hussein Suleman
 * class adds elements in a  queu
 * 
 * 
 * */
public class BTQueueNode<dataType>
{
   BinaryTreeNode<dataType> node;
   BTQueueNode<dataType> next;
   
   public BTQueueNode ( BinaryTreeNode<dataType> n, BTQueueNode<dataType> nxt )
   {
      node = n;
      next = nxt;
   }
}
