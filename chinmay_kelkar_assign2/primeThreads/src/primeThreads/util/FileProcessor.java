package primeThreads.util;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * FileProcessor--Checks for valid 
 * filename and read file one
 * line at a time.
 * @author Chinmay
 *
 */
public class FileProcessor {
	public BufferedReader buffer; //intermediate buffer 
	
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
	 * @throws FileNotFoundException.
	 */
	public FileProcessor(String filename) throws FileNotFoundException {
		Logger.writeMessage("In the FileProcessor constructor", Logger.DebugLevel.CONSTRUCTOR);
		try
		{
			buffer= new BufferedReader(new FileReader(filename));
		}
		catch(FileNotFoundException e)
		{
			System.out.println(e);
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
}
