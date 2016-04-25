package wordCount.driver;
import wordCount.util.FileProcessor;
import wordCount.visitors.PopulateTreeVisitor;
import wordCount.visitors.WordCountVisitor;
import wordCount.visitors.grepVisitor;
import wordCount.treesForStrings.TreeElement;
/**
 * main class: does exception
 * handling, creates element object,
 * visitor objects and calls corresponding
 * methods
 * @author Chinmay
 *
 */
public class Driver {
	
	public static void main(String[] args) throws Exception{
		int NUM_ITERATION=0; //total number of iterations
		String filename; //input filename
		String outputfile; //output filename
		
		try{
			Integer.parseInt(args[2]);
		}
		catch(NumberFormatException e){
			System.err.println("Please enter numeric input for number of iterations");
			System.exit(0);
		}
		
		if(args.length!=4){
			System.err.println("Invalid input");
			System.exit(0);
		}
		
		
		filename=args[0].toString();
		outputfile=args[1].toString();
		NUM_ITERATION=Integer.parseInt(args[2]);
		
		long startTime = System.currentTimeMillis();
		
		
		  for(int i=0;i<NUM_ITERATION;i++){
			  	FileProcessor fileobj=new FileProcessor(filename,outputfile);
			  	TreeElement treeelement= new TreeElement();
			    PopulateTreeVisitor populate= new PopulateTreeVisitor(fileobj); 
				WordCountVisitor wordcount=new WordCountVisitor(fileobj);
				grepVisitor grep=new grepVisitor(fileobj,args[3].toString());
				treeelement.accept(populate);
				fileobj.closebufferreader();
				treeelement.accept(wordcount);
				treeelement.accept(grep);
				fileobj.close();
		  }
		   
		long finishTime = System.currentTimeMillis();
		float total_time =(float)((finishTime-startTime)/NUM_ITERATION);
		System.out.println("total time taken="+total_time+" milliseconds");

		
			
	}

}
