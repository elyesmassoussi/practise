
/**
 * Décrivez votre classe WordsLengths ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
import edu.duke.* ;
public class WordsLengths {
public void countWordLengths(FileResource resource, int[] counts)
{
    for(String word : resource.words()){  	
     int wordlength = word.length(); 
     if (Character.isLetter(word.charAt(word.length()-1)) == false) {
     wordlength--;
     }
     if (wordlength >= counts.length) {  	    	   
          wordlength = counts.length - 1;  	  	
     }  	
     if (wordlength > 0 ) {  	   	   
          counts[wordlength] ++;  	  	
     }
}
}
public void testCountWordLengths()
{
    FileResource file= new FileResource();
    int[] counts= new int[31];
    countWordLengths(file,counts);
    int total=0;
    for(int i=0;i<counts.length;i++)
    {    
        System.out.println(counts[i]+ " " +i);
        total+= counts[i];
    }
    System.out.println(total);
}
}
