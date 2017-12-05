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

    public Pregunta(int id, String pregunta, String[] respuestas, int correcta, int puntuacion) {
        this.id = id;
        this.pregunta = pregunta;
        this.respuestas = respuestas;
        this.correcta = correcta;
        this.puntuacion = puntuacion;
    }

    public int getId() {
        return id;
    }

    public String getPregunta() {
        return pregunta;
    }

    public String[] getRespuestas() {
        return respuestas;
    }

    public int getCorrecta() {
        return correcta;
    }

    public int getPuntuacion() {
        return puntuacion;
    }
    
    public boolean esRespuestaCorrecta(int respuestaUsuario){
        boolean respuestaCorrecta = false;
        respuestaUsuario--;
        if (respuestaUsuario == correcta) {
            respuestaCorrecta = true;
        }
       return respuestaCorrecta;
    }
    
    
}
