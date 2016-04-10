
package primeThreads.store;

import java.util.ArrayList;
import primeThreads.util.Logger;

/**
 * Results--adds elements
 * to arraylist and displays
 * result
 * @author Chinmay
 *
 */

public class Results implements StdoutDisplayInterface,AddtoArraylistInterface {
	
  
	private ArrayList<Integer> primenumbers=new ArrayList<Integer>(); //stores elements
	public int sum=0; //stores sum of numbers
	public ArrayList<Integer> getPrimenumbers() {
		return primenumbers;
	}

	public void setPrimenumbers(ArrayList<Integer> primenumbers) {
		this.primenumbers = primenumbers;
	}

	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}
	
	/**
	 * synchronized method to
	 * add elements in arraylist 
	 * in arraylist
	 */
	public synchronized void addtoarraylist(int temp)
	{
		Logger.writeMessage("Entry "+temp+" added to datastructure", Logger.DebugLevel.DATASTRUCTURE);
		primenumbers.add(temp);
		
	}

	/**
	 * retrives element
	 * from arraylist
	 * and calculates sum
	 */
	public void writeSumToScreen() {
    	
	StringBuilder datastructurecontent=new StringBuilder(); //stores content of arraylist
	datastructurecontent.append("The contents in the datastructure are:");
    	for(int i=0;i<primenumbers.size();i++)
    	{
    		sum=sum+primenumbers.get(i);
    		datastructurecontent.append(primenumbers.get(i)+",");
    	}
    	Logger.writeMessage(datastructurecontent.toString(), Logger.DebugLevel.CONTENT);
    	Logger.writeMessage("The sum of all prime numbers is "+sum, Logger.DebugLevel.NOOUPUT);
    }
} 


