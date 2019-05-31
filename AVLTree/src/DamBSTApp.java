import java.util.*;
import java.io.*;
import javax.swing.*;

/**@author Zuqhame Skosana,SKSZUQ001
 */

public class DamBSTApp{

	public static AVLTree<String> bt;
	
	public static AVLTree<String> only_name;
	
	public static AVLTree b= new AVLTree();
	
	static String arrName[]=new String [211];
	static String arrFSC[]=new String[211];
	static String arrLevels[]=new String[211];
	static String arrT[]=new String [211];
	
	
	static String f40_names[]=new String[40];  //takes a subset of the dam names, take first 40
	static String middle40_name[]=new String[40]; // takes a subset of the dam names, take the middle names
	static String last41_name[]=new String[41]; // takes a subset of the dam names , the last names 
	
	
	public static BinaryTree s;//
	public static int count=0;
    


/** @param This method has two parameters one is meant to store dam names and the other parameter rootNode is meant to store a binary search tree
 * @return This method returns the dam information for example it returns the dam name , FSC ,level and number of iterations to find an item.
 */
   public static void printing_S(String dam_name, BinaryTreeNode<String> rootNode ){
	try{
    FileWriter writeFiles=new FileWriter(new File("BST_time_find.txt"),true);
	PrintWriter printWr=new PrintWriter(writeFiles);
		      
   
   BinaryTreeNode<String> rs=only_name.find(dam_name.replaceAll("\\s+",""), rootNode);
   String universal="";
 
	String output=rs.getData();
	boolean decider=false;
	
	for(int x=0;x<211;x++){
		
		if(arrName[x].replaceAll("\\s+","").equals(output)){
		    decider=true;
		    universal=("you searched for "+arrName[x]+" comparisons for this Dam:   "+b.num_comparisons()+" time: "+b.t_time()+"     | "+arrName[x]+"   "+arrFSC[x]+"  "+arrLevels[x]);
		    System.out.println("you searched for "+arrName[x]+" comparisons for this Dam:   "+b.num_comparisons()+" time: "+b.t_time()+"     | "+arrName[x]+"   "+arrFSC[x]+"  "+arrLevels[x]);
		    
		    break;
			}
		}
		printWr.println(universal+"\n");
	if(decider==false){
	System.out.println("The dam was not found");
		}
	
	
	//return universal;
	printWr.close();
}catch(Exception error){

	}
}
   /**
   * This is the main method which makes use of printg_S method .
   * @param args Used to store input from the user when searching for an item.
   * @return Nothing.
   * @exception IOException On input error and when file is not found.
   * 
   * In the main method also there is where you read form file to array
   * Methods to write on a file are used 
   * FileWritter and PrintWriter are used\
   * try cstch is used to catch amy any exception inside it 
   * preOrder is used when printing out the data
   * This class makes use of other classes as well linke BinarySearchTree
   * 
   */

	public static void main(String args[]){

		 bt = new AVLTree<String> ();
		 
		 only_name=new AVLTree<String>();
		 int iterator=0;
		 

		 try{

            FileWriter writeFile=new FileWriter(new File("BST_time_insertion.txt"),false);
		    PrintWriter printW=new PrintWriter(writeFile);
		      

		 Scanner sc=new Scanner (new File("zuqhame.csv"));
		 
		 sc.nextLine();

		 while(sc.hasNext()){

			 String line[]=sc.nextLine().split(",",-1);

			 String dam_name=line[2];
			 String FSC=line[10];
			 String level=line[42];

			 String set_to_BST=(dam_name+" "+FSC+" "+level);
			 String n_ame=dam_name;
			 
			 
			bt.insert(set_to_BST);
			
			printW.println("time: "+bt.t_time()+" nanoseconds | "+set_to_BST);
			
			
			only_name.insert(n_ame.replaceAll("\\s+",""));
			
			arrName[count]=dam_name;
			
			arrFSC[count]=FSC;
			arrLevels[count]=level;
				
			
				
				
			count++;
			 
			 }
			 
         printW.close();


			 }catch(Exception err){
				 
                 JOptionPane.showMessageDialog(null,"Please use a working file, check the path of your file");
				 }
		 
	try{

       int counterT=0;
       String fileNamed=("zuqhame.csv");
       File file= new File(fileNamed);
      
       Scanner inputStream=new Scanner(file);
       
       inputStream.nextLine();

       while(inputStream.hasNext()){
       String input=inputStream.nextLine();


        String [] a=input.split(",",-1);


         String name=a[2];
       
         arrT[counterT]=name.replaceAll("\\s+","");
         
         counterT++;


         for(int y=0;y<a.length;y++){
             a[y]="";
           }

         }
/**Create multiple files for last 10, first 10 and also create subset of values to be ploted on the graphs and also create file for all dam names and their comparisons
 */
 
 
  
    }catch(Exception err){
		JOptionPane.showMessageDialog(null,"Please use a working file, check the path of your file");
		}












				 if(args.length>0){
					
					 
					printing_S(args[0], only_name.root);
						//System.out.println(printing_S(args[0], only_name.root));
						
					
					 }else{
						 bt.preOrder();
						

						 }





		}

	}

