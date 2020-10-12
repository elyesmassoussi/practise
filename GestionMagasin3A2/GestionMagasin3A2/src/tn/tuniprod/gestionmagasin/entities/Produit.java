package tn.tuniprod.gestionmagasin.entities;


import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author House
 */
public class Produit {
  private   int id;
  private   String libelle;
  private   String marque;
  private   float prix;
  private   Date dateExp;
     
     public Produit(){
      System.out.println("3A2 Esprit");
     }
     
     public Produit(int id, String libelle,String marque){
         
         this.id = id;
         this.libelle = libelle;
         this.marque = marque;
         
     }
     public Produit(int prdid, String prdlibelle,String prdmarque,float prdprix){
        id = prdid;
         libelle = prdlibelle;
         marque = prdmarque;
         if(prdprix >0){
         prix = prdprix;
         }
         else
         prix =0;
     }
     
     public int getId(){
         return id;
     }
     
     public void setId(int id){
         this.id = id;
     }
     
     public String getLibelle(){
         return libelle;
     }
     
     public void setLibelle(String libelle){
         this.libelle = libelle;
     }
     
     public String getMarque(){
         return marque;
     }
     
     public void setMarque(String marque){
         this.marque = marque;
     }
     
     public float getPrix(){
         return prix;
     }
        
     public void setPrix(float prix){
         if(prix >0){
         this.prix = prix;
         }
         else
         this.prix = 0;
     }
     
     public Date getDateExp(){
         return dateExp;
     }
     
     public void setDate(Date dateExp){
         this.dateExp = dateExp;
     }
     
     public void afficher(){
         System.out.println("Id:"+id+" -Marque:"
                 +marque+" -Libelle:"+libelle+" -Prix:"+prix);
     }
     
     @Override
     public String toString(){
         return "Id:"+id+" -Marque:"
                 +marque+" -Libelle:"+libelle+" -Prix:"+prix+" -DateExp:"+dateExp;
     }
     
    
}
