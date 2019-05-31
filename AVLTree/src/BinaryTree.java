// Hussein's Binary Tree
// 26 March 2017
// Hussein Suleman

/**@author Hussein Suleman
 * 
 */

public class BinaryTree<dataType>
{
   BinaryTreeNode<dataType> root;
   
   public BinaryTree ()
   {
      root = null;
   }
   /**@return : getHeight method returns an integer , the height of the tree
    * 
    */
   public int getHeight ()
   {
      return getHeight (root);
   }  
   
   /**@return : this method also return the height of a tree
    * @param : this method has one parameter "node" if node is null it returns -1 else returns the maximum height
    */  
   public int getHeight ( BinaryTreeNode<dataType> node )
   {
      if (node == null)
         return -1;
      else
         return 1 + Math.max (getHeight (node.getLeft ()), getHeight (node.getRight ()));
   }
   /** method get size returns size of tree
    */
   public int getSize ()
   {
      return getSize (root);
   }  
   
   /**@return :returns 0 if node is null esle returns the size
    */  
   public int getSize ( BinaryTreeNode<dataType> node )
   {
      if (node == null)
         return 0;
      else
         return 1 + getSize (node.getLeft ()) + getSize (node.getRight ());
   }
   
   /**@param : method visit takes one parameters which is "node"
    
    */
   public void visit ( BinaryTreeNode<dataType> node )
   {
      System.out.println (node.data);
   }
   /**returns how tree should be printed
    */
   public void preOrder ()
   {
      preOrder (root);
   }
   
   /**preOrder prints tree in a preOrder way
    * 
    */
   public void preOrder ( BinaryTreeNode<dataType> node )
   {
      if (node != null)
      {
         visit (node);
         preOrder (node.getLeft ());
         preOrder (node.getRight ());
      }   
   }
/**preOrder prints tree in a postOrder way
    * 
    */
   public void postOrder ()
   {
      postOrder (root);
   }
   public void postOrder ( BinaryTreeNode<dataType> node )
   {
      if (node != null)
      {
         postOrder (node.getLeft ());
         postOrder (node.getRight ());
         visit (node);
      }   
   }
   /**inOrder prints tree in a preOrder way
    * 
    */

   public void inOrder ()
   {
      inOrder (root);
   }
   public void inOrder ( BinaryTreeNode<dataType> node )
   {
      if (node != null)
      {
         inOrder (node.getLeft ());
         visit (node);
         inOrder (node.getRight ());
      }   
   }
/**levelOrder prints tree in a preOrder way
    * 
    */
   public void levelOrder ()
   {
      if (root == null)
         return;
      BTQueue<dataType> q = new BTQueue<dataType> ();
      q.enQueue (root);
      BinaryTreeNode<dataType> node;
      while ((node = q.getNext ()) != null)
      {
         visit (node);
         if (node.getLeft () != null)
            q.enQueue (node.getLeft ());
         if (node.getRight () != null)
            q.enQueue (node.getRight ());
      }
   }
}
