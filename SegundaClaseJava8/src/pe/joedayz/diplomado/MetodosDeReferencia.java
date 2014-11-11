/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.joedayz.diplomado;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import static java.util.Comparator.*;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;
/**
 *
 * @author NARUTO
 */
public class MetodosDeReferencia {

    public static void main(String[] args) {

        Usuario usuario1 = new Usuario("Hugo", 150);
        Usuario usuario2 = new Usuario("Paco", 120);
        Usuario usuario3 = new Usuario("Luis", 190);
        List<Usuario> usuarios = new ArrayList<>();
        usuarios.add(usuario1);
        usuarios.add(usuario2);
        usuarios.add(usuario3);
        
        usuarios.forEach(u -> u.cambiarAModerador());
     
        //referencia a metodo  - method reference
        usuarios.forEach(Usuario::cambiarAModerador);
        
        Consumer<Usuario> cambiarAModerador = Usuario::cambiarAModerador;
        usuarios.forEach(cambiarAModerador);
        
        Consumer<Usuario> cambiarAModerador2 = u -> u.cambiarAModerador();
         usuarios.forEach(cambiarAModerador2);
         
         //comparar
         
         usuarios.sort(Comparator.comparing(Usuario::getNombre));
         
         //con import statics
         usuarios.sort(comparing(Usuario::getNombre));
         
         //comparando por nombre y por puntos
         Comparator<Usuario> c = Comparator.comparingInt(Usuario::getPuntos).thenComparing(Usuario::getNombre);
                                
         //los nulos ponlos al final
         usuarios.sort(Comparator.nullsLast(Comparator.comparing(Usuario::getNombre)));
         
         //ordenar por puntos pero en formaa decreciente
         usuarios.sort(Comparator.comparing(Usuario::getPuntos).reversed());
         
         //System.out.println(usuarios);
         
         //Referenciando metodos de instancia
         Usuario alex = new Usuario("Alex Padilla", 50);
         Runnable bloque = alex::cambiarAModerador;
         bloque.run();
        
         //Runnable bloque = alex::cambiarAModerador; es equivalente a
         Runnable bloque1 = () -> alex.cambiarAModerador();
         bloque1.run();
         
         
         //accept
         
         Consumer<Usuario> consumer = Usuario::cambiarAModerador;
         consumer.accept(alex);  // ---> hace que se invoque el metodo alex.cambiarAModerador();
         
         //referencia a metodos que reciben argumentos
         //println que es PrintStream, out de System
         
         usuarios.forEach(System.out::println);
         
         
         usuarios.forEach(u -> System.out.println(u));
         
         for(Usuario u : usuarios){ 
             System.out.println(u);
         }
         
         //tambien podemos usar method references para constructores
         
         //Usuario luisa = Usuario::new;   --> no se puede porque Usuario no es interface funcional
         
         Supplier<Usuario> creadorDeUsuarios = Usuario::new;
         
         Usuario nuevo = creadorDeUsuarios.get();  //usamos el supplier para crear objetos con el constructor sin arg
         
         Function<String, Usuario> creadorDeUsuarios2 = Usuario::new;
         
         Usuario miguel = creadorDeUsuarios2.apply("Miguel Mendoza");
         Usuario cesar = creadorDeUsuarios2.apply("Cali CD");
         
         Usuario pepe = new Usuario();
         
         
         BiFunction<String, Integer, Usuario> crearDeUsuarios3 = Usuario::new;
         
         Usuario ubaldo = crearDeUsuarios3.apply("Ubaldo Acosta", 50);
         Usuario paulo = crearDeUsuarios3.apply("Paulo Cesar", 350);
         
         
         
         
         
    }
}
