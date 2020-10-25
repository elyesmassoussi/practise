
/**
 * Write a description of class LogAnalyzer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;
import edu.duke.*;

public class LogAnalyzer
{
     private ArrayList<LogEntry> records;
     
     public LogAnalyzer() {
         records = new ArrayList<LogEntry>();
     }
        
     public void readFile(String filename) {
         FileResource fr= new FileResource(filename);
         for(String s: fr.lines())
         {
             LogEntry e= WebLogParser.parseEntry(s) ;
             records.add(e);
             
         }
     }
        
     public void printAll() {
         for (LogEntry le : records) {
             System.out.println(le);
         }
     }
     public int countUniqueIPs()
     {
         ArrayList<String> unique= new ArrayList<String>();
         for(LogEntry le: records)
         {
             if(!unique.contains(le.getIpAddress()))
             unique.add(le.getIpAddress());
         }
         return unique.size();
     }
     public ArrayList<String> UniqueIP(ArrayList<String> s)
     {
        ArrayList<String> unique= new ArrayList<String>();
         for(int i=0;i<s.size();i++)
         {
             if(!unique.contains(s.get(i)))
             {   
                 unique.add(s.get(i));
             }
         }
         return unique;
     }
     public void printAllHigherThanNum(int num)
     {
         for(LogEntry le: records)
         {
             if(le.getStatusCode()>num)
             System.out.println(le);
         }
     }
     public int countUniqueIPsInRange(int low,int high)
     {   
         ArrayList<String> unique= new ArrayList<String>();
         
         for(LogEntry le: records)
         {
            
            if(le.getStatusCode()>=low && le.getStatusCode()<=high)
            {
                unique.add(le.getIpAddress());
            }
         }
         unique= UniqueIP(unique) ;
         return unique.size();
     }
     public ArrayList<String> uniqueIPVisitsOnDay(String s)
     {
         ArrayList<String> unique= new ArrayList<String>() ;
         for(LogEntry le: records)
         {     String str= le.getAccessTime().toString();
             if(str.indexOf(s)!=-1)
             {
                 unique.add(le.getIpAddress());
             }
         }
         return UniqueIP(unique) ;
     }
     public HashMap<String,Integer> countVisitsPerIP()
     {
         HashMap<String,Integer> counts= new HashMap<String,Integer>();
         for(LogEntry le: records)
         {
             String ip=le.getIpAddress() ;
             if(!counts.containsKey(ip))
             counts.put(ip,1);
             else
             counts.put(ip,counts.get(ip)+1);
         }
         return counts ;
     }
     public int mostNumberVisitsByIP(HashMap<String,Integer> map)
     { 
       int max=0;
       for(String s: map.keySet())
       {
           if(map.get(s)>max)
           max=map.get(s);
       }
       return max;
     }
     public ArrayList<String> iPsMostVisits(HashMap<String,Integer> map)
    {   ArrayList<String> list= new ArrayList<String>() ;
        int i= mostNumberVisitsByIP(map);
        for(String s: map.keySet())
        {
            if(map.get(s)==i)
            list.add(s);
        }
        return list ;
    }
    public HashMap<String,ArrayList<String>> iPsForDays()
    {
      HashMap<String,ArrayList<String>> map= new HashMap<String,ArrayList<String>>();
      for(LogEntry le: records)
      {
          String str= le.getAccessTime().toString();
          str= str.substring(4,10);
          if(!map.containsKey(str))
          {
              ArrayList<String> list= new ArrayList<String>();
              list.add(le.getIpAddress());
              map.put(str,list);
          }
          else
          {
              ArrayList<String> list= new ArrayList<String>();
              list=map.get(str);
              list.add(le.getIpAddress());
              map.put(str,list);
          }
      }
      return map;
    }
    public String dayWithMostIPVisits(HashMap<String,ArrayList<String>> map)
    {   int max=0;
        String day="";
        
        for(String s:map.keySet())
        {
            if(map.get(s).size()>max)
            {
                max=map.get(s).size();
                day=s;
            }
        }
        return day;
    }
     public ArrayList<String> iPsWithMostVisitsOnDay(HashMap<String,ArrayList<String>> map,String day)
    {   
        ArrayList<String> list= new ArrayList<String>();
        HashMap<String,Integer> count= new HashMap<String,Integer>();
        list=map.get(day);
        for(String s: list)
        {
            if(!count.containsKey(s))
             count.put(s,1);
             else
             count.put(s,count.get(s)+1);
        }
        return iPsMostVisits(count);
    }
}
