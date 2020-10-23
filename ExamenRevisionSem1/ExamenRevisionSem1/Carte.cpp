#include <iostream>
#include "Carte.h"

Carte::Carte(){
    id = nbH = 0;
    prix = 0.0;
}

Carte::Carte(int id, int nbH, float prix){
    this->id = id;
    this->nbH = nbH;
    this->prix = prix;
}

int Carte::get_id() const{
    return id;
}

int Carte::get_nbH(){
    return nbH;
}

float Carte::get_prix(){
    return prix;
}
