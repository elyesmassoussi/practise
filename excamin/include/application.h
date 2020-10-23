#ifndef APPLICATION_H
#define APPLICATION_H
#include<string>
#include<vector>
#include"epreuve.h"
using namespace std;

class application
{
    public:
        application();
        virtual ~application();
        application(string) ;
     void ajouterEpreuve(epreuve*) ;
     void afficherQuizz(string)  ;
     void calculerDure() ;
     void afficher() const ;
     void enregistrer() ;
    protected:
string nom ;
vector<epreuve*> tabE ;
    private:
};

#endif // APPLICATION_H
