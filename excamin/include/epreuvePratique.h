#ifndef EPREUVEPRATIQUE_H
#define EPREUVEPRATIQUE_H

#include <epreuve.h>


class epreuvePratique : public epreuve
{
    public:
        epreuvePratique();
        virtual ~epreuvePratique();
   epreuvePratique(long int ,int,int,int);
   void  calculerDuree() ;
   int getIndicateur() ;

    protected:
int indicateur,nbrE ;

    private:
};

#endif // EPREUVEPRATIQUE_H
