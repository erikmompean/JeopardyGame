/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author Manel
 */
public class Pregunta {

    //Manel
    private int id;
    String pregunta;
    String[] respuestas;
    int correcta;
    int puntuacion;

    public Pregunta(int id, String pregunta, String[] respuestas, int correcta) {
        this.id = id;
        this.pregunta = pregunta;
        this.respuestas = respuestas;
        this.correcta = correcta;
    }
    
    
    
    
}
