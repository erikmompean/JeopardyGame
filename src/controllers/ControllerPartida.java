/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.awt.Color;
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
    int ronda = 1;
    
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
        JButton boton = null;
        boolean encontrado = false;
        for(Categoria categoria: mTablero.getCategorias()){
            System.out.println(categoria.getNombre());
            
            for (int j = 0; j < vTablero.ROWS ; j++) {
                HashMap<Integer, Pregunta> preguntas;
                preguntas = categoria.getPreguntas();
                if(e.getSource() == vTablero.allButtons[categoria.getId()][j]){
                    boton = vTablero.allButtons[categoria.getId()][j];
                    pregunta = preguntas.get(j);
                    encontrado = true;
                    break;
                }
                
            }
            if(encontrado)
                break;
            
        }
        //PreguntasController preguntaSeleccionada = new PreguntasController(pregunta);
        //cierrre ventana actual???
        int respuestaUsuario = mostrarVistaPregunta(pregunta);
        administrarRonda(boton, pregunta, respuestaUsuario);
        cambiarTurno();

    }

    private void cambiarTurno() {
        Font f = vTablero.playerLeftName.getFont();
        
        if (jugador1.isEsMiTurno()) {
            
            jugador1.setEsMiTurno(false);
            jugador2.setEsMiTurno(true);
            
            vTablero.playerLeftName.setFont(f.deriveFont(f.getStyle() & ~Font.BOLD));
            vTablero.playerRightName.setFont(f.deriveFont(f.getStyle() | Font.BOLD));
        } else if(jugador2.isEsMiTurno()){
            jugador1.setEsMiTurno(true);
            jugador2.setEsMiTurno(false);
            
            vTablero.playerRightName.setFont(f.deriveFont(f.getStyle() & ~Font.BOLD));
            vTablero.playerLeftName.setFont(f.deriveFont(f.getStyle() | Font.BOLD));
            
            ronda++;
            comprobarDoubleRound();
            comprobarGanador();
        }
    }

    private void iniciarPartida() {
        jugador1.setEsMiTurno(true);
        
        Font f = vTablero.playerLeftName.getFont();
        vTablero.playerLeftName.setFont(f.deriveFont(f.getStyle() | Font.BOLD));
    }

    private void administrarRonda(JButton boton, Pregunta pregunta, int respuesta) {
        boton.setEnabled(false);
        if(pregunta.esRespuestaCorrecta(respuesta)) {
            Color colorAcierto = Color.decode("#B2FF59");
            boton.setBackground(colorAcierto);
            if(jugador1.isEsMiTurno()){
                
                jugador1.sumarPuntuacion(pregunta.getPuntuacion());
                vTablero.scoreLeft.setText(String.valueOf(jugador1.getPuntuacion()));
            } else {
                jugador2.sumarPuntuacion(pregunta.getPuntuacion());
                vTablero.scoreRight.setText(String.valueOf(jugador2.getPuntuacion()));
            }
        }else{
            Color colorFallo = Color.decode("#FF7043");
            boton.setBackground(colorFallo);
        }
    }

    private void comprobarDoubleRound() {
        System.out.println("Ronda: "+ ronda);
        if(ronda == 10){
            JOptionPane.showMessageDialog(vTablero, "Ha empezado la Jeopardy Double Round, ahora las preguntas valen el doble!!", "Ultima Ronda!", JOptionPane.WARNING_MESSAGE);
            iniciarDoubleRound();
        }
    }

    private void iniciarDoubleRound() {
        for(Categoria categoria: mTablero.getCategorias()){
            
            for (int j = 0; j < vTablero.ROWS ; j++) {
                HashMap<Integer, Pregunta> preguntas;
                preguntas = categoria.getPreguntas();
                Pregunta pregunta= preguntas.get(j);
                pregunta.doubleRound();
                vTablero.allButtons[categoria.getId()][j].setText(String.valueOf(pregunta.getPuntuacion()));
            }
            
        }
    }

    private void comprobarGanador() {
        if (ronda >= 11){
            if (jugador1.getPuntuacion() == jugador2.getPuntuacion()){
                empezarFinalJeopardyRound();
            } else {
                PodiumController podium = new PodiumController(jugador1, jugador2);
            }
        }
    }
    
    private int mostrarVistaPregunta(Pregunta pregunta){
        Object[] options = {pregunta.getRespuestas()[0], pregunta.getRespuestas()[1], pregunta.getRespuestas()[2]}; 
        int respuestaUsuario = JOptionPane.showOptionDialog(vTablero, pregunta.getPregunta(), 
                "Pregunta", 
                JOptionPane.YES_NO_CANCEL_OPTION, 
                JOptionPane.QUESTION_MESSAGE,
                null,
                options, 
                options[2]
        );
        
        return respuestaUsuario;
    }

    private void empezarFinalJeopardyRound() {
        
        for (int j = 0; j < vTablero.ROWS ; j++) {
            for(Categoria categoria: mTablero.getCategorias()){
            
                HashMap<Integer, Pregunta> preguntas;
                preguntas = categoria.getPreguntas();
                Pregunta pregunta= preguntas.get(j);
                mostrarVistaPregunta(pregunta);

            }
        }
    }
    
    
}
