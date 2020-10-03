
/**
 * Write a description of class QuakeSortInPlace here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;
import edu.duke.*;

public class QuakeSortInPlace {
    public QuakeSortInPlace() {
        // TODO Auto-generated constructor stub
    }
   
    public int getSmallestMagnitude(ArrayList<QuakeEntry> quakes, int from) {
        int minIdx = from;
        for (int i=from+1; i< quakes.size(); i++) {
            if (quakes.get(i).getMagnitude() < quakes.get(minIdx).getMagnitude()) {
                minIdx = i;
            }
        }
        return minIdx;
    }
    
    public void sortByMagnitude(ArrayList<QuakeEntry> in) {
       
       for (int i=0; i< in.size(); i++) {
            int minIdx = getSmallestMagnitude(in,i);
            QuakeEntry qi = in.get(i);
            QuakeEntry qmin = in.get(minIdx);
            in.set(i,qmin);
            in.set(minIdx,qi);
        }
        
    }

    public void testSort() {
        EarthQuakeParser parser = new EarthQuakeParser(); 
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        String source = "Data/earthQuakeDataWeekDec6sample2.atom";
        //String source = "data/nov20quakedata.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);  
       
        System.out.println("read data for "+list.size()+" quakes");    
        //sortByMagnitude(list);
        //sortByLargestDepth(list);
        //sortByMagnitudeWithBubbleSort(list);
        sortByMagnitudeWithBubbleSortWithCheck(list);
        //sortByMagnitudeWithCheck(list);
        /*for (QuakeEntry qe: list) { 
            System.out.println(qe);
        } */
    }
    
    public void createCSV() {
        EarthQuakeParser parser = new EarthQuakeParser();
        //String source = "data/nov20quakedata.atom";
        String source = "data/nov20quakedatasmall.atom";
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        dumpCSV(list);
        System.out.println("# quakes read: " + list.size());
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
    public int getLargestDepth(ArrayList<QuakeEntry> quakeData, int from)
    { int index=from;
        for(int i=from+1;i<quakeData.size();i++)
        {
            if(quakeData.get(i).getDepth()>quakeData.get(index).getDepth())
            {
                index=i;
            }
        }
        return index;
    }
    public void sortByLargestDepth(ArrayList<QuakeEntry> in)
    {
        for(int i=0;i<70;i++)
        {
            int index=getLargestDepth(in,i);
            QuakeEntry qe=in.get(index);
            QuakeEntry qi=in.get(i);
            in.set(index,qi);
            in.set(i,qe);
        }
    }
    public void onePassBubbleSort(ArrayList<QuakeEntry> quakeData,int numSorted)
    {
        for(int i=0;i<quakeData.size()-1-numSorted;i++)
        {
            if(quakeData.get(i).getMagnitude()>quakeData.get(i+1).getMagnitude())
            {
                QuakeEntry qe= quakeData.get(i);
                QuakeEntry qi= quakeData.get(i+1);
                quakeData.set(i,qi);
                quakeData.set(i+1,qe);
            }
        }
    }
    public void sortByMagnitudeWithBubbleSort(ArrayList<QuakeEntry> in)
    {
        for(int i=0;i<in.size()-1;i++)
        {
            onePassBubbleSort(in,i);
        }
    }
    public boolean checkInSortedOrder(ArrayList<QuakeEntry> quakes)
    {
        boolean result= true;
        int i=0;
        while(result && i<quakes.size()-1)
        {
            if(quakes.get(i).getMagnitude()>quakes.get(i+1).getMagnitude())
            result= false ;
            i++;
        }
        return result;
    }
    public void sortByMagnitudeWithBubbleSortWithCheck(ArrayList<QuakeEntry> in)
    {
        int i=0;
        boolean sorted=checkInSortedOrder(in);;
        while(!sorted && i<in.size()-1)
        {
            onePassBubbleSort(in,i);
            sorted=checkInSortedOrder(in);
            i++;
        }
        System.out.println(i+" times");
    }
    public void sortByMagnitudeWithCheck(ArrayList<QuakeEntry> in)
    {
        int i=0;
        boolean result=checkInSortedOrder(in) ;
        while(!result && i<in.size())
        {
            int minIdx = getSmallestMagnitude(in,i);
            QuakeEntry qi = in.get(i);
            QuakeEntry qmin = in.get(minIdx);
            in.set(i,qmin);
            in.set(minIdx,qi);
            result=checkInSortedOrder(in);
            i++;
        }
        System.out.println(i+" times");
    }
}
