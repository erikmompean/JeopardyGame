/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.HashMap;

/**
 *
 * @author Manel
 */
public class Categoria {
    //Manel
    String nombre;
    HashMap<Integer, Pregunta> preguntas;

    public Categoria(String nombre, HashMap<Integer, Pregunta> preguntas) {
        this.nombre = nombre;
        this.preguntas = preguntas;
    }

    public String getNombre() {
        return nombre;
    }

    public HashMap<Integer, Pregunta> getPreguntas() {
        return preguntas;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPreguntas(HashMap<Integer, Pregunta> preguntas) {
        this.preguntas = preguntas;
    }

    
}
