import java.util.*;
import edu.duke.*;
import java.io.*;
public class VigenereBreaker {
    public String sliceString(String message, int whichSlice, int totalSlices) {
        String result="";
        for(int i=whichSlice ;i<message.length();i+=totalSlices)
        {
            result= result+ message.charAt(i);
        }
        return result;
    }

    public int[] tryKeyLength(String encrypted, int klength, char mostCommon) {
       int[] result= new int[klength];
        String[] table= new String[klength];
        for(int i=0;i<klength;i++)
        {
            table[i]=sliceString(encrypted,i,klength);
            CaesarCracker cc= new CaesarCracker(mostCommon);
            result[i]=cc.getKey(table[i]);
        }
        return result;
    }
    public void breakVigenere () {
        FileResource fr= new FileResource();
        String s=fr.asString();
        int[] keys= new int[4];
        keys=tryKeyLength(s,4,'e');
        VigenereCipher vc= new VigenereCipher(keys);
        String result=vc.decrypt(s);
        System.out.println(result);
    }
    public HashSet<String> readDictionary(FileResource fr)
    {
        HashSet set= new HashSet<String>();
        for(String word : fr.words())
        {
            word.toLowerCase();
            set.add(word);
        }
        return set;
    }
    public int countWords(String message,HashSet<String> dictionary)
    {
        int count=0;
        int size=message.split("\\W+").length;
        String[] split= new String[size];
        message =message.toLowerCase();
        split= message.split("\\W+");
        for(int i=0;i<size;i++)
        {   
            if(dictionary.contains(split[i]))
            count++;
        }
        return count ;
    }
    public String breakForLanguage(String encrypted, HashSet<String> dictionary)
    {
        int count=0;
        int key=0;
        String str="hello world";
        for(int i=1;i<100;i++)
        {
        int[] keys= new int[i];
        keys=tryKeyLength(encrypted,i,mostCommonCharIn(dictionary));
        VigenereCipher vc= new VigenereCipher(keys);
        String result=vc.decrypt(encrypted);
        int nbWords= countWords(result,dictionary);
        if(count<nbWords)
        {
            key=i;
            count=nbWords;
            str=result;
        }
        }
        return str;
    }
    public void breakVigenere2() {
        FileResource fr= new FileResource();
        String s=fr.asString();
        FileResource f= new FileResource();
        HashSet set= new HashSet();
        set=readDictionary(f);
        String result= breakForLanguage(s,set);
    }
    public void breakVigenere3() {
        FileResource fr= new FileResource();
        String s=fr.asString();
        HashMap<String,HashSet<String>> hm= new HashMap<String,HashSet<String>>();                                       
        DirectoryResource dr= new DirectoryResource();
        String name="";
        for(File f: dr.selectedFiles())
        {  
           name= f.getName() ;
           FileResource ff= new FileResource(f);
           HashSet set= new HashSet();
           set=readDictionary(ff);
           hm.put(name,set);
        }
        breakForAllLangs(s,hm);
    }
    public char mostCommonCharIn(HashSet<String> dictionary)
    {
        HashMap<Character,Integer> map= new HashMap<Character,Integer>();
        for(String word:dictionary)
        {
            for(int i=0;i<word.length();i++)
            {   
                if(!map.containsKey(word.charAt(i)))
                map.put(word.charAt(i),1);
                else
                map.put(word.charAt(i),map.get(word.charAt(i))+1);
            }
        }
        int max=0;
        char c=' ';
        for(char cc: map.keySet())
        {
           if(max<map.get(cc))
           {   
               max=map.get(cc);
               c=cc;
           }
        }
        return c;
    }
    public void test()
    {
       FileResource f= new FileResource();
       HashSet set= new HashSet(); 
       set=readDictionary(f);
       System.out.println(mostCommonCharIn(set));
    }
    public void breakForAllLangs(String encrypted,HashMap<String,HashSet<String>> languages)
    {  int count=0;
       String result="";
       String name="";
        for(String s:languages.keySet())
        {
            HashSet set= new HashSet(); 
            set=languages.get(s);
            String r=breakForLanguage(encrypted,set);
            int counts=countWords(r,set);
            if(count<counts)
            {
                result=r;
                name=s;
            }
        }
        System.out.println(name+"\t:\t"+result);
    }
}
