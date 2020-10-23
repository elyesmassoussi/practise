#include "quizz.h"
#include <iostream>
using namespace std ;
quizz::quizz()
{
    //ctor
}

quizz::~quizz()
{
    //dtor
}
quizz::quizz(long int code, int duree ,string theme,int nbrQ)
{this->code=code ;
    this->duree=duree ;
    this->theme=theme;
    this->nbrQ=nbrQ;
}
void quizz::affiche() const
{
    epreuve::affiche() ;
    cout << theme << " " << nbrQ << endl ;
}
void quizz::calculerDuree()
{
    duree=nbrQ*1;
}
