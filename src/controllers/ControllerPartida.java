/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import javax.swing.JButton;
import models.Categoria;
import models.Jugador;
import models.Pregunta;
import models.TableroModel;
import views.PreguntaView;
import views.TableroView;

/**
 *
 * @author Manel
 */
public class ControllerPartida implements ActionListener{
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
        insertarJugadores();
        insertarPreguntas();
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
    
    /**
     * Este metodo se encargade cojer los jugadores y insertar su nombre y su puntuacion
     * en el tablero
     */
    private void insertarJugadores(){
        vTablero.playerLeftName.setText(player1.getNickName());
        vTablero.playerRightName.setText(player2.getNickName());
        vTablero.scoreLeft.setText(String.valueOf(player1.getPuntuacion()));
        vTablero.scoreRight.setText(String.valueOf(player2.getPuntuacion()));
    }

    private void insertarPreguntas(){
        
        for(Categoria categoria: mTablero.getCategorias()){
            System.out.println(categoria.getNombre());
            
            for (int j = 0; j < vTablero.ROWS ; j++) {
                HashMap<Integer, Pregunta> preguntas;
                preguntas = categoria.getPreguntas();
                Pregunta preguntaDelBoton = preguntas.get(j);
                vTablero.allButtons[categoria.getId()][j].setText(String.valueOf(preguntaDelBoton.getPuntuacion()));
                vTablero.allButtons[categoria.getId()][j].addActionListener(this);
            }
            
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Pregunta pregunta = null;
        boolean encontrado = false;
        for(Categoria categoria: mTablero.getCategorias()){
            System.out.println(categoria.getNombre());
            
            for (int j = 0; j < vTablero.ROWS ; j++) {
                HashMap<Integer, Pregunta> preguntas;
                preguntas = categoria.getPreguntas();
                pregunta = preguntas.get(j);
                if(e.getSource() == vTablero.allButtons[categoria.getId()][j]){
                    encontrado = true;
                    break;
                }
                
            }
            if(encontrado)
                break;
            
        }
        PreguntasController preguntaSeleccionada = new PreguntasController(pregunta);
        //cierrre ventana actual???
        
    }
}
