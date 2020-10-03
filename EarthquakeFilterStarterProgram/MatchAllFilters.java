
/**
 * Décrivez votre classe MatchAllFilters ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
import java.util.*;
import edu.duke.*;
public class MatchAllFilters implements Filter{
 private ArrayList<Filter> filters ;
 public MatchAllFilters()
 {
     filters= new ArrayList<Filter>();
 }
 public void addFilter(Filter f)
 {
     filters.add(f);
 }
 public boolean satisfies(QuakeEntry qe)
 {   boolean result=true;
     int i=0;
     while(result  && i<filters.size())
     {
         if(!filters.get(i).satisfies(qe))
         result=false;
         i++;
     }
     return result;
 }
 public String getName()
  {
      String result="";
      for(Filter f:filters)
      {
          result+=f.getName();
      }
      return result;
  }
}
