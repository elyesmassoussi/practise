#ifndef PARKING_H_INCLUDED
#define PARKING_H_INCLUDED
#include <vector>
#include "Carte.h"

using namespace std;

class Parking{
    private:
        int Ref, nbP;
        vector <int> tabAut;
        vector <int> tabUtil;
    public:
        Parking();
        Parking(int, int);
        int get_Ref() const;
        vector <int> get_tabAut();
        vector <int> get_tabUtil();
        bool uniqueAut(int);
        bool uniqueUtil(int);
        void ajouterCarteAut(int);
        void ajouterCarteUtil(int);
        bool operator<(const Parking&);
};

#endif // PARKING_H_INCLUDED
