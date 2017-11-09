/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Manel
 */
public class Podium extends JFrame {

    //Manel
    public JLabel podio;

    public Podium() {
        this.setTitle("PODIO DE JUGADORES");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addComponentsToPane(this.getContentPane());
    }

    private void addComponentsToPane(Container contentPane) {
        contentPane.setLayout(new BorderLayout(8, 8));
       podio.setOpaque(true);
	podio.setBackground(Color.WHITE); 
	contentPane.add(podio, BorderLayout.NORTH);
    }

}
