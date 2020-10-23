#include "epreuve.h"
#include <iostream>
using namespace  std ;
epreuve::epreuve()
{
    //ctor
}

epreuve::~epreuve()
{
    //dtor
}
epreuve::epreuve( long int code , int duree)
{
    this->code=code ;
    this->duree=duree ;

}
void epreuve::affiche() const
{
    cout << code << "  " << duree << "minutes" << endl ;
}

 bool epreuve::EstPlusGrandQueb(epreuve const& b) const
 {
     if( duree>b.duree)
        return true ;
     else
        return false ;
 }
 int epreuve::getDuree()
 {
     return duree ;
 }
bool operator>(epreuve const& a,epreuve const& b)
 {
     return a.EstPlusGrandQueb(b) ;
 }
