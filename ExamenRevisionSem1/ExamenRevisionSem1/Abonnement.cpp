#include <iostream>
#include <string>
#include "Abonnement.h"
#include "Carte.h"

using namespace std;

Abonnement::Abonnement() : Carte(){
    dateExp = "";
}

Abonnement::Abonnement(string dateExp, int id, int nbH, float prix) : Carte(id, nbH, prix){
    this->dateExp = dateExp;
}

string Abonnement::get_dateExp(){
    return dateExp;
}
