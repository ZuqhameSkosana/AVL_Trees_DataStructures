import java.util.*;
import java.io.*;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.io.*;


/**@author       Zuqhame Skosana
 * student num:  SKSZUQ001
 * git username: Zuqhame Skosana, email: SKSZUQ001@myuct.com
*/

public class DamAVLApp{
	
	
/**create object of class AVLTree so that i can make use of methods 
     * create an avl of only names name
     * create a tempoArray that will store only dam names from the csv file
     * compare if name in array is found in avlTree
     * create method in avl that will count number of comparisons
     * create a class that will count the time taken to get a certain comparison
     */
     
      
 AVLTree<String> new_avl = new AVLTree<String> (); /** creating an object of class AVLTree so that can 	access methods in the avl class name of object is new_avl*/
    
    
    
    public static String tempoArray[];
    
	static String arrName[]=new String [211];
	static String arrFSC[]=new String[211];
	static String arrLevels[]=new String[211];
	
	
	static String arrFirst41[];
	//static BinaryTreeNode<String> rootNode;
	public static BinaryTree bnT= new BinaryTree();
	
   
    
    public static AVLTree avl=new AVLTree();
    // stores dam names which will be used to search
    //below
    public static AVLTree avl2=new AVLTree();
 
	public static AVLTree<String> only_name;
	
	public static AVLTree<String> bt;
	
	
	
/** printAllDams is a method which prints out everythin stored in the AVL tree, it does this by calling a method in the class AVLTree
 * @return there is no return statement in this method, it is a void method*/
 
 public static void printAllDams(){
	 
	 avl.treeOrder();
 }
 
 
/** this method printing_S has two parameters dam_name and rootNode
 * @return there is no return statement it is a void method
 * this method is the comparison method printing_S
 * it uses another method from the AVLTree class called find , which searches the AVL tree and check if it does contain the dam_name inserted by user
 * when this method is called it will print the information about the dam seearched and display number of comparisons it took to find the dam_name
 */
 
public static void printing_S(String dam_name, BinaryTreeNode<String> rootNode ){
	
	try{
	FileWriter writeFiles=new FileWriter(new File("AVL_time_find.txt"),true);
	PrintWriter printWr=new PrintWriter(writeFiles);
	
	
	
	
	//rs is an instance of BinaryTeeNode which will take the value found when searching so it will be an address and then use the method get data if found
	
	String format_s=dam_name.replaceAll("\\s+","");
	
	BinaryTreeNode<String> rs=only_name.find(format_s, rootNode);  //this will search the name for me that i want and will calculate number of comparisons
	
	String output= rs.getData().toString(); //gives exact value of String to be compared not address (remember this is just name )
	
	boolean decider=false; //checks if dam found or not
	
	
	
			for(int i=0;i<avl2.getSize();i++){

		 if(arrName[i].replaceAll("\\s+","").equals(output)){
			 decider=true;
			 
			 String a=("number of comparisons: "+ avl.num_comparisons()+ " time: "+avl.t_time()+" for     |"+arrName[i]+"  "+arrFSC[i]+"  "+arrLevels[i]);
			 printWr.println(a+"\n");
			 
			 System.out.println("number of comparisons: "+ avl.num_comparisons()+ " time: "+avl.t_time()+" for     |"+arrName[i]+"  "+arrFSC[i]+"  "+arrLevels[i]);
			 //JOptionPane.showMessageDialog(null,"number of comparisons: "+ avl.num_comparisons()+ " for     |"+arrName[i]+"  "+arrFSC[i]+"  "+arrLevels[i]);
			 
			 break;
			
		}

	}
	
			
			printWr.close();
			
			
			if(decider==false){
			System.out.println("dam not found");
			}
			
		}catch(Exception error){}
			
		 }
 		
 /**
   * This is the main method which makes use of printg_S method and printAllDams method .
   * @param args Used to store input from the user when searching for an item.
   * @return Nothing.
   * @exception IOException On input error and when file is not found.
   * 
   * In the main method also there is where you read form file to array
   * Methods to write on a file are used 
   * FileWritter and PrintWriter are used\
   * try cstch is used to catch amy any exception inside it 
   * AVL tree is used for printing the data stored
   * This class makes use of other classes as well linke BinarySearchTree
   * 
   */

public static void main(String arg[]){
	
	only_name=new AVLTree<String>();
	
	try{
	Scanner sc= new Scanner(new File("zuqhame.csv"));
	
	FileWriter writeFile=new FileWriter(new File("AVL_time_insertion.txt"),false);
    PrintWriter printW=new PrintWriter(writeFile);
		      
	
	
	sc.nextLine();
	int increament=0;
	while(sc.hasNextLine()){
		String slicing[]=sc.nextLine().split(",",-1);
		
		String nameD=slicing[2];
		String FSC_=slicing[10];
		String leyvels=slicing[42];
		
		String chooseCol=(nameD+" "+FSC_+" "+leyvels);
		
		String only_the_dam_name=slicing[2].replaceAll("\\s+","");
		
		printW.println("time: "+avl.t_time()+" nanoseconds | "+chooseCol);
		//
		arrName[increament]=nameD;
		arrFSC[increament]=FSC_;
		arrLevels[increament]=leyvels;
		//
		
		avl2.insert(only_the_dam_name); // sores only the dam name
		only_name.insert(only_the_dam_name);
		
		avl.insert(chooseCol);  // stores all information about dams
		
		
		for(int x=0;x<slicing.length;x++){
			slicing[x]="";
			
			}
			
			 increament++;
		
		
		}
	printW.close();
   }catch(Exception e){
	   
	   }
	   
	  
	  if(arg.length>0){
	    printing_S(arg[0], only_name.root);
	    
	  }else{
	    
	    printAllDams();
    }


}


public static void Abc(){
	
	
	for(int i=0;i<41;i++){
		arrFirst41[i]=arrName[i].replaceAll("//s+","");
		}
	
	
	}

}
