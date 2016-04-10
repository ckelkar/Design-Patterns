import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * StringOperations--performs string 
 * operations
 * @author Chinmay
 *
 */
public class StringOperations {
	public static HashMap<String,Integer> container= new HashMap<String,Integer>(); //stores element and its count
	public ArrayList<String> maxkeys=new ArrayList<String>(); //contains most frequently occuring elements
	public static int maxvalue=0; //stores maximum count
	public static String[] split_string; //contains input data after split
	public String[] elementkey; // contains element with some garbage
	public String key; //contains element
	Driver driver=new Driver();
	
	public static HashMap<String, Integer> getContainer() {
		return container;
	}

	public static void setContainer(HashMap<String, Integer> container) {
		StringOperations.container = container;
	}

	public ArrayList<String> getMaxkeys() {
		return maxkeys;
	}

	public void setMaxkeys(ArrayList<String> maxkeys) {
		this.maxkeys = maxkeys;
	}

	public static int getMaxvalue() {
		return maxvalue;
	}

	public static void setMaxvalue(int maxvalue) {
		StringOperations.maxvalue = maxvalue;
	}

	public static String[] getSplit_string() {
		return split_string;
	}

	public static void setSplit_string(String[] split_string) {
		StringOperations.split_string = split_string;
	}

	public String[] getElementkey() {
		return elementkey;
	}

	public void setElementkey(String[] elementkey) {
		this.elementkey = elementkey;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public Driver getDriver() {
		return driver;
	}

	public void setDriver(Driver driver) {
		this.driver = driver;
	}
	
	/**
	 * split input data
	 * in order for further
	 * processing.
	 * @param filecontent-- input data.
	 */
	public void splitstring(String filecontent)
	{
		split_string=filecontent.split(" ");
	}
	
	/**
	 * processes input file 
	 * and forms hashmap
	 * containing key as element
	 * and value as frequency count.
	 */
	public void process()
	{
		for(int i=0;i<split_string.length;i++)
		{

			if(split_string[i].contains("name"))
			{

				if(split_string[i-1].contains("xs:element"))
				{
					elementkey=split_string[i].split("=");
					key= elementkey[1].replaceAll("[^a-zA-Z]","");
					if(container.containsKey(key))
					{
						container.put(key,container.get(key)+ 1);
					}
					else
					{
						container.put(key,1);
					}
				}
			}
		}
	}

	/**
	 * Finds element with 
	 * maximum occurance
	 * and checks hashmap
	 * for the elements with 
	 * same occurance.
	 * @return arraylist containing 
	 * maximum occuring elements.
	 * 
	 */
	public ArrayList<String> most_frequent_element()
	{
		int counter=0; //index of arraylist
		for(String key: container.keySet())
		{
			if(container.get(key)>=maxvalue)
			{
				maxvalue=container.get(key);
			}
		}
		for(Map.Entry<String, Integer> entry:container.entrySet())
		{

			if(entry.getValue().equals(maxvalue))
			{
				maxkeys.add(counter, entry.getKey());
				counter++;
			}
		}
		return maxkeys;
	}
}
