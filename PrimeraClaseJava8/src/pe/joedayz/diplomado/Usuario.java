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
public class Usuario {
    
    private String nombre;
    private int puntos;
    private boolean moderador;

    public Usuario(String nombre, int puntos) {
        this.nombre = nombre;
        this.puntos = puntos;
        this.moderador = false;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPuntos() {
        return puntos;
    }

    public boolean isModerador() {
        return moderador;
    }
    
    public void cambiarAModerador(){
        this.moderador = true;
        
    }
    
    
    
}
