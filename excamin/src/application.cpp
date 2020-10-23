#include "application.h"
#include <iostream>
#include <fstream>
application::application()
{
    //ctor
}

application::~application()
{
    //dtor
}
application::application(string nom)
{
    this->nom=nom;
}
void application::ajouterEpreuve(epreuve* p)
{ int code=p->getCode() ;
   int resultat=0;
    for(int i=0;i<tabE.size();i++)
        if(tabE[i]->getCode()==code)
        resultat=1;
if(resultat==0)
 tabE.push_back(p);

}
void application::afficherQuizz(string theme)
     { int ex=0 ;
for(int i=0;i<tabE.size();i++)

    if(tabE[i]->getTheme()==theme )
           {
               tabE[i]->affiche() ;
               ex=1 ;
           }
 try
 {
     if(ex==0)
        throw string(  "ce theme n'existe pas") ;

 }
 catch( string  err)
 {
     cout << err  << endl ;
 }

     }
     void application::calculerDure()
     {
         for(int i=0;i<tabE.size();i++)
         {
          tabE[i]->calculerDuree() ;
         }

     }
     void application::afficher() const
     { epreuve e=*tabE[0];
  for(int i=1;i<tabE.size();i++)
  {
   if(*tabE[i]>e)
        e=*tabE[i] ;
  }
  cout << "la duree maximal des epreuve est " << e.getDuree() << endl ;
     }
     void application::enregistrer()
     {
         ofstream f("liste.txt") ;
         if (!f.is_open())
 cout << "Impossible d'ouvrir le fichier en écriture !" << endl;
 else
 {
     for(int i=0;i<tabE.size();i++)
     {
         if(tabE[i]->getIndicateur() ==1)
           {  epreuve e=*tabE[i];
              f << e.getCode() << " " << e.getDuree()  << endl ;
     }
           }
     f.close() ;
     }
     }
