/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jeopardy;

import controllers.InicioController;
import views.Inicio;
import views.Podium;
import views.TableroView;

/**
 *
 * @author Erik
 */
public class Jeopardy {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        TableroView tab = new TableroView("Tablero");
        Inicio  viewInicio = new Inicio();
        InicioController  inicioC = new InicioController(viewInicio);
         //Podium view = new Podium();
         
    }
    
}
