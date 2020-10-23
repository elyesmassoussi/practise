#include <iostream>
#include"epreuve.h"
#include"epreuvePratique.h"
#include"quizz.h"
#include"application.h"
using namespace std;

int main()
{
    cout << "Hello world!" << endl;
    epreuve t(123,12) ;
    epreuvePratique b(1425,0,0,12), k(1536,0,1,45) ;
    quizz q(1475,0,"math",36);
    application app("esprit.RIP") ;
    q.affiche() ;
    t.affiche() ;
app.ajouterEpreuve(&t);
app.ajouterEpreuve(&b);
app.ajouterEpreuve(&k);
app.ajouterEpreuve(&q);
app.afficherQuizz("math") ;
app.afficherQuizz("physique") ;
app.calculerDure();
app.afficher();
app.enregistrer();
    return 0;
}
