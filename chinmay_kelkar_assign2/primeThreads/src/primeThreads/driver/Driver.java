
package primeThreads.driver;

import java.io.File;
import java.io.IOException;

import primeThreads.store.Results;
import primeThreads.store.StdoutDisplayInterface;
import primeThreads.threadMgmt.CreateWorkers;
import primeThreads.util.FileProcessor;
import primeThreads.util.IsPrime;
import primeThreads.util.Logger;

/**
 * Driver--main class
 * @author Chinmay
 *
 */
public class Driver{
	 
	public static void main(String args[]) throws InterruptedException, IOException,NumberFormatException {
		int NUM_THREADS; //defines number of threads
		
		try{ //checks for valid arguments
			Integer.parseInt(args[1]);
			Integer.parseInt(args[2]);	
		}catch(NumberFormatException e)
		{
			System.err.println("Invalid input!!");
			System.exit(0);
		}
		
		if(args.length!=3 || Integer.parseInt(args[1])>5 || Integer.parseInt(args[2])>4){ //checks for valid arguments
			System.err.println("Invalid input!!");
			System.exit(0);
		}
		
		
			
			Logger.setDebugValue(Integer.parseInt(args[2]));
			NUM_THREADS=Integer.parseInt(args[1]);
			IsPrime isprime=new IsPrime(); //object of Isprime class
			StdoutDisplayInterface inter=new Results(); //object of results with reference of StdoutDisplayInterface
			FileProcessor fp=new FileProcessor(args[0]); //object of fileprocessor
			CreateWorkers worker=new CreateWorkers(isprime,fp,inter);
			worker.startWorkers(NUM_THREADS);
			inter.writeSumToScreen();
				


	} // end main(...)

} // end public class Driver

