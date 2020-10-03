
/**
 * Décrivez votre classe PhraseFilter ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class PhraseFilter implements Filter{
  private String where ;
  private String phrase;
  public PhraseFilter(String w , String p)
  {
      where=w;
      phrase=p;
  }
  public boolean satisfies(QuakeEntry qe)
  {
      switch(where)
      {
          case "start" :
          {
              return (qe.getInfo().startsWith(phrase));
          }
          case "end" :
          {
              return (qe.getInfo().endsWith(phrase));
          }
          case "any" :
          {
              return (qe.getInfo().indexOf(phrase)!=-1 ? true: false);
          }
      }
      return false;
  }
  public String getName()
  {
      return "Phrase ";
  }
}
