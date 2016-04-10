
package primeThreads.threadMgmt;
import primeThreads.store.AddtoArraylistInterface;
import primeThreads.store.Results;
import primeThreads.store.StdoutDisplayInterface;
import primeThreads.util.FileProcessor;
import primeThreads.util.IsPrime;
import primeThreads.util.Logger;

/**
 * executes each thread and 
 * adds integer to the arraylist
 * if it is prime
 * @author Chinmay
 *
 */
public class WorkerThread implements Runnable  {
	
	Results res;
	IsPrime is;
	FileProcessor fp;
	AddtoArraylistInterface add; //instance of AddtoArraylistInterface
	boolean checkprime; //checks for prime number
	/**
	 * sets elements acccordingly
	 * @param isprimeIn
	 * @param fpIn
	 * @param interIn
	 */
	public WorkerThread(IsPrime isprimeIn,FileProcessor fpIn,StdoutDisplayInterface interIn){
		Logger.writeMessage("In the WorkerThread constructor", Logger.DebugLevel.CONSTRUCTOR);
		is=isprimeIn;
		fp=fpIn;
		add=(AddtoArraylistInterface)interIn;
	}
	
	public Results getRes() {
		return res;
	}

	public void setRes(Results res) {
		this.res = res;
	}

	public IsPrime getIs() {
		return is;
	}

	public void setIs(IsPrime is) {
		this.is = is;
	}

	public FileProcessor getFp() {
		return fp;
	}

	public void setFp(FileProcessor fp) {
		this.fp = fp;
	}

	
	public boolean isCheckprime() {
		return checkprime;
	}

	public void setCheckprime(boolean checkprime) {
		this.checkprime = checkprime;
	}
/**
 * executes each thread, checks
 * for prime(odd) number and
 * adds to arraylist
 * if it is prime
 */
	public void run() {
		Logger.writeMessage("In run method", Logger.DebugLevel.RUN);
		String temp = null;
		try {
			
		
			while((temp=fp.readLineFromFile())!=null) //reads line from file
			{
				checkprime=is.checkprime(Integer.parseInt(temp));
					if(checkprime==true)
					{
						add.addtoarraylist(Integer.parseInt(temp));
					}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	
    }
    

}