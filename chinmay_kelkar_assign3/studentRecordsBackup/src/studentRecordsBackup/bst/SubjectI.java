package studentRecordsBackup.bst;

import studentRecordsBackup.util.OddEvenFilterI;

/*
 * subject interface 
 */
public interface SubjectI {

	public void registerobserver(ObserverI o,OddEvenFilterI f);
	public void removeobserver(ObserverI o);
	public void notifyobservers(int update_value);
	
}
