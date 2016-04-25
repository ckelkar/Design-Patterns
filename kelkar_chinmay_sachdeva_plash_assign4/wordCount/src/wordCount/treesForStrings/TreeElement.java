package wordCount.treesForStrings;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

import wordCount.util.FileProcessor;
import wordCount.visitors.TreeProcessingVisitorI;

public class TreeElement {
	
	
	public FileProcessor filereader;
	public String searchstring;
	public String temp;
	Pattern pattern;
	Matcher matcher;
	public String[] splitstring;
	public String filecontent=new String();
	public Node root;
	
	public TreeElement(){
		root = null;
		
	}
	
	public void accept(TreeProcessingVisitorI visitor){
		visitor.visit(this);	
	}
	
	public Node getRoot() {
		return root;
	}

	public void setRoot(Node root) {
		this.root = root;
	}

	public void Treeoperations(FileProcessor filereaderIn){
		root=null;
		filereader=filereaderIn;
	}

	public void insert(String nodecontent){
		root=insert(root,nodecontent);
		this.setRoot(root);
		//System.out.println(root);

	}
	/**
	 * creates tree according to the input string
	 * @param node
	 * @param nodecontent
	 * @return
	 */

	private Node insert(Node node,String nodecontent) {
		if(node==null){
			Node newnode=new Node(nodecontent);
			//System.out.println(newnode.nodecontent);
			return newnode;
		}
		else if(node.nodecontent.compareTo(nodecontent)>0){
			node.left=insert(node.left,nodecontent);	
		}
		else if(node.nodecontent.compareTo(nodecontent)<0){
			node.right=insert(node.right,nodecontent);
		}
		else{
			node.count++;
		}
			
		return node;
	}
	
	
}