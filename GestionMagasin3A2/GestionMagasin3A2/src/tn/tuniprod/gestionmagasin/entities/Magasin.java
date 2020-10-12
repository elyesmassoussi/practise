package tn.tuniprod.gestionmagasin.entities;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author House
 */
public class Magasin {
    
    public int id;
    public String adresse;
    public final int CAPACITE_MAGASIN =50;
    public Produit [] tabProduits;
    public int nbProduits;
    
    public static int nbTotal;
    
    public Magasin(){
        tabProduits = new Produit[CAPACITE_MAGASIN];
    }
    
    public Magasin(int id, String adresse){
        this.id = id;
        this.adresse = adresse;
        tabProduits = new Produit[CAPACITE_MAGASIN];
    }
    
    public void ajouterProduit(Produit p){
        if(nbProduits < CAPACITE_MAGASIN){
            tabProduits[nbProduits]=p;
            nbProduits ++;
            nbTotal ++;
            System.out.println("Produit ajouté");
        }
        else
            System.out.println("Magasin plein"); 
    }
    
    public String toString(){
        String ch1="";
        String ch2="";
        ch1= "Id:"+id+" -Adresse:"+adresse+
                " -nbProduits:"+nbProduits+"\n";
        for(int i=0 ; i<nbProduits ;i++){
        ch2 =ch2+ "NomProduit:"+tabProduits[i].getLibelle()+
                " PrixProduit:"+tabProduits[i].getPrix()+"\n";
        }
        return ch1 + ch2;
    }
    
}
