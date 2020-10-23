#ifndef ENS_H
#define ENS_H


#include<string>
#include<vector>
 using namespace std;
class ens
{
    public:
        ens();
        virtual ~ens();
        ens(int,string) ;
    int getMatricule() {return matricule ;} ;
    vector<int> getTabI() { return tabI ;} ;
    string getNom() { return nom;} ;
    vector<int > virtual getTabF() { } ;
    protected:
int matricule ;
string nom ;
vector<int> tabI ;
    private:
};
#endif // ENS_H
