/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package produit;

import java.util.Date;

/**
 *
 * @author masso
 */
public class Produit {

    /**
     * @param args the command line arguments
     */
        private  int id;
        private String libellé;
        private String marque;
        private double prix;
        Date d;
        public Produit(int id,String libellé, String marque)
        {
            this.id=id;
            this.libellé=libellé;
            this.marque=marque;
            
            
        }
        public Produit(int id, String libellé, String marque, double prix)
        {
            this.id=id;
            this.libellé=libellé;
            this.marque=marque;
            this.prix=prix;
            
            
        }
    public static void main(String[] args) {
        // TODO code application logic here
         Produit p;
         Produit a= new Produit(1021,"Lait","Delice");
         Produit b= new Produit(2510,"Yaourt","Vitalait");
         Produit c= new Produit(3250,"Tomate","Sicam",1.2);
         
    }
    
}
   