/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import models.Jugador;
import models.TableroModel;
import views.TableroView;

/**
 *
 * @author Manel
 */
public class ControllerPartida {
    Jugador player1;
    Jugador player2;
    TableroView vTablero;
    TableroModel mTablero;
    
    public ControllerPartida(Jugador player1, Jugador player2, TableroView vTablero, TableroModel mTablero) {
        this.player1 = player1;
        this.player2 = player2;
        this.vTablero = vTablero;
        onCreate();
    }
    
    private void onCreate(){
        
    }

   
}
