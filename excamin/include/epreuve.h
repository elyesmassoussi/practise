#ifndef EPREUVE_H
#define EPREUVE_H
#include<string>
using namespace std ;

class epreuve
{
    public:
        epreuve();
        virtual ~epreuve();
   epreuve(long int ,int) ;
 string virtual getTheme() {} ;
 void virtual affiche() const ;
 void virtual calculerDuree() {} ;
 int virtual getIndicateur() {} ;
 long int getCode() { return code; } ;
int getDuree() ;
 bool EstPlusGrandQueb(epreuve const&) const ;
    protected:
long int code ;
int duree ;
    private:
};
 bool operator>(epreuve const& ,epreuve const& ) ;
#endif // EPREUVE_H
