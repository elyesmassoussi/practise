
/**
 * Décrivez votre classe TitleLastAndMagnitudeComparator ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
import java.util.*;
public class TitleLastAndMagnitudeComparator implements Comparator<QuakeEntry>{
   public int compare(QuakeEntry q1,QuakeEntry q2)
   {
       String[] sq1= new String[q1.getInfo().split("\\W+").length];
       sq1=q1.getInfo().split("\\W+");
       String[] sq2= new String[q2.getInfo().split("\\W+").length];
       sq2=q2.getInfo().split("\\W+");
       if(sq1[sq1.length-1].compareTo(sq2[sq2.length-1])<0)
       return -1;
       if(sq1[sq1.length-1].compareTo(sq2[sq2.length-1])>0)
       return 1;
       else
       {
           if(q1.getMagnitude()<q2.getMagnitude())
           return -1;
           if(q1.getMagnitude()>q2.getMagnitude())
           return 1 ;
       }
       return 0;
   }
}
