/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import javax.swing.JButton;
import javax.swing.JOptionPane;
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
    Jugador jugador1;
    Jugador jugador2;
    TableroView vTablero;
    TableroModel mTablero;
    
    public ControllerPartida(Jugador player1, Jugador player2, TableroView vTablero, TableroModel mTablero) {
        this.jugador1 = player1;
        this.jugador2 = player2;
        this.vTablero = vTablero;
        this.mTablero = mTablero;
        
        onCreate();
    }
    
    private void onCreate(){
        iniciarPartida();
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
        vTablero.playerLeftName.setText(jugador1.getNickName());
        vTablero.playerRightName.setText(jugador2.getNickName());
        vTablero.scoreLeft.setText(String.valueOf(jugador1.getPuntuacion()));
        vTablero.scoreRight.setText(String.valueOf(jugador2.getPuntuacion()));
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
        //PreguntasController preguntaSeleccionada = new PreguntasController(pregunta);
        //cierrre ventana actual???
        Object[] options = {pregunta.getRespuestas()[0], pregunta.getRespuestas()[1], pregunta.getRespuestas()[2]}; 
        int n = JOptionPane.showOptionDialog(vTablero, pregunta.getPregunta(), 
                "Pregunta", 
                JOptionPane.YES_NO_CANCEL_OPTION, 
                JOptionPane.QUESTION_MESSAGE,
                null,
                options, 
                options[2]
        );
        
        cambiarTurno();
        
    }

    private void cambiarTurno() {
        Font f = vTablero.playerLeftName.getFont();
        
        if (jugador1.isEsMiTurno()) {
            jugador1.setEsMiTurno(false);
            jugador2.setEsMiTurno(true);
            
            vTablero.playerLeftName.setFont(f.deriveFont(f.getStyle() & ~Font.BOLD));
            vTablero.playerRightName.setFont(f.deriveFont(f.getStyle() | Font.BOLD));
        } else {
            jugador1.setEsMiTurno(true);
            jugador2.setEsMiTurno(false);
            
            vTablero.playerRightName.setFont(f.deriveFont(f.getStyle() & ~Font.BOLD));
            vTablero.playerLeftName.setFont(f.deriveFont(f.getStyle() | Font.BOLD));
        }
    }

    private void iniciarPartida() {
        jugador1.setEsMiTurno(true);
        
        Font f = vTablero.playerLeftName.getFont();
        vTablero.playerLeftName.setFont(f.deriveFont(f.getStyle() | Font.BOLD));
    }
    
}
