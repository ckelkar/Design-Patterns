package wordCount.visitors;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import wordCount.treesForStrings.TreeElement;
import wordCount.util.FileProcessor;

public class PopulateTreeVisitor implements TreeProcessingVisitorI {
	public FileProcessor filereader;
	public String temp;
	Pattern pattern;
	Matcher matcher;
	
	public PopulateTreeVisitor(FileProcessor filereaderIn){
		filereader=filereaderIn;
	}

	@Override
	public void visit(TreeElement treeobj) {
		try {
			this.createtree(treeobj);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * reads input and 
	 * creates tree
	 * @throws Exception
	 */
	public void createtree(TreeElement tree) throws Exception{
		
		
		while((temp=filereader.readLineFromFile())!=null){
			//filecontent=filecontent+temp+" ";
			pattern=Pattern.compile("\\s+");
			matcher=pattern.matcher(temp);
			temp=matcher.replaceAll(" ");
			//System.out.println(temp);
			if(!temp.isEmpty()){
				pattern=Pattern.compile("[a-zA-Z]+|[0-9]+");
				matcher=pattern.matcher(temp);
				while(matcher.find()){
					tree.insert(matcher.group());	
				}
			}
		}

	}
}
