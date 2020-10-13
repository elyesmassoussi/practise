
/**
 * Décrivez votre classe CodonCount ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
import edu.duke.*;
import java.util.*;
public class CodonCount {
private HashMap<String,Integer> codonTracker ;
public CodonCount()
{
    codonTracker= new HashMap<String,Integer>() ;
}
public void buildCodonMap(int start,String dna)
{
    codonTracker.clear();
    int end= start+3;
    while(end<=dna.length())
    {
        String s=dna.substring(start,end);
        if (!codonTracker.containsKey(s))
        {
	   codonTracker.put(s,1);
	}
	else 
	{
	   codonTracker.put(s,codonTracker.get(s)+1);
	}
        start+=3;
        end+=3;
    }
}
public void test()
{
   for(String s: codonTracker.keySet())
   {   System.out.println(s);
       System.out.println(codonTracker.get(s));
   }
}
public String getMostCommonCodon()
{    int max=0 ;
    String codon="";
    for(String s: codonTracker.keySet())
    {
        if(codonTracker.get(s)>max)
        {
            codon=s;
            max= codonTracker.get(s);
        }
    }
    return codon;
}
public void printCodonCounts(int start,int end)
{
    for(String s: codonTracker.keySet())
    { int value=codonTracker.get(s);
        if(value>=start && value<=end)
        {
          System.out.println(s+"\t"+value);
        }
    }
}
public void tester()
{
    FileResource fr= new FileResource();
    String content= fr.asString() ;
    content= content.toUpperCase();
    content= content.trim();
    buildCodonMap(0,content);
    System.out.println(codonTracker.size());
    //String codon = getMostCommonCodon();
    //System.out.println(codon+"\t"+codonTracker.get(codon));
    printCodonCounts(7,7);
}
}
