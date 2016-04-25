package wordCount.util;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * FileProcessor--Checks for valid 
 * filename and read file one
 * line at a time.
 * @author Chinmay
 *
 */
public class FileProcessor {
	public BufferedReader buffer; //intermediate buffer 
	public FileWriter writer;
	public BufferedWriter filewriter;
	public BufferedReader getBuffer() {
		return buffer;
	}
	public void setBuffer(BufferedReader buffer) {
		this.buffer = buffer;
	}
	
	/**
	 * Checks for the input file 
	 * name and initiates buffer.
	 * @param filename input file name.
	 * @throws IOException 
	 * @throws FileNotFoundException.
	 */
	public FileProcessor(String filename,String outputfile) throws IOException {
		try
		{
			buffer= new BufferedReader(new FileReader(filename));
			writer=new FileWriter(outputfile);
			filewriter = new BufferedWriter(writer);
		
			
			
		}
		catch(FileNotFoundException e)
		{
			System.err.println(e);
			System.exit(1);
		}
		
	}
		
	
	/**
	 * Reads input file 
	 * line by line.
	 * @return A line in 
	 * input file.
	 * @throws Exception.
	 */
	public String readLineFromFile() throws Exception
	{
		String line = buffer.readLine();
		return line;
	}
	
	public void filewriter(String output) throws IOException{
		
			//System.out.println(output);
			filewriter.write(output);
	
	}
	
	public void close() throws IOException{
		
		filewriter.close();
	}
	
	public void closebufferreader() throws IOException{
		buffer.close();
	}
	
}
