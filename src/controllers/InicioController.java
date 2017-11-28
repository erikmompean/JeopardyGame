/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import models.Jugador;
import views.Inicio;
import views.TableroView;

/**
 *
 * @author Manel
 */
public class InicioController implements ActionListener {

    //Manel
    Inicio viewInicio;
    Jugador jugador1;
    Jugador jugador2;

    public InicioController(Inicio viewI) {
        this.viewInicio = viewI;

        init();
    }

    private void init() {

        viewInicio.butonInicio.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String name1 = viewInicio.player1.getText();
        jugador1 = new Jugador(name1);
        String name2= viewInicio.player2.getText();
        jugador2= new Jugador(name2);
        TableroView tableroView = new TableroView("Jeopardy en marcha");
        ControllerPartida controllerP = new ControllerPartida(jugador1, jugador2, tableroView);
        viewInicio.dispose();
    }

}
