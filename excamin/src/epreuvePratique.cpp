#include "epreuvePratique.h"
#include <iostream>
epreuvePratique::epreuvePratique()
{
    //ctor
}

epreuvePratique::~epreuvePratique()
{
    //dtor
}
epreuvePratique::epreuvePratique(long int code, int duree ,int indicateur,int nbrE)
{  this->code=code ;
    this->duree=duree ;
    this->indicateur=indicateur ;
    this->nbrE=nbrE;
}
void epreuvePratique::calculerDuree()
{ if(indicateur==0)
    duree=nbrE*25;
    else
        duree=90 ;
}
int epreuvePratique::getIndicateur()
{
    return indicateur ;
}
