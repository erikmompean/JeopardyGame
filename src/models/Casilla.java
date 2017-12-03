/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import javax.swing.JButton;

/**
 *
 * @author Manel
 */
public class Casilla {
    //Erik
    private int columna;
    private int fila;
    private JButton button;
    private Pregunta pregunta;

    public Casilla(int columna, int fila, JButton button, Pregunta pregunta) {
        this.columna = columna;
        this.fila = fila;
        this.button = button;
        this.pregunta = pregunta;
    }
    
    public void setPunutacion(int puntuacion){
        button.setText(String.valueOf(puntuacion));
    }
}
