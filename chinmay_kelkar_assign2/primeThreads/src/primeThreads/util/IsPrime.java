
package primeThreads.util;

/**
 * IsPrime--checks 
 * for prime number
 * @author Chinmay
 *
 */
public class IsPrime {
	public IsPrime(){
		Logger.writeMessage("In the IsPrime constructor", Logger.DebugLevel.CONSTRUCTOR);
	}
	/**
	 * checks for prime 
	 * number
	 * @param temp--input number
	 * @return
	 */
public boolean checkprime(int temp)
{
	if(temp%2!=0)
	{
		return true;
	}
	else
	{
		return false;
	}
}

}
