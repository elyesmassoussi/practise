
/**
 * Décrivez votre classe assignment ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class assignment {
public String ceasarCipher(String s,int k)
{ String alphabetU="ABCDEFJHIJKLMNOPQRSTUVWXYZ";
    String alphabetL="abcdefghijklmnopqrstuvwxyz";
    StringBuilder st= new StringBuilder(s);
    String codeu= alphabetU.substring(k)+alphabetU.substring(0,k);
    String codel = alphabetL.substring(k)+alphabetL.substring(0,k);
    String result="" ;
    for(int i=0;i<s.length();i++)
    { int index= alphabetU.indexOf(st.charAt(i));
        int indexl = alphabetL.indexOf(st.charAt(i));
        if(index!=-1)
        { result+= codeu.charAt(index) ;
        }
        else if(indexl!=-1)
        { result+= codel.charAt(indexl) ;
        }
        else
        { result +=  st.charAt(i);
        }
    }
    return result;
}
public String encryptTwoKeys(String s, int key1 , int key2)
{
    
    String alphabetU="ABCDEFJHIJKLMNOPQRSTUVWXYZ";
    String alphabetL="abcdefghijklmnopqrstuvwxyz";
    StringBuilder st= new StringBuilder(s);
    String codeu= alphabetU.substring(key1)+alphabetU.substring(0,key1);
    String codel = alphabetL.substring(key1)+alphabetL.substring(0,key1);
    String codeuk= alphabetU.substring(key2)+alphabetU.substring(0,key2);
    String codelk = alphabetL.substring(key2)+alphabetL.substring(0,key2);
    
    String result="" ;
    for(int i=0;i<s.length();i++)
    { if(i%2==0)
        {
        int index= alphabetU.indexOf(st.charAt(i));
        int indexl = alphabetL.indexOf(st.charAt(i));
        if(index!=-1)
        { result+= codeu.charAt(index) ;
        }
        else if(indexl!=-1)
        { result+= codel.charAt(indexl) ;
        }
        else
        { result +=  st.charAt(i);
        }
    }
    else
    {int index= alphabetU.indexOf(st.charAt(i));
        int indexl = alphabetL.indexOf(st.charAt(i));
        if(index!=-1)
        { result+= codeuk.charAt(index) ;
        }
        else if(indexl!=-1)
        { result+= codelk.charAt(indexl) ;
        }
        else
        { result +=  st.charAt(i);
        }
    }
    }
    
    return result;
    
}
public void test()
{   System.out.println(ceasarCipher("At noon be in the conference room with your hat on for a surprise party. YELL LOUD!",15));
    System.out.println(encryptTwoKeys("At noon be in the conference room with your hat on for a surprise party. YELL LOUD!",8,21));
}
}
