/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.joedayz.diplomado;

/**
 *
 * @author NARUTO
 */
public class VariablesLocales {
    
    
    public static void main(String[] args) {
        final int numero = 5;
        
        new Thread( () -> {System.out.println("numero es " + numero);}).start();
        
        
    }
}
