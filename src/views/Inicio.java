/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import java.awt.BorderLayout;
import static java.awt.BorderLayout.CENTER;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

/**
 *
 * @author Manel
 */
public class Inicio extends JFrame {

    public JLabel background;
    public JLabel welcome;
    public JTextField player1;
    public JTextField player2;
    public JButton butonInicio;
    Border bordejpanel = new TitledBorder(new EtchedBorder(80, Color.yellow, Color.black), "Inicio: ");

    public Inicio() {
        super("JEOPARDY");
        this.setPreferredSize(new Dimension(1000, 1000));
        // this.setTitle("JEOPARDY");

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addComponentsToPane(this.getContentPane());
        // background.setOpaque(true);
        this.pack();
        this.setVisible(true);

    }

    void addComponentsToPane(Container pane) {
        //JPanel fondo =new JPanel(new FlowLayout());
        //JLabel fondo= new JLabel(new ImageIcon("./imagenes/Jeopardy.jpg"));
//        background = new JLabel(new ImageIcon("./imagenes/Jeopardy.jpg"));
//
//        pane.add(background);

        //background=new ImageIcon("./imagenes/Jeopardy.jpg").getImage();
//        background = new JLabel();
//        ImageIcon icon = new ImageIcon("./imagenes/Jeopardy.jpg","Jeopardy");
//        background.setIcon(icon);
//        background.setLayout( new BorderLayout() );
//        this.setContentPane(background);
//        background.add(pane);
        welcome = new JLabel("Bienvenido a JEOPARDY");
        welcome.setHorizontalAlignment(SwingConstants.CENTER);
        welcome.setOpaque(true);
        pane.add(welcome, BorderLayout.NORTH);

        player1 = new JTextField("NickName1");
        player2 = new JTextField("NickName2");

        player1.setOpaque(true);

        // pane.add(player1, BorderLayout.NORTH);
        player2.setOpaque(true);

        //player2.setBounds(20,20,20,50);
        //pane.add(player2, BorderLayout.CENTER);
        JPanel textFields = new JPanel();
        
        player1.setHorizontalAlignment(SwingConstants.CENTER);
        textFields.add(player1);
        
        textFields.setBorder(bordejpanel);
        
        background = new JLabel();
        ImageIcon icon = new ImageIcon("./imagenes/Jeopardy.jpg", "Jeopardy");
        background.setIcon(icon);
        textFields.add(background);
        
        
        player2.setHorizontalAlignment(SwingConstants.CENTER);
        textFields.add(player2);
        
        
        pane.add(textFields);

        player1.setToolTipText("Introduce el NickName de Jugador1 aqui ");
        player2.setToolTipText("Introduce el NickName de Jugador2 aqui ");

        butonInicio = new JButton("A Jugar !! ");

        butonInicio.setPreferredSize(new Dimension(100, 20));

        JPanel botones = new JPanel(new BorderLayout());
        botones.add(butonInicio);

        pane.add(botones, BorderLayout.SOUTH);

        butonInicio.setToolTipText("Pulsa aqui para iniciar una nueva aventura en Jeopardy !");

        // pane.add(textFields);
        // pane.add(butonInicio);
    }

}
