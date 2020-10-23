#include <iostream>
#include <string>
#include <typeinfo>
#include <vector>
#include <iterator>
#include <fstream>
#include "Application.h"
#include "Parking.h"
#include "Carte.h"
#include "Abonnement.h"

using namespace std;

Application::Application(){
}

Application::Application(const Application &A){
    Carte *p;
    for(vector <Carte *> :: const_iterator it = A.tabCarte.begin(); it != A.tabCarte.end(); ++it){
        if(typeid(**it) == typeid(Abonnement)){
            p = new Abonnement(static_cast <const Abonnement&> (**it));
        }
        if(typeid(**it) == typeid(Carte)){
            p = new Carte(**it);
        }
        tabCarte.push_back(p);
    }
    tabPark = A.tabPark;
}

Application& Application::operator=(const Application &A){
    if(this != &A){
        Carte *p;
        for(vector <Carte *> :: iterator it = tabCarte.begin(); it != tabCarte.end(); ++it){
            delete(*it);
        }
        tabCarte.clear();
        for(vector <Carte *> :: const_iterator it = A.tabCarte.begin(); it != A.tabCarte.end(); ++it){
            if(typeid(**it) == typeid(Abonnement)){
                p = new Abonnement(static_cast <const Abonnement&> (**it));
            }
            if(typeid(**it) == typeid(Carte)){
                p = new Carte(**it);
            }
            tabCarte.push_back(p);
        }
        tabPark = A.tabPark;
    }
    return *this;
}

Application::~Application(){
    for(vector <Carte *> :: iterator it = tabCarte.begin(); it != tabCarte.end(); ++it){
        delete(*it);
    }
}

vector <Carte *> Application::get_tabCarte(){
    return tabCarte;
}

Parking* Application::chercherPark(int Ref){
    for(vector <Parking> :: iterator it = tabPark.begin(); it != tabPark.end(); ++it){
        if(it->get_Ref() == Ref){
            return &(*it);
        }
    }
    return NULL;
}

vector <Carte*> :: iterator Application::chercherCarte(int id){
    for(vector <Carte *> :: iterator it = tabCarte.begin(); it != tabCarte.end(); ++it){
        if((*it)->get_id() == id){
            return it;
        }
    }
    return tabCarte.end();
}

void Application::ajouter(const Parking &P){
    if(chercherPark(P.get_Ref()) == NULL){
        tabPark.push_back(P);
    }
}

void Application::ajouter(const Carte &C){
    if(chercherCarte(C.get_id()) == tabCarte.end()){
        tabCarte.push_back(new Carte(C));
    }
}

void Application::ajouter(const Abonnement &A){
    if(chercherCarte(A.get_id()) == tabCarte.end()){
        tabCarte.push_back(new Abonnement(A));
    }
}

Parking* Application::moinRentable(){
    Parking* moin = &*tabPark.begin();
    for(vector <Parking> :: iterator it = tabPark.begin(); it != tabPark.end(); ++it){
        if(*it < *moin){
            moin = &*it;
        }
    }
    return moin;
}

void Application::supprimerCarte(int id){
    vector <Carte*> :: iterator C = chercherCarte(id);
    if(C != tabCarte.end()){
        tabCarte.erase(C);
        vector <int> :: iterator i;
        for(vector <Parking> :: iterator it = tabPark.begin(); it != tabPark.end(); ++it){
            for(i = it->get_tabAut().begin(); i != it->get_tabAut().end(); ++i){
                if(*i == id){
                    it->get_tabAut().erase(i);
                    --i;
                }
            }
            for(i = it->get_tabUtil().begin(); i != it->get_tabUtil().end(); ++i){
                if(*i == id){
                    it->get_tabUtil().erase(i);
                    --i;
                }
            }
        }
    }
}

void Application::enregistrer(){
    ofstream f;
    f.open("abonnements.txt");
    if(f.is_open()){
        Abonnement i;
        for(vector <Carte*> :: iterator it = tabCarte.begin(); it != tabCarte.end(); ++it){
            if(typeid(**it) == typeid(Abonnement)){
                unsigned int x = (*it)->get_nbH() - 10;
                i = static_cast <const Abonnement &> (**it);
                f << (*it)->get_id() << " " << (*it)->get_nbH() << " " << (*it)->get_prix() * x << i.get_dateExp() << endl;
            }
        }
        f.close();
    }
}
