/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.tuniprod.gestionmagasin.test;

import java.util.Date;
import tn.tuniprod.gestionmagasin.entities.Magasin;
import tn.tuniprod.gestionmagasin.entities.Produit;

/**
 *
 * @author House
 */
public class MainClass {
    
    public static void main(String []args){
       Produit p1 = new Produit();
       Produit p2 = new Produit(1025,"Lait","Delice");
       Produit p3 = new Produit(2510,"Yaourt","Vitalait");
       Produit p4 = new Produit(3250,"Tomate","Sicam",1.200f);
       Date d4 = new Date();
       p2.setDate(d4);
       
       p1.afficher();
       p2.afficher();
       p3.afficher();
       p4.afficher();
       
       p2.setPrix(0.6f);
       p2.afficher();
       p3.setPrix(0.400f);
       p3.afficher();
       System.out.println("=============");
      // String res = p2.toString();
       System.out.println(p2);
       
       Magasin m1 = new Magasin(25,"Nabeul");
       Magasin m2 = new Magasin(30,"Djerba");
       m1.ajouterProduit(p3);
       m1.ajouterProduit(p2);
       System.out.println("-------=========--------");
       System.out.println(m1.nbProduits);
       System.out.println(Magasin.nbTotal);
       
       m2.ajouterProduit(p4);
       m2.ajouterProduit(p2);
       m2.ajouterProduit(p3);
       System.out.println(m2.nbProduits);
       System.out.println(Magasin.nbTotal);
       System.out.println("-------=========--------");
       
       System.out.println("=============");
       //String res = m1.toString();
       System.out.println(m1);
    }
}
