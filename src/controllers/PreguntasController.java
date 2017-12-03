/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import models.Pregunta;
import views.PreguntaView;

/**
 *
 * @author Manel
 */
public class PreguntasController {
    PreguntaView vistaPregunta;
    Pregunta mPregunta;

    public PreguntasController(PreguntaView vistaPregunta, Pregunta mPregunta) {
        this.vistaPregunta = vistaPregunta;
        this.mPregunta = mPregunta;
        onCreate();
    }

    private void onCreate() {
        vistaPregunta.vPregunta.setText(mPregunta.getPregunta());
    }
    
    
}
