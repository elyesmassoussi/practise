#include <iostream>
#include <cstdlib>
#include <string>
#include "Carte.h"
#include "Abonnement.h"
#include "Application.h"

using namespace std;

int main(){ //Habib Majoul
    int choix, id, nbH, Ref, nbP;
    float prix;
    string dateExp;
    Application App;
    do{
        do{
            system("cls");
            cout << "[0] - Quitter\n" << endl;
            cout << "[1] - Ajouter un Parking" << endl;
            cout << "[2] - Ajouter une Carte" << endl;
            cout << "[3] - Ajouter un Abonnement" << endl;
            cout << "[4] - Ajouter Carte a un Parking" << endl;
            cout << "[5] - Ajouter L'utilisation d'une Carte a un Parking" << endl;
            cout << "[6] - Parking le moin rentable" << endl;
            cout << "[7] - Supprimer Carte" << endl;
            cout << "[8] - Enregistrer les Abonnements\n\n> ";
            cin >> choix;
        }while(choix < 0 || choix > 8);
        system("cls");
        switch(choix){
            case 1:{
                cout << "Reference : ";
                cin >> Ref;
                cout << "Nombre de places totales : ";
                cin >> nbP;
                Parking P(Ref, nbP);
                App.ajouter(P);
                break;
            }
            case 2:{
                cout << "Identifiant : ";
                cin >> id;
                cout << "Nombre d'heures de stationnement : ";
                cin >> nbH;
                cout << "Prix de l'heure : ";
                cin >> prix;
                Carte C(id, nbH, prix);
                App.ajouter(C);
                break;
            }
            case 3:{
                cout << "Identifiant : ";
                cin >> id;
                cout << "Nombre d'heures de stationnement : ";
                cin >> nbH;
                cout << "Prix de l'heure : ";
                cin >> prix;
                cout << "Date d'expedition : ";
                cin >> dateExp;
                Abonnement A(dateExp, id, nbH, prix);
                App.ajouter(A);
                break;
            }
            case 4:
                cout << "Identifiant de la carte : ";
                cin >> id;
                if(App.chercherCarte(id) != App.get_tabCarte().end()){
                    cout << "Reference du parking : ";
                    cin >> Ref;
                    Parking* P = App.chercherPark(Ref);
                    if(P != NULL){
                        P->ajouterCarteAut(id);
                    }else{
                        cout << "Parking Inexistannt" << endl;
                    }
                }else{
                    cout << "Carte Inexistante" << endl;
                }
                break;
            case 5:
                cout << "Identifiant de la carte : ";
                cin >> id;
                if(App.chercherCarte(id) != App.get_tabCarte().end()){
                    cout << "Reference du parking : ";
                    cin >> Ref;
                    Parking* P = App.chercherPark(Ref);
                    if(P != NULL){
                        P->ajouterCarteUtil(id);
                    }else{
                        cout << "Parking Inexistannt" << endl;
                    }
                }else{
                    cout << "Carte Inexistante" << endl;
                }
                break;
            case 6:
                cout << "Reference du parking le moin rentable : " << App.moinRentable()->get_Ref() << endl;
                break;
            case 7:
                cout << "Identifiant de la carte : ";
                cin >> id;
                App.supprimerCarte(id);
                break;
            case 8:
                App.enregistrer();
                break;
            default:
                break;
        }
        system("pause");
    }while(choix != 0);
    return 0;
}
