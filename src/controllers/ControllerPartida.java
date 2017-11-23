/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import models.Jugador;
import views.TableroView;

/**
 *
 * @author Manel
 */
public class ControllerPartida {
    Jugador player1;
    Jugador player2;
    TableroView tablero;

    public ControllerPartida(Jugador player1, Jugador player2, TableroView tablero) {
        this.player1 = player1;
        this.player2 = player2;
        this.tablero = tablero;
    }
    

   
}
