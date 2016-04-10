package studentRecordsBackup.util;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Observer;

import studentRecordsBackup.bst.BST;
import studentRecordsBackup.bst.Node;
import studentRecordsBackup.bst.SubjectI;
import studentRecordsBackup.filereader.FileProcessor;

/**
 * BSTBuilder--builds BSTs and perform
 * corresponding operations
 * @author Chinmay
 *
 */

public class BSTBuilder{
	String filename=null;
	String temp=null;
	BST mainBST; //main BST object
	BST backup1; //backup1 object
	BST backup2; //backup2 object
	int sum; //stores sum
	boolean printtraversal_flag;
	boolean subjectnodeflag;//decides whether node is subject node or object node
	EvenFilterImpl evenfilter= new EvenFilterImpl();
	OddFilterImpl oddfilter= new OddFilterImpl();
	int update_value;
	
	/**
	 * creates three objects
	 * @param filenameIn -input filename
	 * @param update_valuein - value to be used to modify tree elements
	 */
	public BSTBuilder(String filenameIn, int update_valuein){
		filename=filenameIn;
		update_value=update_valuein;
		mainBST=new BST();
		backup1=new BST();
		backup2=new BST();
	}
	
	
	
	/**
	 * reads number from input file
	 * @throws Exception
	 */
	public void readfile() throws Exception{
		
		try{
		
		FileProcessor fp=new FileProcessor(filename);
		//Node subjectNode;
			while((temp=fp.readLineFromFile())!=null){
				//subjectNode = new Node(bnumber, null,null)
				subjectnodeflag=true;
				mainBST.insert(Integer.parseInt(temp),subjectnodeflag,update_value,null);
				subjectnodeflag=false;
					
						backup1.insert(Integer.parseInt(temp),subjectnodeflag,update_value,evenfilter);
						backup2.insert(Integer.parseInt(temp),subjectnodeflag,update_value,oddfilter);
					
				
			}
			
	}catch(Exception e){
			e.printStackTrace();
			System.exit(0);
			
		}
	}
		/**
		 * calls function printInorder() in BST.java
		 * which prints inorder traversal of the tree
		 */
		public void printInorder(){
			System.out.println("Inorder traversal for main tree=");
			mainBST.printInorder(mainBST.root);
			System.out.println("Inorder traversal for backup1 tree=");
			backup1.printInorder(backup1.root);
			System.out.println("Inorder traversal for backup2 tree=");
			backup2.printInorder(backup2.root);
		}
		
		/**
		 * calls functions calculatesum() and printsum() which calculates 
		 *	and prints sum respectively.
		 */
		public void printBSum(){
			String name;
			mainBST.calculatesum(mainBST.root);
			backup1.calculatesum(backup1.root);
			backup2.calculatesum(backup2.root);
			mainBST.printBSum("mainBST");
			backup1.printBSum("backup1");
			backup2.printBSum("backup2");
		}


		/**
		 * finds maximum number in mainBST
		 * and calls tracesubjectree()
		 */

		public void increamentnode() {
			mainBST.findmaximun(mainBST.root);
			tracesubjectree(mainBST.root);
			
		}



		/**
		 * updates main BST and notifies other
		 * observers
		 * @param node
		 */
		public void tracesubjectree(Node node) {
			if(node==null){
				return;
			}
			tracesubjectree(node.left);
				if(node.max_value==true){
					node.B_number=node.B_number+2*update_value;
				}else{
					node.B_number=node.B_number+update_value;
				}
			node.notifyobservers(update_value);
			tracesubjectree(node.right);
			
			
			
		}
	
	}
	


