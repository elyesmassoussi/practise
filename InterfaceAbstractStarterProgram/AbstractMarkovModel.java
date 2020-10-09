
/**
 * Abstract class AbstractMarkovModel - write a description of the class here
 * 
 * @author (your name here)
 * @version (version number or date here)
 */

import java.util.*;

public abstract class AbstractMarkovModel implements IMarkovModel {
    protected String myText;
    protected Random myRandom;
    
    public AbstractMarkovModel() {
        myRandom = new Random();
    }
    public void setRandom(int seed){
		myRandom = new Random(seed);
    }
    public void setTraining(String s) {
        myText = s.trim();
    }
    abstract public String getRandomText(int numChars);
    protected ArrayList<String> getFollows(String key)
	{
	    ArrayList<String> result= new ArrayList<String>();
	    int i=0;
	    int index=myText.indexOf(key,i);
	    int size=myText.length()-key.length();
	    while(index<size&&index!=-1)
	    {  int starter= index+key.length();
	       result.add(myText.substring(starter,starter+1));
	       i=index+1;
	       index=myText.indexOf(key,i);
	    }
	    return result;
	}
}
