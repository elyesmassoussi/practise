#ifndef APPLICATION_H_INCLUDED
#define APPLICATION_H_INCLUDED
#include "Parking.h"
#include "Carte.h"
#include "Abonnement.h"
#include <vector>

using namespace std;

class Application{
    private:
        vector <Parking> tabPark;
        vector <Carte *> tabCarte;
    public:
        Application();
        Application(const Application &);
        Application& operator=(const Application &);
        ~Application();
        vector <Carte *> get_tabCarte();
        void ajouter(const Parking &);
        void ajouter(const Carte &);
        void ajouter(const Abonnement &);
        Parking* chercherPark(int);
        vector <Carte*> :: iterator chercherCarte(int);
        Parking* moinRentable();
        void supprimerCarte(int);
        void enregistrer();
};

#endif // APPLICATION_H_INCLUDED
