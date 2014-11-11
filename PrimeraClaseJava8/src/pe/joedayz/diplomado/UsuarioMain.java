/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.joedayz.diplomado;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 *
 * @author NARUTO
 */
public class UsuarioMain {

    public static void main(String[] args) {
        Usuario usuario1 = new Usuario("Hugo", 150);
        Usuario usuario2 = new Usuario("Paco", 120);
        Usuario usuario3 = new Usuario("Luis", 190);

        List<Usuario> usuarios = Arrays.asList(usuario1, usuario2, usuario3);

        //1
        for (Usuario u : usuarios) {
            System.out.println(u.getNombre());
        }

        //2
        Mostrador mostrador = new Mostrador();
        usuarios.forEach(mostrador);

        //3 - clases anonimas
        Consumer<Usuario> mostrador2 = new Consumer<Usuario>() {

            @Override
            public void accept(Usuario u) {
                System.out.println(u.getNombre());
            }

        };

        usuarios.forEach(mostrador2);

        //4 
        usuarios.forEach(new Consumer<Usuario>() {

            @Override
            public void accept(Usuario u) {
                System.out.println(u.getNombre());
            }

        });

        Consumer<Usuario> mostrador3 = u -> System.out.println(u.getNombre());

        //5
        usuarios.forEach(u -> System.out.println(u.getNombre()));

        usuarios.forEach(u -> u.cambiarAModerador());

        //1 forma
        Runnable r = new Runnable() {

            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println(i);
                }
            }

        };
        new Thread(r).start();

        //2 forma
        Runnable r1 = () -> {
            for (int i = 0; i < 10; i++) {
                System.out.println(i);
            }
        };
        new Thread(r1).start();

        //3ra forma
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println(i);
            }
        }).start();

        Button button = new Button();
        //1
        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("boton presionado");
            }

        });
        //2
        Button button1 = new Button();
        button1.addActionListener(event -> System.out.println("boton1 presionado"));

        //1
        Validator<String> validatorCEP = new Validator<String>() {

            @Override
            public boolean validar(String valor) {
                return valor.matches("[0-9]{5}-[0-9]{3}");
            }

        };

        //2
        Validator<String> validatorMio = valor -> {
            return valor.matches("[0-9]{5}-[0-9]{3}");
        };

       // Object o = () -> {System.out.println("quien soy?");};
        Runnable o = () -> System.out.println("hola lambda");
        
    }
}
