
/**
 * Décrivez votre classe tester ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
import java.util.*;
import edu.duke.*;
public class tester {
   public void testGetFollows()
   {   String s="this is a test yes this is a test.";
       MarkovOne mo= new MarkovOne();
       mo.setTraining(s);
       ArrayList<String> result=mo.getFollows("t.");
       for(String ss:result)
       {
           System.out.println(ss);
       }
   }
   public void testGetFollwosWithFile()
   {
       FileResource fr = new FileResource();
       String st = fr.asString();
       st = st.replace('\n', ' ');
       MarkovOne markov = new MarkovOne();
       markov.setTraining(st);
       ArrayList<String> result=markov.getFollows("he");
       System.out.println(result.size());
   }
}
