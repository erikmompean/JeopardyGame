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

/**
 *
 * @author Manel
 */
public class InicioController  implements ActionListener {

    //Manel
    Inicio viewInicio;
    Jugador jugador1;
    Jugador jugador2;
    

    public InicioController(Inicio viewI) {
        this.viewInicio=viewI;
        init();
    }

    private void init() {
        
       viewInicio.butonInicio.addActionListener(this);
    }
    @Override
     public void actionPerformed(ActionEvent ae) {
         jugador1.setNickName(viewInicio.player1.getText());
         jugador2.setNickName(viewInicio.player2.getText());
         
     }
     
}
