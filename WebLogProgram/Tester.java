
/**
 * Write a description of class Tester here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;

public class Tester
{
    public void testLogEntry() {
        LogEntry le = new LogEntry("1.2.3.4", new Date(), "example request", 200, 500);
        System.out.println(le);
        LogEntry le2 = new LogEntry("1.2.100.4", new Date(), "example request 2", 300, 400);
        System.out.println(le2);
    }
    
    public void testLogAnalyzer() {
        LogAnalyzer la= new LogAnalyzer() ;
        la.readFile("short-test_log");
        la.printAll() ;
        
    }
    public void testUniqueIP() {
        LogAnalyzer la= new LogAnalyzer() ;
        la.readFile("weblog2_log");
        System.out.println(la.countUniqueIPs());
    }
    public void testPrintAllGreaterThanNum()
    {
        LogAnalyzer la= new LogAnalyzer() ;
        la.readFile("weblog2_log");
        la.printAllHigherThanNum(400) ;
    }
    public void testUniqueIPVisitsOnDay()
    {
        LogAnalyzer la= new LogAnalyzer() ;
        la.readFile("weblog2_log");
        ArrayList<String> count= new ArrayList<String>();
        count=la.uniqueIPVisitsOnDay("Sep 27");
        System.out.println(count.size());
    }
    public void testCountUniqueIPsInRange()
    {
        LogAnalyzer la= new LogAnalyzer() ;
        la.readFile("weblog2_log");
        int count=la.countUniqueIPsInRange(400,499);
        System.out.println(count);
    }
    public void testMostVisits()
    {
        LogAnalyzer la= new LogAnalyzer();
        la.readFile("weblog2_log");
        HashMap<String,Integer> map= new HashMap<String,Integer>();
        map= la.countVisitsPerIP() ; 
        System.out.println(la.mostNumberVisitsByIP(map));
    }
    public void testIPsMostVisits()
    {
        LogAnalyzer la= new LogAnalyzer();
        la.readFile("weblog2_log");
        HashMap<String,Integer> map= new HashMap<String,Integer>();
        map= la.countVisitsPerIP() ; 
        ArrayList<String> list = new ArrayList<String>();
        list= la.iPsMostVisits(map);
        for(int i=0;i<list.size();i++)
        {
            System.out.println(list.get(i));
        }
    }
    public void testIPsForDays()
    {
        LogAnalyzer la= new LogAnalyzer();
        la.readFile("weblog2_log");
        HashMap<String,ArrayList<String>> map= new HashMap<String,ArrayList<String>>();
        map=la.iPsForDays();
        for(String s: map.keySet())
        {
            System.out.println(s+"\t"+map.get(s).size());
        }
    }
    public void testMostIPsForDay()
    {
        LogAnalyzer la= new LogAnalyzer();
        la.readFile("weblog2_log");
        HashMap<String,ArrayList<String>> map= new HashMap<String,ArrayList<String>>();
        map=la.iPsForDays();
        String day=la.dayWithMostIPVisits(map);
        System.out.println(day);
    }
   public void testIPsWithMostVisitsOnDay()
   {
        LogAnalyzer la= new LogAnalyzer();
        la.readFile("weblog2_log");
        HashMap<String,ArrayList<String>> map= new HashMap<String,ArrayList<String>>();
        map=la.iPsForDays();
        ArrayList<String> list= new ArrayList<String>();
        list=la.iPsWithMostVisitsOnDay(map,"Sep 29");
        for(String s:list)
        System.out.println(s);
   }
}
