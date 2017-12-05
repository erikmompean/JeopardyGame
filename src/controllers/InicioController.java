/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import DAO.CategoriasDAO;
import DAO.CategoriasDAOImp;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import models.Jugador;
import models.TableroModel;
import views.Inicio;
import views.TableroView;
import models.Categoria;

/**
 *
 * @author Manel
 */
public class InicioController implements ActionListener {

    //Manel
    Inicio viewInicio;
    Jugador jugador1;
    Jugador jugador2;

    public InicioController(Inicio viewI) {
        this.viewInicio = viewI;

        init();
    }

    private void init() {

        viewInicio.butonInicio.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        String name1 = viewInicio.player1.getText();
        jugador1 = new Jugador(name1);

        String name2 = viewInicio.player2.getText();
        jugador2 = new Jugador(name2);

        if (name1.length() == 0 || name2.length() == 0 || name1.equals("NickName1") || name2.equals("NickName2") || name1.equals(name2)) {
            JOptionPane.showMessageDialog(viewInicio, "Tienes que introducir un numero usuario valido", "Ojo deves introducir tu nombre de usuario :)", JOptionPane.WARNING_MESSAGE);

        } else {
            CategoriasDAO dao = new CategoriasDAOImp();
            ArrayList<Categoria> categorias = dao.cargarTodas();

            TableroView vTablero = new TableroView("Jeopardy en marcha");

            TableroModel mTablero = new TableroModel(categorias, jugador1, jugador2);
            ControllerPartida controllerP = new ControllerPartida(jugador1, jugador2, vTablero, mTablero);
            viewInicio.dispose();
        }

    }

}
