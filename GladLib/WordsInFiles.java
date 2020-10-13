
/**
 * Décrivez votre classe WordsInFiles ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
import edu.duke.*;
import java.util.*;
import java.io.File;
public class WordsInFiles {
private HashMap<String,ArrayList<String>> dataTracker ;
public WordsInFiles()
{
    dataTracker = new HashMap<String,ArrayList<String>>() ;
}
private void addWordsFromFile(File f)
{  FileResource fr= new FileResource(f);
   for(String w: fr.words())
   {
       if(!dataTracker.containsKey(w))
       {
           ArrayList<String> list= new ArrayList<String>() ;
           String name = f.getName();
           list.add(name);
           dataTracker.put(w,list);
           
       }
       else
       {
           ArrayList<String> list= new ArrayList<String>() ;
           list=dataTracker.get(w);
           String name = f.getName();
            if(!list.contains(name))
           {
           list.add(name);
           dataTracker.put(w,list);
           }
       }
   }
}
public void buildWordFileMap()
{
    dataTracker.clear();
    DirectoryResource dr= new DirectoryResource() ;
    for(File f: dr.selectedFiles())
    {
        addWordsFromFile(f);
    }
}
public int maxNumber()
{
    int max=0 ;
    for(String s: dataTracker.keySet())
    {
        int i= dataTracker.get(s).size();
        if(i>max)
        max=i ;
    }
    return max ;
}
public ArrayList<String> wordInNumFiles(int number)
{ 
    ArrayList<String> list= new ArrayList<String>() ;
    for(String s: dataTracker.keySet())
    {
        int i= dataTracker.get(s).size();
        if(i==number)
          list.add(s) ;
    }
    return list ;
}
public void printFilesln(String word)
{
    ArrayList<String> list = new ArrayList<String>() ;
    list = dataTracker.get(word) ; 
    for(int i=0 ; i<list.size();i++)
    System.out.println(list.get(i) );
}
public void tester()
{   buildWordFileMap();
    
        //ArrayList<String> list= new ArrayList<String>() ;
        //list=wordInNumFiles(7) ;
        //System.out.println(list.size());
        printFilesln("tree");
}
}
