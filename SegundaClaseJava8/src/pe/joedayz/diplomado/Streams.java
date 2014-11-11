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
import java.util.Set;
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

        
        //filtrar los 10 usuarios con mas puntos y convertirlos en moderadores
        usuarios.sort(Comparator.comparing(Usuario::getPuntos).reversed());        
        usuarios.subList(0, 10).forEach(Usuario::cambiarAModerador);
        
        //antes
        for(Usuario usuario: usuarios){
            if(usuario.getPuntos()> 100){
                usuario.cambiarAModerador();
            }
        }
    
        //java 8 introdujo los streams
        Stream<Usuario> stream0 = usuarios.stream();
        stream0.filter(u -> {return u.getPuntos()>100;});
        
        //mejorado
        Stream<Usuario> stream1 = usuarios.stream(); 
        //stream.filter(u -> u.getPuntos()>100);
        
        usuarios.stream().filter(u -> u.getPuntos()>100);
        
       // usuarios.forEach(System.out::println);
        
        Stream<Usuario> stream2 = usuarios.stream().filter(u -> u.getPuntos()>100);
        //stream2.forEach(System.out::println);
        
        
        usuarios.stream().filter(u -> u.getPuntos()>100).forEach(Usuario::cambiarAModerador);
        
        //quiero los usuarios moderadores
        usuarios.stream().filter(u -> u.isModerador());
        
        usuarios.stream().filter(Usuario::isModerador);
        
        //Como obtener de vuelta una lista
        List<Usuario> masQue100 = new ArrayList<>();
        
        usuarios.stream().filter(u -> u.getPuntos()>100).forEach(u -> masQue100.add(u));
        
        usuarios.stream().filter(u -> u.getPuntos()>100).forEach(masQue100::add);
        
        //Collectors
        //usar el metodo collect para recuperar elementos de Stream<Usuario> para una List
        List<Usuario> masQue100Collect = usuarios.stream().filter(u -> u.getPuntos()>100)
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
        
        masQue100Collect = usuarios.stream().filter(u -> u.getPuntos()>100).collect(toList());
        
        Set<Usuario> masQue100CollectSet = 
                usuarios.stream().filter(u -> u.getPuntos()>100).collect(toSet());
        
        Set<Usuario> setData = usuarios.stream().collect(Collectors.toCollection(HashSet::new));
        
        Usuario[] arrayUsuarios = usuarios.stream().toArray(Usuario[]::new);
        
        //Listar los puntos de todos los usuarios con map de stream
        
        List<Integer> puntos = new ArrayList<>();
        usuarios.forEach(u -> puntos.add(u.getPuntos()));
        
        
         List<Integer> puntosConMap = usuarios.stream().map(Usuario::getPuntos).collect(toList());
         
         IntStream stream = usuarios.stream().mapToInt(Usuario::getPuntos); //max, sorted, average
         
         double media = usuarios.stream().mapToInt(Usuario::getPuntos).average().getAsDouble();
         
         //java.util.Optional , OptionalDouble, OptionalInt
         
         
         OptionalDouble mediaDouble = usuarios.stream().mapToInt(Usuario::getPuntos).average();
         
        media = mediaDouble.orElse(0.0);
         
        media = usuarios.stream().mapToInt(Usuario::getPuntos).average().orElse(0.0);
        
        media = usuarios.stream().mapToInt(Usuario::getPuntos).average().
                    orElseThrow(IllegalStateException::new);
        
        // queremos el ususario con la mayor cantidad de puntos
        Optional<Usuario> max = usuarios.stream().max(Comparator.comparing(Usuario::getPuntos));
        
        Optional<String> maxNombres =  usuarios.stream().max(Comparator.
                comparing(Usuario::getPuntos)).map(Usuario::getNombre);
         
    }

}
