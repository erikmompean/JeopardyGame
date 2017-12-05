/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.LinkedList;
import java.util.Queue;

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

    public final int CATEGORIAS = 6;
    public final int COLUMNS = 6;
    public final int ROWS = 5;
    JPanel topPanel;
    JPanel middlePanel;
    JPanel bottomPanel;
    
    public JLabel playerLeftName;
    public JLabel playerRightName;
    
    public JLabel scoreLeft;
    public JLabel scoreRight;
    //public  Queue<JButton> botonesCategoria = new LinkedList<>();
    public JButton[] botonesCategoria = new JButton[CATEGORIAS];
    public JButton[][] allButtons = new JButton[COLUMNS][ROWS];
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
        playerLeftName = new JLabel("Player1");
        playerRightName = new JLabel("Player2");
        
        Font f = playerLeftName.getFont();
        playerLeftName.setFont(f.deriveFont(f.getStyle() & ~Font.BOLD));   
        playerRightName.setFont(f.deriveFont(f.getStyle() & ~Font.BOLD));
                
        playerLeftName.setFont(playerLeftName.getFont().deriveFont(15.0f));
        playerRightName.setFont(playerLeftName.getFont().deriveFont(15.0f));
        
        scoreLeft = new JLabel();
        scoreRight = new JLabel();
        
        scoreLeft.setFont(playerLeftName.getFont().deriveFont(13.0f));
        scoreRight.setFont(playerLeftName.getFont().deriveFont(13.0f));
        
        topPanel.add(leftFlow, BorderLayout.WEST);
        topPanel.add(rightFlow, BorderLayout.EAST);
        leftFlow.add(playerLeftName);
        leftFlow.add(scoreLeft);

        rightFlow.add(scoreRight);
        rightFlow.add(playerRightName);

    }

    private void createBottomPanel() {
        bottomPanel = new JPanel();
        GridLayout gameLayout = new GridLayout(5, 6);
        bottomPanel.setLayout(gameLayout);
        for (int j = 0; j < ROWS; j++) {
            for(int i = 0; i < COLUMNS;i++) {

                JButton button = new JButton("Button" + i);
                Color jeopardyBlue = Color.decode("#29B6F6");
                button.setBackground(jeopardyBlue);
                button.setPreferredSize(new Dimension(200, 150));
                bottomPanel.add(button);
                allButtons[i][j] = button;
            }
        }

    }
    
    private void createMiddlePanel() {
        middlePanel = new JPanel();
        final int CATEGORY_ROW = 1;
        final int CATEGORY_COL = 5;
        GridLayout gameLayout = new GridLayout(CATEGORY_ROW, CATEGORY_COL);
        middlePanel.setLayout(gameLayout);

            for(int i = 0; i <= CATEGORY_COL;i++) {
                    
                    JButton button = new JButton("Button" + i);
                    button.setBackground(Color.PINK);
                    middlePanel.add(button);
                    //botonesCategoria.add(button);
                    Color color = Color.decode("#FFFF00");
                    button.setBackground(color);
                    botonesCategoria[i] = button;
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
