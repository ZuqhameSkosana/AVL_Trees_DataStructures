/**@author Hussain
 */

/** This class Binary search tree has useful methods that are used by other classes.
 * it has a method "insert" which is used to insert data in the binary search tree used
 * it also has find which is used when searching for an item in the Binary search tree
 * it also has a method called "NumIterations" which is used to return number of comparisons
 * This class will be used by the class DamBSTApp moslty
 * 
 */
public class BinarySearchTree<dataType extends Comparable<? super dataType>> extends BinaryTree<dataType>
{
	
	
	public static int count=0;
	public static int count2=0;
	
	/**@param insert has two parameters d and also node
	 */
   public void insert ( dataType d )
   {
      if (root == null)
         root = new BinaryTreeNode<dataType> (d, null, null);
      else
         insert (d, root);
   }
   
   /**@param insert has two parameters d and also node
    * @return there is no return statement, its a void method
    */ 
   public void insert ( dataType d, BinaryTreeNode<dataType> node )
   {
      if (d.compareTo (node.data) <= 0)
      {
         if (node.left == null)
            node.left = new BinaryTreeNode<dataType> (d, null, null);
         else
            insert (d, node.left);
      }
      else
      {
         if (node.right == null)
            node.right = new BinaryTreeNode<dataType> (d, null, null);
         else
            insert (d, node.right);
      }
   }
   
   /**@param method find has one parametere dataType d
    * @return it return the value if it is found when searching
    */
   
   public BinaryTreeNode<dataType> find ( dataType d )
   {
	  count++; 
      if (root == null)
         return null;
      else
         return find (d, root);
         
         
         
   }
   
   
   /**@param method find has two parameters dataType d and node
    * @return it return the value if it is found when searching
    */
   
   public BinaryTreeNode<dataType> find ( dataType d, BinaryTreeNode<dataType> node )
   {
	   count++;
	   
      if (d.compareTo (node.data) == 0){ 
         count2=count;
         count=0;
         return node;
         
         }
         
      else if (d.compareTo (node.data) < 0)
         return (node.left == null) ? null : find (d, node.left);
      else
         return (node.right == null) ? null : find (d, node.right);
   }
   /** @return : this method returns an integer, counts number of comparisons
    */
 
  public static int NumIterations(){
	  return count2;
	  
	  }
	  
	  

   
}
