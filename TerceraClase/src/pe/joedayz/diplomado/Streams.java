/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.joedayz.diplomado;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.Random;
import java.util.Set;
import java.util.function.IntBinaryOperator;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import static java.util.stream.Collectors.*;
import java.util.stream.IntStream;

/**
 *
 * @author NARUTO
 */
public class Streams {

    public static void main(String[] args) {

        Usuario usuario1 = new Usuario("Hugo", 150);
        Usuario usuario2 = new Usuario("Paco", 120);
        Usuario usuario3 = new Usuario("Luis", 145);
        Usuario usuario4 = new Usuario("Omar", 155);
        Usuario usuario5 = new Usuario("Elias", 125);
        Usuario usuario6 = new Usuario("felipe", 80);
        Usuario usuario7 = new Usuario("Deborah", 127);
        Usuario usuario8 = new Usuario("Maria INES", 56);
        Usuario usuario9 = new Usuario("Liam", 93);
        Usuario usuario10 = new Usuario("Daniel", 111);
        Usuario usuario11 = new Usuario("Miryan", 200);
        Usuario usuario12 = new Usuario("Catalina", 249);
        List<Usuario> usuarios = new ArrayList<>();
        usuarios.add(usuario1);
        usuarios.add(usuario2);
        usuarios.add(usuario3);
        usuarios.add(usuario4);
        usuarios.add(usuario5);
        usuarios.add(usuario6);
        usuarios.add(usuario7);
        usuarios.add(usuario8);
        usuarios.add(usuario9);
        usuarios.add(usuario10);
        usuarios.add(usuario11);
        usuarios.add(usuario12);

        //ordenarlos. Si modifica la lista
        usuarios.sort(Comparator.comparing(Usuario::getNombre));
        
        

        //filtrar los usuarios con mas de 100 puntos
        //no modifica la lista
        usuarios.stream().filter(u -> u.getPuntos() > 100)
                .sorted(Comparator.comparing(Usuario::getNombre));

        //si queremos retornar una lista
        List<Usuario> filtradosYOrdenados = usuarios.stream()
                .filter(u -> u.getPuntos() > 100)
                .sorted(Comparator.comparing(Usuario::getNombre))
                .collect(Collectors.toList());
        
        Usuario masDe100 = usuarios.stream()
                .filter(u -> u.getPuntos() > 100)
                .collect(Collectors.toList())
                .get(0);
                
        
        
       

        //lazy
        Optional<Usuario> usuarioOptional = usuarios.stream()
                .filter(u -> u.getPuntos() > 100)
                .findAny();
//
//        //peek
//        usuarios.stream().
//                filter(u -> u.getPuntos() > 100)
//                .peek(System.out::println)
//                .findAny();

        
        
        
//        //no imprime nada
        usuarios.stream()
                .filter(u -> u.getPuntos() > 100)
                .peek(System.out::println);
//
        
        usuarios.stream()
                .sorted(Comparator.comparing(Usuario::getNombre))
                .peek(System.out::println)
                .findAny();
        
//        //reduccion
        double media = usuarios.stream()
                .mapToInt(Usuario::getPuntos)
                .average()
                .getAsDouble();
//
        Optional<Usuario> max = usuarios.stream()
                .max(Comparator.comparing(Usuario::getPuntos));
        Usuario maximaPuntuacion = max.get();
 
//
        int total = usuarios.stream()
                .mapToInt(Usuario::getPuntos)
                .sum();
        
        System.out.println("total " + total);
        
//
        int valorInicial = 0;
        IntBinaryOperator operacion = (a, b) -> a + b;
//
        total = usuarios.stream()
                .mapToInt(Usuario::getPuntos)
                .reduce(valorInicial, operacion);
//
        System.out.println("total " + total);
//        //o
        total = usuarios.stream()
                .mapToInt(Usuario::getPuntos)
                .reduce(0, (a, b) -> a + b);
//
        System.out.println("total " + total);
//        //o
        total = usuarios.stream()
                .mapToInt(Usuario::getPuntos)
                .reduce(0, Integer::sum);
//
        System.out.println("total " + total);
        
//        //multiplicar
        int multiplicacion = usuarios.stream()
                .mapToInt(Usuario::getPuntos)
                .reduce(1, (a,b) -> a*b);
//        
        total = usuarios.stream()
                .reduce(0, (actual, u) -> actual + u.getPuntos(), Integer::sum);
        
//        //iterator
        usuarios.stream().iterator()
                .forEachRemaining(System.out::println);
//        
//        //anyMatch
        boolean hasModerador = usuarios.stream()
                .anyMatch(Usuario::isModerador);
        

        
        
        
        
        
    }

}
