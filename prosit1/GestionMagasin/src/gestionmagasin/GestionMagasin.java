/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionmagasin;

/**
 *
 * @author masso
 */
public class GestionMagasin {

    /**
     * @param args the command line arguments
     */
    public class Produit
    {
        
        private  int id;
        private String libellé;
        private String marque;
        private float prix;
        public Produit(int id,String libellé, String marque)
        {
            this.id=id;
            this.libellé=libellé;
            this.marque=marque;
            
            
        }
        public Produit(int id,String libellé, String marque,float prix)
        {
            this.id=id;
            this.libellé=libellé;
            this.marque=marque;
            this.prix=prix;
            
            
        }
    }
    public static void main(String[] args) {
        // TODO code application logic here
        Produit p;
        Produit a= new Produit(1021,"Lait","Delice",0);
        
    }
    
}
