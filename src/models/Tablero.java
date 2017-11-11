/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.ArrayList;
import javax.swing.Timer;

/**
 *
 * @author Manel
 */
public class Tablero {
    //Erik
    ArrayList<Casilla> casillas;
    Timer contador;
    Jugador jugador1, jugador2;

    public Tablero(ArrayList<Casilla> casillas, Jugador jugador1, Jugador jugador2) {
        this.casillas = casillas;
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        // TODO Timer
    }

    public ArrayList<Casilla> getCasillas() {
        return casillas;
    }

    public Timer getContador() {
        return contador;
    }

    public Jugador getJugador1() {
        return jugador1;
    }

    public Jugador getJugador2() {
        return jugador2;
    }
    
    
}
