
/**
 * Décrivez votre classe MagnitudeFilter ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class MagnitudeFilter implements Filter{
  private double minimumMag;
  private double maximumMag;
  public MagnitudeFilter(double min, double max)
  {
      minimumMag= min;
      maximumMag= max;
  }
  public boolean satisfies(QuakeEntry qe) { 
        return (qe.getMagnitude() >= minimumMag && qe.getMagnitude() <= maximumMag) ; 
  }
  public String getName()
  {
      return "Magnitude ";
  }
}
