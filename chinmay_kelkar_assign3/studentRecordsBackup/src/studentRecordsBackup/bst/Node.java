package studentRecordsBackup.bst;

import java.util.HashMap;
import java.util.Map;

import studentRecordsBackup.util.BSTBuilder;
import studentRecordsBackup.util.OddEvenFilterI;

public class Node implements SubjectI,ObserverI{
 
	public int B_number; //stores B_number
	public Node left; //left subtree
	public Node right; //right subtree
	public boolean max_value; //max value
	public Node Subjectnode;
	public OddEvenFilterI filter; 
	public ObserverI observer;
	Map<Object,Object> observer_filter; //hashmap which stores observer and its corresponding filters
	
	/**
	 * creates subject node
	 * @param B_numberIn
	 */
	Node(int B_numberIn){
		//System.out.println("Subject node created");
		B_number=B_numberIn;
		left=null;
		right=null;
		max_value=false;
		observer_filter=new HashMap<Object,Object>();
		
	}
	/**
	 * creates observer node
	 * @param B_numberIn
	 * @param SubjectNodeIn
	 * @param filter
	 */
	Node(int B_numberIn, Node SubjectNodeIn, OddEvenFilterI filter)
	{
		//System.out.println("Observer node created");
		B_number=B_numberIn;
		//System.out.println(B_number);
		left=null;
		right=null;
		Subjectnode=SubjectNodeIn;
		Subjectnode.registerobserver(this, filter);
	
	}
	/*
	 * updates observer according to the update value
	 */
	@Override
	public void update(int update_value) {
		this.B_number=this.B_number+update_value;
		
	}
	
	/*
	 * 
	 * stores observer and filter reference in 
	 * the hashmap
	 */
	@Override
	public void registerobserver(ObserverI observer, OddEvenFilterI filter) {
	observer_filter.put(observer, filter);
		
		
	}
	/*
	 * removes observer and filter reference 
	 * from hashmap
	 */
	@Override
	public void removeobserver(ObserverI o) {
		observer_filter.remove(o);
		
	}
	/*
	 * notifies obseerver that change 
	 * has been made in mainBST
	 */
	@Override
	public void notifyobservers(int update_value) {
		for (Map.Entry<Object, Object> entry : observer_filter.entrySet()) {
			observer=(ObserverI) entry.getKey();
			filter=(OddEvenFilterI)entry.getValue();
			if(filter.check(update_value))
			{
				observer.update(update_value);
			}
		    //System.out.println("Key = " + observer + ", Value = " + filter);
		}
		
		
	}
}
