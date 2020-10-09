
/**
 * Décrivez votre classe EfficientMarkovModel ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
import java.util.*;
public class EfficientMarkovModel extends AbstractMarkovModel{
        private int model;
        HashMap<String,ArrayList<String>> map ;
	public EfficientMarkovModel(int n) {
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
	public String toString()
	{
	    return "MarkovModel of order " +model+ ".";
	}
	public void printHashMapInfo()
	{
	    for(String s:map.keySet())
	    {
	        System.out.println(s+" : ");
	        /*for(String p:map.get(s))
	        {
	            System.out.print("["+p+"]");
	        }
	        System.out.println();*/
	        System.out.println(map.get(s).size());
	    }
	    System.out.println(map.size());
	}
	public void buildMap()
	{   map=new HashMap<String,ArrayList<String>>();
	    for(int i=0;i<myText.length()-model;i++)
	    {
	        
	        String s=myText.substring(i,i+model);
	        if(!map.containsKey(s))
	        {
	            ArrayList<String> follows= new ArrayList<String>();
	            follows.add(myText.substring(i+model,i+model+1));
	            map.put(s,follows);
	        }
	        else
	        {
	            ArrayList<String> follows= map.get(s); 
	            follows.add(myText.substring(i+model,i+model+1));
	            map.put(s,follows);
	        }
	    }
	    
	}
	public ArrayList<String> getFollows(String key)
	{
	    return map.get(key);
	}
}
