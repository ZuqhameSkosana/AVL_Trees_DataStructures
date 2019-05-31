// Hussein's AVL Tree
// 2 April 2017
// Hussein Suleman
// reference: kukuruku.co/post/avl-trees/
import java.util.concurrent.*;

/** This class extends Comparables and BinaryTree to make use of some of the classes methods
*   
*/
public class AVLTree<dataType extends Comparable<? super dataType>> extends BinaryTree<dataType>
{
	
	public static int counting=0;
	public static int counting2=0;
	
	public static long comparison_time2=0;
	public static long comparison_time=System.nanoTime();//0;
	
	//public static TimeUnit sec = new TimeUnit(); //convert nano time to seconds
	
	
/**@return The height method is of type int methodwhich means a number will be returned
*  @param The method height has one parameter which is fo type BinaryTreeNode 
*/	
   public int height ( BinaryTreeNode<dataType> node )
   {
      if (node != null)
         return node.height;
      return -1;
   }
   
/** @return :method balanceFactor: the method returns the height which is an integer, therfore an integer will be returned.
*   @param : method has only one parameter which it will make use of in its method body
*/
   public int balanceFactor ( BinaryTreeNode<dataType> node )
   {
      return height (node.right) - height (node.left);
   }
   
/** @param ,method has only one parameter which it will make use of in its method body
*   @return, there is no return statement because the method fixHeight is a void method
*/   

   public void fixHeight ( BinaryTreeNode<dataType> node )
   {
      node.height = Math.max (height (node.left), height (node.right)) + 1;
   }
  

/** the following three methods below, which are rotateLeft, rotateRight and balance are responsible for balncing the tree
*   @return : returns dataType, all the methods return p which is a certain dataType.
*/ 
   public BinaryTreeNode<dataType> rotateRight ( BinaryTreeNode<dataType> p )
   {
      BinaryTreeNode<dataType> q = p.left;
      p.left = q.right;
      q.right = p;
      fixHeight (p);
      fixHeight (q);
      return q;
   }

   public BinaryTreeNode<dataType> rotateLeft ( BinaryTreeNode<dataType> q )
   {
      BinaryTreeNode<dataType> p = q.right;
      q.right = p.left;
      p.left = q;
      fixHeight (q);
      fixHeight (p);
      return p;
   }
   
   public BinaryTreeNode<dataType> balance ( BinaryTreeNode<dataType> p )
   {
      fixHeight (p);
      if (balanceFactor (p) == 2)
      {
         if (balanceFactor (p.right) < 0)
            p.right = rotateRight (p.right);
         return rotateLeft (p);
      }
      if (balanceFactor (p) == -2)
      {
         if (balanceFactor (p.left) > 0)
            p.left = rotateLeft (p.left);
         return rotateRight (p);
      }
      return p;
   }
/** the method below is an insert method
*   @param it has only parameter
*   @return : there is no return statement becuase the method is a void method 
*/


	  
   //counting=0;
   
   /**method records taken to insert a data item
    * */
   public void insert ( dataType d )
   {
	 comparison_time=(System.nanoTime());// initial time given in nano
     
      
      root = insert (d, root);
      
     
      
      
      comparison_time2=((System.nanoTime())-comparison_time);
      
      
      
      comparison_time=0;
      
   }
   

/** The method below is an insert method which takes two parameters
*   @param : method takes two parameters first one is d and second one is node
*   @return : method return a balanced tree agetr insertion process
*/
   public BinaryTreeNode<dataType> insert ( dataType d, BinaryTreeNode<dataType> node )
   {
      if (node == null)
         return new BinaryTreeNode<dataType> (d, null, null);
      if (d.compareTo (node.data) <= 0)
         node.left = insert (d, node.left);
      else
         node.right = insert (d, node.right);
      return balance (node);
   }

/** delete method takes in one parameter
*/
   public void delete ( dataType d )
   {
      root = delete (d, root);
   }   
/**delete method takes in two parameters 
*  @param first parameter is d and second one is node
*   d is what will be deleted from the tree 
*/
   public BinaryTreeNode<dataType> delete ( dataType d, BinaryTreeNode<dataType> node )
   {
      if (node == null) return null;
      if (d.compareTo (node.data) < 0)
         node.left = delete (d, node.left);
      else if (d.compareTo (node.data) > 0)
         node.right = delete (d, node.right);
      else
      {
         BinaryTreeNode<dataType> q = node.left;
         BinaryTreeNode<dataType> r = node.right;
         if (r == null)
            return q;
         BinaryTreeNode<dataType> min = findMin (r);
         min.right = removeMin (r);
         min.left = q;
         return balance (min);
      }
      return balance (node);
   }
   
   public BinaryTreeNode<dataType> findMin ( BinaryTreeNode<dataType> node )
   {
      if (node.left != null)
         return findMin (node.left);
      else
         return node;
   }

   public BinaryTreeNode<dataType> removeMin ( BinaryTreeNode<dataType> node )
   {
      if (node.left == null)
         return node.right;
      node.left = removeMin (node.left);
      return balance (node);
   }


/** method find is used to find a information in the tree
*  @param has one parameter named d
*  @return returns what is found
*/

   public BinaryTreeNode<dataType> find ( dataType d )
   {
      if (root == null)
         return null;
      else
         return find (d, root);
   }

/** @param method has two parameters which are named d and node, d is input form the user, the input is then being searched in the binary tree whinch is being used 
*   @return returns node
*   calculate number of comparisons and calculate time take to find certain item
*   also calculates the time taken to find an item in nanoseconds
*/

   public BinaryTreeNode<dataType> find ( dataType d, BinaryTreeNode<dataType> node )
   {
	   
	   comparison_time=System.nanoTime();// initial time given in seconds 1 second is 1000000000 nano seconds
	  
	   counting++;
      
      if (d.compareTo (node.data) == 0){
		  
		  
		  counting2=counting;
		  counting=0;
		            
	
          comparison_time2=(System.nanoTime())-comparison_time; //difference in time given in nano seconds

		
	      comparison_time=0;
		  
		  return node;
		  }
      
         
         
      else if (d.compareTo (node.data) < 0)
         return (node.left == null) ? null : find (d, node.left);
      else
         return (node.right == null) ? null : find (d, node.right);
   }
   /** method tree order is called when displaying the data in tree order form
   */
   public void treeOrder ()
   {
      treeOrder (root, 0);
   }


   public void treeOrder ( BinaryTreeNode<dataType> node, int level )
   {
      if (node != null)
      {
         for ( int i=0; i<level; i++ )
            System.out.print (" ");
         System.out.println (node.data);
         treeOrder (node.left, level+1);
         treeOrder (node.right, level+1);
      }
   }
   
   /**@return returns the number of comparisons when searching the data structure thre binary tree

   */
   public int num_comparisons(){
	   return counting2;
	   //System.out.println(counting2);
	   
	   }
	   
	   
	   public double t_time(){
		   return comparison_time2;
		   
		   }
   
}
   

