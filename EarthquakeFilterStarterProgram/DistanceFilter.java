
/**
 * Décrivez votre classe DistanceFilter ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class DistanceFilter implements Filter{
  private Location myLocation ;
  private float maximumDistance ;
  public DistanceFilter(Location loc,float maxDis)
  {
      myLocation=loc;
      maximumDistance= maxDis;
  }
  public boolean satisfies(QuakeEntry qe)
  {
      return myLocation.distanceTo(qe.getLocation())<maximumDistance ;
  }
  public String getName()
  {
      return "Distance ";
  }
}
