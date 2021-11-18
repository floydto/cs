/*
 *  *
 * Copyright (c) Petr Skoda, 2002
 * This source code can be used, modified and distributed without any restrictions.
 */

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

/**
 * This class is a simple application launcher, creates visual components
 * and links them together.
 */
public class GameApp extends JFrame {
    private DrawingCanvas dc;
    private JButton restartButton;
    private GameModel gameModel;
    
    private GameApp() {
        setTitle("Simple Game - Tank Simulator");
        dc = new DrawingCanvas(Color.white, 300, 300);
        gameModel = new GameModel(dc);
        getContentPane().setLayout(new BorderLayout());

        JPanel topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        JLabel infoLabel = new JLabel(
            "<html>\"Restart\" ... reset position of the tank<br>arrows ... move around"
            +"<br>Ctrl ... stop<br>Q ... fire cannon<br>E ... fire machine gun"
            +"<br>A/D ... turret left/right</html>"
        );
        topPanel.add(infoLabel);
        getContentPane().add(topPanel, BorderLayout.NORTH);
        
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        centerPanel.add(dc);
        getContentPane().add(centerPanel, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel();
        restartButton = new JButton("Restart");
        bottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        bottomPanel.add(restartButton);
        getContentPane().add(bottomPanel, BorderLayout.SOUTH);

        restartButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { //called when restart button pressed
                gameModel.restart(); 
            }
        });
    
        //add key listener to all focusable components
        restartButton.addKeyListener(gameModel);

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent evt) {
                doExit();
            }
        });
        pack();
        setResizable(false);  //frame size can not be changed
        gameModel.start();
    }
    
    private void doExit() {
        if(getClass().getClassLoader().toString().startsWith("bluej")) {
            // running inside BlueJ IDE => System.exit(int) not supported
            gameModel.dispose();
        } else {
            // not running inside BlueJ IDE
            System.exit(0);
        }
    }

    /**
     * Application entry point.
     */
    public static void main(String[] args) {
        new GameApp().show();
    }
}
