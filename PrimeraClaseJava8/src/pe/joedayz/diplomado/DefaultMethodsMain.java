/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.joedayz.diplomado;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 *
 * @author NARUTO
 */
public class DefaultMethodsMain {

    public static void main(String[] args) {
        Usuario usuario1 = new Usuario("Hugo", 150);
        Usuario usuario2 = new Usuario("Paco", 120);
        Usuario usuario3 = new Usuario("Luis", 190);

        List<Usuario> usuarios = Arrays.asList(usuario1, usuario2, usuario3);  //COLECCION INMUTABLE

        Consumer<Usuario> mostrarMensajes = u -> System.out.println("Antes de imprimir los nombres");

        Consumer<Usuario> imprimirNombres = u -> System.out.println(u.getNombre());

        usuarios.forEach(mostrarMensajes.andThen(imprimirNombres));  //decorator

        //predicates
        Predicate<Usuario> predicado = new Predicate<Usuario>() {

            @Override
            public boolean test(Usuario u) {
                return u.getPuntos() > 160;
            }

        };

        List<Usuario> usuarios2 = new ArrayList<>();
        usuarios2.add(usuario1);
        usuarios2.add(usuario2);
        usuarios2.add(usuario3);
        
        usuarios2.removeIf(u -> u.getPuntos() > 160);

        //usuarios2.forEach(u -> System.err.println(u));

        
        
        
    }
}
