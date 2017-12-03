/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Manel
 */
public class PreguntaView extends JFrame{
    public JLabel vPregunta;
    
    public PreguntaView() {
        super("Pregunta");
        createMiddlePanel();
        
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

        this.setResizable(false);
        this.pack();
        this.setVisible(true);
    }

    private void createMiddlePanel() {
        JPanel middlePanel = new JPanel();
        middlePanel.setLayout(new BoxLayout(middlePanel, BoxLayout.Y_AXIS));
        vPregunta = new JLabel("La raiz cuadrada de 10 al cubo?");
        vPregunta.setFont(vPregunta.getFont().deriveFont(30.0f));
        
        Border margin = new EmptyBorder(20,20,20,20);
        
        vPregunta.setBorder(new CompoundBorder(vPregunta.getBorder(), margin));
        vPregunta.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        middlePanel.add(vPregunta);
        this.add(middlePanel, BorderLayout.CENTER);
    }

    
}
