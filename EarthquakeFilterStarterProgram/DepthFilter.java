
/**
 * Décrivez votre classe DepthFilter ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class DepthFilter implements Filter{
  private double minimumDepth;
  private double maximumDepth;
  public DepthFilter(double min, double max)
  {
      minimumDepth= min;
      maximumDepth= max;
  }
  public boolean satisfies(QuakeEntry qe) { 
        return (qe.getDepth() >= minimumDepth && qe.getDepth() <= maximumDepth) ; 
  }
  public String getName()
  {
      return "Depth ";
  }
}
