
package primeThreads.util;

/**
 * Logger--displays logging
 * @author Chinmay
 *
 */
public class Logger{
    public static enum DebugLevel { CONSTRUCTOR,RUN,DATASTRUCTURE,CONTENT,NOOUPUT
                                   }; //debug level is chosen

    private static DebugLevel debugLevel; //stores debuglevel

    /**
     * sets debugLevel 
     * according to the input
     * using switch case
     * @param levelIn
     */
    public static void setDebugValue (int levelIn) {
	switch (levelIn) {
	  case 4: debugLevel = DebugLevel.CONSTRUCTOR; break;
	  case 3: debugLevel=DebugLevel.RUN;break;
	  case 2:debugLevel=DebugLevel.DATASTRUCTURE;break;
	  case 1:debugLevel=DebugLevel.CONTENT;break;
	  case 0:debugLevel=DebugLevel.NOOUPUT;break;
	  
	}
    }
    /**
     * sets debugvalue
     * @param levelIn
     */
    public static void setDebugValue (DebugLevel levelIn) {
	debugLevel = levelIn;
    }

    // @return None
    public static void writeMessage (String     message  ,
                                     DebugLevel levelIn ) {
	if (levelIn == debugLevel)
	    System.out.println(message);
    }

    public String toString() {
	return "Debug Level is " + debugLevel;
    }
}
