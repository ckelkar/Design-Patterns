package studentRecordsBackup.driver;

import java.io.FileNotFoundException;

import studentRecordsBackup.bst.BST;
import studentRecordsBackup.bst.Node;
import studentRecordsBackup.util.BSTBuilder;

/**
 * main class : does exception handling
 * and controls overall code.
 * @author Chinmay
 *
 */
public class Driver {
	
	public static void main(String[] args) throws Exception{
		Node root = null;
		if(args.length!=2){
			System.err.print("Invalid arguments");
			System.exit(0);
		}
		
		try{
			Integer.parseInt(args[1]);
		}
		catch(NumberFormatException e){
			System.err.println("Invalid UPDATE_VALUE, requires integer!!");
			System.exit(0);
		}
		BSTBuilder bst=new BSTBuilder(args[0].toString(),Integer.parseInt(args[1]));
		bst.readfile();
		bst.printInorder();
		bst.printBSum();
		bst.increamentnode();
		bst.printInorder();
		bst.printBSum();
	
	}

}
