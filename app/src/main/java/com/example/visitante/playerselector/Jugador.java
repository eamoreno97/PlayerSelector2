package com.example.visitante.playerselector;
import java.io.Serializable;
/**
 * Created by Visitante on 26/02/2018.
 */

public class Jugador implements Serializable{
    String Nombre, Apellido, Posicion;
    boolean seleccionado;
    int edad;

    public Jugador(String Nombre, String Apellido, String Posicion, boolean seleccionado, int edad){
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.Posicion = Posicion;
        this.seleccionado = seleccionado;
        this.edad = edad;
    }
}
