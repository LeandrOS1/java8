/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.joedayz.diplomado;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import pe.joedayz.diplomado.Usuario;
import static java.util.Comparator.*;
import java.util.function.Function;
import java.util.function.ToIntFunction;
/**
 *
 * @author NARUTO
 */
public class Ordenamiento {

    public static void main(String[] args) {
        Usuario usuario1 = new Usuario("Hugo", 150);
        Usuario usuario2 = new Usuario("Paco", 120);
        Usuario usuario3 = new Usuario("Luis", 190);
        List<Usuario> usuarios = new ArrayList<>();
        usuarios.add(usuario1);
        usuarios.add(usuario2);
        usuarios.add(usuario3);

        Comparator<Usuario> comparator = new Comparator<Usuario>() {

            @Override
            public int compare(Usuario u1, Usuario u2) {
                return u1.getNombre().compareTo(u2.getNombre());
            }

        };

        Collections.sort(usuarios, comparator);

        Comparator<Usuario> comparator2 = (u1, u2) -> u1.getNombre().compareTo(u2.getNombre());
        Collections.sort(usuarios, comparator2);
        
        //en una sola linea
        Collections.sort(usuarios, (u1, u2) -> u1.getNombre().compareTo(u2.getNombre()));
        
        
        //mas resumida
        usuarios.sort((u1, u2) -> u1.getNombre().compareTo(u2.getNombre()));
        
        //comparing
        Comparator<Usuario> comparator3 = Comparator.comparing(u -> u.getNombre());
        usuarios.sort(comparator3);
        
        usuarios.sort(Comparator.comparing(u -> u.getNombre()));
        
        //usando static imports
        usuarios.sort(comparing(u -> u.getNombre()));
        
       
        
        //Strings
        List<String> palabras = Arrays.asList("JoeDayz", "JobDayz", "Campus");
        palabras.sort(Comparator.reverseOrder());  //naturalOrder
        
        
        
        //ordenando por puntos
        usuarios.sort(Comparator.comparing(u -> u.getPuntos()));
        
        //para ver como trabaja internamente voy a hacer esto
        Function<Usuario, Integer> extraPuntos = u -> u.getPuntos();
        Comparator<Usuario> comparator4 = Comparator.comparing(extraPuntos);
        usuarios.sort(comparator4);
        
        
        
        ToIntFunction<Usuario> extraPuntos2 = u -> u.getPuntos();
        Comparator<Usuario> comparator5 = Comparator.comparing(extraPuntos);
        usuarios.sort(comparator5);
        
        System.out.println(usuarios);
    }
}
