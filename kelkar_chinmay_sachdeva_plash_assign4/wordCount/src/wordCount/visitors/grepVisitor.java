package wordCount.visitors;

import java.io.IOException;

import wordCount.treesForStrings.Node;
import wordCount.treesForStrings.TreeElement;
import wordCount.util.FileProcessor;

public class grepVisitor implements TreeProcessingVisitorI{
	int searchcount=0;
	String searchstring;
	FileProcessor filereader;
	
	public grepVisitor(FileProcessor filereaderIn,String searchstringIn){
		searchstring=searchstringIn;
		filereader=filereaderIn;
	}

	@Override
	public void visit(TreeElement tree) {
		
		try{
			this.searchstring(tree);
		}catch(Exception e){
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		
	}
	
	public void searchstring(TreeElement tree) throws IOException{
		
		this.search(searchstring,tree.root);
	}
	
	/**
	 * creates to the outputstring
	 * and writes to output file
	 * @param inputstring
	 * @param node
	 * @throws IOException
	 */
	public void search(String inputstring,Node node) throws IOException{
		String output;
		searchstring(inputstring,node);
		output="The word <"+inputstring+"> occurs the following times: "+searchcount;
		filereader.filewriter(output);
			
	}
	
	
	/**
	 * search the input string
	 * and calculates how many times 
	 * it occurs
	 * @param inputstring
	 * @param node
	 */
	public void searchstring(String inputstring,Node node) {
		if(node==null){
			return;
		}
		searchstring(inputstring,node.left);
			if(node.nodecontent.compareTo(inputstring)==0){
				searchcount=node.count;
				return;
			}
		searchstring(inputstring,node.right);
	
}

	

}
