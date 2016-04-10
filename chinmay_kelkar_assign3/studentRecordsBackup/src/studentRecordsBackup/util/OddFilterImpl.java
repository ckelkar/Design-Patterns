package studentRecordsBackup.util;

import studentRecordsBackup.bst.Node;

/**
 * checks for the odd update value
 * @author Chinmay
 *
 */
public class OddFilterImpl implements OddEvenFilterI{

	@Override
	public boolean check(int update_value) {
		if(update_value %2 !=0){
			return true;
		}
		
		return false;
	}
	

}
