/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prosit0;
import java.util.*;
/**
 *
 * @author masso
 */
public class Prosit0 {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.print("enter the first number ");
        Scanner sc= new Scanner(System.in);
        int n1= sc.nextInt();
        System.out.print("enter the second number ");
        int n2= sc.nextInt();
        float somme=0;
        somme = n1+n2;
        System.out.println("le resultat est :"+somme);
        
    }
    
}
