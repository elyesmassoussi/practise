#ifndef ECOLEING_H
#define ECOLEING_H
#include<string>
#include<vector>
#include"ens.h"
#include"cour.h"
using namespace std;

class ecoleIng
{
    public:
        ecoleIng();
        virtual ~ecoleIng() ;
        ecoleIng(string);
        void ajouterCours(cour) ;
        void ajouterEns(ens*) ;
        void AffecterCours(int,int) ;
        int nombreTotale() ;
        void afficher(int) const ;
        void enregistrer() ;

    protected:
string nom ;
vector<ens*> tabEns ;
vector<cour> tabC ;
    private:
};

#endif // ECOLEING_H
