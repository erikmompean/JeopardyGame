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
import javax.swing.BoxLayout;
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
    final int ROWS = 5;
    JPanel topPanel;
    JPanel middlePanel;
    JPanel bottomPanel;
    JButton[][] allButtons = new JButton[COLUMNS][ROWS];
    final static int MAXGAP = 20;

    public TableroView(String title){
    super(title);

    this.setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
    addPanels();
    setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

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

    private void createBottomPanel() {
        bottomPanel = new JPanel();
        GridLayout gameLayout =new GridLayout(5, 6);
        bottomPanel.setLayout(gameLayout);
        for (int j = 0; j < ROWS; j++) {
            for(int i = 1; i <= COLUMNS;i++) {

                JButton button = new JButton("Button" + i);
                button.setBackground(Color.lightGray);
                button.setPreferredSize(new Dimension(80, 80));
                bottomPanel.add(button);
            }
        }

    }
    
    private void createMiddlePanel() {
        middlePanel = new JPanel();
        final int CATEGORY_ROW = 1;
        final int CATEGORY_COL = 6;
        GridLayout gameLayout =new GridLayout(CATEGORY_ROW, CATEGORY_COL);
        middlePanel.setLayout(gameLayout);
        for (int j = 0; j < CATEGORY_ROW; j++) {
            for(int i = 1; i <= CATEGORY_COL;i++) {

                    JButton button = new JButton("Button" + i);
                    button.setBackground(Color.PINK);
                    middlePanel.add(button);
            }
        }

    }
    private void addPanels() {
        createTopPanel();
        createMiddlePanel();
        createBottomPanel();
        
        this.add(topPanel);
        this.add(middlePanel);
        this.add(bottomPanel);
        
        
        
    }
}
