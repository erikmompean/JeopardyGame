/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import models.Jugador;
import views.Podium;

/**
 *
 * @author Manel
 */
public class PodiumController {

    //Manel
    private Podium podio;
    private Jugador jugador1;
    private Jugador jugador2;

    public PodiumController(Podium podio, Jugador jugador1, Jugador jugador2) {
        this.podio = podio;
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        posicionar();
    }

    private void posicionar() {
        String text = jugador1.getNickName();
        String text2 = jugador2.getNickName();
        if (jugador1.getPuntuacion() > jugador2.getPuntuacion()) {
            podio.pos1.setText(text);
            podio.pos2.setText(text2);
        } else {
            podio.pos2.setText(text2);
            podio.pos1.setText(text);
        }
    }

}
