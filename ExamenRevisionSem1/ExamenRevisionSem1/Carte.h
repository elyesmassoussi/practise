#ifndef CARTE_H_INCLUDED
#define CARTE_H_INCLUDED

class Carte{
    private:
        int id, nbH;
        float prix;
    public:
        Carte();
        Carte(int, int, float);
        int get_id() const;
        int get_nbH();
        float get_prix();
};

#endif // CARTE_H_INCLUDED
