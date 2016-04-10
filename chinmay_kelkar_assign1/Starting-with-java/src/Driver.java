import java.util.ArrayList;

/**
 * Driver---main class 
 * @author Chinmay
 *
 */

public class Driver {
	public static String filecontent=new String(); //contains input file data
	public static ArrayList<String> outputlist=new ArrayList<String>(); //contains most frequently occuring elements
	public static String temp; //temporary string to store read line
	
	public static String getFilecontent() {
		return filecontent;
	}

	public static void setFilecontent(String filecontent) {
		Driver.filecontent = filecontent;
	}

	public static ArrayList<String> getOutputlist() {
		return outputlist;
	}

	public static void setOutputlist(ArrayList<String> outputlist) {
		Driver.outputlist = outputlist;
	}

	public static String getTemp() {
		return temp;
	}

	public static void setTemp(String temp) {
		Driver.temp = temp;
	}
	/**
	 * prints most frequently
	 * occuring element.
	 * @param args--A string containing
	 * file name.
	 * @throws Exception--invalid path exception.
	 */

	public static void main(String[] args) throws Exception{

		String filename=null;
		try
		{
			if(args.length>0)
			{
				filename = args[0];
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}

		FileProcessor fprocess= new FileProcessor(filename);
		StringOperations str=new StringOperations();

		while((temp=fprocess.readLineFromFile())!= null)
		{
			filecontent=filecontent+" "+temp;
		}
		str.splitstring(filecontent);
		str.process();
		outputlist=str.most_frequent_element();
		for(int i=0;i<outputlist.size();i++)
		{
			System.out.println("The most frequently occuring element is "+outputlist.get(i)+". "+"It appeares "+StringOperations.maxvalue+" times.");
		}
	}

	
}
