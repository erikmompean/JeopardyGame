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

    public TableroModel(ArrayList<Categoria> categorias, Jugador jugador1, Jugador jugador2) {
        this.categorias = categorias;
        
    }

    public ArrayList<Categoria> getCategorias() {
        return categorias;
    }
    
}
