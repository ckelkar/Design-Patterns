package wordCount.visitors;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import wordCount.treesForStrings.Node;
import wordCount.treesForStrings.TreeElement;
import wordCount.util.FileProcessor;

public class WordCountVisitor implements TreeProcessingVisitorI {
	int wordcount=0; //stores wordcount
	int charactercount=0; //stores charactercount
	int maxcount=0;// stores maxelement
	int searchcount=0;// stores how many times input string occurs
	int i=0; 
	String maxstring=null; //stores maximum string
	ArrayList<String> maxelementlist; //stores strings with maxcount
	public Node root; 
	FileProcessor filereader;
	HashMap<Integer,ArrayList<String>> maxelementhashmap;
	
	public WordCountVisitor(FileProcessor filereaderIn) {
		filereader=filereaderIn;
		maxelementhashmap=new HashMap<Integer,ArrayList<String>>();
	}
	@Override
	public void visit(TreeElement tree) {
		
		try{
			this.wordfrequency(tree);
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	public void wordfrequency(TreeElement tree) throws IOException{
		//root=.getRoot();
		//tree.inorder(root);
		this.calculatecount(tree.root);
		
	}
	
	/**
	 * calls calculatecount1,
	 * creates outputstring and writes
	 * to the output file
	 * @param node
	 * @throws IOException
	 */
	public void calculatecount(Node node) throws IOException {
		String wordcountvisitoroutput;
			calculatecount1(node);
			wordcountvisitoroutput="The total number of words is: "+wordcount+System.getProperty("line.separator");
			wordcountvisitoroutput=appendhashmap(wordcountvisitoroutput,maxelementhashmap);
			wordcountvisitoroutput=wordcountvisitoroutput+"The frequency of the most frequently used word is: "+maxcount+System.getProperty("line.separator");
			wordcountvisitoroutput=wordcountvisitoroutput+"The number of characters (without whitespaces) is: "+charactercount+System.getProperty("line.separator");
			filereader.filewriter(wordcountvisitoroutput);
		}

	/**
	 * calculates all counts
	 * @param node
	 */
	public void calculatecount1(Node node){
		if(node==null){
			return;
			
		}
		calculatecount1(node.left);
			if(node.count >= maxcount){
				
				maxcount=node.count;
				
				maxstring=node.nodecontent;
					if(!maxelementhashmap.containsKey(node.count)){
						maxelementlist=new ArrayList<String>();
						maxelementlist.add(node.nodecontent);
						maxelementhashmap.put(node.count,maxelementlist);

					}
					else{
				
						maxelementlist.add(node.nodecontent);
						maxelementhashmap.put(node.count,maxelementlist);
					}
			}
		wordcount=wordcount+node.count;
		charactercount=charactercount+node.nodecontent.length()*node.count;
		calculatecount1(node.right);
		
}		
	
	/**
	 * retrieves hashmapcintent and appends it to
	 * the input string
	 * @param wordcountvisitoroutput
	 * @param maxelementhashmap2
	 * @return
	 */
	private String appendhashmap(String wordcountvisitoroutput,
			HashMap<Integer, ArrayList<String>> maxelementhashmap) {
		if(!maxelementhashmap.isEmpty()){
			int j=0;
			while(j!=maxelementhashmap.get(maxcount).size()){
				wordcountvisitoroutput=wordcountvisitoroutput+"The most frequently used word is: "+maxelementhashmap.get(maxcount).get(j)+System.getProperty("line.separator");
				j++;
			}
		}
		else
		{
			wordcountvisitoroutput=wordcountvisitoroutput+"The most frequently used word is:"+System.getProperty("line.separator");
		}
		
		
		return wordcountvisitoroutput;
	}

}
