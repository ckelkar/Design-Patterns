package studentRecordsBackup.bst;

import java.util.HashMap;
import java.util.Map;

import studentRecordsBackup.util.EvenFilterImpl;
import studentRecordsBackup.util.OddEvenFilterI;
import studentRecordsBackup.util.OddFilterImpl;

public class BST {
	public Node root; // root of the tree
	public Node Subjectnode; // tree node which acts as subject
	public Node Observernode;// tree node which acts as observer
	public static Node persistsubjectnode;//stores subjeect reference
	int sum=0;
	int max;
	
	
	
	public Node getSubjectnode() {
		return Subjectnode;
	}

	public void setSubjectnode(Node subjectnode) {
		Subjectnode = subjectnode;
	}

	public BST(){
		root=null;
	}

	public void insert(int B_number,boolean flag,int update_value,OddEvenFilterI filter){
		root=insert(B_number,root,flag,update_value,filter);	
	}

	/**
	 * inserts node in the tree
	 * @param b_number
	 * @param node
	 * @param flag
	 * @param update_value
	 * @param filter
	 * @return
	 */
	private Node insert(int b_number, Node node,boolean flag,int update_value,OddEvenFilterI filter) {
		if(node==null){
			if(flag==true){
				Node Subjectnode=new Node(b_number);
				persistsubjectnode=Subjectnode;
				return Subjectnode;
			}
			else{
					
						Node Observernode= new Node(b_number,persistsubjectnode,filter);
						return Observernode;
				
			}
			
		}
		else if(node.B_number>b_number){
			node.left=insert(b_number,node.left,flag,update_value,filter);	
		}
		else{
			node.right=insert(b_number,node.right,flag,update_value,filter);
		}
			
		return node;
	}
	
/**
 * prints inorder traversal of tree
 * @param root
 */
	public void printInorder(Node root) {
		
		if(root==null){
			return;
		}
		printInorder(root.left);
		System.out.println(root.B_number);
		printInorder(root.right);
		
		//System.out.println(root.B_number);
	}
	
	/**
	 * calculates sum of all
	 * elements in tree
	 * @param root
	 */
	public void calculatesum(Node root){
		if(root==null){
			return;
		}
		calculatesum(root.left);
		sum=sum+ root.B_number;
		calculatesum(root.right);
	}
	
	/*
	 * prints sum
	 */
	public void printBSum(String name){
		System.out.println("sum for "+name+"= "+sum);
		sum=0;
	}
	
	/*
	 * finds maximum element in tree
	 */
	public void findmaximun(Node node){
		
		if(node.right==null){
			node.max_value=true;
		}
		else{
			findmaximun(node.right);
		}
		return;
				
	}
}
