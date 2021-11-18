/*
 * Exercise Draw6_sol
 *
 * Copyright (c) Petr Skoda, 2002
 * This source code can be used, modified and distributed without any restrictions.
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.Timer;

/**
 * This class represents a game model; it handles all input, animation and
 * game logic.
 */
public class GameModel implements KeyListener, ActionListener {
    private DrawingCanvas dc;
    private Tank tank;
    private long lastTime;
    private Timer animTimer;
    private boolean leftDown;
    private boolean rightDown;
    private boolean slowerDown;
    private boolean fasterDown;
    private boolean stopDown;
    private boolean minigunDown;
    private boolean cannonDown;
    private boolean turrLeftDown;
    private boolean turrRightDown;
    
    public GameModel(DrawingCanvas dc) {
        this.dc = dc;
        leftDown = false;
        rightDown = false;
        fasterDown = false;
        slowerDown = false;
        stopDown = false;
        minigunDown = false;
        cannonDown = false;
        turrLeftDown = false;
        turrRightDown = false;
        animTimer = new Timer(50, this);
        tank = new Tank(150, 150);
        dc.addElement(new Background());
        dc.addElement(tank);
        dc.redraw();
    }
    
    public void keyTyped(KeyEvent e) {
    }

    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        switch (keyCode) {
            case KeyEvent.VK_LEFT:    leftDown = true; break;
            case KeyEvent.VK_RIGHT:   rightDown = true; break;
            case KeyEvent.VK_UP:      fasterDown = true; break;
            case KeyEvent.VK_DOWN:    slowerDown = true; break;
            case KeyEvent.VK_CONTROL: stopDown = true; break;
            case KeyEvent.VK_A:       turrLeftDown = true; break;
            case KeyEvent.VK_D:       turrRightDown = true; break;
            case KeyEvent.VK_E:       
                if(!minigunDown) {
                    minigunDown = true;
                    tank.startMinigun();
                }    
                break;
            case KeyEvent.VK_Q:
                if(!cannonDown) {
                    cannonDown = true;
                    tank.fireCannon();
                }
                break;
        }
    }

    public void keyReleased(KeyEvent e) {
        int keyCode = e.getKeyCode();
        switch (keyCode) {
            case KeyEvent.VK_LEFT:    leftDown = false; break;
            case KeyEvent.VK_RIGHT:   rightDown = false; break;
            case KeyEvent.VK_UP:      fasterDown = false; break;
            case KeyEvent.VK_DOWN:    slowerDown = false; break;
            case KeyEvent.VK_CONTROL: stopDown = false; break;
            case KeyEvent.VK_A:       turrLeftDown = false; break;
            case KeyEvent.VK_D:       turrRightDown = false; break;
            case KeyEvent.VK_E:
                tank.stopMinigun();
                minigunDown = false;
                break;
            case KeyEvent.VK_Q:       cannonDown = false; break;
        }
    }

    public void actionPerformed(ActionEvent evt) {
        animAction(); //called every 50 milliseconds
    }
    
    private void animAction() {
        long lTime = lastTime;
        lastTime = System.currentTimeMillis();
        long dt = lastTime - lTime;
        if(leftDown) {
            tank.turnBodyLeft(dt);
        }
        if(rightDown) {
            tank.turnBodyRight(dt);
        }
        if(fasterDown) {
            tank.accelerate(dt);
        }
        if(slowerDown) {
            tank.decelerate(dt);
        }
        if(stopDown) {
            tank.doStop();
        }
        if(turrLeftDown) {
            tank.turnTurretLeft(dt);
        }
        if(turrRightDown) {
            tank.turnTurretRight(dt);
        }
        tank.move(dt);
        dc.redraw();
    }

    public void restart() {
        tank.doStop();
        tank.setPosition(150, 150);
    }
    
    public void start() {
        lastTime = System.currentTimeMillis();
        animTimer.start();
    }
    
    public void stop() {
        animTimer.stop();
    }

    /**
     * BlueJ does not support System.extit(int) - this method releases all
     * the resources so that the application dies naturally without exit method.
     */
    public void dispose() {
        stop();
        animTimer.removeActionListener(this);
        tank.dispose();
    }
    
}
