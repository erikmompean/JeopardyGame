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
public class Casilla {
    //Erik
    final int NUMERO_MAXIMO_DE_RESPUESTAS = 4;
    int puntuacion, id, respuesta;
    String pregunta;
    String[] respuestas =  new String[NUMERO_MAXIMO_DE_RESPUESTAS];

    public Casilla( int id, int puntuacion,String pregunta, int respuesta, String respuesta1, String[] respuestas ) {
        this.puntuacion = puntuacion;
        this.id = id;
        this.respuesta = respuesta;
        this.pregunta = pregunta;
        if (respuestas.length == NUMERO_MAXIMO_DE_RESPUESTAS){
            for(int i = 0; i < respuestas.length ;i++){
                this.respuestas[i] = respuestas[i];
            }
        }else{
            //TODO error system
        }
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public int getId() {
        return id;
    }

    public int getRespuesta() {
        return respuesta;
    }

    public String getPregunta() {
        return pregunta;
    }

    public String[] getRespuestas() {
        return respuestas;
    }
    
    
}
