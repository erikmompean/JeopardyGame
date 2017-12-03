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
    int id;
    String nombre;
    HashMap<Integer, Pregunta> preguntas;

    public Categoria(int id, String nombre, HashMap<Integer, Pregunta> preguntas) {
        this.id = id;
        this.nombre = nombre;
        this.preguntas = preguntas;
    }

    public int getId() {
        return id;
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
