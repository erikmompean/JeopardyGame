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
public class TableroModel {
    //Erik
    ArrayList<Categoria> categorias;
    Timer contador;
    Jugador jugador1, jugador2;

    public TableroModel(ArrayList<Categoria> categorias, Jugador jugador1, Jugador jugador2) {
        this.categorias = categorias;
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        
    }

    public ArrayList<Categoria> getCategorias() {
        return categorias;
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
