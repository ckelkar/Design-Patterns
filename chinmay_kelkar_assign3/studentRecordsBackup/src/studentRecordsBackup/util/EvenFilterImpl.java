package studentRecordsBackup.util;

/**
 * checks for the update value for even integer
 * @author Chinmay
 *
 */
public class EvenFilterImpl implements OddEvenFilterI {

	@Override
	public boolean check(int update_value) {
		if(update_value % 2==0){
			return true;
		}
		
		return false;
	}

}
