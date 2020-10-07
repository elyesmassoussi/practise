
/**
 * Décrivez votre classe MarkovModel ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
import java.util.*;
public class MarkovModel {
    private String myText;
    private Random myRandom;
    private int model;
	public MarkovModel(int n) {
		myRandom = new Random();
		model=n;
	}
	
	public void setRandom(int seed){
		myRandom = new Random(seed);
	}
	
	public void setTraining(String s){
		myText = s.trim();
	}
	
	public String getRandomText(int numChars){
		if (myText == null){
			return "";
		}
		StringBuilder sb = new StringBuilder();
		int index = myRandom.nextInt(myText.length()-model);
		String key= myText.substring(index,index+model);
		sb.append(key);
		for(int k=0; k < numChars-model; k++){
		  ArrayList<String> follows=getFollows(key);
		  index = myRandom.nextInt(follows.size());
		  String next= follows.get(index);
		  sb.append(next);
		  key= key.substring(1)+next;
		  
		}
		return sb.toString();
	}
	public ArrayList<String> getFollows(String key)
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
