// Hussein's Binary Tree
// 26 March 2017
// Hussein Suleman

/** this class deals with the nodes left nodes and right nodes
 * @author Hussein Suleman
 * 
 */

public class BinaryTreeNode<dataType>
{
   dataType data;
   BinaryTreeNode<dataType> left;
   BinaryTreeNode<dataType> right;
   int height;
   
   /**constructor that initializes the parameters in this class
    * 
    */
   public BinaryTreeNode ( dataType d, BinaryTreeNode<dataType> l, BinaryTreeNode<dataType> r )
   {
      data = d;
      left = l;
      right = r;
      height = 0;
   }
   
   BinaryTreeNode<dataType> getLeft () { return left; }
   BinaryTreeNode<dataType> getRight () { return right; }
   
   /**@return : this method getData() returns the data at a certain node
   */
   
    public dataType getData() {
	
				  return data;
				
	   
	 
	   
	   } 
}
