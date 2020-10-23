#ifndef ABONNEMENT_H_INCLUDED
#define ABONNEMENT_H_INCLUDED
#include <string>
#include "Carte.h"

using namespace std;

class Abonnement : public Carte{
    private:
        string dateExp;
    public:
        Abonnement();
        Abonnement(string, int, int, float);
        string get_dateExp();
};

#endif // ABONNEMENT_H_INCLUDED
