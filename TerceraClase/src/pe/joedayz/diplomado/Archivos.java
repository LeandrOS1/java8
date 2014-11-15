/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.joedayz.diplomado;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 *
 * @author NARUTO
 */
public class Archivos {

    public static void main(String[] args) {
        Usuario usuario1 = new Usuario("Hugo", 150);
        Usuario usuario2 = new Usuario("Paco", 120);
        Usuario usuario3 = new Usuario("Luis", 145);
        Usuario usuario4 = new Usuario("Omar", 155);
        Usuario usuario5 = new Usuario("Elias", 125);
        Usuario usuario6 = new Usuario("felipe", 145);
        Usuario usuario7 = new Usuario("Deborah", 120);
        Usuario usuario8 = new Usuario("Maria INES", 155);
        Usuario usuario9 = new Usuario("Liam", 125);
        Usuario usuario10 = new Usuario("Daniel", 120);
        Usuario usuario11 = new Usuario("Miryan", 300);
        Usuario usuario12 = new Usuario("Catalina", 300);

        usuario11.cambiarAModerador();
        usuario12.cambiarAModerador();

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
        try {
//            Files.list(Paths.get("./src/pe/joedayz/diplomado"))
//                    .forEach(System.out::println);

//            Files.list(Paths.get("./src/pe/joedayz/diplomado"))
//                    .filter(p -> p.toString().endsWith("java"))
//                    .forEach(System.out::println);   
            //mostrar todo su contenido
            LongStream lineas = Files.list(Paths.get("./src/pe/joedayz/diplomado"))
                    .filter(p -> p.toString().endsWith("java"))
                    .mapToLong(p -> lines(p).count());

            List<Long> lineas2 = Files.list(Paths.get("./src/pe/joedayz/diplomado"))
                    .filter(p -> p.toString().endsWith("java"))
                    .map(p -> lines(p).count())
                    .collect(Collectors.toList());

            Map<Path, Long> lineasPorFile = new HashMap();

            Files.list(Paths.get("./src/pe/joedayz/diplomado"))
                    .filter(p -> p.toString().endsWith("java"))
                    .forEach(p -> lineasPorFile.put(p, lines(p).count()));

            Map<Path, Long> lineasMap
                    = Files.list(Paths.get("./src/pe/joedayz/diplomado"))
                    .filter(p -> p.toString().endsWith("java"))
                    .collect(Collectors.toMap(p -> p, p -> lines(p).count()));

            //Mapear todos los usuarios utilizando su nombre como llave
            Map<String, Usuario> nombreAUsuario
                    = usuarios.stream()
                    .collect(Collectors.toMap(Usuario::getNombre,
                                    Function.identity()));

            Map<Integer, List<Usuario>> puntuacion = new HashMap();

            for (Usuario u : usuarios) {
                if (!puntuacion.containsKey(u.getPuntos())) {
                    puntuacion.put(u.getPuntos(), new ArrayList<>());
                }
                puntuacion.get(u.getPuntos()).add(u);
            }

            //primera forma
            for (Usuario u : usuarios) {
                puntuacion.computeIfAbsent(u.getPuntos(), user -> new ArrayList<>())
                        .add(u);

            }

            Map<Integer, List<Usuario>> puntuacion2
                    = usuarios.stream().collect(Collectors.groupingBy(Usuario::getPuntos));

            //agrupar en dos grupos: moderadores y no moderadores
            Map<Boolean, List<Usuario>> moderadores
                    = usuarios.stream().collect(Collectors.partitioningBy(Usuario::isModerador));
            

            Map<Boolean, List<String>> moderadoresPorTipo
                    = usuarios.stream().collect(Collectors.
                            partitioningBy( Usuario::isModerador  ,
                                    Collectors.mapping(Usuario::getNombre, Collectors.toList())));
             
             
             
               Map<Boolean, Integer> puntuacionPorTipo = 
                       usuarios.stream().collect(Collectors.
                            partitioningBy( Usuario::isModerador  ,
                                    Collectors.summingInt(Usuario::getPuntos)));
              
               
               
               String nombres = usuarios.stream().
                       map(Usuario::getNombre)
                       .collect(Collectors.joining(", "));
                System.out.println(nombres);
                
                
                
             
        } catch (IOException ex) {
            Logger.getLogger(Archivos.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    static Stream<String> lines(Path p) {
        try {
            return Files.lines(p);
        } catch (IOException ex) {
            throw new UncheckedIOException(ex);
        }

    }

}
