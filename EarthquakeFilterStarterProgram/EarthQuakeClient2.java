import java.util.*;
import edu.duke.*;

public class EarthQuakeClient2 {
    public EarthQuakeClient2() {
        // TODO Auto-generated constructor stub
    }

    public ArrayList<QuakeEntry> filter(ArrayList<QuakeEntry> quakeData, Filter f) { 
        ArrayList<QuakeEntry> answer = new ArrayList<QuakeEntry>();
        for(QuakeEntry qe : quakeData) { 
            if (f.satisfies(qe)) { 
                answer.add(qe); 
            } 
        } 
        
        return answer;
    } 

    public void quakesWithFilter() { 
        EarthQuakeParser parser = new EarthQuakeParser(); 
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        String source = "data/nov20quakedata.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);         
        System.out.println("read data for "+list.size()+" quakes");

        Filter mf = new MagnitudeFilter(3.5,4.5); 
        Filter df = new DepthFilter(-55000.0,-20000.0);
        // Location loc=new Location(39.7392,-104.9903); 
        //Filter ddf= new DistanceFilter(loc,1000000);
        //Filter  pf= new PhraseFilter("end","a");
        ArrayList<QuakeEntry> m7  = filter(list, mf); 
        m7= filter(m7,df);
        System.out.println(m7.size()+" found");
        for (QuakeEntry qe: m7) { 
            System.out.println(qe);
        } 
    }

    public void createCSV() {
        EarthQuakeParser parser = new EarthQuakeParser();
        //String source = "../data/nov20quakedata.atom";
        String source = "data/nov20quakedatasmall.atom";
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        dumpCSV(list);
        System.out.println("# quakes read: "+list.size());
    }

    public void dumpCSV(ArrayList<QuakeEntry> list) {
        System.out.println("Latitude,Longitude,Magnitude,Info");
        for(QuakeEntry qe : list){
            System.out.printf("%4.2f,%4.2f,%4.2f,%s\n",
                qe.getLocation().getLatitude(),
                qe.getLocation().getLongitude(),
                qe.getMagnitude(),
                qe.getInfo());
        }
    }
    public void testMatchAllFilters()
    {
        EarthQuakeParser parser = new EarthQuakeParser(); 
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        String source = "data/nov20quakedata.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);         
        System.out.println("read data for "+list.size()+" quakes");
        MatchAllFilters maf= new MatchAllFilters() ;
        Filter mf = new MagnitudeFilter(0.0,4.0); 
        Filter df = new DepthFilter(-180000.0,-30000.0);
        Filter  pf= new PhraseFilter("any","o");
        maf.addFilter(mf);
        maf.addFilter(df);
        maf.addFilter(pf);
        ArrayList<QuakeEntry> m7  = filter(list, maf); 
        System.out.println(m7.size()+" found");
        for (QuakeEntry qe: m7) { 
            System.out.println(qe);
        } 
        System.out.println(m7.size()+" found");
    }
    public void testMatchAllFilters2()
    {
        EarthQuakeParser parser = new EarthQuakeParser(); 
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        String source = "data/nov20quakedata.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);         
        System.out.println("read data for "+list.size()+" quakes");
        MatchAllFilters maf= new MatchAllFilters() ;
        Filter mf = new MagnitudeFilter(0.0,5.0); 
        Location loc= new Location(55.7308,9.1153);
        Filter df = new DistanceFilter(loc,3000000);
        Filter  pf= new PhraseFilter("any","e");
        maf.addFilter(mf);
        maf.addFilter(df);
        maf.addFilter(pf);
        ArrayList<QuakeEntry> m7  = filter(list, maf); 
        
        for (QuakeEntry qe: m7) { 
            System.out.println(qe);
        } 
        System.out.println(m7.size()+" found");
        System.out.println(maf.getName());
    }
}
