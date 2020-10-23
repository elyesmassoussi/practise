#ifndef QUIZZ_H
#define QUIZZ_H

#include <epreuve.h>
#include<string>
using namespace std;

class quizz : public epreuve
{
    public:
        quizz();
        virtual ~quizz();
       quizz(long int,int,string ,int) ;
       string getTheme() { return theme;} ;
       void affiche() const ;
       void  calculerDuree() ;
    protected:
string theme ;
int nbrQ ;
    private:
};

#endif // QUIZZ_H
