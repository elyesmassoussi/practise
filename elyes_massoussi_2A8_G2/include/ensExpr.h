#ifndef ENSEXPR_H
#define ENSEXPR_H

#include "ens.h"
#include <string>
#include<vector>
using namespace std ;

class ensExpr : public ens
{
    public:
        ensExpr();
        virtual ~ensExpr();
        ensExpr(int,string) ;
        vector<int> getTabF() { return tabF ; } ;
 bool operator<<(  int) ;
    protected:
vector<int> tabF ;
    private:
};

#endif // ENSEXPR_H
