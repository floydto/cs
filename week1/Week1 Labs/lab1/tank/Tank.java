/*
 * Exercise Draw6_sol
 *
 * Copyright (c) Petr Skoda, 2002
 * This source code can be used, modified and distributed without any restrictions.
 */

import java.awt.Color;
import java.awt.geom.AffineTransform;
import java.awt.Graphics2D;
import java.awt.Image;

/**
 * This class represents a small tank.
 */
public class Tank implements Drawable {
    private double x, y;             // position
    private double bodyDir;          // body orientation
    private double turretDir;        // cannon turrert orientation
    private double speed;            // speed
    private Image tankBodyImage;     // image of tank body
    private Image tankTurretImage;   // image of tank turret

    private AffineTransform tankTrans; // tank image transformation
    
    // motion constants
    private static final double BODY_ROTATION_SPEED = 0.001;   // radians per milisecond
    private static final double TURRET_ROTATION_SPEED = 0.0005;// radians per milisecond
    private static final double ACCELERATION = 0.0001;         // pixels per milisecond
    private static final double MAX_FORWARD_SPEED = 0.06;      // pixels per milisecond
    private static final double MAX_BACKWARD_SPEED = -0.02;    // pixels per milisecond
    
    //keys for sound playback
    private static final String CANNON = "cannon.wav";
    private static final String MINIGUN = "minigun.wav";
    
    public Tank(double x, double y) {
        bodyDir = 0;
        turretDir = 0;
        speed = 0;
        setPosition(x, y);
        tankBodyImage = ImageHelper.getImageResource("tank_body.png");
        tankTurretImage = ImageHelper.getImageResource("tank_turret.png");
        AudioHelper.loadClipResource(CANNON, CANNON);
        AudioHelper.loadClipResource(MINIGUN, MINIGUN);
        tankTrans = new AffineTransform();
    }
    
    public void draw(Graphics2D g2) {
        tankTrans.setToTranslation(x, y); //reset transformation
        tankTrans.rotate(bodyDir);
        tankTrans.translate(-14, -10);
        g2.drawImage(tankBodyImage, tankTrans, null);
        tankTrans.setToTranslation(x, y); //reset transformation
        tankTrans.rotate(turretDir);
        tankTrans.translate(-8, -6);
        g2.drawImage(tankTurretImage, tankTrans, null);
    }
    
    public void move(long dt) {
        x = x + Math.cos(bodyDir) * speed * dt;
        y = y + Math.sin(bodyDir) * speed * dt;
    }
    
    public void fireCannon() {
        AudioHelper.playClip(CANNON, false);
    }

    public void startMinigun() {
        AudioHelper.playClip(MINIGUN, true);
    }

    public void stopMinigun() {
        AudioHelper.stopClip(MINIGUN);
    }
    
    public void turnBodyLeft(long dt) {
        bodyDir = bodyDir - BODY_ROTATION_SPEED * dt;
        turretDir = turretDir - BODY_ROTATION_SPEED * dt;
    }

    public void turnBodyRight(long dt) {
        bodyDir = bodyDir + BODY_ROTATION_SPEED * dt;
        turretDir = turretDir + BODY_ROTATION_SPEED * dt;
    }

    public void turnTurretLeft(long dt) {
        turretDir = turretDir - TURRET_ROTATION_SPEED * dt;
    }

    public void turnTurretRight(long dt) {
        turretDir = turretDir + TURRET_ROTATION_SPEED * dt;
    }

    public void accelerate(long dt) {
        speed = speed + ACCELERATION*dt;
        if(speed > MAX_FORWARD_SPEED) {
            speed = MAX_FORWARD_SPEED;
        }
    }
    
    public void decelerate(long dt) {
        speed = speed - ACCELERATION*dt;
        if(speed < MAX_BACKWARD_SPEED) {
            speed = MAX_BACKWARD_SPEED;
        }
    }
    
    public void doStop() {
        speed = 0;
    }
    
    public void setPosition(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * BlueJ does not support System.extit(int) - this method releases all
     * the resources so that the application dies naturally without exit method.
     */
    public void dispose() {
        AudioHelper.clear();
        tankBodyImage = null;
        tankTurretImage = null;
        tankTrans = null;
    }
}
