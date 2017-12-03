/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author Manel
 */
public class Jugador {
    //Manel
    String nickName;
    int puntuacion;

    public Jugador(String nickName) {
        this.nickName = nickName;
        this.puntuacion = 0;
    }

    public String getNickName() {
        return nickName;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    @Override
    public String toString() {
        return "Jugador{" + "nickName=" + nickName + ", puntuacion=" + puntuacion + '}';
    }
    
    
}
