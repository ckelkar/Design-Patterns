
package primeThreads.threadMgmt;

import java.util.ArrayList;

import primeThreads.store.Results;
import primeThreads.store.StdoutDisplayInterface;
import primeThreads.util.FileProcessor;
import primeThreads.util.IsPrime;
import primeThreads.util.Logger;

/**
 * creates threads 
 * according to the
 * input number of threads
 * @author Chinmay
 *
 */
public class CreateWorkers  {
	Results res;
	IsPrime is;
	FileProcessor fp;
	StdoutDisplayInterface inter;
	
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

	public StdoutDisplayInterface getInter() {
		return inter;
	}

	public void setInter(StdoutDisplayInterface inter) {
		this.inter = inter;
	}

	/**
	 * sets values accordingly
	 * @param isprimeIn
	 * @param fpIn
	 * @param interIn
	 */
	public CreateWorkers(IsPrime isprimeIn,FileProcessor fpIn, StdoutDisplayInterface interIn)
	{
		Logger.writeMessage("In the CreateWorkers constructor", Logger.DebugLevel.CONSTRUCTOR);
		is=isprimeIn;
		fp=fpIn;
		inter=interIn;
	}
	
	/**
	 *creates number of threads
	 *starts it's execution
	 * @param Num_Threads -input number of threads
	 * @throws InterruptedException 
	 */
	public void startWorkers(int Num_Threads) throws InterruptedException{
		ArrayList<Thread> thread_collection=new ArrayList<Thread>();
		
		for(int i=0;i<Num_Threads;i++){
			Thread t;
			t=new Thread(new WorkerThread(is,fp,inter));
			thread_collection.add(t);
			t.start();
			}
		
		for (int i=0;i<Num_Threads;i++)
		{
			thread_collection.get(i).join();
		}
	
	}


}