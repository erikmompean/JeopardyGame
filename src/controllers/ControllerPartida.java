/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import models.Categoria;
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
        this.mTablero = mTablero;
        
        onCreate();
    }
    
    private void onCreate(){
        insertarCategorias();
    }

    /**
     * Este metodo se encargade cojer las categorias de nuestro modelo Tablero 
     * e insertarlo en la vista tablero.
     */
    private void insertarCategorias(){
        int i = 0;
        for(Categoria categoria : mTablero.getCategorias()){
            vTablero.botonesCategoria[i].setText(categoria.getNombre());
            i++;
        }
    }
   
}
