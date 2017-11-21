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

    public Jugador(String nickName1) {
        this.nickName = nickName1;
        this.puntuacion =0;
    }

    public String getNickName1() {
        return nickName;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setNickName1(String nickName1) {
        this.nickName = nickName1;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    @Override
    public String toString() {
        return "Jugador{" + "nickName=" + nickName + ", puntuacion=" + puntuacion + '}';
    }
    
    
}
