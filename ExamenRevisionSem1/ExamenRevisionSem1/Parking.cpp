#include <iostream>
#include <string>
#include <vector>
#include <iterator>
#include "Parking.h"
#include "Carte.h"
#include "Abonnement.h"

using namespace std;

Parking::Parking(){
    Ref = nbP = 0;
}

Parking::Parking(int Ref, int nbP){
    this->Ref = Ref;
    this->nbP = nbP;
}

int Parking::get_Ref() const{
    return Ref;
}

vector <int> Parking::get_tabAut(){
    return tabAut;
}

vector <int> Parking::get_tabUtil(){
    return tabUtil;
}

bool Parking::uniqueAut(int id){
    for(vector <int> :: iterator it = tabAut.begin(); it != tabAut.end(); ++it){
        if(*it == id){
            return false;
        }
    }
    return true;
}

bool Parking::uniqueUtil(int id){
    for(vector <int> :: iterator it = tabUtil.begin(); it != tabUtil.end(); ++it){
        if(*it == id){
            return false;
        }
    }
    return true;
}

void Parking::ajouterCarteAut(int id){
    if(uniqueAut(id)){
        tabAut.push_back(id);
    }
}

void Parking::ajouterCarteUtil(int id){
    try{
        if(uniqueAut(id) == false && (int) tabUtil.size() < nbP && uniqueUtil(id)){
            tabUtil.push_back(id);
        }else{
            throw("Ajout de carte non effectue");
        }
    }catch(string err){
        cout << err;
    }
}

bool Parking::operator<(const Parking& P){
    return this->tabUtil.size() < P.tabUtil.size();
}
