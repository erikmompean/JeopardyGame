/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author Manel
 */
public class Podium extends JFrame {

    //Manel
    public JLabel pos1;
     public JLabel pos2;
    public JLabel titulo;

    public Podium() {
        this.setTitle("PODIO DE JUGADORES");
        this.setPreferredSize(new Dimension(400, 90));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addComponentsToPane(this.getContentPane());
        this.setResizable(false);
        this.pack();
        this.setVisible(true);
    }

    private void addComponentsToPane(Container pane) {
        titulo = new JLabel("PODIUM JUGADORES");
        titulo.setOpaque(true);
        pane.add(titulo);

        pos1 = new JLabel("NikName de jugador Ganador");
        pos2= new JLabel("NikName de jugador PERDEDOR");
       
        JPanel ganador = new JPanel();
        ganador.setBackground(Color.GREEN);
        ganador.add(pos1, BorderLayout.NORTH);
        
        pane.add(ganador);
        JPanel perdedor = new JPanel();
        perdedor.add(pos2);
        perdedor.setBackground(Color.RED);
        pane.add(perdedor, BorderLayout.SOUTH);

    }

}
