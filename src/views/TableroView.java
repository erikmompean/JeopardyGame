/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

/**
 *
 * @author Manel
 */
public class TableroView extends JFrame {

    final int COLUMNS = 6;
    final int ROWS = 6;
    JPanel topPanel;
    JPanel middlePanel;
    JButton[][] allButtons = new JButton[COLUMNS][ROWS];
    final static int MAXGAP = 20;

    public TableroView(String title){
    super(title);


    addPanels();
    Dimension d = new Dimension(1000, 1000);
    setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

    this.setPreferredSize(d);
    this.setResizable(false);
    this.pack();
    this.setVisible(true);

    }

    private void createTopPanel() {
            topPanel = new JPanel(new BorderLayout());
            JPanel leftFlow = new JPanel();
            JPanel rightFlow = new JPanel();
            int anchuraTablero = this.getContentPane().getWidth();
            topPanel.setPreferredSize(new Dimension(anchuraTablero,50));
            JLabel playerLeftName = new JLabel("Player1");
            JLabel playerRightName = new JLabel("Player2");

            JLabel puntuacion1 = new JLabel("1000");
            JLabel puntuacion2 = new JLabel("3000");

            topPanel.add(leftFlow, BorderLayout.WEST);
            topPanel.add(rightFlow, BorderLayout.EAST);
            leftFlow.add(playerLeftName);
            leftFlow.add(puntuacion1);

            rightFlow.add(puntuacion2);
            rightFlow.add(playerRightName);


    }

    private void createMiddlePanel() {
        middlePanel = new JPanel();
        GridLayout gameLayout =new GridLayout(6, 6);
        middlePanel.setLayout(gameLayout);

        for(int i = 1; i <= COLUMNS;i++) {
            for (int j = 0; j < ROWS; j++) {
                JButton button = new JButton("Button" + i);
                button.setBackground(Color.lightGray);
                middlePanel.add(button);
            }
        }

    }

    private void addPanels() {
        createTopPanel();
        createMiddlePanel();

        this.add(topPanel, BorderLayout.PAGE_START);
        this.add(middlePanel, BorderLayout.CENTER);
    }
}
