#ifndef COUR_H
#define COUR_H


#include<string>
using namespace std;

class cour
{
    public:
        cour();
        virtual ~cour();
      cour(int,string);
      int getCode() {return code ;} ;
    protected:
int code ;
string des;
    private:
};

#endif // COUR_H
